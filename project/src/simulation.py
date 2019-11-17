from network import Network
from tests import tests
import argparse

def avgRtt(topology, num_switches, switches, filename, subtitle):
	# build and start network
	a = Network().set_controller('default').set_number_of_switches(num_switches).set_topology(topology.lower()).build()
	net = a.net
	net.start()

	# initialize tests
	pingAll = tests['pingall'](net)
	pingfull = tests['pingallfull'](net)

	# initialize link strategy
	links_down = tests['linkinterrupt'](net, switches, 'down')
	links_up = tests['linkinterrupt'](net, switches, 'up')

	# lay out test plan
	# testPlan = [pingAll, pingfull, links_down, pingAll, pingfull, links_up,  pingAll, pingfull]
	testPlan = [pingfull, pingfull, links_down, pingfull, pingfull, links_up,  pingfull, pingfull]

	#  open output file
	title = "Average RTT for " + topology + " Topology With " + str(num_switches) + " Nodes"
	f = openfile(filename, title, subtitle)

	# run test plan
	for test in testPlan:
		test.run()
		if test.type == 'pingallfull':
			avg = test.getStats('avgrtt') # avgrtt returns (average, successes, total) where failures count for 3 seconds
			f.write("{}\n".format(str(avg[0])))
			f.write("{}\n".format(str(avg[2] - avg[1])))

	net.stop()

def avgSpeed(topology, num_switches, switches, filename, subtitle):
	# build and start network
	a = Network().set_controller('default').set_number_of_switches(num_switches).set_topology(topology.lower()).build()
	net = a.net
	net.start()

	# initialize tests
	pingAll = tests['pingall'](net)
	iperf = tests['iperf'](net)

	# initialize link strategy
	links_down = tests['linkinterrupt'](net, switches, 'down')
	links_up = tests['linkinterrupt'](net, switches, 'up')

	# lay out test plan
	testPlan = [iperf, iperf, links_down, pingAll, iperf, links_up,  pingAll, iperf]

	#  open output file
	title = "Average Speed for " + topology + " Topology With " + str(num_switches) + " Nodes"
	f = openfile(filename, title, subtitle)

	# run test plan
	for test in testPlan:
		results = test.run()
		if test.type == 'iperf':
			avg = test.getStats('avgspeed') # avgspeed returns (average, errors)
			f.write("{}\n".format(str(avg[0])))
			f.write("{}\n".format(str(avg[1])))
	try:
		net.stop()
	except:
		print "**************** no *****************"

def openfile(fileName, title, subtitle):
	f = open("data/" + fileName, "w")
	f.write("{}\n".format(title))
	f.write("{}\n".format(subtitle))
	return f

def cut_every_other(num_switches):
	# get links between switches to turn off/on
	# this list is a list of tuples which are the switches between which the links will be turned off/on.
	# for example if we want to break the links between s1 and s2, and s3 and s4
	# the list would look like: [('s1', 's2'), ('s3', 's4')]
	switches = []
	for i in range(1,num_switches + 1):
		for j in range(i+2, num_switches + 1, 2):
			switches.append(('s' + str(i), 's' + str(j)))
	return switches

def cut_one(one, two):
	return [(one, two)]

if __name__ == '__main__':
	# topology, nodes, switch cuts, filename, subtitle
	# avgRtt('Mesh', 20, cut_one('s1', 's2'), 'mesh-20-avgrtt-one', 'Cut One Switch')
	# avgRtt('Ring', 20, cut_one('s1', 's2'), 'ring-20-avgrtt-one', 'Cut One Switch')
	# avgRtt('Bus', 20, cut_one('s1', 's2'), 'bus-20-avgrtt-one', 'Cut One Switch')
	# avgRtt('Star', 20, cut_one('s0', 's1'), 'star-20-avgrtt-one', 'Cut One Switch')

	avgSpeed('Mesh', 20, cut_one('s1', 's2'), 'mesh-20-avgspeed-one', 'Cut One Switch')
	# avgSpeed('Ring', 20, cut_one('s1', 's2'), 'ring-20-avgspeed-one', 'Cut One Switch')
	# avgSpeed('Bus', 20, cut_one('s1', 's2'), 'bus-20-avgspeed-one', 'Cut One Switch')
	# avgSpeed('Star', 20, cut_one('s0', 's1'), 'star-20-avgspeed-one', 'Cut One Switch')



