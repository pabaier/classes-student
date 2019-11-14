from mininet.net import Mininet
from mininet.node import OVSSwitch, IVSSwitch, UserSwitch, Controller, RemoteController
from mininet.topolib import TreeTopo
from mininet.log import setLogLevel
from mininet.cli import CLI

class PingAllFull:
	def __init__(self, net, stat):
		self.net = net
		self.stat = stat.lower()

	def run(self):
		self.results = self.net.pingAllFull()
		return self.results
	
	def getStats(self):
		switch = {
			'avgrtt': self.avgRTT(),
			'totaltime': self.totalTime()
		}
		return switch[self.stat]

	def avgRTT(self):
		pings = len(self.results)
		rtts = []
		for element in self.results:
			rtts.append(float(element[2][2]))
			if float(element[2][2] == 0):
				pings -= 1
		if pings <= 0:
			return 0
		avgRtt = sum(rtts) / pings
		return(avgRtt)

	def totalTime(self):
		time = 0.0
		for result in self.results:
			time += result[2][4]
		return time

class PingAll:
	def __init__(self, net, stat):
		self.net = net
		self.stat = stat.lower()

	def run(self):
		self.results = self.net.pingAll()
		return self.results

	def getStats(self):
		switch = {
			'percentage': self.percentage(),
		}
		return switch[self.stat]

	def percentage(self):
		return self.results

class IPerf:
	def __init__(self, net, stat):
		self.net = net
		self.stat = stat.lower()

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

	def getStats(self):
		switch = {
			'avgspeed': self.avgSpeed(),
			'totalspeed': self.totalSpeed()
		}
		return switch[self.stat]

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
	def __init__(self, net, type, links, linkStatus):
		self.net = net
		self.type = type.lower()
		self.links = links
		self.linkStatus = linkStatus
	
	def run(self):
		self.getType()

	def getType(self):
		switch = {
			'configlinkstatus': self.configLinkStatus()
		}
		return switch[self.type]
	
	def configLinkStatus(self):
		self.net.configLinkStatus(self.links[0], self.links[1], self.linkStatus)

tests = { 
	'pingall': ( lambda x, y: PingAll(x, y) ), 
	'pingallfull': ( lambda x, y: PingAllFull(x, y) ), 
	'iperf': ( lambda x, y: IPerf(x, y) ),
	'linkinterrupt': ( lambda a, b, c, d: LinkInterrupt(a, b, c, d) ),
}


