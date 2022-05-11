#x = (1, 2, (3, 'John', 4), 'Hi')

#==============================================================================
# def oddTuples(aTup):
#     '''
#     aTup: a tuple
#     
#     returns: tuple, every other element of aTup. 
#     '''
#     odd = ()
#     count = 0
#     for i in aTup:
#         if count % 2 == 0:
#             odd += (i,)
#         count += 1
#     return odd
# 
# c = ('I', 'am', 'a', 'test', 'tuple')
# d = oddTuples(c)
#==============================================================================

#==============================================================================
# def oddTuples(aTup):
#     return (aTup[::2])
# 
# c = ('I', 'am', 'a', 'test', 'tuple')
# d = oddTuples(c)
#==============================================================================

#==============================================================================
# def applyToEach(L, f):
#     for i in range(len(L)):
#         L[i] = f(L[i])
#         
# testList = [1, -4, 8, -9]
# applyToEach(testList, abs)
# print(testList)
#==============================================================================

#==============================================================================
#   >>> print testList
#   [2, -3, 9, -8]
#==============================================================================

#==============================================================================
# def applyToEach(L, f):
#      for i in range(len(L)):
#          L[i] = f(L[i])
# 
# def addOne(a):
#     return a + 1
# 
# testList = [1, -4, 8, -9]
# 
# applyToEach(testList, addOne)
# print(testList)
#==============================================================================
#==============================================================================
# 
# #[1, 16, 64, 81]
# 
# def applyToEach(L, f):
#      for i in range(len(L)):
#          L[i] = f(L[i])
#          
# def square(n):
#     return n*n
# 
# testList = [1, -4, 8, -9]
# 
# applyToEach(testList, square)
# 
#==============================================================================

#==============================================================================
# animals = {'a': 'aardvark', 'b': 'baboon', 'c': 'coati'}
# 
# animals['d'] = 'donkey'
#==============================================================================

#==============================================================================
# def how_many(aDict):
#     '''
#     aDict: A dictionary, where all the values are lists.
# 
#     returns: int, how many values are in the dictionary.
#     '''
#     a = 0
#     for i in animals.values():
#         for j in i:
#             a += 1
#     return a
#==============================================================================

def biggest(aDict):
    '''
    aDict: A dictionary, where all the values are lists.

    returns: The key with the largest number of values associated with it
    '''
    max = 0
    for i in aDict:
        if len(aDict[i]) > max:
            max = len(aDict[i])
            maxKey = i
            
    return maxKey
            
            
        

animals = { 'a': ['aardvark'], 'b': ['baboon'], 'c': ['coati']}

animals['d'] = ['donkey']
animals['d'].append('dog')
animals['d'].append('dingo')
print(biggest(animals))
    


       




























