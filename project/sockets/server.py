import argparse
import json
import select
import socket
import sys
import threading


class ClientThread(threading.Thread):
    def __init__(self, clientAddress, clientsocket):
        threading.Thread.__init__(self)
        self.socket = clientsocket
        self.address = clientAddress[0]
        self.port = clientAddress[1]
        print("New connection added: ", clientAddress)

    def run(self):
        msg = ''
        while True:
            data = self.socket.recv(2048)
            msg = data.decode()
            if msg == 'exit':
                registration.pop(self.port)
                break
            print(f'{self.port}: {msg}')
            SensorData.append(float(msg))
        print(f'{self.port} exited')


parser = argparse.ArgumentParser(description='Server Program.')
parser.add_argument('--ip', "-i", type=str, default='localhost', dest="server_ip", help='server ip')
parser.add_argument('--port', "-p", type=int, default=10000, dest="server_port", help='server port')
args = parser.parse_args()

registration = {}
SensorData = []
server_address = (args.server_ip, args.server_port)
server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
server.bind(server_address)
print("Server started")
running = True
while running:
    server.listen(1)
    # maintains a list of possible input streams
    sockets_list = [sys.stdin, server]
    print("---")
    read_sockets, write_socket, error_socket = select.select(sockets_list, [], [])

    for socks in read_sockets:
        if socks == server:
            clientsock, clientAddress = server.accept()
            message = clientsock.recv(2048).decode('utf-8')
            registration[clientAddress[1]] = clientsock
            newthread = ClientThread(clientAddress, clientsock)
            newthread.start()
        else:
            message = sys.stdin.readline().rstrip()
            if message == 'exit':
                running = False
                break
            for client in registration:
                registration[client].send(str.encode(message))
            sys.stdout.flush()
            print()
server.close()
