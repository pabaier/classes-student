from network import Network
from tests import tests
import argparse
from mininet.cli import CLI
from mininet.node import Controller,OVSSwitch
from mininet.net import Mininet
import topologies

def main():
	# build and start network
	# a = Network().set_controller('default').set_topology('Internet2-OSE3').build()
	# net = a.net
	net = Mininet( controller=Controller, switch=OVSSwitch )

	# controllers
	c1 = net.addController( 'c1', port=6633 )
	c2 = net.addController( 'c2', port=6634 )
	c3 = net.addController( 'c3', port=6635 )
	c4 = net.addController( 'c4', port=6637 )
	# add switches
	for i in range(34):
		switch = 's' + str(i+1)
		net.addSwitch(switch, stp=True, failMode='standalone')
	# addhosts
	for i in range(34):
		host = 'h' + str(i+1)
		net.addHost(host)
	# links
	for i in range(34):
		net.addLink(net.hosts[i], net.switches[i])
	switch = net.switches
	switches = [None]
	for s in switch:
		switches.append(s)
	net.addLink(switches[1],switches[2])
	net.addLink(switches[1],switches[3])
	net.addLink(switches[2],switches[5])
	net.addLink(switches[3],switches[4])
	net.addLink(switches[3],switches[6])
	net.addLink(switches[4],switches[22])
	net.addLink(switches[5],switches[6])
	net.addLink(switches[5],switches[7])
	net.addLink(switches[6],switches[7])
	net.addLink(switches[7],switches[8])
	net.addLink(switches[8],switches[9])
	net.addLink(switches[9],switches[10])
	net.addLink(switches[10],switches[11])
	net.addLink(switches[10],switches[13])
	net.addLink(switches[11],switches[12])
	net.addLink(switches[12],switches[16])
	net.addLink(switches[13],switches[14])
	net.addLink(switches[13],switches[15])
	net.addLink(switches[13],switches[17])
	net.addLink(switches[14],switches[33])
	net.addLink(switches[15],switches[16])
	net.addLink(switches[16],switches[23])
	net.addLink(switches[17],switches[18])
	net.addLink(switches[18],switches[19])
	net.addLink(switches[19],switches[20])
	net.addLink(switches[19],switches[32])
	net.addLink(switches[20],switches[21])
	net.addLink(switches[21],switches[23])
	net.addLink(switches[22],switches[23])
	net.addLink(switches[23],switches[24])
	net.addLink(switches[24],switches[25])
	net.addLink(switches[24],switches[26])
	net.addLink(switches[25],switches[30])
	net.addLink(switches[26],switches[27])
	net.addLink(switches[27],switches[28])
	net.addLink(switches[28],switches[29])
	net.addLink(switches[29],switches[30])
	net.addLink(switches[30],switches[31])
	net.addLink(switches[31],switches[32])
	net.addLink(switches[32],switches[33])
	net.addLink(switches[33],switches[34])

	net.build()
	c1.start()
	c2.start()
	c3.start()
	c4.start()
	c1Switches = ['s1', 's2', 's3', 's4', 's5', 's6', 's7', 's8']
	c2Switches = ['s9', 's10', 's11', 's12', 's13', 's15', 's16']
	c3Switches = ['s14', 's17', 's18', 's19', 's20', 's21', 's31', 's32', 's33', 's34']
	c4Switches = ['s22', 's23', 's24', 's25', 's26', 's27', 's28', 's29', 's30']
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

	# tests
	pingAll = tests['pingall'](net)
	pingfull = tests['pingallfull'](net)
	controller1_toggle = tests['controllerinterrupt'](net, c1)
	controller2_toggle = tests['controllerinterrupt'](net, c2)
	controller3_toggle = tests['controllerinterrupt'](net, c3)
	controller4_toggle = tests['controllerinterrupt'](net, c4)
	net.pingAllFull()
	# c1 down
	filename = "Internet2-OSE3-c1"
	title = "Internet2-OSE3"
	subtitle = "Average RTT with c1 Down"
	f = openfile(filename, title, subtitle)
	plan = [pingfull, pingfull, controller1_toggle, pingfull, pingfull, controller1_toggle, pingfull, pingfull]
	for test in plan:
		test.run()
		if test.type == 'pingallfull':
			avg = test.getStats('avgrtt') # avgrtt returns (average, successes, total) where failures count for 3 seconds
			f.write("{}\n".format(str(avg[0])))
			f.write("{}\n".format(str(avg[2] - avg[1])))

	# c2 down
	filename = "Internet2-OSE3-c2"
	title = "Internet2-OSE3"
	subtitle = "Average RTT with c2 Down"
	f = openfile(filename, title, subtitle)
	plan = [pingfull, pingfull, controller2_toggle, pingfull, pingfull, controller2_toggle, pingfull, pingfull]
	for test in plan:
		test.run()
		if test.type == 'pingallfull':
			avg = test.getStats('avgrtt') # avgrtt returns (average, successes, total) where failures count for 3 seconds
			f.write("{}\n".format(str(avg[0])))
			f.write("{}\n".format(str(avg[2] - avg[1])))

	# c3 down
	filename = "Internet2-OSE3-c3"
	title = "Internet2-OSE3"
	subtitle = "Average RTT with c3 Down"
	f = openfile(filename, title, subtitle)
	plan = [pingfull, pingfull, controller3_toggle, pingfull, pingfull, controller3_toggle, pingfull, pingfull]
	for test in plan:
		test.run()
		if test.type == 'pingallfull':
			avg = test.getStats('avgrtt') # avgrtt returns (average, successes, total) where failures count for 3 seconds
			f.write("{}\n".format(str(avg[0])))
			f.write("{}\n".format(str(avg[2] - avg[1])))

	# c4 down
	filename = "Internet2-OSE3-c4"
	title = "Internet2-OSE3"
	subtitle = "Average RTT with c4 Down"
	f = openfile(filename, title, subtitle)
	plan = [pingfull, pingfull, controller4_toggle, pingfull, pingfull, controller4_toggle, pingfull, pingfull]
	for test in plan:
		test.run()
		if test.type == 'pingallfull':
			avg = test.getStats('avgrtt') # avgrtt returns (average, successes, total) where failures count for 3 seconds
			f.write("{}\n".format(str(avg[0])))
			f.write("{}\n".format(str(avg[2] - avg[1])))

	# c1 and c2 down
	filename = "Internet2-OSE3-c1-c2"
	title = "Internet2-OSE3"
	subtitle = "Average RTT with c1 and c2 Down"
	f = openfile(filename, title, subtitle)
	plan = [pingfull, pingfull, controller1_toggle, controller2_toggle, pingfull, pingfull, controller1_toggle, controller2_toggle, pingfull, pingfull]
	for test in plan:
		test.run()
		if test.type == 'pingallfull':
			avg = test.getStats('avgrtt') # avgrtt returns (average, successes, total) where failures count for 3 seconds
			f.write("{}\n".format(str(avg[0])))
			f.write("{}\n".format(str(avg[2] - avg[1])))

	# c1 and c3 down
	filename = "Internet2-OSE3-c1-c3"
	title = "Internet2-OSE3"
	subtitle = "Average RTT with c1 and c3 Down"
	f = openfile(filename, title, subtitle)
	plan = [pingfull, pingfull, controller1_toggle, controller3_toggle, pingfull, pingfull, controller1_toggle, controller3_toggle, pingfull, pingfull]
	for test in plan:
		test.run()
		if test.type == 'pingallfull':
			avg = test.getStats('avgrtt') # avgrtt returns (average, successes, total) where failures count for 3 seconds
			f.write("{}\n".format(str(avg[0])))
			f.write("{}\n".format(str(avg[2] - avg[1])))

	# c1 and c4 down
	filename = "Internet2-OSE3-c1-c4"
	title = "Internet2-OSE3"
	subtitle = "Average RTT with c1 and c4 Down"
	f = openfile(filename, title, subtitle)
	plan = [pingfull, pingfull, controller1_toggle, controller4_toggle, pingfull, pingfull, controller1_toggle, controller4_toggle, pingfull, pingfull]
	for test in plan:
		test.run()
		if test.type == 'pingallfull':
			avg = test.getStats('avgrtt') # avgrtt returns (average, successes, total) where failures count for 3 seconds
			f.write("{}\n".format(str(avg[0])))
			f.write("{}\n".format(str(avg[2] - avg[1])))

	# c2 and c3 down
	filename = "Internet2-OSE3-c2-c3"
	title = "Internet2-OSE3"
	subtitle = "Average RTT with c2 and c3 Down"
	f = openfile(filename, title, subtitle)
	plan = [pingfull, pingfull, controller2_toggle, controller3_toggle, pingfull, pingfull, controller2_toggle, controller3_toggle, pingfull, pingfull]
	for test in plan:
		test.run()
		if test.type == 'pingallfull':
			avg = test.getStats('avgrtt') # avgrtt returns (average, successes, total) where failures count for 3 seconds
			f.write("{}\n".format(str(avg[0])))
			f.write("{}\n".format(str(avg[2] - avg[1])))

	# c2 and c4 down
	filename = "Internet2-OSE3-c2-c4"
	title = "Internet2-OSE3"
	subtitle = "Average RTT with c2 and c4 Down"
	f = openfile(filename, title, subtitle)
	plan = [pingfull, pingfull, controller2_toggle, controller4_toggle, pingfull, pingfull, controller2_toggle, controller4_toggle, pingfull, pingfull]
	for test in plan:
		test.run()
		if test.type == 'pingallfull':
			avg = test.getStats('avgrtt') # avgrtt returns (average, successes, total) where failures count for 3 seconds
			f.write("{}\n".format(str(avg[0])))
			f.write("{}\n".format(str(avg[2] - avg[1])))

	# c3 and c4 down
	filename = "Internet2-OSE3-c3-c4"
	title = "Internet2-OSE3"
	subtitle = "Average RTT with c3 and c4 Down"
	f = openfile(filename, title, subtitle)
	plan = [pingfull, pingfull, controller3_toggle, controller4_toggle, pingfull, pingfull, controller3_toggle, controller4_toggle, pingfull, pingfull]
	for test in plan:
		test.run()
		if test.type == 'pingallfull':
			avg = test.getStats('avgrtt') # avgrtt returns (average, successes, total) where failures count for 3 seconds
			f.write("{}\n".format(str(avg[0])))
			f.write("{}\n".format(str(avg[2] - avg[1])))

	# CLI (net)
	net.stop()

def openfile(fileName, title, subtitle):
	f = open("data/" + fileName, "w")
	f.write("{}\n".format(title))
	f.write("{}\n".format(subtitle))
	return f

if __name__ == '__main__':
	main()

