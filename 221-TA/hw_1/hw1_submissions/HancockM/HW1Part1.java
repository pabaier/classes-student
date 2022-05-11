
/**
 * Write a description of class HW1Part1 here.
 *
 * Matt Hancock
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class HW1Part1
{
    public static boolean isAVowel(char ch){
      if(ch == 'a' || ch == 'e' ||ch == 'i' || ch == 'o' || ch == 'u' || ch == 'y' || ch == 'A' || ch == 'E' ||ch == 'I' || ch == 'O' || ch == 'U' || ch == 'Y'){
          return true;
        }else{
            return false;
    }
}
    public static void main(String[] args) {

    int vowelCount = 0;
    int i = 0;
    String plurality = "";
    Scanner scnr = new Scanner(System.in);
    System.out.println("Enter a single word: ");
    String userWord = scnr.nextLine();
    for(i = 0; i < userWord.length() -1 ; ++i){
        if(isAVowel(userWord.charAt(i))){
            if(i>0){
                if(isAVowel(userWord.charAt(i-1))== false){
                    vowelCount +=1;
                }
            }else{
                vowelCount += 1;
            }
        }
    }
    
    if(isAVowel(userWord.charAt(i)) && userWord.charAt(i) != 'e'){
        if(isAVowel(userWord.charAt(i-1))== false){
            vowelCount +=1;
        }
    }

    if(vowelCount > 1 || vowelCount ==0){
        plurality = "syllables";
    }else{
        plurality = "syllable";
    }
        
    System.out.println(userWord + ": " + vowelCount + " " + plurality);
}
}
