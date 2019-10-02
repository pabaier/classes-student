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
};

/* helper method used to print packet information */
static void printPacket(char *operation, struct packet p, bool isNtoHS) {
    printf("\n %s:\n", operation);
    short t;
    if (isNtoHS)
        t = ntohs(p.type);
    else
        t = htons(p.type);
    printf("\tType: %d\n", t);
    printf("\tUserName: %s\n", p.uName);
    printf("\tMachineName: %s\n", p.mName);
    printf("\tData: %s\n", p.data);
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
    struct packet packet_chat;
    struct packet packet_chat_response;
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
        printPacket("Registration Packet Sent", packet_reg, true);
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
            then we continue into the chat and can send chat messages.
        */

    else if (ntohs(packet_reg_confirm.type) == 221) {
        printPacket("Registration Confirmation Packet Received", packet_reg_confirm, false);
        /*main loop: get and send lines of text */
        printf("\n------------------------------------");
        printf("\nSend server a message: ");

        while (fgets(buf, sizeof(buf), stdin)) {
            buf[MAX_LINE - 1] = '\0';
            printf("------------------------------------");
            /*
                Constructing the chat packet.
                This is the packet that will contain the chat message
                It uses the code '131' indicating it is a chat message.
            */
            packet_chat.type = htons(131);
            strcpy(packet_chat.uName, userName);
            strcpy(packet_chat.mName, computerName);
            strcpy(packet_chat.data, buf);

            /*
                Send the chat packet to the server
            */
            if (send(s, &packet_chat, sizeof(packet_chat), 0) < 0) {
                printf("\nSend Failed \n");
                exit(1);
            } else {
                printPacket("Chat Packet Sent", packet_chat, true);
            }
            /*
                After the server receives the chat packet
                it sends a chat response with code 231.
                If the response code is not 231, we exit the program.
            */
            if (recv(s, &packet_chat_response, sizeof(packet_chat_response), 0) < 0) {
                printf("\n Did not receive chat response \n");
                exit(1);
            } else if (ntohs(packet_chat_response.type) != 231) {
                printPacket("Chat Response Packet Received", packet_chat_response, false);
                exit(1);
            }
            printPacket("Chat Response Packet Received", packet_chat_response, false);
            printf("\n------------------------------------");
            printf("\nSend server a message: ");
        }
    }
        /*
            if the registration confirmation code is not 221
            we exit the program
        */
    else {
        printPacket("Registration Confirmation Packet Received", packet_reg_confirm, false);
        exit(1);
    }

}
