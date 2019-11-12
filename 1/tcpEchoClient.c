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
};

/* helper method used to print packet information */
static void printPacket(char *operation, struct packet p, bool isNtoHS) {
    printf("\n %s:\n", operation);
    short t;
    short s;
    if (isNtoHS) {
        t = ntohs(p.type);
    } else {
        t = htons(p.type);
    }
    printf("\tType: %d\n", t);
    printf("\tUserName: %s\n", p.uName);
    printf("\tMachineName: %s\n", p.mName);
    printf("\tData: %s\n", p.data);
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

/*
 * this method is run in a separate thread from the main thread
 * and its purpose is to wait to receive chat messages from other
 * clients in the chat room
 */
void *receive_chat() {
    struct packet packet_chat_in;
    /*
     * After the client receives the final registration acknowledgment packet
     * it waits to receive chat packets of type 231 from 
     * other group members via the server and when it does, it prints the
     * packet's data, which is the chat message
     */
    while (true) {
        packet_chat_in = receivePacket("Chat Packet", packet_chat_in, 231);
        printf("\t%s: %s", packet_chat_in.uName, packet_chat_in.data);
    }

}

int main(int argc, char *argv[]) {
    /* declare variables */
    struct hostent *hp;
    struct sockaddr_in sin;
    char *host, *userName, *groupName;
    char computerName[MAXNAME];
    char buf[MAX_LINE];
    struct packet packet_reg;
    struct packet packet_reg_confirm;
    struct packet packet_chat, packet_chat_confirm;
    short SERVER_PORT;
    pthread_t receive_chat_thread;


    /*
        The following grabs the command line arguments.
        Besides the name of the program,
        if there are 2 arguments, the user name will be the first one,
        and the group name will be the second one.
        if there are 3 arguments, the user name will be the first one,
        the group name will be the second one, and the server port will be
        the third one.
        if there are 4 arguments, the user name will be the first one,
        the group name will be the second one, the server port will be
        the third one, and the server hostname will be the fourth one.
        if there are no arguments, the program will exit.
    */
    if (argc == 5) {
        userName = argv[1];
        groupName = argv[2];
        SERVER_PORT = atoi(argv[3]);
        host = argv[4];
    } else if (argc == 4) {
        userName = argv[1];
        groupName = argv[2];
        SERVER_PORT = atoi(argv[3]);
        host = "localhost";
    } else if (argc == 3) {
        userName = argv[1];
        groupName = argv[2];
        SERVER_PORT = 7777;
        host = "localhost";
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
    strcpy(packet_reg.data, groupName);

    sendPacket(packet_reg);
    printPacket("Registration Packet 1 Sent", packet_reg, true);

    packet_reg_confirm = receivePacket("Registration Confirmation Packet 1", packet_reg_confirm, 221);
    printPacket("Registration Packet 1 Acknowledged", packet_reg_confirm, false);

    /*
     * start thread to receive chat packets.
     * this thread runs the receive_chat method
     */
    pthread_create(&receive_chat_thread, NULL, receive_chat, NULL);

    /* main thred to get user input */
    while (fgets(buf, sizeof(buf), stdin)) {
        buf[MAX_LINE - 1] = '\0';
        /*
            Constructing the chat packet.
            This is the packet that will contain the chat message
            It uses the code '131' indicating to the server it is a chat message.
        */
        packet_chat.type = htons(131);
        strcpy(packet_chat.uName, userName);
        strcpy(packet_chat.mName, computerName);
        strcpy(packet_chat.data, buf);

        /*
            Send the chat packet to the server
        */
        sendPacket(packet_chat);
    }
}
