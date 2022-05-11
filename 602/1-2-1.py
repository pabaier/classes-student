def yieldAllCombos(items):
    """
        Generates all combinations of N items into two bags, whereby each 
        item is in one or zero bags.

        Yields a tuple, (bag1, bag2), where each bag is represented as a list 
        of which item(s) are in each bag.
    """
    N = len(items)
    for i in range(3**N): #convert to base 3
        bag1 = []
        bag2 = []

        for j in range(N):
            if (i // 3 ** j) % 3 == 1: #need to convert bitwise operations to base 3!
                bag1.append(items[j])
            elif (i // 3 ** j) % 3 == 2: # %3 converts to base 3
                bag2.append(items[j])
        yield (bag1, bag2)
    

# generate all combinations of N items
def powerSet(items):
    N = len(items)
    # enumerate the 2**N possible combinations
    for i in range(2**N):
        combo = []
        for j in range(N):
            # test bit jth of integer i
            if (i >> j) % 2 == 1:
                combo.append(items[j])
        yield combo

L = [1,2,3]
x = yieldAllCombos(L)       
y = powerSet(L)
n = 0
for i in x:
    print (" " + str(i))
print('----------------------')
for i in y:
    print(i)
x = (7 >> 2)%1
print (x)


#==============================================================================
# 1	2	3
# ————————————————————
# 0	0	0
# 0	0	1
# 0	0	2
# 0	1	0
# 0	1	1
# 0	1	2
# 0	2	0
# 0	2	1
# 0	2	2
# 1	0	0
# 1	0	1
# 1	0	2
# 1	1	0
# 1	1	1
# 1	1	2
# 1	2	0
# 1	2	1
# 1	2	2
# 2	0	0
# 2	0	1
# 2	0	2
# 2	1	0
# 2	1	1
# 2	1	2
# 2	2	0
# 2	2	1
# 2	2	2
#==============================================================================




#==============================================================================
# 0 - 0
# 0 - 1
# 0 - 2
# 0 - 3
# 0 - 1,2
# 0 - 1,3
# 0 - 2,3
# 0 - 1,2,3
# 1 - 0
# 1 - 2
# 1 - 3
# 1 - 2,3
# 2 - 0
# 2 - 1
# 2 - 3
# 2 - 1,3
# 3 - 0
# 3 - 1
# 3 - 2
# 3 - 1,2
# 1,2 - 0
# 1,2 - 3
# 2,3 - 0
# 2,3 - 1
# 1,3 - 0
# 1,3 - 2
# 1,2,3 - 0
#==============================================================================
