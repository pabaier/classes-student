
/**
 * This program returns the number of syllables of a word input by the user.
 * Connor Matthews
 * September 29, 2017
 */

import java.util.Scanner;
public class HW1Part1 {
    public static boolean isAVowel(char ch){
           if(ch =='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='y'){
                return true;
            }
            return false;
        }
    public static void main (String [ ] args) {
        Scanner scnr = new Scanner(System.in);
        String userWord = "";
        int syllables = 0;
        int i = 0;
        System.out.println("Enter a single word: ");
        userWord = scnr.next();
        userWord = userWord.toLowerCase();
        int length = userWord.length();
        System.out.println(userWord);
        char letter;
        for(i = 0; i < length; i++){
            letter= userWord.charAt(i);
            if(isAVowel(letter)){
                syllables++;
                if(i < length - 1){
                    if(isAVowel(userWord.charAt(i + 1)) && isAVowel(letter)){
                        syllables--;

                    }
                }    
            }
        }
        if(userWord.charAt(length - 1) == 'e'){
                    syllables--;
                }
        if(syllables == 0){
            syllables++;
        }
        for(i= 0; i < length; i++){
            if(Character.isLetter(userWord.charAt(i)) == false){
                System.out.println("Error: Input contains character that is not letter");
                break;
            }
        }  
        System.out.println("Number of syllables: " + syllables);
    }
}
