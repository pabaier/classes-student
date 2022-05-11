
/**
 * Counts the number of syllables in a word.
 *
 * Orianna Gandy-Wells
 * Sept. 23, 2017
 */
import java.util.Scanner;

public class HW1Part1 {
    public static boolean isALetter(char ch){
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){
            return true;
            }
        else{
            return false;
        }
        }
    
    public static boolean isAVowel( char ch ){
     
            if((ch == 'a') || 
                (ch == 'e')  ||
                (ch == 'i') || 
                (ch == 'o') ||
                (ch == 'u') ||
                (ch == 'y')||
                (ch == 'A') || 
                (ch == 'E')  ||
                (ch == 'I') || 
                (ch == 'O') ||
                (ch == 'U')||
                (ch == 'Y')){
                return true;
            }
              else{
                 return false;
                }
            }
        
            
    public static void main(String [] args){
        String word = "";
        int vowels = 0;
        int syllables = 0;
        int end = 0;
        Scanner scnr = new Scanner(System.in);
 
        System.out.println("Enter a word: ");
        word = scnr.next();
        end = word.length() - 1;
        
        for( int i = 0; i < word.length(); i++){
            if(isALetter(word.charAt(i)) == true){
            isAVowel(word.charAt(i));
            }
            else{
                System.out.println("Invalid entry");
                break;
            }
            if (isAVowel(word.charAt(i)) == true && ((i <= 0) || (isAVowel(word.charAt(i-1)) != true))){
                vowels++;
                syllables++;
                
            }  
        if(word.charAt(end) == 'e'){
                    syllables--;     
        }
        if(syllables < 1){
            syllables++;
        }
        if(word.length() > 9 && vowels < 3){
            syllables++;
        }
      }
    
        System.out.println("Syllable(s) in your word: " + syllables);
    }
}




