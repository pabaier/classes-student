#!/usr/bin/python

"""
Create a network where different switches are connected to
different controllers, by creating a custom Switch() subclass.
"""

from mininet.net import Mininet
from mininet.node import OVSSwitch, Controller, RemoteController
from mininet.topolib import TreeTopo
from mininet.log import setLogLevel
from mininet.cli import CLI
import argparse
# from topologies import BusTopo
import topologies


def simpleTest(args):
	c0 = Controller( 'c0' )

	topologies.num_switches = args.switches
	topo = getTopo(args.topo)
	net = Mininet(topo=topo, controller=c0)
	net.start()
	CLI( net )
	net.stop()

def getTopo(topo):
	switch = {
		'ring': topologies.Ring(),
		'bus': topologies.Bus()
	}
	return switch[topo]


if __name__ == '__main__':
    parser = argparse.ArgumentParser(description='Server Program.')
    parser.add_argument('--switches', "-s", type=int, default=1, dest="switches", help='number of switches in network')
    parser.add_argument('--topo', "-t", type=str, default='bus', dest="topo", help='which topology to use')
    args = parser.parse_args()
    # Tell mininet to print useful information
    setLogLevel('info')
    simpleTest(args)