from mininet.topo import Topo

num_switches = 5

class Bus( Topo ):

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

class Ring( Topo ):

    def build( self ):
        # Add hosts and switches
        for i in range(num_switches):
            host = 'h' + str(i+1)
            switch = 's' + str(i+1)
            self.addHost(host)
            self.addSwitch(switch, stp=True, failMode='standalone')
            self.addLink(host, switch)
            if i > 0:
                prevswitch = 's' + str(i)
                self.addLink(prevswitch, switch)
        self.addLink('s' + str(num_switches), 's1')

topos = { 'bus': ( lambda: Bus() ), 'ring': ( lambda: Ring() ) }
