#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Mar 22 17:49:03 2017

@author: paulbaier
"""

import random



def genEven():
    '''
    Returns a random number x, where 0 <= x < 100
    '''
    l = []
    for i in range(100):
        if i%2 == 0:
            l.append(i)     
    return random.choice(l)
    
    
    
x = random.randrange(0,100,2)


def stochasticNumber():
    '''
    Stochastically generates and returns a uniformly distributed even number between 9 and 21
    '''
    return random.randrange(10,21,2)

print (stochasticNumber())