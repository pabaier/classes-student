# Request To Send/Clear To Send Simulation

This project simulates a central receiver/switch (serverSock.py) and multiple clients (clientSock.py) connecting to the switch. The purpose is to simulate the RTS/CTS process normally, then introduce a bad actor who will jam the receiver, and finally defend against the malicious actor by implementing the channel hopping counter measure.

# Setup
## Normal Conditions
### Server
```
python serverSock.py -c 2
```

### Client
##### Trusted Actor
```
python clientSock.py -n steve -c 2
```
##### Malicious Actor
```
python clientSock.py -n bad_egg -s false -c 2
```

## Counter Measures With Channel Hopping
### Server
```
python serverSock.py
```

### Client
##### Trusted Actor
```
python clientSock.py -n steve
```
##### Malicious Actor
```
python clientSock.py -n bad_egg -s false -c 2