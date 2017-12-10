def longest_run(L):
    """
    Assumes L is a list of integers containing at least 2 elements.
    Finds the longest run of numbers in L, where the longest run can
    either be monotonically increasing or monotonically decreasing. 
    In case of a tie for the longest run, choose the longest run 
    that occurs first.
    Does not modify the list.
    Returns the sum of the longest run. 
    """
    
    # low to high (lth)
    start = 0
    end = 0
    startBest = 0
    endBest = 0
    
    for i in range(1, len(L)):
        if L[i] >= L[i-1]:
            end = i
            if (end - start) > (endBest - startBest):
                startBest = start
                endBest = end
        else:
            end = i
            start = i

    lth_start = startBest
    lth_end = endBest
        
    # high to low (htl)
    start = 0
    end = 0
    startBest = 0
    endBest = 0
    
    for i in range(1, len(L)):
        if L[i] <= L[i-1]:
            end = i
            if (end - start) > (endBest - startBest):
                startBest = start
                endBest = end
        else:
            end = i
            start = i

    htl_start = startBest
    htl_end = endBest
    
    
    #check best
    delta_lth = lth_end - lth_start
    delta_htl = htl_end - htl_start
    
    if delta_lth > delta_htl:
        bs = lth_start
        be = lth_end
    elif delta_lth < delta_htl:
        bs = htl_start
        be = htl_end
    else:
        if lth_start < htl_start:
            bs = lth_start
            be = lth_end
        else:
            bs = htl_start
            be = htl_end
    sum = 0
    for i in range(bs, be + 1):
        sum += L[i]

    return sum
        
    
print(str(longest_run([1, 2, 3, 4, 5, 6, 7, 8, 9])) + " 45")
print(str(longest_run([1, 2, 3, 2, 1])) + " 6")             
print(str(longest_run([3, 2, 1, 2, 3])) + " 6")             
print(str(longest_run([1, 2, 1, 2, 1, 2, 1, 2, 1])) + " 3") 
print(str(longest_run([1, 2, 3, 4, 5, 0, 10, 1, 2, 3, 4, 5])) + " 15") #15
print(str(longest_run([1, 2, 3, 10, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1])) + " 65")

print(str(longest_run([-1, -2, -3, -4, -10, -100, -150, -169, -1000, -10000, -100000])) + " -111439")
print(str(longest_run([-100, -10, -10, -10, -10, -10, -10, -10, 0])) + " -170")             
print(str(longest_run([-1, -10, -10, -10, -10, -10, -10, -100])) + " -161")             
print(str(longest_run([1, 2, 3, 2, 1, -10, -20, 3, 3, 3, 3, 3, 3, 3, 3, 3])) + " 7") 
