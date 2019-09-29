#include<stdio.h>
#include<sys/types.h>
#include<sys/socket.h>
#include<netinet/in.h>
#include<netdb.h>
#include<string.h>
#include<stdlib.h>

// #define SERVER_PORT 7777
#define MAX_LINE 256
#define MAX_PENDING 5
#define MAXNAME 256

/* structure of the packet */
struct packet{
	short type;
	char uName[MAXNAME];
	char mName[MAXNAME];
	char data[MAXNAME];
};

/* structure of Registration Table */
struct registrationTable{
int port;
int sockid;
char mName[MAXNAME];
char uName[MAXNAME];
};

int main(int argc, char* argv[])
{
	struct sockaddr_in sin;
	struct sockaddr_in clientAddr;
	char buf[MAX_LINE];
	int s, new_s;
	int len;
	struct packet packet_reg;
	struct registrationTable table[10];
	short SERVER_PORT;

	if(argc == 2){
		SERVER_PORT = atoi(argv[1]);
	}
	else{
		SERVER_PORT = 7777;
	}	

	/* setup passive open */
	if((s = socket(PF_INET, SOCK_STREAM, 0)) < 0){
		perror("tcpserver: socket");
		exit(1);
	}

	/* build address data structure */
	bzero((char*)&sin, sizeof(sin));
	sin.sin_family = AF_INET;
	sin.sin_addr.s_addr = INADDR_ANY;
	sin.sin_port = htons(SERVER_PORT);

	if(bind(s,(struct sockaddr *)&sin, sizeof(sin)) < 0){
		perror("tcpclient: bind");
		exit(1);
	}
	listen(s, MAX_PENDING);

	len = sizeof(struct sockaddr_in);

	/* wait for connection, then receive and print text */
	while(1){
		if((new_s = accept(s, (struct sockaddr *)&clientAddr, &len)) < 0){
			perror("tcpserver: accept");
			exit(1);
		}

		printf("\n Client's port is %d \n", ntohs(clientAddr.sin_port)); 

		if(recv(new_s, &packet_reg,sizeof(packet_reg),0) < 0)
		{
			printf("\n Could not receive first registration packet \n");
			exit(1);
		}
		else if(ntohs(packet_reg.type) == 121)
		{
			printf("\n Client's info is %d", ntohs(packet_reg.type));
			printf("\n %s", packet_reg.uName); 
			printf("\n %s\n", packet_reg.mName); 
		}
		else
		{
			printf("\n %d is not a recognized command \n", ntohs(packet_reg.type)); 
		}

		while(len = recv(new_s, buf, sizeof(buf), 0))
			fputs(buf, stdout);
		close(new_s);
	}
}
