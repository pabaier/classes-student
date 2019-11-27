import argparse
import json
import select
import socket
import sys
import threading
import time

nodes = ['a', 'b', 'c']
socket_register = []

def status_checker():
    while True:
        popList = []
        time.sleep(7)
        t = time.localtime()
        current_time = time.strftime("%H:%M:%S", t)
        print(f'{current_time}: status check')
        try:
            for client in socket_register:
                client.send('check'.encode())
                data = client.recv(2048)
                msg = data.decode()
                if msg in nodes:
                    client.send('ok'.encode())
                else:
                    client.send('kill'.encode())
                    popList.append(client)
        except:
            pass
        for client in popList:
            socket_register.remove(client)

def run(args):
    manager_address = (args.manager_ip, args.manager_port)
    manager = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    manager.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
    manager.bind(manager_address)
    print("manager started")

    t1 = threading.Thread(target=status_checker) 
    t1.start()

    running = True
    while running:
        manager.listen(1)
        clientsock, clientAddress = manager.accept()
        socket_register.append(clientsock)
    manager.close()

if __name__ == '__main__':
    parser = argparse.ArgumentParser(description='manager Program.')
    parser.add_argument('--ip', "-i", type=str, default='localhost', dest="manager_ip", help='manager ip')
    parser.add_argument('--port', "-p", type=int, default=10001, dest="manager_port", help='manager port')
    args = parser.parse_args()
    
    run(args)