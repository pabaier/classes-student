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