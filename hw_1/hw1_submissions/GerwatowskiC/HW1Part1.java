
/**
 * Homework 1 Part 1
 *
 * Claire Gerwatowski
 * 9/26/17
 */
import java.util.Scanner;
public class HW1Part1
{
    public static void main (String[] args)
    {
        String word = "";
        Scanner scnr = new Scanner(System.in);
        word = scnr.nextLine();
        word = word.trim();
        System.out.println(word);
        
        boolean letters = true;
        
        for (int i=0; i<word.length(); i++){
            if(Character.isLetter(word.charAt(i))){
                letters = true;
            }
            else {
                letters = false;
                System.out.println("Enter only letters");
                break;
            }
            }
        
        int vowelCount = 0;
        if (letters){
            for (int i=0; i<word.length(); i++){
                if ((word.charAt(i) == 'a') ||
                    (word.charAt(i) == 'e') ||
                    (word.charAt(i) == 'i') ||
                    (word.charAt(i) == 'o') ||
                    (word.charAt(i) == 'u') ||
                    (word.charAt(i) == 'y')){
                    if ((i!=word.length()-1) && 
                        ((word.charAt(i+1) == 'a') ||
                        (word.charAt(i+1) == 'e') ||
                        (word.charAt(i+1) == 'i') ||
                        (word.charAt(i+1) == 'o') ||
                        (word.charAt(i+1) == 'u') ||
                        (word.charAt(i+1) == 'y')))
                        vowelCount += 0;
                    
                    else{
                        vowelCount += 1;               
                    }
                }
                else{
                    vowelCount += 0;
                
                }
            }
            if (word.charAt(word.length()-1) == 'e'){
                if ((word.charAt(word.length()-2) == 'a') ||
                    (word.charAt(word.length()-2) == 'e') ||
                    (word.charAt(word.length()-2) == 'i') ||
                    (word.charAt(word.length()-2) == 'o') ||
                    (word.charAt(word.length()-2) == 'u') ||
                    (word.charAt(word.length()-2) == 'y')){
                    vowelCount-= 0;
                }
                else {
                    vowelCount-= 1;
                }
            }
        }
        System.out.println(vowelCount);
        if (vowelCount == 0)
            vowelCount+=1;
        if (vowelCount>1)
            System.out.println("There are " + vowelCount + " syllables in " + word);
        else {
            System.out.println("There is " + vowelCount + " syllable in " + word);
        }
    }
    }