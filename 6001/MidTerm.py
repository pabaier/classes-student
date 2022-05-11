#==============================================================================
# def closest_power(base, num):
#     '''
#     base: base of the exponential, integer > 1
#     num: number you want to be closest to, integer > 0
#     Find the integer exponent such that base**exponent is closest to num.
#     Note that the base**exponent may be either greater or smaller than num.
#     In case of a tie, return the smaller value.
#     Returns the exponent.
#     '''
#     num = int(num)
#     closestDiff = num
#     exp = 0
#     for i in range(0,num):
#         if abs(base**i - num) < closestDiff:
#             closestDiff = abs(base**i - num)
#             exp = i
#     return exp
#==============================================================================

#==============================================================================
# def dotProduct(listA, listB):
#     '''
#     listA: a list of numbers
#     listB: a list of numbers of the same length as listA
#     '''
#     listSum = 0
#     for i in range(len(listA)):
#         listSum = listSum + listA[i] * listB[i]
#     return listSum
#==============================================================================

#==============================================================================
# def deep_reverse(L):
#     """ assumes L is a list of lists whose elements are ints
#     Mutates L such that it reverses its elements and also 
#     reverses the order of the int elements in every element of L. 
#     It does not return anything.
#     """  
#     def swapAll(M):
#         start = 0
#         end = len(M)-1
#         while start < end:
#             temp = M[start]
#             M[start] = M[end]
#             M[end] = temp
#             start += 1
#             end -= 1
#     swapAll(L)
#     for i in range(len(L)):
#         swapAll(L[i])
#==============================================================================

#==============================================================================
# def dict_interdiff(d1, d2):
#     
#     def intersect(i1, i2):
#         intDict = {}
#         for key in i1:
#             if key in i2:
#                 intDict[key] = f(i1[key], i2[key])
#         return intDict
#     
#     def difference(diff1, diff2):
#         diffDict = {}
#         for key in diff1:
#             if not key in diff2:
#                 diffDict[key] = diff1[key]
#         for key in diff2:
#             if not key in diff1:
#                 diffDict[key] = diff2[key]
#         return diffDict
#     
#     return (intersect(d1,d2), difference(d1, d2))
#==============================================================================
            
    
#==============================================================================
# def applyF_filterG(L, f, g):
#     """
#     Assumes L is a list of integers
#     Assume functions f and g are defined for you. 
#     f takes in an integer, applies a function, returns another integer 
#     g takes in an integer, applies a Boolean function, 
#         returns either True or False
#     Mutates L such that, for each element i originally in L, L contains  
#         i if g(f(i)) returns True, and no other elements
#     Returns the largest element in the mutated L or -1 if the list is empty
#     """
#     
# 
#     L2 = L[:]
#     for i in L2:
#         if not g(f(i)):
#             L.remove(i)
#     if len(L) == 0:
#         return -1
#     biggest = L[0]
#     for b in L:
#         if b > biggest:
#             biggest = b
#     return biggest
#==============================================================================

#==============================================================================
# def flatten(aList):
#     ''' 
#     aList: a list 
#     Returns a copy of aList, which is a flattened version of aList 
#     '''
#     bList = []
#     
#     def isList(L):
#         return type(L) == list
#         
#     def recurFlat(lst):
#         for i in lst:
#             if not isList(i):
#                 bList.append(i)
#             else:
#                 recurFlat(i)
#         
#     recurFlat(aList)
#     return bList
#==============================================================================
    