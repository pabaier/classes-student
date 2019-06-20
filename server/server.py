import aiohttp
import argparse
import codecs
import json
import logging
import os
import pickle
import requests
import sys
from aiohttp import web
dir_path = os.path.dirname(os.path.realpath(__file__))
sys.path.append(dir_path + "/..")
from crypto import Crypt
from datetime import datetime
from db.FileSystem import FileSystem as database


async def add(request):
    logging.info(f'handling add request {request}')
    if request.body_exists:
        try:
            request_body = await request.json()
        except:
            logging.error(f'could not parse {request}')
            error = {'message': 'error parsing json body'}
            return web.json_response(error, status=web.HTTPBadRequest.status_code)

        request_body = json.loads(request_body)
        encrypted_message = request_body['encrypted_message']
        pickled_signed_data = request_body['signed_data']
        pickled_public_key = request_body['public_key']

        signed_data = unpickle_data(pickled_signed_data)
        public_key = unpickle_data(pickled_public_key)

        verified = Crypt.verify(public_key, signed_data, encrypted_message.encode())
        timestamp = str(datetime.utcnow())

        # full message consists of a header, with hash and time, and body, with user and data
        if verified:
            try:
                logging.info(f'writing message {encrypted_message} to db')

                merkle_hash = Crypt.sha256(encrypted_message)

                header = {
                    "previousHash": get_previous_hash(),
                    "merkleHash": merkle_hash,
                    "user": pickled_public_key,
                    "time": timestamp
                }

                tid = Crypt.sha256(json.dumps(header))
                transaction = {
                    "data": encrypted_message,
                    "id": tid
                }

                block = {
                    "header": header,
                    "transaction": transaction
                }

                block_string = json.dumps(block)
                db.write(block_string)
                send_broadcast(block_string)
                response = {'message': 'ok', 'tid': tid}
                return web.json_response(response)
            except:
                logging.info(f'error writing message {encrypted_message} to db')
                response = {'message': 'error writing message to database'}
                return web.json_response(response, status=web.HTTPError.status_code)
        else:
            response = {'message': 'error verifying data'}
            return web.json_response(response, status=web.HTTPBadRequest.status_code)
    else:
        logging.error(f'no body in request {request}')
        error= {'message': 'body required'}
        return web.json_response(error, status=web.HTTPBadRequest.status_code)


# hashes the previous transaction's header
def get_previous_hash():
    transaction = json.loads(db.get_last_transaction())
    return json.dumps(transaction['transaction']['id'])


def unpickle_data(data):
    return pickle.loads(codecs.decode(data.encode(), "base64"))


async def get(request):
    logging.info(f'handling get request {request}')
    tid = request.query['tid']
    transaction = db.get_transaction(tid)
    return web.json_response({'status':'ok', 'response': transaction})


async def get_all(request):
    logging.info(f'handling get all request {request}')
    user = request.query['user']
    transactions = db.get_transactions(user)
    return web.json_response({'status':'ok', 'response': transactions})


# broadcasts block to all sibling nodes
# block is a string
def send_broadcast(block):
    logging.info(f'broadcasting block {block}')
    for port in sibling_nodes:
        requests.post(f'http://localhost:{port}/broadcast', json=block)


# receive a broadcast from a sibling
async def broadcast(request):
    logging.info(f'handling broadcast request {request}')
    if request.body_exists:
        try:
            block_string = await request.json()
        except:
            logging.error(f'could not parse {request}')
            error = {'message': 'error parsing json body'}
            return web.json_response(error, status=web.HTTPBadRequest.status_code)

        block = json.loads(block_string)
        logging.info(f'verifying block')
        verified = verify_broadcast(block)
        if verified:
            logging.info(f'block verified')
            db.write(block_string)
            send_broadcast(block_string)
        else:
            logging.warning(f'block not verified')

    else:
        logging.error(f'no body in request {request}')
    return web.Response(text='ok')


def verify_broadcast(block):
    header = block['header']
    previous_hash = header['previousHash']
    transaction = block['transaction']
    tid = transaction['id']

    if not previous_hash == get_previous_hash():
        return False
    if not tid == Crypt.sha256(json.dumps(header)):
        return False
    return True


######################################################################
#                        test methods                                #
######################################################################
async def handle(request):
    name = request.match_info.get('name', "World!")
    text = {"response": "hello, " + name}
    print('received request, replaying with "{}".'.format(text))
    return web.json_response(text)


async def handle_data(request):
    print('handling post request')
    if request.body_exists:
        b = await request.json()
    try:
        print(b)
    except:
        print('json not defined')
    async with aiohttp.ClientSession() as session:
        async with session.get('http://localhost:' + str(args.rport)) as resp:
            print(resp.status)
            print(await resp.text())
    return web.Response(text='ok')

parser = argparse.ArgumentParser(description='small http server')
parser.add_argument('-p', '--port', type=int, default=8080, help='port for this server to run')
parser.add_argument('-r', '--rport', nargs='+', type=int, help='port(s) of siblings')
parser.add_argument('-l', '--logging', type=int, default=30, help='set the logging level')

args = parser.parse_args()
sibling_nodes = args.rport

logging.getLogger().setLevel(args.logging)

db = database()

app = web.Application()

app.router.add_post('/record', add)
app.router.add_get('/record', get)
app.router.add_get('/record/user', get_all)
app.router.add_post('/broadcast', broadcast)

# test routes
app.router.add_post('/send', handle_data)
app.router.add_get('/{name}', handle)
app.router.add_get('/', handle)


web.run_app(app, port=args.port)
