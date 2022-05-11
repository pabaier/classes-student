/*Sydney Jackson
CSCI 221 - MWF 10:30 AM - 11:20 AM - McCauley
HWPart1: Counting Syllables: Creating a method that determines if a letter in a word is a vowel,
then creating a program that inputs a word from the user, determines the number of syllables based
on specific conditions, then outputs the word and the number of syllables it has back to the user.*/

//import scanner method
import java.util.Scanner;
public class HW1Part1{
    //creating the method isVowel to determine if a char, or a letterm, is a vowel
    public static boolean isVowel  (char ch){
    //loop to decide if a letter is a vowel, returns true if it is, returns false if it is not
    if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'y'){
        return true;
    }
    else{
        return false;
    }
}
    public static void main(String[] args){
        //initialize counter for the loop to count the syllables
        int vowelCount = 0;
        //create new scanner to get word from user to count syllables
        Scanner scnr = new Scanner(System.in);
        //loop that gets new word from user 10 times
        for (int j = 0; j < 10; ++j){
            //reset the vowelCount after each word
            vowelCount = 0;
            //prompt user to type in a word
            System.out.println("Type a word: ");
            //set variable to the next string typed in by user
            String word = scnr.nextLine();
            //set word to all lower case letters so it is easier to find the vowels
            word = word.toLowerCase();
            //declare variable to use as stopping condition for the loop that searches for vowels
            int len = word.length();
            //loop that finds runs searches through the word from 0 to the word's length
            for (int i = 0; i < len; ++i){
                //if there is an 'e' at the end of the word, 1 is subtracted from vowelCount
                if (i == (len - 1) && word.charAt(i) == 'e'){ 
                    vowelCount--;
                }
                //if there is a vowel right after another vowel, 1 is subtracted from vowelCount
                if  ((i < len - 2) && (isVowel(word.charAt(i))) && (isVowel(word.charAt(i+1)))){
                    vowelCount--;
                }
                //if the letter at 'i' is a vowel, 1 is added to the vowelCount
                if (isVowel(word.charAt(i))){
                    vowelCount++;
                }
            
                
                
            }
            //to ensure that no word can have 0 syllables, if 0 syllables are counted after the
            //previous loops, 1 is added because no word has 0 syllables
            if (vowelCount == 0){
                vowelCount++;
            }
            //output the number of syllables the word has to the user
            System.out.println(word + " has " + vowelCount + " syllable(s).");
        }
        }
    
    }

        
    
    