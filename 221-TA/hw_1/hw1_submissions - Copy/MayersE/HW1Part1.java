import java.util.Scanner;
/**
 * CSCI 221
 * 
 * Program is designed to estimate the number of syllables a word contains.
 *
 * Ethan Mayers
 * September 29, 2017
 */
public class HW1Part1 {
    public static void main (String [] args) {
        Scanner scnr = new Scanner(System.in);
        String word = "";
        String finalWord = "";
        char a = 'a';
        char e = 'e';
        char i = 'i';
        char o = 'o';
        char u = 'u';
        char y = 'y';
        int syllables = 0;
        int letter = 0;
        
        System.out.println("Provide a single word with no spaces. Use letters only.");
        word = scnr.nextLine();
        finalWord = word.trim();
        
        for (letter = 0; letter < finalWord.length(); letter++){
            if ((finalWord = 'a') || (finalWord = 'e') || (finalWord = 'i') ||
            (finalWord = 'o') || (finalWord = 'u') || (finalWord = 'y')){               
                syllables++;
            }
        }
        System.out.println("Word contains " + syllables + " syllables.");
        }
        
        
    }