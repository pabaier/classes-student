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

static char* strConcat(char *str1, char *str2) {
    char *message = malloc(strlen(str1) + strlen(str2) + 1);
    strcpy(message, str1);
    strcat(message, str2);
    return message;
}

/* helper method used to send packet */
static void sendPacket(struct packet p) {
    if (send(s, &p, sizeof(p), 0) < 0) {
        printf("\n Send failed\n");
        exit(1);
    }
}

/* helper method used to receive packet */
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
        Constructing the registration packet at client.
        This is the first packet sent and includes the code '121'
        which indicates it is a registration packet.
    */
    packet_reg.type = htons(121);
    strcpy(packet_reg.uName, userName);
    strcpy(packet_reg.mName, computerName);

    /*
        Send the registration packet to the server.
    */
    sendPacket(packet_reg);
    printPacket("Registration Packet 1 Sent"), p, true);

    /*
        Get registration response.
        After the server receives our registration it lets us know
        by sending back a confirmation message with code '221'.
    */
    packet_reg_confirm = receivePacket("Registration Confirmation Packet 1", packet_reg_confirm, 221);
    printPacket("Registration Packet 1 Acknowledged", packet_reg_confirm, false);

    /*
        if the registration confirmation packet is the correct code
        then we continue into the multicast messages.
    */

    // send the second registration packet
    packet_reg.type = htons(122);
    strcpy(packet_reg.uName, userName);
    strcpy(packet_reg.mName, computerName);

    sendPacket(packet_reg);
    printPacket("Registration Packet 2 Sent"), p, true);

    packet_reg_confirm = receivePacket("Registration Confirmation Packet 2", packet_reg_confirm, 222);
    printPacket("Registration Packet 2 Acknowledged", packet_reg_confirm, true);

    // send a 3rd registration packet
    packet_reg.type = htons(123);
    strcpy(packet_reg.uName, userName);
    strcpy(packet_reg.mName, computerName);

    sendPacket(packet_reg);
    printPacket("Registration Packet 3 Sent"), p, true);
    packet_reg_confirm = receivePacket("Registration Confirmation Packet 3", packet_reg_confirm, 223);
    printPacket("Registration Complete", packet_reg_confirm, true);

    /* main loop: get multicast packets */
    while (true) {
        printf("------------------------------------");
        /*
            After the client receives the acknowledgment packet
            it starts receiving the multicast from the server.
        */
        packet_multicast = receivePacket("Multicast Packet", packet_multicast, 231);
        printPacket("Multicast Packet Received", packet_multicast, false);
        printf("\n------------------------------------");
    }
}
