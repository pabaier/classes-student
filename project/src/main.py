from program import Program
from tests import tests
import argparse

a = Program().set_controller('default').set_number_of_switches(5).set_topology('mesh').build()
net = a.net
net.start()
pingAll = tests['pingall'](net)
pingfull = tests['pingallfull'](net)
switches = []
for i in range(2,6):
	switches.append(('s1', 's' + str(i)))
links_down = tests['linkinterrupt'](net, switches, 'down')
links_up = tests['linkinterrupt'](net, switches, 'up')

testPlan = [pingAll, pingfull, links_down, pingAll, pingfull, links_up,  pingAll, pingfull]
for test in testPlan:
	test.run()
	if test.type == 'pingallfull':
		avg = test.getStats('avgrtt')
		print str(avg)

net.stop()