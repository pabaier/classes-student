import aiohttp
import argparse
import codecs
import json
import logging
import os
import pickle
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
                    "previousHash": '',#get_previous_hash(),
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
parser.add_argument('-port', type=int, default=8080, help='port for this server to run')
parser.add_argument('-rport', type=int, default=8081, help='port another server is running on')
parser.add_argument('-logging', type=int, default=30, help='set the logging level')

args = parser.parse_args()

logging.getLogger().setLevel(args.logging)

db = database()

app = web.Application()
app.router.add_get('/', handle)
app.router.add_get('/{name}', handle)
app.router.add_post('/send', handle_data)
app.router.add_post('/record', add)

web.run_app(app, port=args.port)
