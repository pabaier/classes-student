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

    def build( self, net, controller_amount ):
        port = 6633
        controllers = []
        for i in range(controller_amount):
            controllers.append(net.addController( 'c' + str(i + 1), port=port))
            port += 1

        # add switches
        for i in range(18):
            switch = 's' + str(i+1)
            net.addSwitch(switch, stp=True, failMode='standalone')
        # addhosts
        for i in range(18):
            host = 'h' + str(i+1)
            net.addHost(host)
        # links
        for i in range(18):
            net.addLink(net.hosts[i], net.switches[i])
        switch = net.switches
        switches = [None]
        for s in switch:
            switches.append(s)
        net.addLink(switches[1],switches[2])
        net.addLink(switches[1],switches[11])
        net.addLink(switches[2],switches[3])
        net.addLink(switches[2],switches[8])
        net.addLink(switches[3],switches[4])
        net.addLink(switches[3],switches[5])
        net.addLink(switches[3],switches[11])
        net.addLink(switches[4],switches[5])
        net.addLink(switches[4],switches[7])
        net.addLink(switches[5],switches[6])
        net.addLink(switches[5],switches[8])
        net.addLink(switches[5],switches[11])
        net.addLink(switches[6],switches[7])
        net.addLink(switches[6],switches[12])
        net.addLink(switches[7],switches[8])
        net.addLink(switches[7],switches[11])
        net.addLink(switches[8],switches[9])
        net.addLink(switches[8],switches[11])
        net.addLink(switches[8],switches[15])
        net.addLink(switches[9],switches[10])
        net.addLink(switches[9],switches[11])
        net.addLink(switches[9],switches[16])
        net.addLink(switches[10],switches[11])
        net.addLink(switches[12],switches[13])
        net.addLink(switches[14],switches[15])
        net.addLink(switches[14],switches[17])
        net.addLink(switches[15],switches[16])
        net.addLink(switches[15],switches[18])
        net.addLink(switches[16],switches[17])
        net.addLink(switches[17],switches[18])

        net.build()
        for controller in controllers:
            controller.start()

        if controller_amount == 5:
            switchMap = [['s1', 's2', 's3', 's4'],['s5', 's6', 's7'],['s8', 's9', 's10', 's11'], ['s12', 's13'],['s14', 's15', 's16', 's17', 's18'] ]
        else:
            switchMap = [['s1', 's2', 's3', 's4'],['s5', 's6', 's7'], ['s8', 's9', 's10', 's11'], ['s12', 's13'], ['s15', 's16'], ['s14', 's17', 's18']]

        for i in range(len(switchMap)):
            for s in switchMap[i]:
                switch = net.getNodeByName(s)
                switch.start(controllers[i])

        return controllers

topos = { 'bus': ( lambda: Bus() ), 
'ring': ( lambda: Ring() ), 
'star': ( lambda: Star() ), 
'mesh': ( lambda: Mesh() ), 
'highwinds': ( lambda: Highwinds() 
) }
