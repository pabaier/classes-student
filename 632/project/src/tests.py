from mininet.net import Mininet
from mininet.node import OVSSwitch, IVSSwitch, UserSwitch, Controller, RemoteController
from mininet.topolib import TreeTopo
from mininet.log import setLogLevel
from mininet.cli import CLI

class PingAllFull:
	def __init__(self, net):
		self.net = net
		self.type = 'pingallfull'

	def run(self):
		self.results = self.net.pingAllFull()
		return self.results
	
	def getStats(self, stat):
		switch = {
			'avgrtt': self.avgRTT(),
			'totaltime': self.totalTime()
		}
		return switch[stat.lower()]

	def avgRTT(self):
		successes, total_attempts = 0, 0
		rtts = []
		for element in self.results:
			successes += element[2][1]
			total_attempts += element[2][0]
			if float(element[2][2] != 0):
				rtts.append(float(element[2][2]))
		if len(rtts) <= 0:
			return (0, 0, 0)
		avgRtt = sum(rtts) / len(rtts)
		return((avgRtt, successes, total_attempts))

	def totalTime(self):
		time = 0.0
		for result in self.results:
			time += result[2][4]
		return time

class PingAll:
	def __init__(self, net):
		self.net = net
		self.type = 'pingall'

	def run(self):
		self.results = self.net.pingAll()
		return self.results

	def getStats(self, stat):
		switch = {
			'percentage': self.percentage(),
		}
		return switch[stat.lower()]

	def percentage(self):
		return self.results

class IPerf:
	def __init__(self, net):
		self.net = net
		self.type = 'iperf'

	def run(self):
		# test = 100
		# while test == 100: # if 100% of packets were dropped, do it again
		# 	test = self.net.pingAll()
		self.results = []
		i = 0
		while i < len(self.net.hosts):
			for host in self.net.hosts[i+1:]:
				try:
					res = self.net.iperf([self.net.hosts[i], host]) # returns a tuple of speeds (24 gbps, 24 gbps)
					record = (float(res[0].split(' ')[0]), float(res[1].split(' ')[0]))
					self.results.append(record)
				except:
					self.results.append((0,0))
			i += 1
		return self.results

	def getStats(self, stat):
		switch = {
			'avgspeed': self.avgSpeed(),
			'totalspeed': self.totalSpeed()
		}
		return switch[stat.lower()]

	def avgSpeed(self):
		avg = 0
		total = len(self.results)
		errors = 0
		for element in self.results:
			if element[0] == 0:
				total -= 1
				errors += 1
			else:
				avg += (element[0] + element[1])/2
		if total > 0:
			return (avg/total, errors)
		return (0, errors)
	
	def totalSpeed(self):
		total = 0
		for element in self.results:
			total += (element[0] + element[1])
		return total

class LinkInterrupt:
	def __init__(self, net, links, linkStatus):
		self.net = net
		self.links = links
		self.linkStatus = linkStatus
		self.type = 'links_' + linkStatus

	def run(self):
		for link in self.links:
			self.net.configLinkStatus(link[0], link[1], self.linkStatus)

class SwitchInterrupt:
	def __init__(self, net, switch, switchStatus):
		self.net = net
		self.switch = net.getNodeByName(switch)
		self.switch_name = switch
		self.switchStatus = switchStatus.lower()
		self.type = 'switch_toggle'
		self.intfs = self.switch.intfs

	def run(self):
		if self.switchStatus == 'on':
			self.switchStatus == 'off'
			self.switch.stop()
		else:
			self.switchStatus == 'on'
			self.switch.start([self.net.controller])
			self.switch.intfs = self.intfs 

class ControllerInterrupt:
	def __init__(self, net, controller):
		self.net = net
		self.controller = controller
		self.up = True
		self.type = 'controllerInterrupt'

	def run(self):
		if self.up:
			self.up = False
			self.controller.stop()
		else:
			self.status = True
			self.controller.start()

tests = { 
	'pingall': ( lambda net: PingAll(net) ), 
	'pingallfull': ( lambda net: PingAllFull(net) ), 
	'iperf': ( lambda net: IPerf(net) ),
	'linkinterrupt': ( lambda net, links, linkStatus: LinkInterrupt(net, links, linkStatus) ),
	'switchinterrupt': ( lambda net, switch, switchStatus: SwitchInterrupt(net, switch, switchStatus) ),
	'controllerinterrupt': ( lambda net, controller: ControllerInterrupt(net, controller) )
}


