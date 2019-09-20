import operator
import collections

message = "UDSMLS JGJUSP UDQUZQ LLMUAS AIMFSL SHSLCL UDSMIG CJUDSM LSUCPS OQWUDS MLSUCP SOQWNJ SJQIQL WMPVGE SLSIQU SWFSGJ UISQPQ VJMZQV VSWQFS GOQWQJ VMLEQJ UDSPSJ JQESQL WLSHSI NJSJUD SJQPSF SGOQWP MISUDQ LMLZSU DSMOSI QUCMLO SIXMIP SWCJYM IUMENQ IQLUSS OSIXSZ UJSZIS ZGUDSF SGOQWP NJUASE SLSIQU SWAGQU INVGIQ LWMPOI MZSJJQ LMLUIC HCQVUQ JFCLCU JSVXMU DSIBCJ SCUPCE DUASWS WNZSWX IMPOQU USILJU DSMLSU CPSOQW CJCPOI QZUCZQ VCLPMJ UQOOVC ZQUCML SLHCIM LPSLUJ ASZQNJ SMXUDS WCXXCZ NVUCSJ MXESUU CLEUDS FSGOQW UMUDSI SZSCHS IMHSIQ JSZNIS ZDQLLS VCLJUS QWJUIS QPZCOD SIJJCP NVQUSQ MLSUCP SOQWAG NJCLEQ OJSNWM IQLWMP FSGESL SIQUMI BDCZDP QGMIPQ GLMUAS JSZNIS"
message = message.lower().replace(" ", "")

monogramFrequencies = {'e': 12.1, 't': 8.94, 'a': 8.55, 'o': 7.47, 'i': 7.33, 'n': 7.17, 's': 6.73, 'r': 6.33, 'h': 4.96, 'l': 4.21, 'd': 3.87, 'c': 3.16, 'u': 2.68, 'm': 2.53, 'f': 2.18, 'g': 2.09, 'p': 2.07, 'w': 1.83, 'y': 1.72, 'b': 1.6, 'v': 1.06, 'k': 0.81, 'j': 0.22, 'x': 0.19, 'z': 0.11, 'q': 0.1}
bigramFrequencies = {'th': 1.52, 'he': 1.28, 'in': 0.94, 'er': 0.94, 'an': 0.82, 're': 0.68, 'nd': 0.63, 'at': 0.59, 'on': 0.57, 'nt': 0.56, 'ha': 0.56, 'es': 0.56, 'en': 0.55, 'st': 0.55, 'ed': 0.53, 'to': 0.52, 'it': 0.5, 'ou': 0.5, 'ea': 0.47, 'hi': 0.46, 'is': 0.46, 'or': 0.43, 'ti': 0.34, 'as': 0.33, 'te': 0.27, 'et': 0.19, 'ng': 0.18, 'of': 0.16, 'al': 0.09, 'de': 0.09, 'se': 0.08, 'le': 0.08, 'sa': 0.06, 'si': 0.05, 'ar': 0.04, 've': 0.04, 'ra': 0.04, 'ld': 0.02, 'ur': 0.02}
trigramFrequencies = {'the': 1.81, 'and': 0.73, 'ing': 0.72, 'ent': 0.42, 'ion': 0.42, 'her': 0.36, 'for': 0.34, 'tha': 0.33, 'nth': 0.33, 'int': 0.32, 'ere': 0.31, 'tio': 0.31, 'ter': 0.3, 'est': 0.28, 'ers': 0.28, 'ati': 0.26, 'hat': 0.26, 'ate': 0.25, 'all': 0.25, 'hes': 0.24, 'ver': 0.24, 'his': 0.24, 'eth': 0.24, 'oft': 0.22, 'ith': 0.21, 'fth': 0.21, 'sth': 0.21, 'oth': 0.21, 'res': 0.21, 'ont': 0.2}
# solution_map = {'a': 'A', 'b': 'B', 'c': 'C', 'd': 'D', 'e': 'E', 'f': 'F', 'g': 'G', 'h': 'H', 'i': 'I', 'j': 'J', 'k': 'K', 'l': 'L', 'm': 'M', 'n': 'N', 'o': 'O', 'p': 'P', 'q': 'Q', 'r': 'R', 's': 'S', 't': 'T', 'u': 'U', 'v': 'V', 'w': 'W', 'x': 'X', 'y': 'Y', 'z': 'Z'}

