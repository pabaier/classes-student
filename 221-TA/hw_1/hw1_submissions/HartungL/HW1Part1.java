
/**
 * This class will be counting syllables to the best of its ablilities
 *
 * Lexus Hartung
 * 9-26-17
 */
import java.util.Scanner;

public class HW1Part1 {
    public static void main (String [] args) {
        int syllableCount = 0;
        int i = 0;
        String userIn = " ";
        Scanner scnr = new Scanner(System.in);
        
        System.out.println("Give me a word so that I can guess the number of syllables ");
        userIn = scnr.next();
        userIn = userIn.trim();
        userIn = userIn.toLowerCase();
        
        for (i = 0; i < userIn.length(); ++i){
            if(i == 0){
                if (isAVowel(userIn.charAt(i))){
                    syllableCount += 1;
                }
            }
            else if (i == userIn.length() - 1){
                if (endingE(userIn.charAt(userIn.length() - 1))){
                    syllableCount += 1;
                }
            }
            else if (isAVowel(userIn.charAt(i)) && isDoubleVowel(userIn.substring(i - 1,i + 1))){
                syllableCount += 1;
            }
        }
        if (syllableCount == 0) {
            syllableCount = 1;
        }
        System.out.println("The syllable count is " + syllableCount);
    }
    public static boolean isAVowel(char ch){
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' ||ch == 'u' || ch == 'y'){
            return true;
        }
        else {
            return false;
        }
    }
    public static boolean isDoubleVowel (String check) {
        if(check.charAt(0) == 'a' || check.charAt(0) == 'e' ||check.charAt(0) == 'i' ||
        check.charAt(0) == 'o' ||check.charAt(0) == 'u' ||check.charAt(0) == 'y'){
            return false;
        }
        else{
            return true;
        }
    }
    public static boolean endingE (char e){
        if(e == 'e'){
            return false;
        }
        else{
            return true;
        }
    }
}
