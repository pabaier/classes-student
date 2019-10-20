# socket_echo_client.py
import socket
import sys
import select 

# Create a TCP/IP socket
server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Connect the socket to the port where the server is listening
server_address = ('localhost', 10000)
print('connecting to {} port {}'.format(*server_address))
server.connect(server_address)

running = True
while running:

    # maintains a list of possible input streams 
    sockets_list = [sys.stdin, server] 
  
    read_sockets,write_socket, error_socket = select.select(sockets_list,[],[]) 
  
    for socks in read_sockets: 
        if socks == server: 
            message = socks.recv(2048).decode('utf-8')
            print(f'-{message}')
        else:
            print(">", end="")
            message = sys.stdin.readline().rstrip()
            if message == 'exit':
                running = False
            server.send(str.encode(message)) 
            # sys.stdout.write("<You>") 
            # sys.stdout.write(message) 
            # sys.stdout.flush()
            print()
server.close()