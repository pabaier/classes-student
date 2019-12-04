from network import Network
from tests import tests
import argparse
from mininet.cli import CLI
from mininet.node import Controller,OVSSwitch
from mininet.net import Mininet
import topologies
from topologies import topos

def main(topology, controller_count):
	down_pairs = [(1,None), (2,None), (3,None), (4,None), (5,None), 
		(1,2), (1,3), (1,4), (1,5),
		(2,3), (2,4), (2,5),
		(3,4), (3,5), (4,5)]
	if controller_count == 6:
		down_pairs += [(6, None), (1,6), (2,6), (3,6), (4,6), (5,6)]
	for d in down_pairs:
		runTest(d, topology, controller_count)

def runTest(d, topology='highwinds', controller_count=5):
	topologyName = topology.capitalize() + "-" + str(controller_count)
	if d[1]:
		filename = topologyName + "-c" + str(d[0]) + "-c" + str(d[1])
		subtitle = "Average RTT with c" + str(d[0]) + " and c" + str(d[1])+ " Down"
	else:
		filename = topologyName + "-c" + str(d[0])
		subtitle = "Average RTT with c" + str(d[0]) + " Down"
	title = topologyName + " Controllers"
	f = open("data/" + filename, "a")
	f.write("{}\n".format(title))
	f.write("{}\n".format(subtitle))

	for test in range(2):
		net = Mininet( controller=Controller, switch=OVSSwitch )
		controllers = topos[topology](net, controller_count)

		# tests
		pingfull = tests['pingallfull'](net)
		toggles = []
		for c in controllers:
			toggles.append(tests['controllerinterrupt'](net, c))

		if test == 0:
			plan = [pingfull, pingfull]
		elif d[1]:
			plan = [toggles[d[0]-1], toggles[d[1]-1], pingfull, pingfull]
		else:
			plan = [toggles[d[0]-1], pingfull, pingfull]
		for test in plan:
			test.run()
			if test.type == 'pingallfull':
				avg = test.getStats('avgrtt') # avgrtt returns (average, successes, total) where failures count for 3 seconds
				f.write("{}\n".format(str(avg[0])))
				f.write("{}\n".format(str(avg[2] - avg[1])))

		# CLI (net)
		net.stop()

	
if __name__ == '__main__':
	main()