# socket_echo_client.py
import argparse
import math
import random
import select
import socket
import sys

parser = argparse.ArgumentParser(description='Client Program.')
parser.add_argument('--ip', "-i", type=str, default='localhost', dest="server_ip", help='server ip')
parser.add_argument('--port', "-p", type=int, default=10000, dest="server_port", help='server port')
args = parser.parse_args()


# server.send(b'7')
payload = random._urandom(1490)

running = True
while running:
    # Create a TCP/IP socket
    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    # Connect the socket to the port where the server is listening
    server_address = (args.server_ip, args.server_port)
    server.connect(server_address)

    server.send(payload)
    print("hiho")
server.close()
