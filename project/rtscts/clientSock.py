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

parser = argparse.ArgumentParser(description='Client Program.')
parser.add_argument('--ip', "-i", type=str, default='localhost', dest="server_ip", help='server ip')
parser.add_argument('--port', "-p", type=int, default=10000, dest="server_port", help='server port')
parser.add_argument('--name', "-n", type=str, default='client', dest="name", help='client name')
args = parser.parse_args()

# server.send(b'7')

payload = args.name.encode()

# Create a TCP/IP socket
server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Connect the socket to the port where the server is listening
server_address = (args.server_ip, args.server_port)
server.connect(server_address)

channels = [4,9,3,1,6,5,2,8,7,0]

def main():
    wait_time = random.randint(1,7)
    # print(f'wait time is {wait_time} seconds')
    running = True
    server.send(payload)
    while running:
        rts()
        time.sleep(random.randint(1,7))
    server.close()

def rts():
    t = datetime.datetime.now().minute
    channel = channels[t%10]
    rts = {'channel': channel}
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