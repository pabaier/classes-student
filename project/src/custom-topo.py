#!/usr/bin/python

"""
Create a network where different switches are connected to
different controllers, by creating a custom Switch() subclass.
"""

from mininet.net import Mininet
from mininet.node import OVSSwitch, IVSSwitch, UserSwitch, Controller, RemoteController
from mininet.topolib import TreeTopo
from mininet.log import setLogLevel
from mininet.cli import CLI
import argparse
import topologies


def simpleTest(args):
    # c0 = Controller( 'c0' )
    topologies.num_switches = args.switch_count
    controller = getController(args.controller)
    topo = topologies.topos[args.topo]()
    switch = getSwitch(args.switch)

    net = Mininet(topo=topo, controller=controller, switch=switch)
    if args.controller == 'remote':
        net.addController( 'c0', controller=RemoteController, ip=args.ip, port=6633)
    net.start()
    
    # http://mininet.org/api/classmininet_1_1net_1_1Mininet.html
    # net.configLinkStatus('s1','s3','down')
    # net.pingAllFull()
    f = open("{}-{}".format(args.topo, args.switch_count), "w")
    f.write("{}".format(args.topo))
    f.write("\n{}".format(args.switch_count))
    switches = net.switches
    for i in range(1,args.runs + 1):
        results = net.pingAllFull()
        print '*********************************************************'
        avgRtt = getAvgRtt(results)
        f.write("\n{}".format(str(avgRtt)))
        # for r in results:
        #     print r[0] # starting node
        #     print r[1] # ending node
        #     print r[2] # (successes, total attempts, min rtt, avg rtt, max rtt, mdev rtt)
    
    # CLI( net )
    net.stop()

def getAvgRtt(results):
    pings = len(results)
    rtts = []
    for element in results:
        rtts.append(float(element[2][2]))
    avgRtt = sum(rtts) / pings
    return(avgRtt)

def getTime(results):
    time = 0.0
    for result in results:
        time += result[2][4]
    return time

def getController(controller):
    switch = {
        'remote': RemoteController,
        'default': Controller( 'c0' )
    }
    return switch[controller]

def getSwitch(switch):
    s = {
        'ovs': OVSSwitch,
        'ivs': IVSSwitch,
        'user': UserSwitch
    }
    return s[switch]


if __name__ == '__main__':
    parser = argparse.ArgumentParser(description='Server Program.')
    parser.add_argument('--switch_count', "-sc", type=int, default=1, dest="switch_count", help='number of switches in network')
    parser.add_argument('--topo', "-t", type=str, default='bus', dest="topo", help='which topology to use')
    parser.add_argument('--switch', "-s", type=str, default='ovs', dest="switch", help='which switch to use')
    parser.add_argument('--controller', "-c", type=str, default='default', dest="controller", help='which controller to use')
    parser.add_argument('--ip', "-i", type=str, default='127.0.0.1', dest="ip", help='which ip a remote controller will use')
    parser.add_argument('--runs', "-r", type=int, default=1, dest="runs", help='how many tests to run')

    args = parser.parse_args()
    # Tell mininet to print useful information
    setLogLevel('info')
    simpleTest(args)