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
from topologies import topos
from topologies import BusTopo


setLogLevel( 'info' )

# Two local and one "external" controller (which is actually c0)
# Ignore the warning message that the remote isn't (yet) running
c0 = Controller( 'c0' )

# bus = topos['bustopo'](7)
bus = BusTopo()
net = Mininet(topo=bus, controller=c0)
# net.addController(c0)
# net.build()
net.start()
CLI( net )
net.stop()