
/**
 *
 * @author Corey Taylor
 * @version 9/27/2017
 */
import java.util.Scanner;
public class HW1Part1
{
    
    public static void SyllableCounter(){
        Scanner scnr = new Scanner(System.in);
        String word = " ";
        char c = ' ';
        int syllableCount = 0;
        System.out.println("Please enter a word.");
        word = scnr.nextLine();
        String regex = "[a-zA-Z]*";
        if(word.matches(regex)){
            for (int i = 0; i < (word.length() - 1); i++){
                
                c = word.charAt(i);
                char cNew = word.charAt(i + 1);
                if (isVowel(c) && !isVowel(cNew)){
                    syllableCount = (syllableCount + 1);
                }
            
            }
            if (word.charAt(word.length() - 1) == 'e' || word.charAt(word.length() - 1) == 'E' && isVowel(word.charAt(word.length() - 2))){
                syllableCount = (syllableCount + 1);
            }
            if (word.charAt(word.length() - 1) == 'e' || word.charAt(word.length() - 1) == 'E' && !isVowel(word.charAt(word.length() - 2))){
                syllableCount = (syllableCount - 1);
            }
            if (syllableCount <= 1){
                System.out.println("Your word, " + word + ", has 1 syllable.");
            }else{
                System.out.println("Your word, " + word + ", has " + syllableCount + " syllables.");
            }
            
        }else{
            System.out.println("The word you have entered is not valid.");
            System.out.println("Please enter a word comprised only of letters.");
        }
        scnr.close();
        }  
        
      public static boolean isVowel(char ch){
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'y' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' || ch == 'Y'){
            return true;
        }else{
            return false;
        }
        
        }
        public static void main(String[] args){
          SyllableCounter();  
        }
    }

        
        
        
        
    

