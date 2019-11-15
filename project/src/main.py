from program import Program
from tests import tests
import argparse

a = Program().set_controller('default').set_number_of_switches(5).set_topology('mesh').build()
net = a.net
net.start()
pingAll = tests['pingall'](net)
pingfull = tests['pingallfull'](net)
s1_s2_down = tests['linkinterrupt'](net, ['s1', 's2'], 'down')
s1_s2_up = tests['linkinterrupt'](net, ['s1', 's2'], 'up')
s1_s3_down = tests['linkinterrupt'](net, ['s1', 's3'], 'down')
s1_s3_up = tests['linkinterrupt'](net, ['s1', 's3'], 'up')

testPlan = [pingAll, pingfull, s1_s2_down, s1_s3_down, pingAll, pingfull, s1_s2_up, s1_s3_up, pingAll, pingfull]
for test in testPlan:
	test.run()
	if test.type == 'pingallfull':
		avg = test.getStats('avgrtt')
		print str(avg)

net.stop()