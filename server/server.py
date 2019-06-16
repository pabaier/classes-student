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
        pickled_encrypted_message = request_body['encrypted_message']
        pickled_signed_data = request_body['signed_data']
        pickled_public_key = request_body['public_key']

        signed_data = unpickle_data(pickled_signed_data)
        public_key = pickle.loads(codecs.decode(pickled_public_key.encode(), "base64"))
        encrypted_message = pickle.loads(codecs.decode(pickled_encrypted_message.encode(), "base64"))

        verification = Crypt.verify(public_key, signed_data, encrypted_message)
        response = {
            'message': 'ok',
            'verified': verification
        }
        return web.json_response(response)
    else:
        logging.error(f'no body in request {request}')
        error= {'message': 'body required'}
        return web.json_response(error, status=web.HTTPBadRequest.status_code)

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

app = web.Application()
app.router.add_get('/', handle)
app.router.add_get('/{name}', handle)
app.router.add_post('/send', handle_data)
app.router.add_post('/add', add)

web.run_app(app, port=args.port)
