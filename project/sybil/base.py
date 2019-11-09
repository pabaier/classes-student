import argparse
import json
import select
import socket
import sys
import threading
import time

SensorData = {}

class ClientThread(threading.Thread):
    def __init__(self, clientAddress, clientsocket):
        threading.Thread.__init__(self)
        self.socket = clientsocket
        self.address = clientAddress[0]
        self.port = clientAddress[1]
        print("New connection added: ", clientAddress)

    def run(self):
        global SensorData
        msg = ''
        while True:
            data = self.socket.recv(2048)
            msg = data.decode()
            SensorData[self.port] = (float(msg))

def printdata():
    global SensorData
    sensorSum = 0
    if (len(SensorData) > 0):
        for key in SensorData:
            print(f'\t{key}: {SensorData[key]}')
            sensorSum += SensorData[key]
        print(f'   avg: {sensorSum / len(SensorData)}')

def agregator():
    time.sleep(3)
    print("---")
    printdata()
    print("---")

def run():
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