from os import chmod
from Crypto.PublicKey import RSA
import base64
import os

def main():
	# createKeys()
	# deleteKeys()
	# print(getKey('private.key'))
	pubKey = getKey('public.key')
	privateKey = getKey('private.key')
	a = encrypt(pubKey, 'you are my love!')
	b = decrypt(privateKey, a)
	print(a)
	print(b)

def decrypt(key, cipher):
	a = base64.b64decode(cipher)
	return key.decrypt(a).decode("utf-8")

def encrypt(key, text):
	encryptedBytes = key.encrypt(str.encode(text), 32)[0]
	return base64.b64encode(encryptedBytes)

def getKey(filename):
	with open(filename, 'r') as file:
		key = file.read()
	return RSA.importKey(key)

def createKeys():
	key = RSA.generate(2048)
	privateKey = key.exportKey('PEM')
	with open("private.key", 'wb') as file:
		# chmod("private.key", 600)
		file.write(privateKey)
	publicKey = key.publickey().exportKey(format='PEM')
	with open("public.key", 'wb') as file:
		file.write(publicKey)

def deleteKeys():
	try:
		os.remove("private.key")
		os.remove("public.key")
	except:
		return

if __name__ == '__main__':
	main()