import java.util.Scanner;

/**
 * by: Michael Dudley
 * Description: Checks to see how many syllables are in a word.
 */
public class HW1Part1
{
    public static boolean isAVowel(char ch){
        if(ch == 'A' || ch == 'a' || ch == 'E' || ch == 'e' || ch == 'I' || ch == 'i' 
            || ch == 'O' || ch == 'o' || ch == 'U' || ch == 'u' || ch == 'Y' || ch =='y'){
            return true;
        }
         return false;
        }
        
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a word!");
        String userWord = scan.next();
        int vowel = 0;
        for(int i = 0; i < userWord.length();i++){
            if(!Character.isLetter(userWord.charAt(i))){
                System.out.println("Error not a word");
                return;
            }
            if(i == 0){
                if(isAVowel(userWord.charAt(i))){
                    vowel++;
                }
            }else if(userWord.length() - 1 == i){
                if(userWord.charAt(userWord.length()-1) != 'e' && userWord.charAt(userWord.length()-1) != 'E'
                && isAVowel(userWord.charAt(i))){
                vowel++;
                }
                    
            }
            else if(isAVowel(userWord.charAt(i)) && !isAVowel(userWord.charAt(i-1))){
                vowel++;
            }
               
        }
        if(vowel <= 0){
            vowel = 1;
        }
        System.out.println(userWord + ": " + vowel + " Syllables");
    }
        
}
