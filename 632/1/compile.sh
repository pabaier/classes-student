#bin/bash

gcc -o server tcpEchoServer.c -lnsl -lpthread
gcc -o client tcpEchoClient.c -lnsl -lpthread
