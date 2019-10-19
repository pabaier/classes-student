# socket_echo_client.py
import socket
import sys

# Create a TCP/IP socket
sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Connect the socket to the port where the server is listening
server_address = ('localhost', 10000)
print('connecting to {} port {}'.format(*server_address))
sock.connect(server_address)

running = True
while running:
    try:
        message = input(">")
        if message == 'exit':
                running = False
        print('sending {!r}'.format(message))
        sock.sendall(str.encode(message))

        if running:
            # Look for the response
            amount_received = 0
            amount_expected = len(message)

            while amount_received < amount_expected:
                data = sock.recv(64)
                amount_received += len(data)
                print('received {!r}'.format(data))
    except:
        pass

sock.close()
# finally:
#     print('closing socket')
#     sock.close()