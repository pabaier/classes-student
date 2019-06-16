import requests
import sys
from crypto.Crypt import *
sys.path.append("..")


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
	a = encrypt(pub_key, 'you are my love!')
	b = decrypt(private_key, a)
	signature = sign(private_key, a)
	verification = verify(pub_key, signature, a)
	print(verification)


if __name__ == '__main__':
	main()