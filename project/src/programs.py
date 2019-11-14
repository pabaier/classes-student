from mininet.topo import Topo
from mininet.net import Mininet
from mininet.node import OVSSwitch, IVSSwitch, UserSwitch, Controller, RemoteController
from mininet.topolib import TreeTopo
from mininet.log import setLogLevel
from mininet.cli import CLI
from tests import tests
import argparse
import topologies

class Program():

	def __init__(self):
		self.num_switches = topologies.num_switches = 5
		self.controller = Controller( 'c0' )
		self.topology = topologies.topos['bus']
		self.switch = OVSSwitch
		self.tests = []

	def set_number_of_switches(self, num):
		self.num_switches = num
		topologies.num_switches = num
		return self

	def set_controller(self, controller):
		switch = {
			'remote': RemoteController,
			'default': Controller( 'c0' )
		}
		self.controller = switch[controller]
		return self

	def set_topology(self, topo):
		self.topology = topologies.topos[topo]()
		return self

	def set_switch(self, switch):
		s = {
			'ovs': OVSSwitch,
			'ivs': IVSSwitch,
			'user': UserSwitch
		}
		self.switch = s[switch]
		return self
	
	def add_tests(self, test):
		self.tests.append(test)
		return self

	def build(self):
		self.net = Mininet(topo=self.topology, controller=self.controller, switch=self.switch)
		return self

def a():
	a = Program().set_controller('default').set_number_of_switches(5).set_topology('mesh').build()
	net = a.net
	net.start()
	test = tests['pingallfull'](net, 'avgrtt')
	links_down = tests['linkinterrupt'](net, ['s1', 's2'], 'down')
	links_up = tests['linkinterrupt'](net, ['s1', 's2'], 'up')

	testPlan = [test, test, links_down, test, test, links_up, test, test]
	for test in testPlan:
		test.run()
	net.stop()

a()

programs = { 'a': ( lambda: a() ), 'ring': ( lambda: Ring() ), 'star': ( lambda: Star() ), 'mesh': ( lambda: Mesh() ) }
