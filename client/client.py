import sys
sys.path.append("..")
from crypto.Crypt import *

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

if __name__ == '__main__':
	main()