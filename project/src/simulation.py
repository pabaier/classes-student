from network import Network
from tests import tests
import argparse

def cut_every_other(topology, num_switches):
	# build and start network
	a = Network().set_controller('default').set_number_of_switches(num_switches).set_topology(topology.lower()).build()
	net = a.net
	net.start()

	# initialize tests
	pingAll = tests['pingall'](net)
	pingfull = tests['pingallfull'](net)

	# get links between switches to turn off/on
	# this list is a list of tuples which are the switches between which the links will be turned off/on.
	# for example if we want to break the links between s1 and s2, and s3 and s4
	# the list would look like: [('s1', 's2'), ('s3', 's4')]
	switches = []
	for i in range(1,num_switches + 1):
		for j in range(i+2, num_switches + 1, 2):
			switches.append(('s' + str(i), 's' + str(j)))

	# initialize link strategy
	links_down = tests['linkinterrupt'](net, switches, 'down')
	links_up = tests['linkinterrupt'](net, switches, 'up')

	# lay out test plan
	testPlan = [pingAll, pingfull, links_down, pingAll, pingfull, links_up,  pingAll, pingfull]

	#  open output file
	filename = topology + "-" + str(num_switches)
	title = "Average RTT for " + topology + " Topology With " + str(num_switches) + " Nodes"
	subtitle = "Test 2 Every Other Link Cut"
	f = openfile(filename, title, subtitle)

	# run test plan
	for test in testPlan:
		test.run()
		if test.type == 'pingallfull':
			avg = test.getStats('avgrtt') # avgrtt returns (average, successes, total) where failures count for 3 seconds
			f.write("{}\n".format(str(avg[0])))

	net.stop()

def openfile(fileName, title, subtitle):
	f = open("data/" + fileName, "w")
	f.write("{}\n".format(title))
	f.write("{}\n".format(subtitle))
	return f

if __name__ == '__main__':
	cut_every_other('Mesh', 5)
	cut_every_other('Mesh', 10)
	cut_every_other('Mesh', 20)
