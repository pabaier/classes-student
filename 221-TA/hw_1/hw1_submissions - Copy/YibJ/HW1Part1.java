
/**
 * Finding syllables.
 *
 * Julie Yib 
 * 09/26
 */
import java.util.Scanner;
public class HW1Part1 {
    public static void main(String[] args) {
        
     
        Scanner search = new Scanner(System.in);
        String usrWord = "";
        char ch;
   
        System.out.println("Enter a word: ");
        usrWord = search.next();
        int len = usrWord.length();
        usrWord = usrWord.trim();
        usrWord = usrWord.toLowerCase();
        int countS = 0;
        
        for (int i = 0; i < len; i++){ 
                ch = usrWord.charAt(i);
                if (!Character.isLetter(ch) &&  isAVowel(usrWord.charAt(i))){
                    countS++;
                    if(i < len-1){
                        if(isAVowel(usrWord.charAt(i+1)) && isAVowel(usrWord.charAt(i))){
                            countS--;
                        }
                    }
                }
                else {
                    System.out.println("Enter a word that does not have any characters.");
                }
                if (usrWord.charAt(len-1) == 'e') {
                    countS-=1;
                }
            
        }

        System.out.println(usrWord + ": " + countS + " syllables");
    }
        
        
    

    public static boolean isAVowel(char ch) {
        
        char [] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};
        
        for (int i = 0; i < vowels.length; i++){
            if (ch == vowels[i]){
                 return true;
            }
            
        }
        return false;
    }


}

    

