# Chat Room Application

### Compiling
```
./complie.sh
```

### Run Server
```
./server
```

### Run Client
```
./client joe a
```
* where `joe` is the user name and `a` is the group name

### Arguments
##### Server
* 0 or 1 arguments only
```
./server 7878
```
* where `7878` is the port number
* default value is `7777`
##### Client
* 2 or 3 arguments only
```
./client a.b.com joe a
```
* where `a.b.com` is the hostname
* default is `localhost`
