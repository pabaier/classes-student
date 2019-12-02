from network import Network
from tests import tests
import argparse
from mininet.cli import CLI
from mininet.node import Controller,OVSSwitch
from mininet.net import Mininet
import topologies

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
	switch_toggle = tests['switchinterrupt'](net, 's1', 'on')


	# lay out test plan
	# testPlan = [pingAll, pingfull, links_down, pingAll, pingfull, links_up,  pingAll, pingfull]
	testPlan = [pingfull, pingfull, switch_toggle, pingfull, pingfull, switch_toggle,  pingfull, pingfull]

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
	switch_toggle = tests['switchinterrupt'](net, 's1', 'on')

	# lay out test plan
	testPlan = [iperf, links_down, iperf, links_up, iperf]

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
		if test.type == 'links_up':
			for node in net.values():
				while node.waiting:
					node.sendInt()
					node.waitOutput()
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

def fault():
	# build and start network
	# a = Network().set_controller('default').set_topology('highwinds').build()
	# net = a.net
	net = Mininet( controller=Controller, switch=OVSSwitch )

	# controllers
	c1 = net.addController( 'c1', port=6633 )
	c2 = net.addController( 'c2', port=6634 )
	c3 = net.addController( 'c3', port=6635 )
	c4 = net.addController( 'c4', port=6637 )
	# add switches
	for i in range(18):
		switch = 's' + str(i+1)
		net.addSwitch(switch, stp=True, failMode='standalone')
	# addhosts
	for i in range(18):
		host = 'h' + str(i+1)
		net.addHost(host)
	# links
	for i in range(18):
		net.addLink(net.hosts[i], net.switches[i])
	switch = net.switches()
	switches = [None]
	for s in switch:
		switches.append(s)
	net.addLink(switches[1],switches[2])
	net.addLink(switches[1],switches[11])
	net.addLink(switches[2],switches[3])
	net.addLink(switches[2],switches[8])
	net.addLink(switches[3],switches[4])
	net.addLink(switches[3],switches[5])
	net.addLink(switches[3],switches[11])
	net.addLink(switches[4],switches[5])
	net.addLink(switches[4],switches[7])
	net.addLink(switches[5],switches[6])
	net.addLink(switches[5],switches[8])
	net.addLink(switches[5],switches[11])
	net.addLink(switches[6],switches[7])
	net.addLink(switches[6],switches[12])
	net.addLink(switches[7],switches[8])
	net.addLink(switches[7],switches[11])
	net.addLink(switches[8],switches[9])
	net.addLink(switches[8],switches[11])
	net.addLink(switches[8],switches[15])
	net.addLink(switches[9],switches[10])
	net.addLink(switches[9],switches[11])
	net.addLink(switches[9],switches[16])
	net.addLink(switches[10],switches[11])
	net.addLink(switches[12],switches[13])
	net.addLink(switches[14],switches[15])
	net.addLink(switches[14],switches[17])
	net.addLink(switches[15],switches[16])
	net.addLink(switches[15],switches[18])
	net.addLink(switches[16],switches[17])
	net.addLink(switches[17],switches[18])

	net.build()
	c1.start()
	c2.start()
	c3.start()
	c4.start()
	c1Switches = ['s1', 's2', 's3', 's4', 's5']
	c2Switches = ['s6', 's7', 's8', 's9', 's10', 's11']
	c3Switches = ['s12', 's13']
	c4Switches = ['s14', 's15', 's16', 's17', 's18']
	for s in c1Switches:
		switch = net.getNodeByName(s)
		switch.start([c1])
	for s in c2Switches:
		switch = net.getNodeByName(s)
		switch.start([c2])
	for s in c3Switches:
		switch = net.getNodeByName(s)
		switch.start([c3])
	for s in c4Switches:
		switch = net.getNodeByName(s)
		switch.start([c4])

	CLI (net)
	net.stop()
	
if __name__ == '__main__':
	fault()
	# topology, nodes, switch cuts, filename, subtitle
	# avgRtt('Mesh', 3, cut_one('s1', 's2'), 'mesh-20-avgrtt-one', 'Cut One Switch')
	# avgRtt('Ring', 20, cut_one('s1', 's2'), 'ring-20-avgrtt-one', 'Cut One Switch')
	# avgRtt('Bus', 20, cut_one('s1', 's2'), 'bus-20-avgrtt-one', 'Cut One Switch')
	# avgRtt('Star', 20, cut_one('s0', 's1'), 'star-20-avgrtt-one', 'Cut One Switch')

	# avgSpeed('Mesh', 20, cut_one('s1', 's2'), 'mesh-20-avgspeed-one', 'Cut One Switch')
	# avgSpeed('Ring', 20, cut_one('s1', 's2'), 'ring-20-avgspeed-one', 'Cut One Switch')
	# avgSpeed('Bus', 20, cut_one('s1', 's2'), 'bus-20-avgspeed-one', 'Cut One Switch')
	# avgSpeed('Star', 20, cut_one('s0', 's1'), 'star-3-avgspeed-one', 'Cut One Switch')



