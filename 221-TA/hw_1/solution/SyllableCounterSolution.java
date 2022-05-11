import java.util.Scanner;
/**
 * class SyllableCounter uses a heuristic to estimate
 *   the number of syllables in a word
 *
 * @author (McCauley)
 */
public class SyllableCounterSolution
{
    
    public static void main(String [] args)
    {
       Scanner scnr = new Scanner(System.in);
       System.out.print("Enter a word: ");
       String word = scnr.next( );
       word = word.trim();
       
       // verify that word is all letters
       int i = 0;
       boolean allGood = true;
       int countOfVowels = 0;
       while (i < word.length()){
          if (!Character.isAlphabetic(word.charAt(i))){
              allGood = false;
              break;
          }
          // if a vowel found, count it, unless it is preceded by a vowel
          if (isAVowel(word.charAt(i)) &&
              (i == 0 // this vowel is first letter in word 
              || // not first letter in word, so check what came before it
                 // this vowel not preceded by a vowel
              (i > 0 && !isAVowel(word.charAt(i-1))))){
                 // count the vowel
                 countOfVowels++;
              }
          // if 'e' at end of word and not preceded by a vowel, 
          // don't count it
          if ((word.charAt(i) == 'E' || word.charAt(i) == 'e')&&
               i == word.length() - 1 && !isAVowel(word.charAt(i-1)))
               countOfVowels--;
               
          i++;
        }
        if (!allGood)
           System.out.println("Error on \"" + word + "\" must be all letters.");
        else { // all letters must be at least one syllable
           int syllables = countOfVowels;
           if (syllables == 0) syllables++;
           System.out.println("Found " + syllables + " syllables(s) in \"" + word + "\"");
        
        } 
    }
        
        public static boolean isAVowel(char what) {
            return 
                what == 'A' || what == 'a' ||
                what == 'E' || what == 'e' ||
                what == 'I' || what == 'i' ||
                what == 'O' || what == 'o' ||
                what == 'U' || what == 'u' ||
                what == 'Y' || what == 'y';
        }
       
}
