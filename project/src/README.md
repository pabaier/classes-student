# Mininet application to Model And Test Different Network Topologies
## Includes a Plotter Script To Plot Test Output (requires python3 and matplotlib)

### Testing
##### Usage
After logging in to mininet run the `custom-topo` script
```
sudo python custom-topo.py -sc 4 -t mesh -s ovs -r 4
```
`--switch_count/-sc` is the number of switches to use in the topology 
`--topo/-t` is the topology to use. options are found in `topologies.py` and include:
* bus, ring, star, and mesh

`--switch/-sw` indicates which type of switch to use. options are based off the [mininet API](http://mininet.org/api/annotated.html) and include:
* ovs, ivs, and user

`--runs/-r` are the number of times to run the test.

`--test/-ts` is which test to run

`--stat/-s` is which stat to collect based on the test

###### tests and stats
* pingall
	* percentage - percentage of failed packets
* pingallfull
	* avgrtt - average round trip time
	* totaltime - total time to run all pings
* iperf
	* avgspeed - average speed of all requests
	* totalspeed - total speed to run all requests

##### Output
The output of this script will be a file with the name of the topology followed by a dash and the number of nodes
> mesh-5

The file itself contains the topology as the first line, the number of nodes as the second line, and the results of each run on subsequent lines 

### Plotter Usage
```
python plotter.py -f hiho
```
`--filename/-f` is the name of the file to plot

