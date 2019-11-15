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
		pings = len(self.results)
		successes, total_attempts = 0, 0
		rtts = []
		for element in self.results:
			rtts.append(float(element[2][2]))
			successes += element[2][1]
			total_attempts += element[2][0]
			if float(element[2][2] == 0):
				pings -= 1
		if pings <= 0:
			return 0
		avgRtt = sum(rtts) / pings
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
		test = 100
		while test == 100: # if 100% of packets were dropped, do it again
			test = self.net.pingAll()
		self.results = []
		i = 0
		while i < len(self.net.hosts):
			for host in self.net.hosts[i+1:]:
				res = self.net.iperf([self.net.hosts[i], host])
				record = (float(res[0].split(' ')[0]), float(res[1].split(' ')[0]))
				self.results.append(record)
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
		for element in self.results:
			avg += (element[0] + element[1])/2
		return avg / len(self.results)
	
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
		self.type = 'linkinterrupt'

	def run(self):
		for link in self.links:
			self.net.configLinkStatus(link[0], link[1], self.linkStatus)

tests = { 
	'pingall': ( lambda net: PingAll(net) ), 
	'pingallfull': ( lambda net: PingAllFull(net) ), 
	'iperf': ( lambda net: IPerf(net) ),
	'linkinterrupt': ( lambda net, links, linkStatus: LinkInterrupt(net, links, linkStatus) ),
}


