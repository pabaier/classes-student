# socket_echo_client.py
import argparse
import math
import random
import select
import socket
import sys
import datetime
import time
import json

def getBool(st):
    switch = {'true': True, 'false': False}
    return switch[st]

parser = argparse.ArgumentParser(description='Client Program.')
parser.add_argument('--ip', "-i", type=str, default='localhost', dest="server_ip", help='server ip')
parser.add_argument('--port', "-p", type=int, default=10000, dest="server_port", help='server port')
parser.add_argument('--name', "-n", type=str, default='client', dest="name", help='client name')
parser.add_argument('--sleep', "-s", type=str, default='true', dest="sleep", help='if client should sleep')
parser.add_argument('--channel', "-c", type=int, default='-1', dest="channel", help='broadcast on a specific channel')
args = parser.parse_args()

# Create a TCP/IP socket
server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Connect the socket to the port where the server is listening
server_address = (args.server_ip, args.server_port)
server.connect(server_address)

channels = [4,9,3,1,6,5,2,8,7,0]
sleep = getBool(args.sleep)


def main():
    running = True
    if args.channel > 0:
        for i in range(10):
            channels[i] = args.channel
    server.send(json.dumps({'name': args.name}).encode())
    while running:
        if sleep:
            time.sleep(random.randint(2,4))
        rts()
    server.close()

def rts():
    t = datetime.datetime.now().minute
    channel = channels[t%10]
    rts = {'channel': channel}
    # request to send
    server.send(json.dumps(rts).encode())
    raw_data = server.recv(1024).decode()

    data = json.loads(raw_data)
    if(data['body']):
        p = random.randint(1, 100)
        print(f"CTS! sending {p} on channel {channel}")
        server.send(json.dumps({'body': p}).encode())
    else:
        print('RTS')

if __name__ == '__main__':
    main()