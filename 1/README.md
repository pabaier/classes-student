# Chat Room Application

### Compiling
```
./compile.sh
```

### Run Server
```
./server
```

### Run Client
```
./client joe a
```
where:
* `joe` is the user name and `a` is the group name

### Arguments
##### Server
* 0 or 1 arguments only
```
./server 7878
```
where:
* `7878` is the port number
	* default value is `7777`
##### Client
* 2, 3, or 4 arguments
```
./client joe a 7878 a.b.com
```
where:
* `7878` is the server's port number
	* default value is `7777`
* `a.b.com` is the hostname
	* default is `localhost`
* if `hostname` is specified, `port` must be specified before it
