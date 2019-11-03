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
# from topologies import BusTopo
import topologies

setLogLevel( 'info' )

c0 = Controller( 'c0' )

topologies.num_switches = 7
# bus = BusTopo()
ring = topologies.Ring()
net = Mininet(topo=ring, controller=c0)
net.start()
CLI( net )
net.stop()