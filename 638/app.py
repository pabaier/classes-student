import argparse
from client.client import Client
import json
import logging
import os

parser = argparse.ArgumentParser(description='small http server')
parser.add_argument('-p', '--port', type=int, default=8080, help='port of the server this client will connect to')
parser.add_argument('-l', '--logging', type=int, default=30, help='set the logging level')

args = parser.parse_args()
port = args.port

pub_key_location = 'client/public.key'
private_key_location = 'client/private.key'

logging.getLogger().setLevel(args.logging)

a = Client(f'http://localhost:{port}', pub_key_location, private_key_location)

# resp = a.send_transaction("what what what asdfasdfasdfasdfasdf;lkj asdf adsf asdf asdf asdf aaaaaaaaaadg asdg asd gas dgas dga sdgWhat a horrible candle-snuffing word. That's like saying, He can't climb that mountain, he's just a man, or That's not a diamond, it's just a rock. Just.")
# b = resp.json()
# print(b)

inp = ''
while not inp is 'exit' and not inp is 'x':
    print("s: send\ng: get transaction by id\na: get all of your transactions\nx: exit")
    inp = input('>')
    if inp == 's':
        notes = input('patient notes: ')
        resp = a.send_transaction(notes)
        print(resp.json())
    elif inp == 'g':
        id = input('enter transaction id: ')
        resp = a.get_transaction(id)
        print(resp)
    elif inp == 'a':
        resp = a.get_user_transactions()
        for m in resp:
            print(f'>{m}')
    print()