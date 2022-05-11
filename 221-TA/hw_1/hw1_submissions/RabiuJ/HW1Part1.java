
/**
 * Syllable Counting
 * 
 * Jonathan Rabiu
 * 
 */

 import java.util.Scanner;
 public class HW1Part1{
     public static void main (String [] args) {
        Scanner scnr = new Scanner(System.in);
        String word = "";
        int vowels = 0;
        
        System.out.println("Enter a word to count its syllables");
        word = scnr.nextLine();
        word.trim();
        for (int i=0; i < word.length(); ++i){
            if(word.charAt(i)== 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u' || word.charAt(i) == 'y'){
                if(word.indexOf(word.charAt(i)) > 0 && word.charAt(i-1) != 'a' && word.charAt(i-1) != 'e' && word.charAt(i-1) != 'i' 
                && word.charAt(i-1) != 'o' && word.charAt(i-1) != 'u' && word.charAt(i-1) != 'y'){               
                    vowels = vowels +1;  
                    
               }
            }
        }
        System.out.println(word + ": " + vowels + " syllables");

    }
}
