from mininet.topo import Topo
from math import ceil, floor

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

def Highwinds( net, controller_amount, controllerGroup ):
    port = 6633
    controllers = []
    for i in range(controller_amount):
        controllers.append(net.addController( 'c' + str(i + 1), port=port))
        port += 1

    # add switches
    switchNames = []
    for i in range(18):
        switch = 's' + str(i+1)
        net.addSwitch(switch, stp=True, failMode='standalone')
        switchNames.append(switch)

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

    if controllerGroup == 0:
        switchMap = chunk_consecutive(switchNames, controller_amount)
    elif controllerGroup == 1:
        switchMap = chunk_odds_evens(switchNames, controller_amount)
    else:
        switchMap = chunk_by_twos(switchNames, controller_amount)

    for i in range(len(switchMap)):
        for s in switchMap[i]:
            switch = net.getNodeByName(s)
            switch.start([controllers[i]])

    return controllers

def Bics( net, controller_amount, controllerGroup ):
    port = 6633
    controllers = []
    for i in range(controller_amount):
        controllers.append(net.addController( 'c' + str(i + 1), port=port))
        port += 1

    # add switches
    switchNames = []
    for i in range(32):
        switch = 's' + str(i+1)
        net.addSwitch(switch, stp=True, failMode='standalone')
        switchNames.append(switch)

    # addhosts
    for i in range(32):
        host = 'h' + str(i+1)
        net.addHost(host)
    # links
    for i in range(32):
        net.addLink(net.hosts[i], net.switches[i])
    switch = net.switches
    switches = [None]
    for s in switch:
        switches.append(s)
    net.addLink(switches[1],switches[2])
    net.addLink(switches[2],switches[3])
    net.addLink(switches[2],switches[4])
    net.addLink(switches[2],switches[7])
    net.addLink(switches[2],switches[8])
    net.addLink(switches[3],switches[9])
    net.addLink(switches[3],switches[19])
    net.addLink(switches[5],switches[6])
    net.addLink(switches[5],switches[7])
    net.addLink(switches[6],switches[17])
    net.addLink(switches[7],switches[8])
    net.addLink(switches[7],switches[11])
    net.addLink(switches[7],switches[12])
    net.addLink(switches[8],switches[9])
    net.addLink(switches[8],switches[10])
    net.addLink(switches[8],switches[19])
    net.addLink(switches[10],switches[13])
    net.addLink(switches[10],switches[19])
    net.addLink(switches[11],switches[12])
    net.addLink(switches[11],switches[17])
    net.addLink(switches[12],switches[13])
    net.addLink(switches[12],switches[14])
    net.addLink(switches[14],switches[15])
    net.addLink(switches[14],switches[16])
    net.addLink(switches[14],switches[18])
    net.addLink(switches[14],switches[19])
    net.addLink(switches[16],switches[17])
    net.addLink(switches[16],switches[18])
    net.addLink(switches[16],switches[23])
    net.addLink(switches[19],switches[20])
    net.addLink(switches[19],switches[23])
    net.addLink(switches[19],switches[26])
    net.addLink(switches[19],switches[27])
    net.addLink(switches[20],switches[24])
    net.addLink(switches[20],switches[26])
    net.addLink(switches[21],switches[22])
    net.addLink(switches[22],switches[25])
    net.addLink(switches[23],switches[24])
    net.addLink(switches[24],switches[25])
    net.addLink(switches[25],switches[28])
    net.addLink(switches[25],switches[31])
    net.addLink(switches[26],switches[32])
    net.addLink(switches[28],switches[29])
    net.addLink(switches[29],switches[30])
    net.addLink(switches[30],switches[31])
    net.addLink(switches[31],switches[32])

    net.build()
    for controller in controllers:
        controller.start()

    if controllerGroup == 0:
        switchMap = chunk_consecutive(switchNames, controller_amount)
    elif controllerGroup == 1:
        switchMap = chunk_odds_evens(switchNames, controller_amount)
    else:
        switchMap = chunk_by_twos(switchNames, controller_amount)

    for i in range(len(switchMap)):
        for s in switchMap[i]:
            switch = net.getNodeByName(s)
            switch.start([controllers[i]])

    return controllers

