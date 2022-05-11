import java.util.Scanner;
/**
 * This is a program to count the number of syllables in a user inputed word
 *
 * @author Richard Marshall
 * 
 */
public class HW1Part1
{
    
    public static boolean isAVowel( char ch ) {
     boolean isVowel = false;
     
     if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'y') {
            isVowel = true;
        }
    return isVowel;
    }
    
    public static void main (String[] args){
        Scanner scnr = new Scanner(System.in);
        String userWord = "";
        boolean isValidWord;
        boolean isVowel;
        int syllables = 0;
        
        while (true){
        System.out.println("Please enter a word:");
        userWord = userWord.replaceAll(userWord, scnr.next());
        userWord = userWord.trim();
        userWord = userWord.toLowerCase();
        isValidWord = userWord.chars().allMatch(Character::isLetter);
        
        if (isValidWord){
            break;
        }
        System.out.println("Invalid input."); 
        System.out.println("Please enter a word with only letters.");
       }
        
        for (int index = 0; index < userWord.length(); index ++) {
            isVowel = isAVowel(userWord.charAt(index));
            
            if (isVowel) {
                
                if (index != 0 && isAVowel(userWord.charAt(index-1))) {
                    //Doesn't count this
                }
                else if ((index == (userWord.length() - 1) && userWord.charAt(index) == 'e')){
                    //Doesn't add this to the counter
                }
                else {
                syllables++;
                }
            }
        }
        
        if (syllables == 0) {
            syllables++;
        }
        
        System.out.println(userWord + " has " + syllables + " syllable(s).");
    }
}
