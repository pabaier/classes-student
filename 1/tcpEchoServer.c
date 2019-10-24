#include<stdio.h>
#include<sys/types.h>
#include<sys/socket.h>
#include<netinet/in.h>
#include<netdb.h>
#include<pthread.h>
#include<string.h>
#include<stdlib.h>
#include <unistd.h>
#include <stdbool.h>
#include <fcntl.h>

// #define SERVER_PORT 7777
#define MAX_LINE 256
#define MAX_PENDING 5
#define MAXNAME 256
#define TABLESIZE 10

// number of threads the server must run
pthread_t threads[2];

/* structure of the packet */
struct packet {
    short type;
    char uName[MAXNAME];
    char mName[MAXNAME];
    char data[MAXNAME];
    short seqNumber;
};

/* structure of Registration Table */
struct registrationTable {
    int port;
    int sockid;
    char mName[MAXNAME];
    char uName[MAXNAME];
};

/* make registration table global
 * 1) so methods outside of main can access it without needing to pass it as a parameter
 * 2) so all registrationTable values are initialized to default values (zero and empty string)
*/
struct registrationTable table[TABLESIZE];

/* Declare a global mutex variable
 * When a thread wants to access the table, it will lock the
 * mutex variable first.
 * Then it will read/update the table.
 * The thread will unlock the mutex variable
*/
pthread_mutex_t my_mutex = PTHREAD_MUTEX_INITIALIZER;

/* global table_index for the table */
int table_index = 0;

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

/* helper method used to send packet
 * if the send fails, the program prints that it failed and exits
 */
