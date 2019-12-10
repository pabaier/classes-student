# Mininet application to Model And Test Different Network Topologies (python2.7)
## Includes a Plotter Script To Plot Test Output (requires python3 and matplotlib)
### Usage
After logging in to mininet run the `main.py` script
```
sudo python main.py
```
### simulation.py
This contains all of the tools to build the network. Controllers, switches, and topologies are specified here (see `topologies.py` for topology details)
##### Controller Options
* `remote`
* `default`
##### Switch Options
* `ovs`
* `ivs`
* `user`
### tests.py
This is a file with all test classes. Test classes must take a mininet network object upon instantiation and implement a `run` method and have a `type` attribute. Any tests that collect data should also have a `getStats` method. Lastly, cutting links is included here because it follows a similar pattern and has a `run` method for actually cutting the links 
##### Test Options with Stats Options
* `pingallfull`
	* `avgrtt` - average round trip time
	* `totaltime` - total time to run all pings
* `pingall`
	* `percentage` - percentage of failed packets
* `iperf`
	* `avgspeed` - average speed of all requests
	* `totalspeed` - total speed to run all requests
* `linkinterrupt`
	* upon instantiation also takes a list of tuples containing the node pairs whose links will be altered and a linkStatus which will indicate whether to cut the link or add it.
* `switchinterrupt`
	* upon instantiation also takes a list of tuples containing the node pairs whose links will be altered and a linkStatus which will indicate whether to cut the link or add it.
* `controllerinterrupt`
	* upon instantiation also takes a list of tuples containing the node pairs whose links will be altered and a linkStatus which will indicate whether to cut the link or add it.
### topologies.py
This is a file with all topology classes.
##### Topology Options
* `bus`
* `ring`
* `star`
* `mesh`
### main.py
Pulls together `Network` and `Tests` in order to
1. Build the network
2. Define the tests to run
3. Define the links to cut and create
4. Order the test plan
5. Run the test plan
6. record the results
This file can be copied to make any other simulation.
##### Output
The output of this script will be a file with the name of the topology followed by a dash and the number of nodes
> Mesh-5

The file itself contains a description on the first line and the results of each run on subsequent lines 
### Plotter Usage
```
python plotter.py -f hiho
```
`--filename/-f` is the name of the file to plot

