# socket_echo_client.py
import argparse
import select
import socket
import sys

parser = argparse.ArgumentParser(description='Client Program.')
parser.add_argument('--ip', "-i", type=str, default='localhost', dest="server_ip", help='server ip')
parser.add_argument('--port', "-p", type=int, default=10000, dest="server_port", help='server port')
args = parser.parse_args()

# Create a TCP/IP socket
server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Connect the socket to the port where the server is listening
server_address = (args.server_ip, args.server_port)
print('connecting to {} port {}'.format(*server_address))
server.connect(server_address)
server.send(b'7')

running = True
while running:

    # maintains a list of possible input streams 
    sockets_list = [sys.stdin, server]
    print("---")
    read_sockets, write_socket, error_socket = select.select(sockets_list, [], [])

    for socks in read_sockets:
        if socks == server:
            message = socks.recv(2048).decode('utf-8')
            server.send(str.encode('80'))
            print(f'sending status to server')
        else:
            message = sys.stdin.readline().rstrip()
            if message == 'exit':
                running = False
            server.send(str.encode(message))
            sys.stdout.flush()
            print()
server.close()
