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
	c5 = net.addController( 'c4', port=6638 )

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
	c5.start()
	c1Switches = ['s1', 's2', 's3', 's4', 's5', 's6', 's7']
	c2Switches = ['s8', 's9', 's10', 's11', 's12']
	c3Switches = ['s13', 's14', 's15', 's17', 's31', 's32', 's33', 's34']
	c4Switches = ['s16', 's18', 's19', 's20', 's21', 's22', 's23']
	c5Switches = ['s24', 's25', 's26', 's27', 's28', 's29', 's30']

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
	for s in c5Switches:
		switch = net.getNodeByName(s)
		switch.start([c5])

	# tests
	pingAll = tests['pingall'](net)
	pingfull = tests['pingallfull'](net)
	controller1_toggle = tests['controllerinterrupt'](net, c1)
	controller2_toggle = tests['controllerinterrupt'](net, c2)
	controller3_toggle = tests['controllerinterrupt'](net, c3)
	controller4_toggle = tests['controllerinterrupt'](net, c4)
	controller5_toggle = tests['controllerinterrupt'](net, c5)
	toggles = {1:controller1_toggle, 2:controller2_toggle, 3:controller3_toggle, 4:controller4_toggle, 5:controller5_toggle}

	net.pingAllFull()
	down_singles = [1,2,3,4,5]
	down_pairs = [(1,2), (1,3), (1,4), (1,5),
				(2,3), (2,4), (2,5),
				(3,4), (3,5), (4,5) ]
	for d in down_singles:
		filename = "Internet2-OSE3-c" + str(d)
		title = "Internet2-OSE3"
		subtitle = "Average RTT with c" + str(d) + " Down"
		f = openfile(filename, title, subtitle)
		plan = [pingfull, pingfull, toggles[d], pingfull, pingfull, toggles[d], pingfull, pingfull]
		for test in plan:
			test.run()
			if test.type == 'pingallfull':
				avg = test.getStats('avgrtt') # avgrtt returns (average, successes, total) where failures count for 3 seconds
				f.write("{}\n".format(str(avg[0])))
				f.write("{}\n".format(str(avg[2] - avg[1])))
		f.close()

	for d in down_pairs:
		filename = "Internet2-OSE3-c" + str(d[0]) + "-c" + str(d[1])
		title = "Internet2-OSE3"
		subtitle = "Average RTT with c" + str(d[0]) + " and c" + str(d[1])+ " Down"
		f = openfile(filename, title, subtitle)
		plan = [pingfull, pingfull, toggles[d[0]], toggles[d[1]], pingfull, pingfull, toggles[d[0]], toggles[d[1]], pingfull, pingfull]
		for test in plan:
			test.run()
			if test.type == 'pingallfull':
				avg = test.getStats('avgrtt') # avgrtt returns (average, successes, total) where failures count for 3 seconds
				f.write("{}\n".format(str(avg[0])))
				f.write("{}\n".format(str(avg[2] - avg[1])))
		f.close()

	# CLI (net)
	net.stop()

def openfile(fileName, title, subtitle):
	f = open("data/" + fileName, "w")
	f.write("{}\n".format(title))
	f.write("{}\n".format(subtitle))
	return f

if __name__ == '__main__':
	main()

