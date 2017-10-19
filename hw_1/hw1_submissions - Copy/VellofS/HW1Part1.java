//This is a program that checks the amount of syllables in a particular word:
//I discussed this with Paul B. (for loops to check at position i) , && 
//Angelica, and Kyle from our class (pseudocode on how to start this program)
//NO answers were directly given in any shape or form: 

//import statement:
import java.util.Scanner;


//public class titled:
public class HW1Part1 {
	//main():
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		//initiate word as a string
		String word = " ";
		//print statement:
		System.out.println("Enter a word: ");
		//searches for the next word once entered:
		word = scnr.next();
		//lowercases the word:
		word = word.toLowerCase();
		//initiation of numSyllables:
		int numSyllables = 0;
		//for loop, stop when word length is less than i:
		for (int i = 0; i < word.length(); i++) {
			
			//if statement to check how many vowels in the word:
			if (word.charAt(i) == 'a'|| word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || 
					word.charAt(i) == 'u' || word.charAt(i) == 'y') {	
				//if statement to check if two vowels are next to each other along with vowels next to each other:
				if (i < word.length()-1) {
					if(word.charAt(i + 1) == 'a'|| word.charAt(i + 1) == 'e' || word.charAt(i + 1) == 'i' || 
							word.charAt(i + 1) == 'o' || 
							word.charAt(i + 1) == 'u' || word.charAt(i + 1) == 'y') {	
						//increment numSyllables:
						numSyllables++;
						//increment i
						i++;
	
					} 
					//else, increment numSyllables:
					else {
						numSyllables++;
					}
				}
				//if statement if the numSyllables is less than or equal to 0:
				if (numSyllables <=0) {
					//increment numSyllables:
					numSyllables++;
				}
			
			
				}
		//print statement:		
	}	System.out.print(word + ": " + numSyllables + " syllables");

}}
