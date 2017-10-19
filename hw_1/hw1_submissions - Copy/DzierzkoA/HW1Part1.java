/*
 * Author: Adam Dzierzko
 */
import java.util.Scanner;

public class HW1Part1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userWord;
        System.out.println("This program will count the number of syllables in a given word");
        System.out.println("Please enter single word: " );
        userWord = scanner.next();

        System.out.println("The wold you typed is: " + userWord);
        System.out.println("It contains " + numberOfSyllables(userWord) + " syllable(s)");


    }

    public static boolean isAVowel(char ch){
        if ("aeiouyAEIOUY".indexOf(ch) < 0 ){
            return false;
        }
        else
            return true;
    }

    public static int numberOfSyllables(String s){
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            if(i == 0 && isAVowel(s.charAt(i)))
                count++;
            else if(isAVowel(s.charAt(i)) && !isAVowel(s.charAt(i -1)))
                count++;
        }
        if(s.charAt(s.length() - 1) == 'e' && s.charAt(s.length() -2) != 'e'){          //Manatee
            count --;
        }
        if(count == 0)                                                                  //no word has 0 syllables
            count++;

        return count;
    }
}
