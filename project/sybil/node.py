# socket_echo_client.py
import argparse
import math
import random
import select
import socket
import sys
import time
import threading

running = True

def manager_receiver(server, id):
    global running
    while running:
        message = server.recv(2048).decode('utf-8')
        print(f'sending id to network manager: {id}')
        server.send(str.encode(id))
        message = server.recv(2048).decode('utf-8')
        if message == 'kill':
            print(f'killing node {id}...done')
            running = False

def run(args):
    global running
    # Create a TCP/IP socket
    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    manager = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    # Connect the socket to the port where the server is listening
    server_address = (args.server_ip, args.server_port)
    print('connecting to base at {} on port {}'.format(*server_address))
    server.connect(server_address)

    manager_address = (args.manager_ip, args.manager_port)
    print('connecting to manager at {} on port {}'.format(*manager_address))
    manager.connect(manager_address)

    response = server.recv(2048).decode()

    if response != 'success':
        running = False

    t1 = threading.Thread(target=manager_receiver, args=(manager,args.id,)) 
    t1.start()

    while running:
        print("---")
        num = math.floor(random.randint(args.min, args.max))
        server.send(str.encode(str(num)))
        print(f'sending status to server: {num}')
        time.sleep(3)
    server.close()
    manager.close()

if __name__ == '__main__':
    parser = argparse.ArgumentParser(description='Client Program.')
    parser.add_argument('--ip', "-i", type=str, default='localhost', dest="server_ip", help='server ip')
    parser.add_argument('--port', "-p", type=int, default=10000, dest="server_port", help='server port')
    parser.add_argument('--mip', "-mi", type=str, default='localhost', dest="manager_ip", help='manager ip')
    parser.add_argument('--mport', "-mp", type=int, default=10001, dest="manager_port", help='manager port')
    parser.add_argument('--min', "-m", type=int, default=0, dest="min", help='minimum range for data')
    parser.add_argument('--max', "-x", type=int, default=10, dest="max", help='maximum range for data')
    parser.add_argument('--id', "-id", type=str, dest="id", help='node id')

    args = parser.parse_args()
    
    run(args)