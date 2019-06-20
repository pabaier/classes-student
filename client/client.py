import codecs
import json
import logging
import pickle
import requests
from crypto import Crypt


class Client:
    def __init__(self, server, public_key=None, private_key=None):
        self.public_key = Crypt.get_key(public_key)
        self.private_key = Crypt.get_key(private_key)
        self.server = server

    # message should be a string. it is encrypted and POSTed as JSON
    def send_transaction(self, message):
        logging.info(f'sending transaction with message {message}')
        encrypted_message = Crypt.encrypt(self.public_key, message)
        signed_data = Crypt.sign(self.private_key, encrypted_message)

        # need to encode the data and public key as string to send through HTTP
        # first pickle the data, then encode as base64
        pickled_signed_data = Client.pickle_data(signed_data)
        pickled_public_key = Client.pickle_data(self.public_key)

        data = {
            'encrypted_message': encrypted_message.decode(),
            'signed_data': pickled_signed_data,
            'public_key': pickled_public_key
        }
        response = requests.post(f'{self.server}/record', json=json.dumps(data))
        logging.info(f'response from server {response}')
        return response

    # gets the transaction with id tid
    # tid is a SHA256 of the transaction's header
    def get_transaction(self, tid):
        logging.info(f'getting transaction {tid}')
        response = requests.get(f'{self.server}/record', params={'tid':tid})
        logging.info(f'response from server {response}')
        return response

    # gets all of the transactions for a single user
    # user is the user's pickled public key (from the database)
    def get_user_transactions(self, user):
        logging.info(f'getting transactions for user {user}')
        response = requests.get(f'{self.server}/record/user', params={'user':user})
        logging.info(f'response from server {response}')
        return response

    @staticmethod
    def pickle_data(data):
        return codecs.encode(pickle.dumps(data), "base64").decode()

    @staticmethod
    def unpickle_data(data):
        return pickle.loads(codecs.decode(data.encode(), "base64"))


def main():
    http_check()


def http_check():
    r = requests.get('http://localhost:8080/')
    a = r.json()
    print(a['response'])


def key_test():
    # createKeys()
    # deleteKeys()
    pub_key = get_key('public.key')
    private_key = get_key('private.key')
    encrypted_message = encrypt(pub_key, 'you are my love!')
    b = decrypt(private_key, encrypted_message)
    signature = sign(private_key, encrypted_message)
    verification = verify(pub_key, signature, encrypted_message)
    print(verification)


if __name__ == '__main__':
    main()