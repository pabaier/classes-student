#!/usr/bin/python

"""
This example shows how to create an empty Mininet object
(without a topology object) and add nodes to it manually.
"""

from mininet.net import Mininet
from mininet.node import Controller
from mininet.cli import CLI
from mininet.log import setLogLevel, info

def createOne():

	net = Mininet( controller=Controller )

	info( '*** Adding controller\n' )
	net.addController( 'c0' )
	info( '*** Adding hosts\n' )
	h1 = net.addHost( 'h1')
	h2 = net.addHost( 'h2')

	info( '*** Adding switch\n' )
	s3 = net.addSwitch( 's3' )

	info( '*** Creating links\n' )
	net.addLink( h1, s3 )
	net.addLink( h2, s3 )

	info( '*** Starting network\n')
	return net

def a(net, num_hosts=1):
	info( '*** Adding hosts\n' )
	for i in range(0, num_hosts):
		net.addHost('h' + str(i+1))
	
	info( '*** Adding switch\n' )
	s3 = net.addSwitch( 's3' )

	info( '*** Creating links\n' )
	hosts = net.hosts
	for host in hosts:
		net.addLink( host, s3 )

	return net

def emptyNet():
	netA = Mininet( controller=Controller )

	info( '*** Adding controller\n' )
	netA.addController( 'c0', ip='127.0.0.1' )

	a(netA,4)
	c0 = netA.get('c0')
	s3 = netA.get('s3')
	netA.start()
	h1 = netA.get('h1')

	result = h1.cmd('ifconfig')
	print "*****************************"
	print result

	info( '*** Running CLI\n' )
	CLI( netA )

	info( '*** Stopping network' )
	netA.stop()

if __name__ == '__main__':
	setLogLevel( 'info' )
	emptyNet()