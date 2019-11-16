from program import Program
from tests import tests
import argparse

def main():
	# build and start network
	a = Program().set_controller('default').set_number_of_switches(5).set_topology('mesh').build()
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
	for i in range(2,6):
		switches.append(('s1', 's' + str(i)))

	# initialize link strategy
	links_down = tests['linkinterrupt'](net, switches, 'down')
	links_up = tests['linkinterrupt'](net, switches, 'up')

	# lay out test plan
	testPlan = [pingAll, pingfull, links_down, pingAll, pingfull, links_up,  pingAll, pingfull]

	#  open output file
	f = openfile("mesh-5", "Average RTT for Mesh Topology With 5 Nodes")

	# run test plan
	for test in testPlan:
		test.run()
		if test.type == 'pingallfull':
			avg = test.getStats('avgrtt') # avgrtt returns (average, successes, total) where failures count for 3 seconds
			f.write("{}\n".format(str(avg[0])))

	net.stop()

def openfile(fileName, title):
	f = open(fileName, "w")
	f.write("{}\n".format(title))
	return f

if __name__ == '__main__':
	main()
