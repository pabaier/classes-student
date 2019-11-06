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

class Star( Topo ):

    def build( self ):
        self.addSwitch('s0')

        # Add hosts and switches
        for i in range(num_switches):
            host = 'h' + str(i+1)
            switch = 's' + str(i+1)
            self.addHost(host)
            self.addSwitch(switch)
            self.addLink(host, switch)
            self.addLink(switch, 's0')

class Mesh( Topo ):

    def build( self ):
        # Add hosts and switches
        for i in range(num_switches):
            host = 'h' + str(i+1)
            switch = 's' + str(i+1)
            self.addHost(host)
            self.addSwitch(switch, stp=True, failMode='standalone')
            self.addLink(host, switch)
        switches = self.switches()
        counter = 1
        for switch in switches:
            for s in switches[counter:]:
                self.addLink(switch, s)
            counter += 1


topos = { 'bus': ( lambda: Bus() ), 'ring': ( lambda: Ring() ), 'star': ( lambda: Star() ), 'mesh': ( lambda: Mesh() ) }
