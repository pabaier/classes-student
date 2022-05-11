/**
 * FILE: HW1Part1.java
 * Purpose: Estimate number of syllables in a word entered by user
 * Author: Andrea Lingenfelter
 */

// package HW1Part1;

import java.util.Scanner;

public class HW1Part1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int vowelCount = 0;
		int syllables = 0;
		String word = " ";
		char ch = ' ';
		char [] vowels = {'A', 'E', 'I', 'O', 'U', 'Y', 'a', 'e', 'i', 'o', 'u', 'y'};
		
		
		
		System.out.println("Please enter a word: ");
		word = input.nextLine();
		word = word.trim();
		
		if (word.length() == 0) {
			System.out.println("No word entered. Try again.");
		}
		
		if (word.indexOf(' ') >= 0) {
			word = word.substring(0, word.indexOf(' ' ));
		}
		
		// validate all characters are letters
		for (int i = 0; i < word.length(); i++) {
			ch = word.charAt(i);
			if(!Character.isLetter(ch)) {
				System.out.println("Invalid Entry");
				break;
			}
			else {
				System.out.println(ch + " is a valid char");
			}
		}
		
		
		//count vowels
		for (int i = 0; i < word.length(); i++) {
			for (int j = 0; j < vowels.length; j++) {
				if (word.charAt(i) == vowels[j]) {
					vowelCount++;
					System.out.println(vowelCount);
				}
			}
		}
		
		//remove count of "e" at end of word
		if (word.charAt(word.length() - 1) == 'e') {
			System.out.println("Vowel Count with final e: " + vowelCount);
			vowelCount--;
			System.out.println("Updated Vowel Count: " + vowelCount);
		}
		
		//if count is 0, make 1
		if (syllables == 0) {
			syllables = 1;
		}
		
		System.out.println(word);
	}
		
		
}
		 
		

	


