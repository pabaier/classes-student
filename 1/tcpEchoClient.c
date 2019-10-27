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

// global socket to server for use in send/receive helper methods
int s;

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
    } else {
        t = htons(p.type);
        s = htons(p.seqNumber);
    }
    printf("\tType: %d\n", t);
    printf("\tUserName: %s\n", p.uName);
    printf("\tMachineName: %s\n", p.mName);
    printf("\tData: %s\n", p.data);
    printf("\tSeqNumber: %d\n", s);
}

/* helper method to concatenate two strings
 * it works by getting the size of each string,
 * adding it together to create a new space in memory for the new string
 * copying the first string into that memory space
 * then adding the second string on the end
 * and returning the resulting string
 */
static char *strConcat(char *str1, char *str2) {
    char *message = malloc(strlen(str1) + strlen(str2) + 1);
    strcpy(message, str1);
    strcat(message, str2);
    return message;
}

/* helper method used to send packet
 * if the send fails, the program prints that it failed and exits
 */
static void sendPacket(struct packet p) {
    if (send(s, &p, sizeof(p), 0) < 0) {
        printf("\n Send failed\n");
        exit(1);
    }
}

/* helper method used to receive packet
 * the method takes in a string as a parameter which is used for the output
 * it also takes a packet as a parameter, which is used to store the payload from the server
 * lastly it takes a packet type, which is the expected packet type being sent by the server
 * if there is an error with receiving the packet or if the packet type is incorrect
 * the program will exit.
 */
static struct packet receivePacket(char *operation, struct packet p, int packetType) {
    if (recv(s, &p, sizeof(p), 0) < 0) {
        printf("\n %s \n", strConcat("Did not receive ", operation));
        exit(1);
    } else if (ntohs(p.type) != packetType) {
        printPacket(strConcat(operation, " Received"), p, false);
        printf("\nError Received. Exiting \n");
        exit(1);
    }
    return p;
}

int main(int argc, char *argv[]) {
    struct hostent *hp;
    struct sockaddr_in sin;
    char *host, *userName;
    char computerName[MAXNAME];
    char buf[MAX_LINE];
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
     * Build, send, and get response for first registration packet.
     * The server expects the first registration packet type to be 121
     * The confirmation packet from the server should be packet type 221
     */
    packet_reg.type = htons(121);
    strcpy(packet_reg.uName, userName);
    strcpy(packet_reg.mName, computerName);

    sendPacket(packet_reg);
    printPacket("Registration Packet 1 Sent", packet_reg, true);

    packet_reg_confirm = receivePacket("Registration Confirmation Packet 1", packet_reg_confirm, 221);
    printPacket("Registration Packet 1 Acknowledged", packet_reg_confirm, false);

    /*
     * Build, send, and get response for second registration packet.
     * The server expects the first registration packet type to be 122
     * The confirmation packet from the server should be packet type 222
     */
    packet_reg.type = htons(122);
    strcpy(packet_reg.uName, userName);
    strcpy(packet_reg.mName, computerName);

    sendPacket(packet_reg);
    printPacket("Registration Packet 2 Sent", packet_reg, true);

    packet_reg_confirm = receivePacket("Registration Confirmation Packet 2", packet_reg_confirm, 222);
    printPacket("Registration Packet 2 Acknowledged", packet_reg_confirm, true);

    /*
     * Build, send, and get response for first registration packet.
     * The server expects the first registration packet type to be 123
     * The confirmation packet from the server should be packet type 223
     */
    packet_reg.type = htons(123);
    strcpy(packet_reg.uName, userName);
    strcpy(packet_reg.mName, computerName);

    sendPacket(packet_reg);
    printPacket("Registration Packet 3 Sent", packet_reg, true);

    packet_reg_confirm = receivePacket("Registration Confirmation Packet 3", packet_reg_confirm, 223);
    printPacket("Registration Complete", packet_reg_confirm, true);

    /* main loop to get multicast packets */
    while (true) {
        printf("------------------------------------");
        /*
         * After the client receives the final acknowledgment packet
         * it starts receiving the multicast from the server.
         * It expects the multicast packet to be packet type 231
         */
        packet_multicast = receivePacket("Multicast Packet", packet_multicast, 231);
        printPacket("Multicast Packet Received", packet_multicast, false);
        printf("\n------------------------------------");
    }
}
