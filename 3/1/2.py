import copy
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
	# for i in range(0, 25): # i is the shift

	a = list(letterFrequencies[0].keys())
	letterFrequencies[0].pop(a[0])

	printDict(letterFrequencies)

def printDict(dicti):
	for row in dicti:
		print(dicti[row])

if __name__ == "__main__":
	main()