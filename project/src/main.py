from program import Program
from tests import tests
import argparse

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