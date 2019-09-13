cipher = "TEBKFKQEBZLROPBLCERJXKBSBKQP"
for i in range(0,25):
    out = ''
    for letter in cipher:
        letterValue = ord(letter)
        newLetterValue = letterValue + i
        if newLetterValue > 90:
            newLetterValue = 65 + (newLetterValue - 90) - 1
        out = out + chr(newLetterValue)
    print(out)

# for letter in cipher:
#     letterValue = ord(letter)
#     newLetterValue = letterValue + 3
#     if newLetterValue > 90:
#         newLetterValue = 65 + (newLetterValue - 90) - 1
#     out = out + chr(newLetterValue)
# print(out)