# sorted_x = sorted(monogramFrequencies.items(), key=lambda kv: kv[1], reverse=True)
# s = dict(collections.OrderedDict(sorted_x))
# b = {}
# for a in s:
# 	b[a.lower()] = s[a]
# print(b)

def main():
	solution_map = {
		'a': 'B', 
		'b': 'W',
		'c': 'I', 
		'd': 'H', 
		'e': 'G', 
		'f': 'K', 
		'g': 'Y', 
		'h': 'V', 
		'i': 'R', 
		'j': 'S', 
		'k': 'K', 
		'l': 'N', 
		'm': 'O', 
		'n': 'U', 
		'o': 'P', 
		'p': 'M', 
		'q': 'A', 
		'r': 'R', 
		's': 'E', 
		't': 'T', 
		'u': 'T', 
		'v': 'L', 
		'w': 'D', 
		'x': 'F', 
		'y': 'Y', 
		'z': 'C'
	}
	monogramCount = getNGramCount(1, message)
	monogramCount_sorted = sortDict(monogramCount)
	print(monogramCount_sorted)

	# monoMessage = replaceLetters(monogramCount, monogramFrequencies, message)

	bigramCount = getNGramCount(2, message, overlap=True)
	bigramCount_sorted = sortDict(bigramCount)
	# print(bigramCount_sorted)

	trigramCount = getNGramCount(3, message, True)
	trigramCount_sorted = sortDict(trigramCount)
	# print(trigramCount_sorted)

	# b = a.replace("f", "h").replace("g", "r")
	# c = b.replace("i", "r") # this comes fro the third most common digram 'si'. we know 's' maps to 'e'. the most common 'e_' is 'er', so 'i' is 'r'
	# e = c.replace("o", "i").replace("q", "n").replace("w", "g") # 'oqw could be 'a', 'n', 'd' or 'i', 'n', 'g'

	# c = {}
	# for a in range(ord('a'), ord('z')+1):
	# 	c[chr(a)] = chr(a-32)
	# print(c)
	print(decipher(message, solution_map))

def decipher(message, mapping):
	solution = ''
	for letter in message:
		if letter.lower() == mapping[letter].lower():
			solution += letter
		else:
			solution += mapping[letter]
	return solution

def replaceLetters(encodedLetters, frequencyLetters, message):
	encoded_sorted = sortDict(encodedLetters)
	frequency_sorted = sortDict(frequencyLetters)

	a = list(encoded_sorted.keys())
	b = list(frequency_sorted.keys())
	mappings = {}
	for i in range(0,len(a)):
		mappings[a[i]] = b[i]
	
	mapped = []
	i = 0
	for messageLetter in message:
		mapped.append(mappings[messageLetter])
	mappedMessage = ""
	for letter in mapped:
		mappedMessage += letter
	return mappedMessage

def sortDict(dicti, reverse=True):
	dict_sorted = sorted(dicti.items(), key=lambda kv: kv[1], reverse=reverse)
	return dict(collections.OrderedDict(dict_sorted))

def getNGramCount(n, message, overlap=False):
	gap = n
	if overlap:
		gap = 1
	ngramCount = {}
	for i in range(0,len(message)-n+1, gap):
		ngram = message[i:i+n];
		if ngram in ngramCount.keys():
			ngramCount[ngram] += 1
		else:
			ngramCount[ngram] = 1
	return ngramCount

if __name__ == "__main__":
	main()