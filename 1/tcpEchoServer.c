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

void *chat_multicaster() {
    char *filename;
    char text[1000];
    int fd;
    bool clientRegistered;
    struct packet packet_data;
    int seqNumber = 1;

    filename = "input.txt";
    fd = open(filename, O_RDONLY, 0);

    while (true) {
        clientRegistered = false;
        // Check whether any client is listed on the table
        // If at least one client is listed, readd 100 bytes ofdata from the
        // file and store it in text
        int i;
        for (i = 0; i < TABLESIZE; i++) {
            if (table[i].port != 0) {
                clientRegistered = true;
                pthread_mutex_lock(&my_mutex);
                break;
            }
        }

        if (clientRegistered) {
            ssize_t nread = read(fd, text, 100);

            // Construct the data packet
            // Send data packets to each client listed on the table
            for (i = 0; i < TABLESIZE; i++) {
                if (table[i].port != 0) {
                    packet_data.type = htons(231);
                    packet_data.seqNumber = htons(seqNumber);
                    strcpy(packet_data.uName, table[i].uName);
                    strcpy(packet_data.mName, table[i].mName);
                    strcpy(packet_data.data, text);
                    if (send(table[i].sockid, &packet_data, sizeof(packet_data), 0) < 0) {
                        printf("\n Send failed\n");
                        exit(1);
                    } else {
                        printf("%d ", seqNumber);
                        printPacket("Data Packet Sent", packet_data, true);
                    }
                }
            }
            seqNumber++;
            pthread_mutex_unlock(&my_mutex);
            sleep(1);
        }
    }
}

