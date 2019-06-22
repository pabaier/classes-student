### Executables

This project uses Python 3.6 and virtual env. Virtual env can be installed with pip. Once installed, activate it from the root directory by running

```bash
python -m venv env
```

then run it by running

```bash
source env/bin/activate
```

Once your virtual environment is running you can install the requirements by running

```bash
pip3 install -r requirements.txt
```

The code can be run locally and requires at minimum one server running. To run multiple servers, the entire directory should be copied as many times as desired. Each copy will run one implementation of the blockchain. It is better to copy the directory after virtual env is set up and the requirements are installed. **After it is copied do not forget to start the virtual environment in each directory** by running

```bash
source env/bin/activate
```

A server can be run with the following command from the terminal

```bash
python server/server.py --port 8080 --rport 8081
```



`--port` is the port number this server will run on. `--rport` is the port on which any servers will be running that this server will communicate with. If you want to run 3 servers, copy the directory 3 times and run the following commands in each directory:

```bash
python server/server.py --port 8080 --rport 8081 8082
```

```bash
python server/server.py --port 8081
```

```bash
python server/server.py --port 8082
```

The first command says that the first server will run on port `8080` and will forward transactions to servers on ports`8081` and `8082`. The second and third commands establish two more servers running on ports `8081` and `8082` respectively and they do not forward messages to any other servers, although they can if the `--rport` argument is defined. This argument takes any number of ports listed with spaces in between.
	Once the servers are running, you can run the client program form the root directory of any of the copies of the project. Run the client program with the following command:

```bash
python app.py -p 8082
```

**Again, make sure you are running inside the virtual environment with all dependencies installed**

The client program has instruction once it is running. It gives options to send data, get a transaction by id, get all of your transactions (based on your private key), and exit. When the client is instantiated with will check for two files, `private.key` and `public.key` in the `client/` directory. If they are found, they will be used and represent the client’s identity. If they are not found, the client will generate new ones into that directory. By changing the public and private keys in the client directory, different users can be represented.