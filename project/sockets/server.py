import socket, threading
class ClientThread(threading.Thread):
    def __init__(self,clientAddress,clientsocket):
        threading.Thread.__init__(self)
        self.csocket = clientsocket
        self.port = clientAddress[1]
        print ("New connection added: ", clientAddress)
    def run(self):
        print ("Connection from : ", clientAddress)
        #self.csocket.send(bytes("Hi, This is from Server..",'utf-8'))
        msg = ''
        while True:
            data = self.csocket.recv(2048)
            msg = data.decode()
            if msg=='exit':
              break
            print (f'{self.port}: {msg}')
            for port in registration:
                print(f'port {port} - myport {self.port}')
                if not port == self.port:
                    print(f'sending to port {port}')
                    registration[port].send(bytes(msg,'UTF-8'))
        print (f'{self.port} exited')

registration = {}
LOCALHOST = "127.0.0.1"
PORT = 10000
server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
server.bind((LOCALHOST, PORT))
print("Server started")
print("Waiting for client request..")
while True:
    server.listen(1)
    clientsock, clientAddress = server.accept()
    registration[clientAddress[1]] = clientsock
    newthread = ClientThread(clientAddress, clientsock)
    newthread.start()