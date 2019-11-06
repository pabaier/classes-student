#!/usr/bin/python

"""
Create a network where different switches are connected to
different controllers, by creating a custom Switch() subclass.
"""

from mininet.net import Mininet
from mininet.node import OVSSwitch, IVSSwitch, UserSwitch, Controller, RemoteController
from mininet.topolib import TreeTopo
from mininet.log import setLogLevel
from mininet.cli import CLI
import argparse
# from topologies import BusTopo
import topologies


def simpleTest(args):
    # c0 = Controller( 'c0' )
    topologies.num_switches = args.switch_count
    controller = getController(args.controller)
    topo = getTopo(args.topo)
    switch = getSwitch(args.switch)

    net = Mininet(topo=topo, controller=controller, switch=switch)
    if args.controller == 'remote':
        net.addController( 'c0', controller=RemoteController, ip=args.ip, port=6633)
    net.start()
    CLI( net )
    net.stop()

def getController(controller):
    switch = {
        'remote': RemoteController,
        'default': Controller( 'c0' )
    }
    return switch[controller]

def getTopo(topo):
	switch = {
		'ring': topologies.Ring(),
		'bus': topologies.Bus(),
        'star': topologies.Star(),
        'mesh': topologies.Mesh()
	}
	return switch[topo]

def getSwitch(switch):
    s = {
        'ovs': OVSSwitch,
        'ivs': IVSSwitch,
        'user': UserSwitch
    }
    return s[switch]


if __name__ == '__main__':
    parser = argparse.ArgumentParser(description='Server Program.')
    parser.add_argument('--switch_count', "-sc", type=int, default=1, dest="switch_count", help='number of switches in network')
    parser.add_argument('--topo', "-t", type=str, default='bus', dest="topo", help='which topology to use')
    parser.add_argument('--switch', "-s", type=str, default='ovs', dest="switch", help='which switch to use')
    parser.add_argument('--controller', "-c", type=str, default='default', dest="controller", help='which controller to use')
    parser.add_argument('--ip', "-i", type=str, default='127.0.0.1', dest="ip", help='which ip a remote controller will use')


    args = parser.parse_args()
    # Tell mininet to print useful information
    setLogLevel('info')
    simpleTest(args)