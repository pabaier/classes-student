import argparse
import json
import select
import socket
import sys
import threading
import time

NodeInfo = {}

class ClientThread(threading.Thread):
    def __init__(self, clientAddress, clientsocket):
        threading.Thread.__init__(self)
        self.socket = clientsocket
        self.address = clientAddress[0]
        self.port = clientAddress[1]
        print("New connection added: ", clientAddress)

    def run(self):
        popped = False
        global NodeInfo
        self.id = self.socket.recv(2048).decode()
        self.socket.send('ok'.encode())

        NodeInfo[self.port] = {'id': self.id, 'status': ''}
        connected = True
        while connected:
            try:
                status = self.socket.recv(2048).decode()
                NodeInfo[self.port]['status'] = status
            except:
                NodeInfo.pop(self.port)
                popped = True
                connected = False
            if not NodeInfo[self.port]['status']:
                connected = False

        if not popped:
            NodeInfo.pop(self.port)

def checkStatus():
    alarm = False
    global NodeInfo
    if (len(NodeInfo) > 0):
        for key in NodeInfo:
            print(f'\t{NodeInfo[key]["id"]}: {NodeInfo[key]["status"]}')
            if NodeInfo[key]['status'] == 'alert':
                alarm = True
    if alarm:
        print('******* ALERT, ALERT, ALERT *******')
    

def agregator():
    while True:
        time.sleep(3)
        t = time.localtime()
        current_time = time.strftime("%H:%M:%S", t)
        print(current_time)
        checkStatus()
        print("---")

def run(args):
    global NodeInfo
    server_address = (args.server_ip, args.server_port)
    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
    server.bind(server_address)
    print("Server started")

    t1 = threading.Thread(target=agregator) 
    t1.start()
    
    running = True
    while running:
        server.listen(1)
        # maintains a list of possible input streams
        clientsock, clientAddress = server.accept()
        response = 'success'
        newthread = ClientThread(clientAddress, clientsock)
        newthread.start()
        clientsock.send(str.encode(response))
    server.close()

if __name__ == '__main__':
    parser = argparse.ArgumentParser(description='Server Program.')
    parser.add_argument('--ip', "-i", type=str, default='localhost', dest="server_ip", help='server ip')
    parser.add_argument('--port', "-p", type=int, default=10000, dest="server_port", help='server port')
    args = parser.parse_args()
    
    run(args)