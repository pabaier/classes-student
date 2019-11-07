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

// STRUCT DEFINITIONS
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
    char uName[MAXNAME];
    char mName[MAXNAME];
};

/* structure of Group Table */
struct groupTable {
    char name[MAXNAME];
    /* these two variables are pointers because when we update then,
     * we want to update them across all threads
     * so we get the value the are pointing to, increase/add to it, then
     * have them point to the new updated value.
     */
    struct registrationTable *registeredClients;
    int *registrantCount;
};

/* structure of the information passed to the join handler */
struct joinHandlerInfo {
    struct registrationTable *clientData;
    char groupName[MAXNAME];
};

/* make registration table global
 * 1) so methods outside of main can access it without needing to pass it as a parameter
 * 2) so all registrationTable values are initialized to default values (zero and empty string)
*/
struct groupTable groups[TABLESIZE];
/*
 * need to keep track of the number of groups in the group table for when we
 * check if a group exists and when we add a group to the table.
 * this needs to be global to the server because it is used accross threads
 */
int num_groups = 0;

/* Declare a global mutex variable
 * When a thread wants to access the table, it will lock the
 * mutex variable first.
 * Then it will read/update the table.
 * The thread will unlock the mutex variable
*/
pthread_mutex_t my_mutex = PTHREAD_MUTEX_INITIALIZER;

/* index for number of threads (one per client) */
int num_clients = 0;

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

/* helper method used to get the index of the group from the groups table
 * the method takes in a string as a parameter which is the groupd name to search for.
 * it uses the num_groups variable to loop through the groups table and compares
 * the group names with the input group name.
 * if the names match, the method returns the table index value of that group
 * if there is no match, the method returns -1
 */
static int getGroup(char *groupName) {
    for(int i = 0; i < num_groups; i++) {
        if(strcmp(groupName, groups[i].name) == 0) {
            return i;
        }
    }
    return -1;
}

/*
 * this method is run in a separate thread from the main thread
 * and its purpose is to wait for a message from the client, then
 * send the message to all members of the client's group.
 * every client has this thread uniquely running
 */
void *join_handler(struct joinHandlerInfo *i) {
    /* get the clients information from the method parameter */
    struct joinHandlerInfo info = *i;
    /* get the client data in the format of the registrationTable struct */
    struct registrationTable clientData = *i->clientData;
    char *groupName = info.groupName;

    /* declare variables */
    int newsock;
    int newport;
    int rg_count;
    struct packet packet_reg;
    struct packet packet_reg_confirm;
    struct packet packet_message;
    struct groupTable group;
    /* there can be a maximum of 100 groups at a time */
    struct registrationTable groupRegistrationTable[100];
    newsock = clientData.sockid;
    newport = clientData.port;
    
    /*
     * Basic Outline
     * 1. check if group exists
     * 2. if it does, add this client to the group's registration table
     * 3. if it does not, create the group in the groupTable and register this client
     */

    /*
     * 1. check if group exists in groups table
     */
    int groupIndex = getGroup(groupName);
    /*
     * 2. group exists, so add this client to the group's registration table
     */
    if(groupIndex >= 0) {
        group = groups[groupIndex];
        int regCount = *group.registrantCount;
        /* add this client to the group's registeredClients list */
        group.registeredClients[regCount] = clientData;
        regCount++;
        /* point the group's registrantCount variable to the updated value */
        groups[groupIndex].registrantCount = &regCount;
    }
    /*
     * 3. group does not exist, so add the group name and create a new registration table for the group
     */
    else {
        groupIndex = num_groups;
        strcpy(group.name, groupName);
        /* add this first client to the group's registration table */
        groupRegistrationTable[0] = clientData;
        group.registeredClients = groupRegistrationTable;
        int registrantCount = 1;
        /*
         * point the registrantCount value in the groupTable to 
         * the memory location of registrantCount
         */
        group.registrantCount = &registrantCount;
        /* add this new group to the groups table and increment the number of groups by 1*/
        groups[groupIndex] = group;
        num_groups++;
    }
    
    // keep thread open for each client so they can send messages to broadcast
    while (true) {
        /*
         * receive the information from the client, then 
         * send it to everyone in the group's registration table
         * the server is expecting a chat packet to have type 131
         */
        packet_message = receivePacket("Chat Packet", packet_message, newsock, 131);
        /* we already have this client's group from above, but we
         * get it again incase any of the pointers have changed
         */
        group = groups[groupIndex];
        struct registrationTable client;

        // send the message to everyone in the group (but not to yourself) with type 231
        packet_message.type = htons(231);
        for(int i = 0;i < *group.registrantCount; i++) {
            /* get the client from the group registeredClients table */
            client = group.registeredClients[i];
            /*
             * check if it is us by comparing the entry's port number
             * with our port number. If they are different, it's not us
             * so send the message to them
             */
            if(client.port != newport) {
                sendPacket(packet_message, client.sockid);
                printf("Sent to Group %s, user %s\n", group.name, client.uName);
            }
        }
    }
    pthread_exit(NULL);
}

int main(int argc, char *argv[]) {
    /* declare variables */
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
    struct joinHandlerInfo info;
    short SERVER_PORT;
    pthread_t threads[100];

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
        strcpy(packet_reg_confirm.data, packet_reg.data);
        sendPacket(packet_reg_confirm, new_s);
        printPacket("Registration Confirmation Packet Sent", packet_reg_confirm, true);

        /* insert client data into client_info variable */
        client_info.port = ntohs(clientAddr.sin_port);
        client_info.sockid = new_s;
        strcpy(client_info.uName, packet_reg.uName);
        strcpy(client_info.mName, packet_reg.mName);

        info.clientData = &client_info;
        strcpy(info.groupName, packet_reg.data);

        /* pass client_info into join_handler thread */
        pthread_create(&threads[num_clients], NULL, join_handler, &info);
        /* increment the num_clients variable by one */
        num_clients++;
    }
}

