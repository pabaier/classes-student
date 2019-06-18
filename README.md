This is a project for CSIS 638 on blockchain

The program consists of a Client class, a Server module, a FileSystem class, and a Crypt module. At a high level, the Client's responsibility is to interact with the server, the server responds to the client and processes transactions, the server uses the FileSystem class to read and write data, and both the client and the server use the Crypt module to encrypt and decrypt data. The following sections will go into more detail about the responsibilities of each part of the program.

The Client class is initiated with a server location as a string, a public key location as a string, and a private key location as a string. The public and private keys are retrieved from the local file system upon instantiation of the client and stored in the client instance. 

A client instance has a "send_transaction" method that takes a message as a string and sends it to the server with which it was instantiated. The method first encrypts the message with the client's public key using the Crypt class's encrypt method (more details about the Crypt class's methods will follow in the Crypt Class section). The encrypted message is then signed using the client's private key using the Crypt class's sign method. Next, the encrypted message is decoded into a string using the UTF-8 codec, and the signed data and public key are "pickled". This is Python's way of serializing data and allows for the data to be "un-pickled" on the other end and converted back into a python data type. Here the two pieces of data are pickled and then encoded in base64. The reason to encode it into base64 is to produce strings capable of being sent via HTTP. The data is POSTed to the client's server address using Python's "requests" module and the response is returned.

**get_transaction**

**get_all_transactions**

The server module takes three optional arguments upon initialization. The first is "-port", which specifies the port on which it will run, "-rport", which is the port of an adjacent server, and "-logging", which sets the logging level for the server. The server has five endpoints: "/record", "/all", "/health", "/distribute", and "/consent". Each route will be explained below.

The "/record" route calls the server's add method. This method converts the request string to json using Python's built in json module, then extracts each of the three fields: the encrypted message, the signed data, and the public key. The public key is required because it is used to verify the signed data. The pickled data is unpickled using Python's pickle module and then the Crypt module's verify method, which takes all three pieces of data, is used to verify the encrypted message. If verified, the pickled public key and encrypted message are written to the block chain along with a time stamp using the FileSystem module's write method. The data can then be accessed by searching for the user's pickled public key.
