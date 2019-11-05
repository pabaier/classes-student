import argparse
import json
import select
import socket
import sys
import threading
import time
import datetime

ok_to_send = True
channels = [4,9,3,1,6,5,2,8,7,0]

class ClientThread(threading.Thread):
    def __init__(self, clientAddress, clientsocket, name):
        threading.Thread.__init__(self)
        self.socket = clientsocket
        self.address = clientAddress[0]
        self.port = clientAddress[1]
        self.name = name
        print("New connection added: ", clientAddress)

    def run(self):
        global ok_to_send
        while True:
            raw_data = self.socket.recv(16).decode()
            t = datetime.datetime.now().minute
            channel = channels[t%10]
            data = json.loads(raw_data)
            if data['channel'] == channel:
                if ok_to_send:
                    ok_to_send = False
                    time.sleep(1)
                    self.socket.send(json.dumps({'body': True}).encode())
                    raw_data = self.socket.recv(12).decode()
                    data = json.loads(raw_data)
                    print(f"---{self.name}: {data['body']} - channel {channel}---")
                    ok_to_send = True
                else:
                    self.socket.send(json.dumps({'body': False}).encode())
            else:
                self.socket.send(json.dumps({'body': False}).encode())


parser = argparse.ArgumentParser(description='Server Program.')
parser.add_argument('--ip', "-i", type=str, default='localhost', dest="server_ip", help='server ip')
parser.add_argument('--port', "-p", type=int, default=10000, dest="server_port", help='server port')
parser.add_argument('--channel', "-c", type=int, default='-1', dest="channel", help='broadcast on a specific channel')
args = parser.parse_args()

server_address = (args.server_ip, args.server_port)
server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
server.bind(server_address)

if args.channel > 0:
    for i in range(10):
        channels[i] = args.channel

running = True
while running:
    server.listen(1)
    clientsock, clientAddress = server.accept()
    data_raw = clientsock.recv(1024).decode()
    data = json.loads(data_raw)
    newthread = ClientThread(clientAddress, clientsock, data['name'])
    newthread.start()
server.close()

