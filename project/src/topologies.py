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

class Highwinds( Topo ):

    def build( self ):
        # Add hosts and switches
        for i in range(1,19):
            host = 'h' + str(i+1)
            switch = 's' + str(i+1)
            self.addHost(host)
            self.addSwitch(switch, stp=True, failMode='standalone')
            self.addLink(host, switch)
        switch = self.switches()
        switches = [None]
        for s in switch:
            switches.append(s)
        self.addLink(switches[1],switches[2])
        self.addLink(switches[1],switches[11])
        self.addLink(switches[2],switches[3])
        self.addLink(switches[2],switches[8])
        self.addLink(switches[3],switches[4])
        self.addLink(switches[3],switches[5])
        self.addLink(switches[3],switches[11])
        self.addLink(switches[4],switches[5])
        self.addLink(switches[4],switches[7])
        self.addLink(switches[5],switches[6])
        self.addLink(switches[5],switches[8])
        self.addLink(switches[5],switches[11])
        self.addLink(switches[6],switches[7])
        self.addLink(switches[6],switches[12])
        self.addLink(switches[7],switches[8])
        self.addLink(switches[7],switches[11])
        self.addLink(switches[8],switches[9])
        self.addLink(switches[8],switches[11])
        self.addLink(switches[8],switches[15])
        self.addLink(switches[9],switches[10])
        self.addLink(switches[9],switches[11])
        self.addLink(switches[9],switches[16])
        self.addLink(switches[10],switches[11])
        self.addLink(switches[12],switches[13])
        self.addLink(switches[14],switches[15])
        self.addLink(switches[14],switches[17])
        self.addLink(switches[15],switches[16])
        self.addLink(switches[15],switches[18])
        self.addLink(switches[16],switches[17])
        self.addLink(switches[17],switches[18])

topos = { 'bus': ( lambda: Bus() ), 'ring': ( lambda: Ring() ), 'star': ( lambda: Star() ), 'mesh': ( lambda: Mesh() ), 'highwinds': ( lambda: Highwinds() ) }
