#==============================================================================
# trans = {'0':'ling', '1':'yi', '2':'er', '3':'san', '4': 'si',
#           '5':'wu', '6':'liu', '7':'qi', '8':'ba', '9':'jiu', '10': 'shi'}
# 
# def convert_to_mandarin(us_num):
#     '''
#     us_num, a string representing a US number 0 to 99
#     returns the string mandarin representation of us_num
#     '''
#     int_num = int(us_num)
#     str_num = ''
#     
#     if int_num > 10 and int_num < 20:
#         str_num += trans['10'] + ' ' + trans[str(int_num % 10)]
#     elif int_num > 19 and int_num < 100:
#         tens = int_num // 10
#         ones = int_num % 10
#         str_num += trans[str(tens)] + ' ' + trans['10']
#         if not ones == 0:
#             str_num += ' ' + trans[str(ones)]
#     else:
#         str_num = trans[us_num]
#         
#     return str_num
#==============================================================================


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
    current_streak = 0
    longest_streak = 0 
    current_start = 0
    longest_start = 0
    
    for i in range(1,len(L)):
        if L[i] >= L[i-1]:
            current_streak += 1
            if current_streak > longest_streak:
                longest_streak = current_streak
                longest_start = current_start
        else:
            current_streak = 0
            current_start = i
    
    sum = 0
    for i in range(longest_start, longest_start + longest_streak + 1):
        sum += L[i]
    ascending = (sum, longest_start, longest_streak)


    current_streak = 0
    longest_streak = 0 
    current_start = 0
    longest_start = 0
    
    for i in range(1,len(L)):
        if L[i] <= L[i-1]:
            current_streak += 1
            if current_streak > longest_streak:
                longest_streak = current_streak
                longest_start = current_start
        else:
            current_streak = 0
            current_start = i
    
    sum = 0
    for i in range(longest_start, longest_start + longest_streak + 1):
        sum += L[i]
    descending = (sum, longest_start, longest_streak)
    
    if(ascending[0] > descending[0]):
        return ascending[0]
    else:
        return descending[0]
    
    
    
    
    
print(str(longest_run([1, 2, 3, 4, 5, 6, 7, 8, 9])) + " 45")
print(str(longest_run([1, 2, 3, 2, 1])) + " 6")             
print(str(longest_run([3, 2, 1, 2, 3])) + " 6")             
print(str(longest_run([1, 2, 1, 2, 1, 2, 1, 2, 1])) + " 3") 
print(str(longest_run([1, 2, 3, 4, 5, 0, 10, 1, 2, 3, 4, 5])) + " 15") #15
print(str(longest_run([1, 2, 3, 10, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1])) + " 65")