def Internet2( net, controller_amount, controllerGroup ):
    port = 6633
    controllers = []
    for i in range(controller_amount):
        controllers.append(net.addController( 'c' + str(i + 1), port=port))
        port += 1

    # add switches
    switchNames = []
    for i in range(34):
        switch = 's' + str(i+1)
        net.addSwitch(switch, stp=True, failMode='standalone')
        switchNames.append(switch)
    # addhosts
    for i in range(34):
        host = 'h' + str(i+1)
        net.addHost(host)
    # links
    for i in range(34):
        net.addLink(net.hosts[i], net.switches[i])
    switch = net.switches
    switches = [None]
    for s in switch:
        switches.append(s)
    net.addLink(switches[1],switches[2])
    net.addLink(switches[1],switches[3])
    net.addLink(switches[2],switches[5])
    net.addLink(switches[3],switches[4])
    net.addLink(switches[3],switches[6])
    net.addLink(switches[4],switches[22])
    net.addLink(switches[5],switches[6])
    net.addLink(switches[5],switches[7])
    net.addLink(switches[6],switches[7])
    net.addLink(switches[7],switches[8])
    net.addLink(switches[8],switches[9])
    net.addLink(switches[9],switches[10])
    net.addLink(switches[10],switches[11])
    net.addLink(switches[10],switches[13])
    net.addLink(switches[11],switches[12])
    net.addLink(switches[12],switches[16])
    net.addLink(switches[13],switches[14])
    net.addLink(switches[13],switches[15])
    net.addLink(switches[13],switches[17])
    net.addLink(switches[14],switches[33])
    net.addLink(switches[15],switches[16])
    net.addLink(switches[16],switches[23])
    net.addLink(switches[17],switches[18])
    net.addLink(switches[18],switches[19])
    net.addLink(switches[19],switches[20])
    net.addLink(switches[19],switches[32])
    net.addLink(switches[20],switches[21])
    net.addLink(switches[21],switches[23])
    net.addLink(switches[22],switches[23])
    net.addLink(switches[23],switches[24])
    net.addLink(switches[24],switches[25])
    net.addLink(switches[24],switches[26])
    net.addLink(switches[25],switches[30])
    net.addLink(switches[26],switches[27])
    net.addLink(switches[27],switches[28])
    net.addLink(switches[28],switches[29])
    net.addLink(switches[29],switches[30])
    net.addLink(switches[30],switches[31])
    net.addLink(switches[31],switches[32])
    net.addLink(switches[32],switches[33])
    net.addLink(switches[33],switches[34])

    net.build()

    for controller in controllers:
        controller.start()

    if controllerGroup == 0:
        switchMap = chunk_consecutive(switchNames, controller_amount)
    elif controllerGroup == 1:
        switchMap = chunk_odds_evens(switchNames, controller_amount)
    else:
        switchMap = chunk_by_twos(switchNames, controller_amount)


    for i in range(len(switchMap)):
        for s in switchMap[i]:
            switch = net.getNodeByName(s)
            switch.start([controllers[i]])

    return controllers

def chunk_consecutive(lst, num_controllers):
    chunks = int(ceil(len(lst)/float(num_controllers)))
    a = []
    for i in range(0,len(lst),chunks):
        a.append(lst[i:i+chunks])
    return a

def chunk_odds_evens(lst, num_controllers):
    chunks = int(ceil(len(lst)/float(num_controllers)))
    a = []
    tempA = []
    tempB = []
    for i in range(0,len(lst)):
        if i % 2 == 0:
            tempA.append(lst[i])
        else:
            tempB.append(lst[i])
    a += tempA
    a += tempB
    return chunk_consecutive(a,num_controllers)

def chunk_by_twos(lst, num_controllers):
    chunks = int(ceil(len(lst)/float(num_controllers)))
    a = []
    tempA = [lst[0]]
    tempB = []
    flag = True
    for i in range(1,len(lst)):
        if i % 2 == 0:
            flag = not flag
        if flag:
            tempA.append(lst[i])
        else:
            tempB.append(lst[i])
    a += tempA
    a += tempB
    return chunk_consecutive(a,num_controllers)


topos = { 'bus': ( lambda: Bus() ), 
'ring': ( lambda: Ring() ), 
'star': ( lambda: Star() ), 
'mesh': ( lambda: Mesh() ), 
'highwinds': Highwinds,
'bics': Bics,
'internet2-OSE3': Internet2
}

topologies = ['highwinds', 'bics', 'internet2-OSE3']
