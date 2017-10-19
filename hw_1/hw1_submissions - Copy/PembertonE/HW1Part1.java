
/**
 * Write a description of class HW1Part1 here.
 *
 * Elizabeth Pemberton
 * Due Friday September 29 2017
 */
import java.util.Scanner;

public class HW1Part1{
    public static void main (String [] args) {
      Scanner scnr = new Scanner(System.in);
      String userWord = " ";
      int charNum = 0;
      int vowNum = 0;
      int i = 0;

      //char[] wordArray = userWord.toCharArray();
      
      
      //Ask the User for a Word
      System.out.println("Please enter one word ");
      userWord = scnr.next();
      userWord = userWord.trim();
      charNum = userWord.length();
      
      String[] wordArray = userWord.split("");

      
      System.out.println("Word chosen is -- " + userWord);
      System.out.println("Length of Word is  -- " + charNum);
      System.out.println("The first word is " + wordArray[0]);
      
      for (i= 0; i < charNum; ++i) {
          if (isaVowel(wordArray[i]) == true){
              vowNum += 1; 
              System.out.println("There are "+ vowNum + "vowels in the word.");
            }
        }
        
      if (vowNum < 1){
         System.out.println("There are " + vowNum + " syllables in the word " + userWord);
        }
    
    
}
    
    public static boolean isaVowel (char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||ch == 'y' ||
        ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' || ch == 'Y'){
            System.out.println("Character " + ch + " is a vowel");
            return true;
        }
        else if ((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z')){
            System.out.println("Character " + ch + "is a constant");
            return false;
        }
            else{
                System.out.println( ch + " is not in the alphabet");
                return false;
        }  
        }
}

