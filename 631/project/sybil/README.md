# Sybil Attack Simulation

This project simulates a central server (server.py) and multiple IoT devices (client.py) reporting to the server. The purpose is to simulate normal data aggregation from a number of IoT nodes, then introduce a bad actor who will distort the data by reporting bad information, and finally defend against the malicious actor by implementing an authentication system as a counter measure.

# Setup
## Normal Conditions
### Server
```
python server.py
```

### IoT Node
##### Trusted Actor
```
python client.py -m 1 -x 10
```
##### Malicious Actor
```
python client.py -m 1 -x 2
```

## Counter Measures With Authentication
### Server
```
```

### IoT Node
##### Trusted Actor
```
```
##### Malicious Actor
```
```