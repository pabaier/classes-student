from itertools import *

#==============================================================================
# for i in range(100):
#     j = i >> 1
#     print(str(i) + " >> 1 =  " + str(j))
#==============================================================================
#==============================================================================
# for i in range(27):
#     for j in range(3):
#         print(str((i // 3**j)%3), end=' ')
#     print()
# for i in range(27):
#     for j in range(3):
#         print(str((i // 2**j)%2), end=' ')
#     print()
#==============================================================================

def powerSet(items):
    d = chain.from_iterable(combinations(items,i) for i in range(len(items)+1))
    
    for i in d:
        yield i

a =  [1,2,3,4,5,6,7,8,9]
a1 = ['a', 'b', 'c']
b = ((x + 1) for x in a)
c = sum(x+1 for x in a)

d = powerSet([1,2,3])
for i in d:
    print(i)
    
a =  [1,2,3,4,5,6,7,8,9]
b = ['one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']
c = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i']













#==============================================================================
# def brute_force_cow_transport(cows,limit=10):
#     """
#     Finds the allocation of cows that minimizes the number of spaceship trips
#     via brute force.  The brute force algorithm should follow the following method:
# 
#     1. Enumerate all possible ways that the cows can be divided into separate trips
#     2. Select the allocation that minimizes the number of trips without making any trip
#         that does not obey the weight limitation
#             
#     Does not mutate the given dictionary of cows.
# 
#     Parameters:
#     cows - a dictionary of name (string), weight (int) pairs
#     limit - weight limit of the spaceship (an int)
#     
#     Returns:
#     A list of lists, with each inner list containing the names of cows
#     transported on a particular trip and the overall list containing all the
#     trips
#     """
#     pass
#     total = []
#     c = []
#     for i in cows:
#         c.append(i)
#         
#     N = len(c)
#     # enumerate the 2**N possible combinations
#     for i in range(2**N):
#         combo = []
#         for j in range(N):
#             # test bit jth of integer i
#             if (i >> j) % 2 == 1:
#                 combo.append(c[j])
#         total.append(combo)
#     
#     # make list of weight totals and index values of weights less than limit
#     weightList = []
#     indexList = []
#     index = 0
#     for i in total:
#         sum = 0
#         for j in i:
#             sum += cows[j]
#         weightList.append(sum)
#         if sum <= limit:
#             indexList.append(index)
#         index += 1
#     
#     workingList = []
#     for i in indexList:
#         workingList.append(total[i])
#         
#     lengthList = []
#     for i in workingList:
#         lengthList.append(len(i))
#         
#     totalLengthList = []
#     for i in total:
#         totalLengthList.append(len(i))
#==============================================================================
