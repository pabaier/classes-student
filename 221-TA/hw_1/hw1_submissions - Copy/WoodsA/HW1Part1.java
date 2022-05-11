
/**
 * This program approximates the number of sylables in a word.
 * Ashley Woods
 * 9-29-17(edited)
 */
import java.util.Scanner;
public class HW1Part1
{
    public static void main(String[]args){
        Scanner scnr = new Scanner(System.in);
        System.out.print("Please enter one word: ");
        String word = scnr.next();
        int lenWord = word.length();
        System.out.println("");
        int i = 0;
        int vowelCount = 0;
        boolean goodInput = true;
        for (i=0; i<(lenWord); ++i){
           if (Character.isLetter(word.charAt(i)) == false) {
               System.out.print("There was an error with your word.");
               goodInput = false;
               break;
            }
        }
        if(word.charAt(0) == 'A') {
            word = 'a' + word.substring(1);
        }
        if(word.charAt(0) == 'E') {
            word = 'e' + word.substring(1);
        }
        if(word.charAt(0) == 'I') {
            word = 'i' + word.substring(1);
        }
        if(word.charAt(0) == 'O') {
            word = 'o' + word.substring(1);
        }
        if(word.charAt(0) == 'U') {
            word = 'u' + word.substring(1);
        }
        if(word.charAt(0) == 'Y') {
            word = 'y' + word.substring(1);
        }
        if (goodInput = true){
        if (word.charAt(0) == 'a' || word.charAt(0) == 'e' || word.charAt(0) == 'i' || word.charAt(0) == 'o' || word.charAt(0) == 'u' || word.charAt(0) == 'y') {
            ++vowelCount;
        }
        for (i=1; i<(lenWord); ++i) {
            char character = word.charAt(i);
            if (character == 'a') {
                ++vowelCount;
                if (word.charAt(i-1)=='a' || word.charAt(i-1)=='e' || word.charAt(i-1)=='i' || word.charAt(i-1)=='o' || word.charAt(i-1)=='u' || word.charAt(i-1)=='y') {
                    --vowelCount;
                }
            }
            else if (character == 'e'){
                ++vowelCount;
                if (word.charAt(i-1)=='a' || word.charAt(i-1)=='e' || word.charAt(i-1)=='i' || word.charAt(i-1)=='o' || word.charAt(i-1)=='u' || word.charAt(i-1)=='y') {
                    --vowelCount;
                }
            }
            else if (character == 'i'){
                ++vowelCount;
                if (word.charAt(i-1)=='a' || word.charAt(i-1)=='e' || word.charAt(i-1)=='i' || word.charAt(i-1)=='o' || word.charAt(i-1)=='u' || word.charAt(i-1)=='y') {
                    --vowelCount;
                }
            }
            else if (character == 'o'){
                ++vowelCount;
                if (word.charAt(i-1)=='a' || word.charAt(i-1)=='e' || word.charAt(i-1)=='i' || word.charAt(i-1)=='o' || word.charAt(i-1)=='u' || word.charAt(i-1)=='y') {
                    --vowelCount;
                }
            }
            else if (character == 'u'){
                ++vowelCount;
                if (word.charAt(i-1)=='a' || word.charAt(i-1)=='e' || word.charAt(i-1)=='i' || word.charAt(i-1)=='o' || word.charAt(i-1)=='u' || word.charAt(i-1)=='y') {
                    --vowelCount;
                }
            }
            else if (character == 'y'){
                ++vowelCount;
                if (word.charAt(i-1)=='a' || word.charAt(i-1)=='e' || word.charAt(i-1)=='i' || word.charAt(i-1)=='o' || word.charAt(i-1)=='u' || word.charAt(i-1)=='y') {
                    --vowelCount;
                }
            }
        }
        if (vowelCount <= 0 && (goodInput == true)) {
            vowelCount = 1;
        }
        if (vowelCount == 1 && (goodInput == true)) {
            System.out.println("1 syllable");
        }
        else {
            System.out.println(vowelCount + " syllables");
        }
    }
}
}
