// Shaina Mae Mainar
// HW1 Part 1
// I certify that this is my own work pledged 9/26/2017
import java.util.Scanner;
public class HW1Part1 {
    //Run everything on main
    public static void main(String args[]){
        Scanner scnr = new Scanner(System.in);
        String word = "";
        int syllables = 0;
        
        System.out.println("Enter a word: ");
        word = scnr.next();
        word = word.trim();
        
        while(isAlpha(word) == false){
            System.out.println("Error");
            System.out.println("Enter a word: ");
            word = scnr.next();
            word = word.trim();
            if(isAlpha(word) == true){
                break;
            }
        }
        //System.out.println(word);
        if(countSyllables(word) == 0){
            syllables = 1;
        }
        else{
            syllables = countSyllables(word);
        }
        System.out.println("There are " + syllables + " syllables in " + "\"" + word + "\"");

        
    }
    public static boolean isVowel(char c) {
        // This method will test to see if the chars in the string are vowels
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y') {
            return true;
        } else {
            return false;
        }
    }
    
    public static int countSyllables(String word) {
        //This method counts how syllables using the given parameters
        int count = 0;
        word = word.toLowerCase();
        boolean isPrevVowel = false;
        for (int j = 0; j < word.length(); j++) {
            if (word.contains("a") || word.contains("e") || word.contains("i") || word.contains("o") || word.contains("u") || word.contains("y")) {
                if (isVowel(word.charAt(j)) && !((word.charAt(j) == 'e') && (j == word.length()-1))) {
                    if (isPrevVowel == false) {
                        count++;
                        isPrevVowel = true;
                    }
                } else {
                    isPrevVowel = false;
                    
                }
            } else {
                count++;
                break;
            }
        }
        return count;
}

   public static boolean isAlpha(String word) {
       // This method tests if the string chars are letters
       char[] chars = word.toCharArray();
    //System.out.println(chars);

        for (char c : chars) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }
    
        return true;
    }
}
