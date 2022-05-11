# -*- coding: utf-8 -*-

#==============================================================================
# x = 25
# epsilon = 0.01
# step = 0.1
# guess = 0.0
# 
# while abs(guess**2-x) >= epsilon:
#     if guess <= x:
#         guess += step
#     else:
#         break
# 
# if abs(guess**2 - x) >= epsilon:
#     print('failed')
# else:
#     print('succeeded: ' + str(guess))
#==============================================================================

#==============================================================================
# print("Please think of a number between 0 and 100!")
# 
# userIn = 'o'
# low = 0
# high = 100
# guess = int(high/2)
# 
# while userIn != 'c':
#     print("Is your secret number " + str(guess) + "?")
#     print("Enter 'h' to indicate the guess is too high.", end = " ")
#     print("Enter 'l' to indicate the guess is too low.", end = " ")
#     userIn = input("Enter 'c' to indicate I guessed correctly. ")
#     
#     if userIn == 'l':
#         low = guess
#         guess = int((high + low)/2)
#     elif userIn == 'h':
#         high = guess
#         guess = int((high + low)/2)
#     elif userIn == 'c':
#         break;
#     else:
#         print("Sorry, I did not understand your input.")
# print("Game over. Your secret number was: " + str(guess))
#==============================================================================

#==============================================================================
# def square(x):
#     '''
#     x: int or float.
#     '''
#     return x*x
# print(str(square(7)))
#==============================================================================

#==============================================================================
# def evalQuadratic(a, b, c, x):
#     '''
#     a, b, c: numerical values for the coefficients of a quadratic equation
#     x: numerical value at which to evaluate the quadratic.
#     '''
#     # Your code here
#     return a*x*x + b*x + c
#==============================================================================

#==============================================================================
# def iterPower(base, exp):
#     '''
#     base: int or float.
#     exp: int >= 0
#  
#     returns: int or float, base^exp
#     '''
#     total = 1
#     for i in range(exp):
#         total *= base
#     return total
# 
# print(str(iterPower(3,3)))
#==============================================================================

#==============================================================================
# def recurPower(base, exp):
#     '''
#     base: int or float.
#     exp: int >= 0
#  
#     returns: int or float, base^exp
#     '''
#     if exp == 0:
#         return 1
#     else:
#         return base * recurPower(base, exp-1)
# 
# print(str(recurPower(3,3)))
#==============================================================================
    
#==============================================================================
# def gcdIter(a, b):
#     '''
#     a, b: positive integers
#     
#     returns: a positive integer, the greatest common divisor of a & b.
#     '''
#     if a > b:
#         divisor = b
#     else:
#         divisor = a
#     while divisor > 0:
#         if(a%divisor == 0 and b%divisor == 0):
#             return divisor
#         else:
#             divisor -= 1
# 
# print(str(gcdIter(17,12)))
#==============================================================================

#==============================================================================
# def gcdRecur(a, b):
#     '''
#     a, b: positive integers
#     
#     returns: a positive integer, the greatest common divisor of a & b.
#     '''
#     if(b == 0):
#         return a
#     else:
#         return gcdRecur(b, a%b)
# 
# print(str(gcdRecur(9,12)))
#==============================================================================
    
#==============================================================================
# def isIn(char, aStr):
#     '''
#     char: a single character
#     aStr: an alphabetized string
#     
#     returns: True if char is in aStr; False otherwise
#     '''
#     length = int(len(aStr)/2)
#     if len(aStr) > 0:
#         test = aStr[length]
#     else:
#         return False
#     if(char == test):
#         return True
#     elif(char > test and length > 0):
#         return isIn(char,aStr[length:])
#     elif(char < test and length > 0):
#         return isIn(char,aStr[:length])
#     else:
#         return False
#         
# print(isIn('a', ''))
# print(isIn('a', 'agoqtuv'))
#==============================================================================
#==============================================================================
# import math
# 
# def polysum(n, s):
#     
#     area = (0.25*n*s*s)/(math.tan(math.pi/n))
#     perim = n * s
#     
#     return round(area + (perim*perim), 4)
#     
#     
# print(polysum(55,97))
#==============================================================================
    
    
    
    
    
    
    
    
    
    
    
    
    
    