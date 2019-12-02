from network import Network
from tests import tests
import argparse
from mininet.cli import CLI
from mininet.node import Controller,OVSSwitch
from mininet.net import Mininet
import topologies
import tests

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
switch = net.switches
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

# tests
pingAll = tests['pingall'](net)
pingfull = tests['pingallfull'](net)
controller1_toggle = tests['controllerinterrupt'](net, c1)
controller2_toggle = tests['controllerinterrupt'](net, c2)
controller3_toggle = tests['controllerinterrupt'](net, c3)
controller4_toggle = tests['controllerinterrupt'](net, c4)

plan = [pingfull, controller1_toggle, pingfull, controller1_toggle, pingfull]

for test in plan:
    test.run()

# CLI (net)
net.stop()