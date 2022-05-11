
/**
 * This program uses logic to determine the number of syllables in a given word.
 * The input string's syllables are broken down by the following heuristic (excerpt from HW1 Specification pdf: count up the number of vowels in the word (including 'y'), except for
 * Vowels that have vowels directly before them, and
 * The letter e, if it appears by itself at the end of a word (i.e it is not next to another vowel).)
 
 * @author John Haley
 */
import java.util.Scanner;

public class HW1Part1
{
    
    public static void main(String[] args)
    {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter a word: ");
        String word = scnr.next();
        char ch;
        
        int wordLength = word.length();
        int syllCntr = 0;
        
        //System.out.print(wordLength + " " + vowelCntr);
        
        boolean isA;
        boolean isE;
        boolean isI;
        boolean isO;
        boolean isU;
        boolean isY;
        boolean isVowel;
        
       
        
        for (int i=0; i<wordLength; i++){
            ch = word.charAt(i);
            
            isA = (ch == 65 || ch == 97);
            isE = (ch == 69 || ch == 101);
            isI = (ch == 73 || ch == 105);
            isO = (ch == 79 || ch == 111);
            isU = (ch == 85 || ch == 117);
            isY = (ch == 89 || ch == 121);
            
            if(isA || isE || isI || isO ||isU|| isY){
                syllCntr++;
            }
            else if(i == wordLength && isE){
                syllCntr++;
            }
        }
        
            
       System.out.println("Syllable counter: " + syllCntr);
            
    }
}

         //while(!isVowel){

        
            
          
            