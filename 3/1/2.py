import copy
import operator

ENGLISH_LETTER_FREQUENCIES = {
	'a':0.080, 
	'b':0.015, 
	'c':0.030, 
	'd':0.040, 
	'e':0.130, 
	'f':0.020, 
	'g':0.015, 
	'h':0.060, 
	'i':0.065, 
	'j':0.005, 
	'k':0.005, 
	'l':0.035, 
	'm':0.030,
	'n':0.070,
	'o':0.080,
	'p':0.020,
	'q':0.002,
	'r':0.065,
	's':0.060,
	't':0.090,
	'u':0.030,
	'v':0.010,
	'w':0.015,
	'x':0.005,
	'y':0.020,
	'z':0.002 
}

def main():
	message = "TSMVM MPPCW CZUGX HPECP RFAUE IOBQW PPIMS FXIPC TSQPK SZNUL OPACR DDPKT SLVFW ELTKR GHIZS FNIDF ARMUE NOSKR GDIPH WSGVL EDMCM SMWKP IYOJS TLVFA HPBJI RAQIW HLDGA IYOUX".lower().replace(" ", "")

	# get frequency of each letter in each position (positions are 1-5 because we know the key length is 5)
	letterFrequencies = {0: {}, 1:{}, 2:{}, 3:{}, 4:{}}
	for i in range(0,len(message)):
		letterIndex = i%5
		letter = message[i]
		if letter in letterFrequencies[letterIndex]:
			letterFrequencies[letterIndex][letter] += 1
		else:
			letterFrequencies[letterIndex][letter] = 1

	letterFrequencyPercentages = copy.deepcopy(letterFrequencies)

	# get frequency percentages
	total = len(message)/5 # 28
	for entry in letterFrequencies:
		for letter in letterFrequencies[entry]:
			letterFrequencyPercentages[entry][letter] /= total 

	# cycle through percentages to see which shift is most likely
	a = getShiftValue(letterFrequencyPercentages[0])
	b = getShiftValue(letterFrequencyPercentages[1])
	c = getShiftValue(letterFrequencyPercentages[2])
	d = getShiftValue(letterFrequencyPercentages[3])
	e = getShiftValue(letterFrequencyPercentages[4])

	shiftValues = [a,b,c,d,e]
	print(decipherMessage(message, shiftValues))

def decipherMessage(message, key):
	decipheredMessage = ''
	i = 0
	for letter in message:
		decipheredMessage += getLetterShift(letter, key[i])
		i += 1
		i %= len(key)
	return decipheredMessage

def getShiftValue(row):
	shiftTotals = {}
	for i in range(0, 26): # i is the shift
		total = 0
		for letter in row:
			shiftedLetter = getLetterShift(letter, i)
			value = ENGLISH_LETTER_FREQUENCIES[shiftedLetter]
			total += value * row[letter]
		shiftTotals[i] = total
	
	return getMax(shiftTotals)

def getMax(shiftTotals):
	return max(shiftTotals.items(), key=operator.itemgetter(1))[0]

def getLetterShift(letter, shift):
	letterValue = ord(letter)
	newLetterValue = letterValue + shift
	if newLetterValue > 122:
		newLetterValue = 97 + (newLetterValue - 122) - 1
	return chr(newLetterValue)

def printDict(dicti):
	for row in dicti:
		print(str(row) + ": " + str(dicti[row]))

if __name__ == "__main__":
	main()

