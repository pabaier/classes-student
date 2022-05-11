# from itertools import chain, combinations
import itertools
        
#==============================================================================
# def powerSet(items):
#     d = chain.from_iterable(combinations(items,i) for i in range(len(items)+1))
#     
#     for i in d:
#         yield i
#==============================================================================

def powerSet(items):
    """
        Generates all combinations of N items
        Input: list of items
        Yields a list of which item(s) are in bag.
    """
    N = len(items)
    yield [x for length in range(N + 1) \
            for x in itertools.combinations(items, length)]

d = powerSet([1,2,3])
for i in d:
    print(i)