static void sendPacket(struct packet p, int clientSocket) {
    if (send(clientSocket, &p, sizeof(p), 0) < 0) {
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
static struct packet receivePacket(char *operation, struct packet p, int clientSocket, int packetType) {
    if (recv(clientSocket, &p, sizeof(p), 0) < 0) {
        printf("\n %s \n", strConcat("Did not receive ", operation));
        exit(1);
    } else if (ntohs(p.type) != packetType) {
        printPacket(strConcat(operation, " Received"), p, false);
        printf("\nError Received. Exiting \n");
        exit(1);
    }
    return p;
}

/* chat multicaster method */
void *chat_multicaster() {
    char *filename;
    char text[1000];
    int fd;
    bool clientRegistered;
    struct packet packet_data;
    int seqNumber = 1;

    /* open the file */
    filename = "input.txt";
    fd = open(filename, O_RDONLY, 0);

    /* continuously loop in order to send data to clients once they register */
    while (true) {
        clientRegistered = false;
        /* Check whether any client is listed on the table
         * If at least one client is listed, read 100 bytes of data
         * from the file and store it in text
         */

        /* loops through the registration table looking for clients
         * sets the clientRegistered flag to true if it finds one
         */
        int i;
        for (i = 0; i < TABLESIZE; i++) {
            if (table[i].port != 0) {
                clientRegistered = true;
                /* lock the table once we need it */
                pthread_mutex_lock(&my_mutex);
                break;
            }
        }

        /* if a client is found start reading and sending data */
        if (clientRegistered) {
            ssize_t nread = read(fd, text, 100);

            /* loop through the table and construct the data packet
             * for each client in the table.
             * once the packet is made, send it to the client
             */
            for (i = 0; i < TABLESIZE; i++) {
                if (table[i].port != 0) {
                    packet_data.type = htons(231);
                    packet_data.seqNumber = htons(seqNumber);
                    strcpy(packet_data.uName, table[i].uName);
                    strcpy(packet_data.mName, table[i].mName);
                    strcpy(packet_data.data, text);
                    sendPacket(packet_data, table[i].sockid);
                    printPacket("Data Packet Sent", packet_data, true);
                }
            }
            seqNumber++;
            /* unlock the table */
            pthread_mutex_unlock(&my_mutex);
            /* this pauses the sending of packets for 1 second.
             * it is not required but helps to make the output readable
             */
            sleep(1);
        }
    }
}

// join handler method
void *join_handler(struct registrationTable *clientData) {
    int newsock;
    int newport;
    int rg_count;
    struct packet packet_reg;
    struct packet packet_reg_confirm;
    newsock = clientData->sockid;
    newport = clientData->port;

    /*
     * Get second registration packet from client.
     * The server expects the second registration packet type to be 122
     */
    packet_reg = receivePacket("Registration Packet 2", packet_reg, newsock, 122);
    printPacket("Registration Packet 2 Received", packet_reg, true);

    /*
     * Build and send confirmation for second registration packet.
     * The client expects the second registration confirmation packet type to be 222
     */
    packet_reg_confirm.type = htons(222);
    strcpy(packet_reg_confirm.uName, packet_reg.uName);
    strcpy(packet_reg_confirm.mName, packet_reg.mName);
    sendPacket(packet_reg_confirm, newsock);
    printPacket("Registration Confirmation Packet Sent", packet_reg_confirm, true);

    /*
     * Get third registration packet from client.
     * The server expects the third registration packet type to be 123
     */
    packet_reg = receivePacket("Registration Packet 3", packet_reg, newsock, 123);
    printPacket("Registration Packet 3 Received", packet_reg, true);

    /*
     * Build and send confirmation for third registration packet.
     * The client expects the third registration confirmation packet type to be 223
     */
    packet_reg_confirm.type = htons(223);
    strcpy(packet_reg_confirm.uName, packet_reg.uName);
    strcpy(packet_reg_confirm.mName, packet_reg.mName);
    sendPacket(packet_reg_confirm, newsock);
    printPacket("Registration Confirmation Packet Sent", packet_reg_confirm, true);

    /* if the client makes it this far, reward them
     * by registering them in the registration table
     */
    table[table_index].port = newport;
    table[table_index].sockid = newsock;
    strcpy(table[table_index].uName, packet_reg.uName);
    strcpy(table[table_index].mName, packet_reg.mName);
    table_index++;

    // Wait for more registration packets from the client
    // Send acknowledgement/confirmation to the client
    // Update the table
    // Leave the thread
    pthread_exit(NULL);
}

int main(int argc, char *argv[]) {
    struct sockaddr_in sin;
    struct sockaddr_in clientAddr;
    char buf[MAX_LINE];
    int s, new_s;
    int len;
    struct packet packet_reg;
    struct packet packet_reg_confirm;
    struct packet packet_chat;
    struct packet packet_chat_response;
    struct registrationTable client_info;
    short SERVER_PORT;
    pthread_t threads[2];

    /*
        The following grabs the command line arguments.
        It will take a port number as a parameter otherwise
        the port number will default to 7777.
    */
    if (argc == 2) {
        SERVER_PORT = atoi(argv[1]);
    } else {
        SERVER_PORT = 7777;
    }

    /* setup passive open */
    if ((s = socket(PF_INET, SOCK_STREAM, 0)) < 0) {
        perror("tcpserver: socket");
        exit(1);
    }

    /* build address data structure */
    bzero((char *) &sin, sizeof(sin));
    sin.sin_family = AF_INET;
    sin.sin_addr.s_addr = INADDR_ANY;
    sin.sin_port = htons(SERVER_PORT);

    if (bind(s, (struct sockaddr *) &sin, sizeof(sin)) < 0) {
        perror("tcpclient: bind");
        exit(1);
    }
    listen(s, MAX_PENDING);

    len = sizeof(struct sockaddr_in);

    /* create the chat multicaster thread */
    pthread_create(&threads[1], NULL, chat_multicaster, NULL);

    /* wait for connection, then start the registration process */
    while (1) {
        if ((new_s = accept(s, (struct sockaddr *) &clientAddr, &len)) < 0) {
            perror("tcpserver: accept");
            exit(1);
        }

        printf("\n Client's port is %d \n", ntohs(clientAddr.sin_port));

        /*
         * Get first registration packet from client.
         * The server expects the first registration packet type to be 121
         */
        packet_reg = receivePacket("Registration Packet 1", packet_reg, new_s, 121);
        printPacket("Registration Packet 1 Received.", packet_reg, true);

        /*
         * Build and send confirmation for first registration packet.
         * The client expects the first registration confirmation packet type to be 221
         */
        packet_reg_confirm.type = htons(221);
        strcpy(packet_reg_confirm.uName, packet_reg.uName);
        strcpy(packet_reg_confirm.mName, packet_reg.mName);
        sendPacket(packet_reg_confirm, new_s);
        printPacket("Registration Confirmation Packet Sent", packet_reg_confirm, true);

        /* insert client data into client_info variable */
        client_info.port = ntohs(clientAddr.sin_port);
        client_info.sockid = new_s;
        strcpy(client_info.uName, packet_reg.uName);
        strcpy(client_info.mName, packet_reg.mName);

        /* pass client_info into join_handler thread */
        pthread_create(&threads[0], NULL, join_handler, &client_info);

        /* wait for the join_handler thread to complete
         * exit_value is the value returned by the join_handler
         */
        void *exit_value;
        pthread_join(threads[0], &exit_value);
    }
}

