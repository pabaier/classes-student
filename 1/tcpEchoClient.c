#include<stdio.h>
#include<sys/types.h>
#include<sys/socket.h>
#include<netinet/in.h>
#include<netdb.h>
#include<string.h>
#include<stdlib.h>
#include <unistd.h>
#include <stdbool.h>

// #define SERVER_PORT 7777
#define MAX_LINE 256
#define MAXNAME 256

/* structure of the packet */
struct packet {
    short type;
    char uName[MAXNAME];
    char mName[MAXNAME];
    char data[MAXNAME];
    short seqNumber;
};

/* helper method used to print packet information */
static void printPacket(char *operation, struct packet p, bool isNtoHS) {
    printf("\n %s:\n", operation);
    short t;
    short s;
    if (isNtoHS) {
        t = ntohs(p.type);
        s = ntohs(p.seqNumber);
    }
    else {
        t = htons(p.type);
        s = htons(p.seqNumber);
    }
    printf("\tType: %d\n", t);
    printf("\tUserName: %s\n", p.uName);
    printf("\tMachineName: %s\n", p.mName);
    printf("\tData: %s\n", p.data);
    printf("\tSeqNumber: %d\n", s);
}

int main(int argc, char *argv[]) {
    struct hostent *hp;
    struct sockaddr_in sin;
    char *host, *userName;
    char computerName[MAXNAME];
    char buf[MAX_LINE];
    int s;
    struct packet packet_reg;
    struct packet packet_reg_confirm;
    struct packet packet_multicast;
    short SERVER_PORT = 7777;

    /*
        The following grabs the command line arguments.
        Besides the name of the program,
        if there are 2 arguments, the host will be the first one,
        and the user name will be the second one.
        if there is only 1 argument, the host will be 'localhost'
        and the username will be the argument.
        if there are no arguments, the program will exit.
    */
    if (argc == 3) {
        host = argv[1];
        userName = argv[2];
        // SERVER_PORT = atoi(argv[2]);
    } else if (argc == 2) {
        host = "localhost";
        userName = argv[1];
    } else {
        fprintf(stderr, "usage:newclient username\n");
        exit(1);
    }

    /* translate host name into peer's IP address */
    hp = gethostbyname(host);
    if (!hp) {
        fprintf(stderr, "unkown host: %s\n", host);
        exit(1);
    }
    gethostname(computerName, sizeof(computerName));

    /* active open */
    if ((s = socket(PF_INET, SOCK_STREAM, 0)) < 0) {
        perror("tcpclient: socket");
        exit(1);
    }

    /* build address data structure */
    bzero((char *) &sin, sizeof(sin));
    sin.sin_family = AF_INET;
    bcopy(hp->h_addr, (char *) &sin.sin_addr, hp->h_length);
    sin.sin_port = htons(SERVER_PORT);

    if (connect(s, (struct sockaddr *) &sin, sizeof(sin)) < 0) {
        perror("tcpclient: connect");
        close(s);
        exit(1);
    }

    /*
        Constructing the registration packet at client.
        This is the first packet sent and includes the code '121'
        which indicates it is a registration packet.
    */
    packet_reg.type = htons(121);
    strcpy(packet_reg.uName, userName);
    strcpy(packet_reg.mName, computerName);

    /*
        Send the registration packet to the server.
        If it fails to send, the program exits.
    */
    if (send(s, &packet_reg, sizeof(packet_reg), 0) < 0) {
        printf("\n Send failed\n");
        exit(1);
    } else {
        printPacket("Registration Packet 1 Sent", packet_reg, true);
    }
    /*
        Get registration response.
        After the server receives our registration it lets us know
        by sending back a confirmation message with code '221'.
    */
    if (recv(s, &packet_reg_confirm, sizeof(packet_reg_confirm), 0) < 0) {
        printf("\n Did not receive registration confirmation packet \n");
        exit(1);
    }
        /*
            if the registration confirmation packet is the correct code
            then we continue into the multicast messages.
        */

    else if (ntohs(packet_reg_confirm.type) == 221) {
        printPacket("Registration Packet 1 Acknowledged", packet_reg_confirm, false);
        // send the second registration packet
        packet_reg.type = htons(122);
        strcpy(packet_reg.uName, userName);
        strcpy(packet_reg.mName, computerName);
        if (send(s, &packet_reg, sizeof(packet_reg), 0) < 0) {
            printf("\n Send failed\n");
            exit(1);
        } else {
            printPacket("Registration Packet 2 Sent", packet_reg, true);
        }
        // see if server responded with acknowledgement
        if (recv(s, &packet_reg_confirm, sizeof(packet_reg_confirm), 0) < 0) {
            printf("\n Did not receive registration confirmation packet 2\n");
            exit(1);
        }

        else if (ntohs(packet_reg_confirm.type) == 222) {
            printPacket("Registration Packet 2 Acknowledged", packet_reg_confirm, true);
            // send a 3rd registration packet
            packet_reg.type = htons(123);
            strcpy(packet_reg.uName, userName);
            strcpy(packet_reg.mName, computerName);

            if (send(s, &packet_reg, sizeof(packet_reg), 0) < 0) {
                printf("\n Send failed\n");
                exit(1);
            } 

            else {
                printPacket("Registration Packet 3 Sent", packet_reg, true);
                // see if server acknowledged final packet
                if (recv(s, &packet_reg_confirm, sizeof(packet_reg_confirm), 0) < 0) {
                    printf("\n Did not receive registration confirmation packet 3\n");
                    exit(1);
                }

                else if (ntohs(packet_reg_confirm.type) == 223) {
                    // registration complete!
                    printPacket("Registration Complete", packet_reg_confirm, true);
                }
            }
        }
        /* main loop: get multicast packets */ 
        while (true) {
            printf("------------------------------------");
            /*
                After the client receives the acknowledgment packet
                it starts receiving the multicast from the server.
            */
            if (recv(s, &packet_multicast, sizeof(packet_multicast), 0) < 0) {
                printf("\n Error receiving multicast packet \n");
                exit(1);
            } else if (ntohs(packet_multicast.type) != 231) {
                printPacket("Multicast Packet Received", packet_multicast, false);
                printf("\nError Received. Exiting \n");
                exit(1);
            }
            printPacket("Multicast Packet Received", packet_multicast, false);
            printf("\n------------------------------------");
        }
    }
    /*
        if the registration confirmation code is not 221
        we exit the program
    */
    else {
        printPacket("Registration Confirmation Packet Received", packet_reg_confirm, false);
        printf("\nError Received. Exiting \n");
        exit(1);
    }

}
