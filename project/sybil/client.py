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
parser.add_argument('--min', "-m", type=int, default=0, dest="min", help='minimum range for data')
parser.add_argument('--max', "-x", type=int, default=10, dest="max", help='maximum range for data')

args = parser.parse_args()

# Create a TCP/IP socket
server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Connect the socket to the port where the server is listening
server_address = (args.server_ip, args.server_port)
print('connecting to {} port {}'.format(*server_address))
server.connect(server_address)
response = server.recv(2048).decode()

running = False
if response == 'success':
    running = True

while running:

    # maintains a list of possible input streams 
    sockets_list = [sys.stdin, server]
    print("---")
    read_sockets, write_socket, error_socket = select.select(sockets_list, [], [])

    for socks in read_sockets:
        if socks == server:
            message = socks.recv(2048).decode('utf-8')
            num = math.floor(random.randint(args.min, args.max))
            server.send(str.encode(str(num)))
            print(f'sending status to server: {num}')
        else:
            message = sys.stdin.readline().rstrip()
            if message == 'exit':
                running = False
            server.send(str.encode(message))
            sys.stdout.flush()
            print()
server.close()
