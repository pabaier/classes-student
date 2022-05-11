/*
 * Kyle Winstead
 * Homework 1 Part 1
 * McCauley 12:30p
 * 
 * Pseudocode
 * String word
 * Prompt user for entry of one word only
 * read in word=in.next() because it will automatically take away all white space around first word and delete anything before and after the white space
 * 		Method:wordSyllables
 * 		counts how many syllables in the word (see method pseudocode for detail)
 * 		
 * 		Method: isOnlyLetters
 * 		checks to make sure the string read in that has been chopped is only all letters.
 */
import java.util.*;
public class HW1Part1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		String word = "";
		
		
		
		System.out.println("Enter one word: ");
		word = in.next();
		System.out.println("Syllable count: " + wordSyllables(word));
		
		
	
		
		
	}
	/**
	 * @method wordSyllables - Turn the string letters to all upper case letters. run the string through a loop to check for at
	 * least one index filled with something (checking for characters occurs later). Check to see if all letters in string are characters
	 * and print error if false. do this by calling in a method. Check to see if the string ends in 'e' and if so, minus one from the
	 * syllable counter. if it ends in 'aiouy' increment syllables by one. if string starts with 'aeiou' increment by one. if there are
	 * one character entered, print one syllable. 
	 * @param word
	 * @return syllables - returns the number of syllables in a word or error for the 
	 */
	 public static	 int wordSyllables(String word) {
	        int syllables = 0;
	        String upper = word.toUpperCase();
	     
	        for (int i = 1; i < upper.length()-1; i++){
	            char a = upper.charAt(i);
	            char b = (upper.charAt(i-1));
	            if ("AEIOUY".indexOf(a) >= 0 && "AEIOUY".indexOf(b) == -1){
	                syllables++;
	            }
	             
	        }
	        char a = upper.charAt(0);
	        char b = upper.charAt(upper.length()-1);
	        
	        if(isOnlyLetters(word)) {
	        	
	        
	        if (b == 'E'){
	            syllables = syllables;
	        } 
	        else if ("AIOUY".indexOf(b) >= 0)
	            syllables++;
        
	        if ("AEIOUY".indexOf(a) >= 0){
	            syllables++;
	        }
	        if(syllables <= 0){
	            syllables = 1;
	        }
	        
	        
	        }
	        else {
	        	
	        	syllables = 0;
	        }return syllables;
	    }
	 
	 /**
	  * @method this method allows to check to see if all characters are in fact part of the alphabet. it starts with checking to see
	  * if the word is in the Char array, consisting of all letters only. then it loops to see if that character is in the aray
	  * 	  * if it is, it returns true. if it is not a letter it returns false. der4
	  * @param word
	  * @return boolean - if input is all letters or not.
	  */
	 	public static boolean isOnlyLetters (String word) {
	 		char[] characters = word.toCharArray();
	 		for(char c : characters) {
	 			if (!Character.isLetter(c)) {
	 				return false;
	 		}
	 	}
	 	return true;
	 }
}


