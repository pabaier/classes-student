# socket_echo_client.py
import argparse
import math
import random
import select
import socket
import sys
import datetime

parser = argparse.ArgumentParser(description='Client Program.')
parser.add_argument('--ip', "-i", type=str, default='localhost', dest="server_ip", help='server ip')
parser.add_argument('--port', "-p", type=int, default=10000, dest="server_port", help='server port')
parser.add_argument('--name', "-n", type=str, default='client', dest="name", help='client name')
args = parser.parse_args()


# server.send(b'7')
payload = args.name.encode()
count = 1

# Create a TCP/IP socket
server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Connect the socket to the port where the server is listening
server_address = (args.server_ip, args.server_port)
server.connect(server_address)

running = True
while running:
    server.send(payload)
    print(f"{count}-{payload} - {datetime.datetime.now()}")
    count +=1
server.close()
