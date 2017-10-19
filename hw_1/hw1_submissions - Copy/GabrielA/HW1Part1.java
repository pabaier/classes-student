import java.util.Scanner;

public class HW1Part1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String word = "";
		System.out.println("Enter any word.");
		word = sc.next(); // no trim needed, because next() used.

		// transform string into char array
		char[] charArray = word.toCharArray();

		// use for loop with Unicode Table to check if A-Z, a-z, or not
		// char A = 65, char z = 122
		for (int i = 0; i < charArray.length; i++) {
			if ((int) charArray[i] < 65 || (int) charArray[i] > 122) {
				System.out.println("Error: You are only allowed to enter letters!");
				return;
			}

		}

		// Count all vowels
		int vowelsCounter = 0;
		for (int i = 0; i < word.length(); i++) {
			       if (word.charAt(i) == 'a' || word.charAt(i) == 'A' 
					|| word.charAt(i) == 'e' || word.charAt(i) == 'E'
					|| word.charAt(i) == 'i' || word.charAt(i) == 'I' 
					|| word.charAt(i) == 'o' || word.charAt(i) == 'O'
					|| word.charAt(i) == 'u' || word.charAt(i) == 'U' 
					|| word.charAt(i) == 'y' || word.charAt(i) == 'Y') {
				vowelsCounter++;

				// nested if: if there is a second vowel in a row, decrease 
				//counter by 1. Also consider not go go out of bounds: i<word.length()-1
				  if ((i < word.length() - 1)  // <<--- this makes sure it's not out of bounds
					   && (word.charAt(i + 1) == 'a' || word.charAt(i + 1) == 'A'
						|| word.charAt(i + 1) == 'e' || word.charAt(i + 1) == 'E' 
						|| word.charAt(i + 1) == 'i' || word.charAt(i + 1) == 'I' 
						|| word.charAt(i + 1) == 'o' || word.charAt(i + 1) == 'O'
						|| word.charAt(i + 1) == 'u' || word.charAt(i + 1) == 'U' 
						|| word.charAt(i + 1) == 'y' || word.charAt(i + 1) == 'Y')) {
					vowelsCounter--;
				}
			}

		}
		// if it ends with 'e', deduct 1 vowel
		if (word.charAt(word.length() - 1) == 'e' || word.charAt(word.length() - 1) == 'E')
			vowelsCounter--;

		// here I need to increase one vowel if the word ends with 2 or more
		// consecutive 'e's
		if ((word.charAt(word.length() - 1) == 'e' || word.charAt(word.length() - 1) == 'E')
	     && (word.charAt(word.length() - 2) == 'e' || word.charAt(word.length() - 2) == 'E'))
			vowelsCounter++;

		// to make sure each word has at least 1 vowel: Ex: me, she, he ...
		if (vowelsCounter == 0) {
			System.out.println("The amount of syllables in " + word + " is 1");
			return;
		}

		System.out.println("The amount of syllables in " + word + " is " + vowelsCounter);

	}

}