// join handler method
void *join_handler(struct registrationTable*clientData) {
    int newsock;
    int newport;
    int rg_count;
    struct packet packet_reg;
    struct packet packet_reg_confirm;
    newsock = clientData->sockid;
    newport = clientData->port;

    // check if client has responded 
    if (recv(newsock,&packet_reg,sizeof(packet_reg),0)<0) {
        printf("\nDid not receive registration packet 2\n");
        exit(1);
        }
    // make sure the packet is valid
    else if (ntohs(packet_reg.type) == 122) {
        // acknowledge the second packet
        printPacket("Registration Packet 2 received", packet_reg, true);
        // construct acknowledgement packet
        packet_reg_confirm.type = htons(222);
        strcpy(packet_reg_confirm.uName, packet_reg.uName);
        strcpy(packet_reg_confirm.mName, packet_reg.mName);
        // send acknowledgement to client
        if (send(newsock, &packet_reg_confirm, sizeof(packet_reg_confirm), 0) < 0) {
            printf("\n Send failed\n");
            exit(1);
        } else {
            printPacket("Registration Confirmation Packet Sent", packet_reg_confirm, true);
            // check to see if client has submitted final registration packet
            if (recv(newsock,&packet_reg,sizeof(packet_reg),0)<0) {
                printf('\nDid not receive registration packet 3\n');
                exit(1);
            }
            else if (ntohs(packet_reg.type) == 123) {
                // acknowledge the third packet
                printPacket("Registration Packet 3 received", packet_reg, true);
                packet_reg_confirm.type = htons(223);
                strcpy(packet_reg_confirm.uName, packet_reg.uName);
                strcpy(packet_reg_confirm.mName, packet_reg.mName);
                if (send(newsock, &packet_reg_confirm, sizeof(packet_reg_confirm), 0) < 0) {
                    printf("\n Send failed\n");
                    exit(1);
                } else {
                    printPacket("Registration Confirmation Packet Sent", packet_reg_confirm, true);
                }
            }
        }
    }

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
    int len, index = 0;
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

    pthread_create(&threads[1], NULL, chat_multicaster, NULL);

    /* wait for connection, then receive and print text */
    while (1) {
        if ((new_s = accept(s, (struct sockaddr *) &clientAddr, &len)) < 0) {
            perror("tcpserver: accept");
            exit(1);
        }

        printf("\n Client's port is %d \n", ntohs(clientAddr.sin_port));

        /*
            Get registration packet
            After establishing a connection, the client must register with
            the server.
        */
        if (recv(new_s, &packet_reg, sizeof(packet_reg), 0) < 0) {
            printf("\n Could not receive first registration packet \n");
            exit(1);
        }
            /*
                if valid registration packet
                This checks to make sure the registration packet code is 121.
                If it is, register the client in the registration table and
                send the registration confirmation to the client
            */
        else if (ntohs(packet_reg.type) == 121) {
            printPacket("Registration Packet Received.", packet_reg, true);
            // insert client data into client_info variable
            client_info.port = ntohs(clientAddr.sin_port);
            client_info.sockid = new_s;
            strcpy(client_info.uName, packet_reg.uName);
            strcpy(client_info.mName, packet_reg.mName);
            // pass client_info into join_handler thread
            pthread_create(&threads[0],NULL,join_handler,&client_info);

            /* register client in the registration table */
            table[index].port = clientAddr.sin_port;
            table[index].sockid = new_s;
            strcpy(table[index].uName, packet_reg.uName);
            strcpy(table[index].mName, packet_reg.mName);
            index++;

            /*
                build and send confirmation packet
                the confirmation packet code is 221.
                this code is returned to the client along with the
                information the originally sent.
            */
            packet_reg_confirm.type = htons(221);
            strcpy(packet_reg_confirm.uName, packet_reg.uName);
            strcpy(packet_reg_confirm.mName, packet_reg.mName);
            if (send(new_s, &packet_reg_confirm, sizeof(packet_reg_confirm), 0) < 0) {
                printf("\n Send failed\n");
                exit(1);
            } else {
                printPacket("Registration Confirmation Packet Sent", packet_reg_confirm, true);
            }
            /*
                loop and continue to receive chat packets from the client.
                valid chat packets have code 131
            */
            /*while (len = recv(new_s, &packet_chat, sizeof(packet_chat), 0)) {
                /*
                    Check the chat packet type. If it is not 131,
                    Send a response type of 1, indicating an error.
                
                if (ntohs(packet_chat.type) != 131) {
                    packet_chat_response.type = htons(1);
                    printPacket("Chat Packet Received", packet_chat, false);
                    printf("\nChat Packet type not recognized");
                }
                    /*
                        If the chat packet type is 131, continue to print the chat
                        message and respond with the successful code 231
                    */
                else {
                    printPacket("Chat Packet Received", packet_chat, false);
                    printf("\n------------------------------------\n");
                    printf("%s: %s", table[index - 1].uName, packet_chat.data);
                    printf("------------------------------------");
                    /*
                        Build the chat response packet to the client.
                        chat reponse packets contain code 231 along with all of the
                        information contained in the client's chat packet.
                    
                    packet_chat_response.type = htons(231);
                    strcpy(packet_chat_response.uName, packet_chat.uName);
                    strcpy(packet_chat_response.mName, packet_chat.mName);
                    strcpy(packet_chat_response.data, packet_chat.data);
                }
                /*
                    Send the chat response packet back to the client.
                
                if (send(new_s, &packet_chat_response, sizeof(packet_chat_response), 0) < 0) {
                    printf("\n Send Failed \n");
                    exit(1);
                }
                printPacket("Chat Response Packet Sent", packet_chat_response, true);
            }
            close(new_s);*/
        }
            /*
                not valid registration packet
                if the registration packet code is not 121, send a packet back
                to the client with a code other than 221, which indicates to the
                client that there was a problem with their registration.
            */
        else {
            printPacket("Registration Packet Received", packet_reg, false);
            packet_reg_confirm.type = htons(1);
            if (send(new_s, &packet_reg_confirm, sizeof(packet_reg_confirm), 0) < 0) {
                printf("\n Send failed\n");
                exit(1);
            }
            printPacket("Registration Confirmation Packet Sent", packet_reg_confirm, true);
            printf("\n %d is not a recognized command \n", ntohs(packet_reg.type));
        }
    }
}

