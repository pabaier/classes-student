// Jonathan E. Anderson
// Program to count the syllables in a word given by the user
import java.util.Scanner;
public class HW1Part1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String userWord = "";

        int i = 0; // i is a loop variable
        int j = 0; //j is a secondary loop variable
        int wordLen;
        int vowelCount = 0;

        boolean validWord = true;

        System.out.print("Input word: ");
        userWord = input.next();
        userWord = userWord.toLowerCase();
        wordLen = userWord.length();
        //System.out.println(userWord); // debugging/development tool


        for(i = 0; i< wordLen; i++){
            if(userWord.charAt(i)<= 60 || userWord.charAt(i) >= 123) {
                validWord = false;
            }
        }

        if (!validWord) {
            System.out.print("Invalid word! all words must contain only letters.");
        } else {
            //System.out.print(userWord); // debugging/development tool

            for(i=0; i< wordLen; i++) {
                if (userWord.charAt(i) == 'a' || userWord.charAt(i) == 'e' || userWord.charAt(i) == 'i' || userWord.charAt(i) == 'o' || userWord.charAt(i) == 'u' || userWord.charAt(i) == 'y') {
                    vowelCount += 1;
                    System.out.println(vowelCount + " ");
                }
                if (i != 0) {
                    if ((userWord.charAt(i) == 'a' || userWord.charAt(i) == 'e' || userWord.charAt(i) == 'i' || userWord.charAt(i) == 'o' || userWord.charAt(i) == 'u' || userWord.charAt(i) == 'y') && (userWord.charAt(i - 1) == 'a' || userWord.charAt(i - 1) == 'e' || userWord.charAt(i - 1) == 'i' || userWord.charAt(i - 1) == 'o' || userWord.charAt(i - 1) == 'u' || userWord.charAt(i - 1) == 'y')) {
                        vowelCount -= 1;
                        System.out.println(vowelCount + " ");
                    }
                }
                if ((i == wordLen - 1 && userWord.charAt(i) == 'e') && (userWord.charAt(i - 1) != 'a' || userWord.charAt(i - 1) != 'e' || userWord.charAt(i - 1) != 'i' || userWord.charAt(i - 1) != 'o' || userWord.charAt(i - 1) != 'u' || userWord.charAt(i - 1) != 'y')) {
                    vowelCount -= 1;
                }
            }
            if (vowelCount == 0) {
                    vowelCount = 1;

            }


            System.out.print(userWord + " has " + vowelCount + " syllables.");

            }
    }
}
