// package HW1Part1;


/**
 * Counts Syllables in a word.
 * @author (Ryan Barrett)
 */
import java.util.*;
public class HW1Part1
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = scan.next();
        
        int syllables = 0;
        boolean syllableBefore = false;
        word = word.toLowerCase();
        for(int i = 0; i < word.length(); i++)
        {
            char letter = word.charAt(i);
            
            if(letter == 'e' && i == word.length() - 1)
                ;
            else if((letter == 'a' || letter == 'i' || letter == 'o'
                || letter == 'e' || letter == 'u' || letter == 'y') 
                && !syllableBefore)
            {
                syllables++;
                syllableBefore = true;
            }
            else
                syllableBefore = false;
        }
        
        if(syllables == 0 && word.length() > 0)
            syllables = 1;
        
        System.out.print("The number of syllables in the word is " + syllables);
            
        return;
    }
}
