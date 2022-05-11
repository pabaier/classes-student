import argparse
import json
import select
import socket
import sys
import threading
import time
import datetime


class ClientThread(threading.Thread):
    def __init__(self, clientAddress, clientsocket):
        threading.Thread.__init__(self)
        self.socket = clientsocket
        self.address = clientAddress[0]
        self.port = clientAddress[1]
        print("New connection added: ", clientAddress)

    def run(self):
        while True:
            data = self.socket.recv(1490)
            print(f'{self.port}: {datetime.datetime.now()}')

parser = argparse.ArgumentParser(description='Server Program.')
parser.add_argument('--ip', "-i", type=str, default='localhost', dest="server_ip", help='server ip')
parser.add_argument('--port', "-p", type=int, default=10000, dest="server_port", help='server port')
args = parser.parse_args()

server_address = (args.server_ip, args.server_port)
server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
server.bind(server_address)

running = True
while running:
    server.listen(1)
    clientsock, clientAddress = server.accept()
    message = clientsock.recv(1490)
    print(str(datetime.datetime.now()))
    newthread = ClientThread(clientAddress, clientsock)
    newthread.start()
server.close()

