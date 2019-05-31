from os import chmod
import base64
import os
from Crypto.Hash import SHA
from Crypto.PublicKey import RSA
from Crypto.Signature import PKCS1_PSS

def main():
	# createKeys()
	# deleteKeys()
	pubKey = getKey('public.key')
	privateKey = getKey('private.key')
	a = encrypt(pubKey, 'you are my love!')
	b = decrypt(privateKey, a)
	signature = sign(privateKey, a)
	verification = verify(pubKey, signature, a)
	print(verification)

# sign the encrypted data with the private key
# first SHA the data, then create the signer from the private key
# then sign the SHA with the signer
def sign(privateKey, data):
	h = SHA.new()
	h.update(data)
	signer = PKCS1_PSS.new(privateKey)
	signature = signer.sign(h)
	return signature

# verify the encrypted data
# first SHA the data, then create the verifier from the public key
# then verify the SHA'd data and signature with the verifier
def verify(publicKey, signature, data):
	h = SHA.new()
	h.update(data)
	verifier = PKCS1_PSS.new(publicKey)
	isVerified = verifier.verify(h, signature)
	return isVerified 

# decrypt to string using private key
# first decode the base64, then decrypt with private key
def decrypt(key, cipher):
	a = base64.b64decode(cipher)
	return key.decrypt(a).decode("utf-8")

# encrypt to base64 encoded bytes using public key
# first encrypt using public key, then base64 encode
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