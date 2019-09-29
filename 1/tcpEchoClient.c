#include<stdio.h>
#include<sys/types.h>
#include<sys/socket.h>
#include<netinet/in.h>
#include<netdb.h>
#include<string.h>
#include<stdlib.h>

// #define SERVER_PORT 7777
#define MAX_LINE 256
#define MAXNAME 256

/* structure of the packet */
struct packet{
	short type;
	char uName[MAXNAME];
	char mName[MAXNAME];
	char data[MAXNAME];
};

int main(int argc, char* argv[])
{
	struct hostent *hp;
	struct sockaddr_in sin;
	char *host;
	char buf[MAX_LINE];
	int s;
	int len;
	struct packet packet_reg;
	short SERVER_PORT;

	if(argc == 3){
		host = argv[1];
		SERVER_PORT = atoi(argv[2]);
	}
	else if(argc == 2){
		host = argv[1];
		SERVER_PORT = 7777;
	}
	else{
		fprintf(stderr, "usage:newclient server\n");
		exit(1);
	}

	/* translate host name into peer's IP address */
	hp = gethostbyname(host);
	if(!hp){
		fprintf(stderr, "unkown host: %s\n", host);
		exit(1);
	}

	/* active open */
	if((s = socket(PF_INET, SOCK_STREAM, 0)) < 0){
		perror("tcpclient: socket");
		exit(1);
	}

	/* build address data structure */
	bzero((char*)&sin, sizeof(sin));
	sin.sin_family = AF_INET;
	bcopy(hp->h_addr, (char *)&sin.sin_addr, hp->h_length);
	sin.sin_port = htons(SERVER_PORT);

	if(connect(s,(struct sockaddr *)&sin, sizeof(sin)) < 0){
		perror("tcpclient: connect");
		close(s);
		exit(1);
	}

	/* Constructing the registration packet at client */
	packet_reg.type = htons(121);
	strcpy(packet_reg.uName, "steve");
	strcpy(packet_reg.mName, host);

	/* Send the registration packet to the server */
	if(send(s, &packet_reg,sizeof(packet_reg),0) < 0)	
	{
		printf("\n Send failed\n");
		exit(1);
	}

	/* main loop: get and send lines of text */
	while(fgets(buf, sizeof(buf), stdin)){
		buf[MAX_LINE-1] = '\0';
		len = strlen(buf) + 1;
		send(s, buf, len, 0);
	}
}
