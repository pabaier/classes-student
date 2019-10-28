#!/usr/bin/python                                                                            

import argparse
from mininet.topo import Topo
from mininet.net import Mininet
from mininet.util import dumpNodeConnections
from mininet.log import setLogLevel
from mininet.cli import CLI

class MyTopo(Topo):
    "Single switch connected to n hosts."
    def build(self, switches=1, hosts_per_switch=1):
		host_count = 1
		center_switch = self.addSwitch('s1')
		for i in range(1, switches + 1):
			switch = self.addSwitch('s' + str(i+1))
			self.addLink(center_switch, switch)
			# Python's range(N) generates 0..N-1
			for h in range(hosts_per_switch):
				host = self.addHost('h%s' % (host_count))
				self.addLink(host, switch)
				host_count += 1

def simpleTest(args):
    "Create and test a simple network"
    topo = MyTopo(switches=args.switches, hosts_per_switch=args.hosts_per_switch)
    net = Mininet(topo)
    net.start()
    print "Dumping host connections"
    dumpNodeConnections(net.hosts)

    # h1 = net.get('h1')
    h1 = net.hosts[0]
    result = h1.cmd('python3.7 ~/631/project/ddos/serverSock.py --ip %s &' % (h1.IP()))

    hosts = net.hosts[1:]
    for host in hosts:
        host.cmd('python3.7 ~/631/project/ddos/clientSock.py --ip %s &' % (h1.IP()))

    # print "Testing network connectivity"
    # net.pingAll()
    CLI( net )
    net.stop()

if __name__ == '__main__':
    parser = argparse.ArgumentParser(description='Server Program.')
    parser.add_argument('--switches', "-s", type=int, default=1, dest="switches", help='number of switches in network')
    parser.add_argument('--hosts', "-hs", type=int, default=1, dest="hosts_per_switch", help='number of hosts per switch')
    args = parser.parse_args()
    # Tell mininet to print useful information
    setLogLevel('info')
    simpleTest(args)