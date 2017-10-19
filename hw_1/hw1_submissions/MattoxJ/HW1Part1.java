import java.util.Scanner;
/**
 * Approximating syllables
 *
 * Jacob Mattox
 * 09/26/17
 */
public class HW1Part1
{
    
    public static boolean isAVowel( char ch ) //used to check for vowels
    {
        if(ch == 'a' || ch =='e' || ch =='i' || ch =='o' || ch =='u' || ch =='y' || ch =='A' || 
           ch =='E' || ch =='I' || ch =='O' || ch =='U' || ch =='Y')
            return true;
        else
            return false;
       
        
    }
    
    
    public static void main(String[] args)
    {
        Scanner scnr = new Scanner(System.in); //initializing needed scanner and variables
        String word = "";
        int counter = 0;
        boolean wordCheck = true;
        
        System.out.println("This program counts the number of syllables in entered word\n");
        
        while(wordCheck){ //makes sure word is a valid input
            System.out.print("Please enter a word (only letters): ");
            word = scnr.next();
            for(int i = 0; i < word.length(); i++){
                if(Character.isLetter(word.charAt(i)))
                    wordCheck = false;
                    
                else{
                    wordCheck = true;
                    System.out.println("Non-letter characters detected \n");
                    break;
                }
                }
            }
            
        for(int i = 0; i < word.length(); i++) //iterates through word and detects vowels
        {
            if(isAVowel(word.charAt(i))) //if a vowel is found, decides on how much to increment counter
            {
                if(i > 0 && isAVowel(word.charAt(i - 1)))
                {
                    counter = counter;
                }
                else
                {
                    ++counter;
                }
                 
                if(i == (word.length() - 1) && (word.charAt(i) == 'e' || word.charAt(i) == 'E'))
                { //catches the words that end in e or E
                    if(isAVowel(word.charAt(word.length()-2)))
                    {
                    counter = counter;
                }
                
                    else
                    {
                    --counter;
                }
                
                }
                
                if(counter == 0) //catch-all for no syllables counted
                {
                    ++counter;
                }

            }
        }
        System.out.print(counter + " syllables"); //prints out number of syllables
      
    }
    
}
