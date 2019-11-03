"""Custom topology example
Two directly connected switches plus a host for each switch:
   host --- switch --- switch --- host
Adding the 'topos' dict with a key/value pair to generate our newly defined
topology enables one to pass in '--topo=mytopo' from the command line.
"""

from mininet.topo import Topo

num_switches = 5

class BusTopo( Topo ):
    "Simple topology example."
    # def __init__(self):
    #     super(BusTopo, self).__init__()
    #     self.num_switches = 1
    def setSwitches(self, num):
        num_switches = num

    def build( self ):
        # Add hosts and switches
        for i in range(num_switches):
            host = 'h' + str(i+1)
            switch = 's' + str(i+1)
            self.addHost(host)
            self.addSwitch(switch)
            self.addLink(host, switch)
            if i > 0:
                prevswitch = 's' + str(i)
                self.addLink(prevswitch, switch)

# topos = { 'bustopo': ( lambda: BusTopo() ) }