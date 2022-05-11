
def isWordGuessed(secretWord, lettersGuessed):
    '''
    secretWord: string, the word the user is guessing
    lettersGuessed: list, what letters have been guessed so far
    returns: boolean, True if all the letters of secretWord are in lettersGuessed;
      False otherwise
    '''
    for l in secretWord:
        if l not in lettersGuessed:
            return False
    return True

def getGuessedWord(secretWord, lettersGuessed):
    '''
    secretWord: string, the word the user is guessing
    lettersGuessed: list, what letters have been guessed so far
    returns: string, comprised of letters and underscores that represents
      what letters in secretWord have been guessed so far.
    '''
    s = ""
    for l in secretWord:
        if l in lettersGuessed:
            s = s + l
        else:
            s = s + "_ "
    return s

def getAvailableLetters(lettersGuessed):
    '''
    lettersGuessed: list, what letters have been guessed so far
    returns: string, comprised of letters that represents what letters have not
      yet been guessed.
    '''
    s = ""
    alpha = "abcdefghijklmnopqrstuvwxyz"
    for l in alpha:
        if l not in lettersGuessed:
            s = s + l
    return s

















a = "happy"
b = "abcdehy"
print(getAvailableLetters(b))