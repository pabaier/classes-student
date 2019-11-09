import argparse
import json
import select
import socket
import sys
import threading
import time

nodes = ['a', 'b', 'c']

class ClientThread(threading.Thread):
    def __init__(self, clientAddress, clientsocket):
        threading.Thread.__init__(self)
        self.socket = clientsocket
        self.address = clientAddress[0]
        self.port = clientAddress[1]
        print("New connection added: ", clientAddress)

    def run(self):
        global nodes
        connected = True
        while connected:
            try:
                time.sleep(7)
                self.socket.send('check'.encode())
                data = self.socket.recv(2048)
                msg = data.decode()
                if msg in nodes:
                    self.socket.send('ok'.encode())
                else:
                    self.socket.send('kill'.encode())
            except:
                connected = False

def run(args):
    manager_address = (args.manager_ip, args.manager_port)
    manager = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    manager.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
    manager.bind(manager_address)
    print("manager started")

    running = True
    while running:
        manager.listen(1)
        clientsock, clientAddress = manager.accept()
        newthread = ClientThread(clientAddress, clientsock)
        newthread.start()
    manager.close()

if __name__ == '__main__':
    parser = argparse.ArgumentParser(description='manager Program.')
    parser.add_argument('--ip', "-i", type=str, default='localhost', dest="manager_ip", help='manager ip')
    parser.add_argument('--port', "-p", type=int, default=10001, dest="manager_port", help='manager port')
    args = parser.parse_args()
    
    run(args)