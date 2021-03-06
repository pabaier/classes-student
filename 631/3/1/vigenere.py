import copy
import operator

ENGLISH_LETTER_FREQUENCIES = {'a':0.080, 'b':0.015, 'c':0.030, 'd':0.040, 'e':0.130, 'f':0.020, 'g':0.015, 'h':0.060, 'i':0.065, 'j':0.005, 'k':0.005, 'l':0.035, 'm':0.030, 'n':0.070, 'o':0.080, 'p':0.020, 'q':0.002, 'r':0.065, 's':0.060, 't':0.090, 'u':0.030, 'v':0.010, 'w':0.015, 'x':0.005, 'y':0.020, 'z':0.002}

def main():
	message = "TSMVM MPPCW CZUGX HPECP RFAUE IOBQW PPIMS FXIPC TSQPK SZNUL OPACR DDPKT SLVFW ELTKR GHIZS FNIDF ARMUE NOSKR GDIPH WSGVL EDMCM SMWKP IYOJS TLVFA HPBJI RAQIW HLDGA IYOUX".lower().replace(" ", "")

	# get frequency of each letter with a period of 5 (produces a dict of {0:{'a':3, 'b':1}, 1{'a':2, 'b':4}, ...} )
	letterFrequencies = getLetterFrequencies(message)
	
	# gets the percentage that each letter appears within each period
	letterFrequencyPercentages = getLetterFrequencyPercentages(letterFrequencies)

	# uses the percentage and english letter frequencies to derive
	key = getKeys(letterFrequencyPercentages)

	# deciphers the message based on the key
	decipheredMessage = decipherMessage(message, key)

	# print results
	for value in key:
		print(list(ENGLISH_LETTER_FREQUENCIES.keys())[value], end='')
	print()
	print(decipheredMessage)

def decipherMessage(message, key):
	decipheredMessage = ''
	i = 0
	for letter in message:
		decipheredMessage += getLetterShift(letter, key[i])
		i += 1
		i %= len(key)
	return decipheredMessage

def getKeys(letterFrequencyPercentages):
	keys = []
	for row in letterFrequencyPercentages:
		keys.append(getShiftValue(letterFrequencyPercentages[row]))
	return keys

# for each period:
# 	for every letter in that period:
# 		multiply the % the letter appears in the cipher text by the english language frequency of that letter, then sum up this value for every letter
# 		this gives the strength of that shift value
# 		shift the letters over one and repeat
# 		repeat this until every shift has been tried (26 in the case of the English alphabet)
# 		then find and return the strongest shift (the one that produces the maximum value)

# This method does this process for a single period
def getShiftValue(row):
	shiftTotals = {}
	for i in range(0, 26): # i is the shift
		total = 0
		# shift every letter in the row and sum the probabilities for the entire row
		for letter in row:
			shiftedLetter = getLetterShift(letter, i)
			value = ENGLISH_LETTER_FREQUENCIES[shiftedLetter]
			total += value * row[letter]
		shiftTotals[i] = total
	
	return getMax(shiftTotals)

# gets the max value in a dictionary
def getMax(shiftTotals):
	return max(shiftTotals.items(), key=operator.itemgetter(1))[0]

# same basic algorithm as the Caesar Cipher
# assumes all letters are lowercase
def getLetterShift(letter, shift):
	letterValue = ord(letter)
	newLetterValue = letterValue + shift
	if newLetterValue > 122:
		newLetterValue = 97 + (newLetterValue - 122) - 1
	return chr(newLetterValue)

def getLetterFrequencies(message, period=5):
	letterFrequencies = {}
	for i in range(0,period):
		letterFrequencies[i] = {}
	for i in range(0,len(message)):
		letterIndex = i%period
		letter = message[i]
		if letter in letterFrequencies[letterIndex]:
			letterFrequencies[letterIndex][letter] += 1
		else:
			letterFrequencies[letterIndex][letter] = 1
	return letterFrequencies

def getLetterFrequencyPercentages(letterFrequencies):
	letterFrequencyPercentages = {}
	for row in letterFrequencies:
		letterFrequencyPercentages[row] = {}
		total = 0
		for letter in letterFrequencies[row]:
			total += letterFrequencies[row][letter]
			letterFrequencyPercentages[row][letter] = {}
		for letter in letterFrequencies[row]:
			letterFrequencyPercentages[row][letter] = letterFrequencies[row][letter]/total
	
	return letterFrequencyPercentages

def printDict(dicti):
	for row in dicti:
		print(str(row) + ": " + str(dicti[row]))

if __name__ == "__main__":
	main()

