/* Asa Perryman
 * CSCI 221
 * Purpose: To determinte the number of syllables in a user input word
 *          by the use of a heuristic.
 */

import java.util.Scanner;

public class HW1Part1 {
    public static void main (String [] args) {

        //Initialize variables
        int i = 0;
        int j = 0;
        int vowelCount = 0;

        //Create scanner and user prompt
        System.out.print("Enter any word: ");
        Scanner scnr = new Scanner(System.in);
        String userWord = scnr.next();

        //Loop for iterating through the given word
        for(i=0; i < userWord.length(); i++){

            //Conditional for checking for numbers in userWord
            if(!Character.isLetter(userWord.charAt(i))){

                //Error message printed if numbers occur and 
                //rescans for a new word
                System.out.println("Invalid input. Try again.");
                userWord = scnr.next();
                i = 0;

            }  
        }

        //Removes whitespaces from before and after the string
        userWord = userWord.trim();
        userWord = userWord.toLowerCase();

        //Loop to increase vowel count
        for(i = 0; i < userWord.length(); i++){

            //Condition to check letter for vowel 
            if(userWord.charAt(i) == 'a' || userWord.charAt(i) == 'e' || 
            userWord.charAt(i) == 'i' || userWord.charAt(i) == 'o'|| 
            userWord.charAt(i) == 'u' || userWord.charAt(i) == 'y'){

                vowelCount += 1;
                //System.out.println(userWord.charAt(i));
                //System.out.println(i);

                //Condition to check for vowels following vowels
                if(i > 0){
                    if(userWord.charAt(i-1) == 'a' || userWord.charAt(i-1) == 'e'
                    || userWord.charAt(i-1) == 'i' || userWord.charAt(i-1) == 'o'|| 
                    userWord.charAt(i-1) == 'u' || userWord.charAt(i-1) == 'y'){
                        vowelCount -= 1;
                        //System.out.println(userWord.charAt(i));
                    }

                    else if (i == userWord.length()-1){
                        if(userWord.charAt(i)== 'e'){
                            vowelCount -= 1;
                            // System.out.println(userWord.charAt(i));
                        }
                    }
                }
            }
        } 

        //Prevents syllables from being 0
        if(vowelCount == 0){
            vowelCount = 1;
        }

        //Allows for print statements that correspond with vowel count value
        if(vowelCount == 1){
            System.out.println();
            System.out.println(userWord + " has " + vowelCount + " syllable."); 
        }

        else{
            System.out.println();
            System.out.println(userWord + " has " + vowelCount + " syllables.");
        }
    }

}
