
#==============================================================================
# n = input("You are in the lost forest. Go left or right? ")
# while n == "right":
#     n = input("You are in the lost forest. Go left or right? ")
# print("You got out of the woods!")
#==============================================================================
#==============================================================================
# x = 5023
# sum = 0
# loops = x
# while loops > 0:
#     sum += x
#     loops -= 1
# print(str(x) + " * " + str(x) + " = " + str(sum))
#==============================================================================
    
    
#==============================================================================
# school = 'Massachusetts Institute of Technology'
# numVowels = 0
# numCons = 0
# 
# for char in school:
#     if char == 'a' or char == 'e' or char == 'i' \
#        or char == 'o' or char == 'u':
#         numVowels += 1
#     elif char == 'o' or char == 'M':
#         print(char)
#     else:
#         numCons -= 1
# 
# print('numVowels is: ' + str(numVowels))
# print('numCons is: ' + str(numCons)) 
#==============================================================================


# 1 in Problem set 
#==============================================================================
# s = 'azcbobobegghakl'
# vowels = 0
# for letter in s:
#     if letter == 'a' or letter == 'e' or letter == 'i'\
#     or letter == 'o' or letter == 'u':
#         vowels += 1
# print("Number of vowels: " + str(vowels))
#==============================================================================

# 2 in Problem set
#==============================================================================
# s = 'bobazcbobobegghaklbob'
# bob = 0
# loops = 0
# while loops < len(s):
#     if s[loops:loops + 3] == 'bob':
#         bob += 1
#     loops += 1
# print("Number of times bob occurs is: " + str(bob))
#==============================================================================

# 3 in Problem set
s = 'z'
highestNum = 0
currentNum = 0
start = 0
end = 1
highestString = " "
currentChar = s[0]
while start < len(s)-1:
    
    while end < len(s):
        if currentChar <= s[end:end+1]:
            currentChar = s[end:end+1]
            end += 1;
            currentNum += 1
        else:
            break;
            
    if currentNum > highestNum:
        highestString = s[start:end]
        highestNum = currentNum

    if end > len(s)-1:
        break;
    currentChar = s[end]
    start = end
    end = start + 1
    currentNum = 0

print("Longest string in alphabetical order is: " + highestString)
            
            
        
        























        
