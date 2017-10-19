
/**
 * This code reads a word from the user then determines the number of syllables based on the number of vowels
 *
 * @author (Riley Moore)
 * @version (a version number or a date)
 */

import java.util.Scanner; 
public class HW1Part1
{


    
    public static void main(String[] args)
    {
        Scanner scnr = new Scanner(System.in);
        int j = 0;
        String userWord = " ";
        int numOfVowels = 0;
        int wordLength = 0;         
        System.out.println("Enter a single word to determine the amount of syllables are in your word");
        userWord = scnr.nextLine();
        userWord = userWord.toLowerCase();
        wordLength = userWord.length();
        for(j=0;j<wordLength-1; j++){
            if(isAVowel(userWord.charAt(j)) && !isAVowel(userWord.charAt(j+1))){
                numOfVowels = numOfVowels + 1;
            }
        }
            if(isAVowel(userWord.charAt(userWord.length()-1)) && ((userWord.charAt(userWord.length()-1) == 'e'))){
                numOfVowels = numOfVowels + 1;
            }
            if(wordLength == 0){
                numOfVowels = 0;
            }
        
        System.out.println("The word "+ userWord +" has "+ numOfVowels +" syllables.");
    }


    
   public static boolean isAVowel(char ch){
    final int NUM_VALS = 6;
    int i = 0;
    char vowel[] = {'a','e','i','o','u','y'};
        for(i=0; i<NUM_VALS; i++){
            if(vowel[i]==ch){
                return true;
            }
        }
    return false;
    } 
}
