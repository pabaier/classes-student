#!/usr/bin/python                                                                            
                                                                                             
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

def simpleTest():
    "Create and test a simple network"
    topo = MyTopo(switches=2, hosts_per_switch=2)
    net = Mininet(topo)
    net.start()
    print "Dumping host connections"
    dumpNodeConnections(net.hosts)
    # print "Testing network connectivity"
    # net.pingAll()
    CLI( net )
    net.stop()

if __name__ == '__main__':
    # Tell mininet to print useful information
    setLogLevel('info')
    simpleTest()