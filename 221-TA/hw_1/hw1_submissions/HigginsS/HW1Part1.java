
/**
 * Code for Homework 1 Part 1
 *
 * @author (Steven Higgins)
 * 
 */
import java.util.Scanner;

public class HW1Part1
{
    public static void main(String[] args)
    {   
        int i = 0;
        int numVowels = 0;
        String inputWord = " ";
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a single Word to count the Syllables");
        inputWord = input.next();
        inputWord = inputWord.trim();
        inputWord = inputWord.toLowerCase();
        for(i = 0; i < inputWord.length() - 1 ; i++) {
            if(isAVowel(inputWord.charAt(i))) {
                if(!(isAVowel(inputWord.charAt(i + 1)))) {
                    numVowels = numVowels + 1;
                }
            }
        }   
        if(isAVowel(inputWord.charAt(inputWord.length() - 1)) && inputWord.charAt(inputWord.length() - 1) != 'e'){
            numVowels = numVowels + 1;
        }
        if(numVowels == 0){
            numVowels = 1;
        }
        System.out.println("The Number of Syllables is: " + numVowels);
   
    }

    public static boolean isAVowel(char ch) {
        final int NUM_VOWS = 6;
        int i = 0;
        char vowels[] = {'a', 'e', 'i', 'o', 'u', 'y'};
        for(i = 0; i < NUM_VOWS; i++) {
            if(vowels[i] == ch){
                return true;
            }
        }
        return false;
    }
}
    