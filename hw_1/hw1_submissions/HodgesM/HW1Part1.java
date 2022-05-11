

/**
 * Code for HW1
 *
 * Submission for Mark Hodges
 * 
 */
import java.util.Scanner;

public class HW1Part1
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String userWord;
        int wordLength;
        int i;
        int syllable = 0;
        
        System.out.println("Enter a word: ");
        userWord = input.next();
        wordLength = userWord.length();
        for (i = 0; i <= wordLength; i++) {
        	if (userWord.charAt(i).isAlphabetic()) {
        		System.out.println("Yes");
        	}
        	else {
        		System.out.println("No");
        	}
        }
        return;
    }
}
