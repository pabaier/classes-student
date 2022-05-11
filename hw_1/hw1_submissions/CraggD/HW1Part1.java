
/**
 * Write a description of class HW1Part1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */


import java.util.Scanner;


public class HW1Part1
{
    public static void main (String [] args)
    {
        Scanner scnr = new Scanner(System.in);
        
       
        String userInput = "";
        System.out.print("Please enter a word: ");
        userInput = scnr.nextLine();
        userInput = userInput.trim();
        
        for(int iter = 0; iter < userInput.length(); ++iter)
        {
            if(userInput.charAt(iter) == ' ' )
            {
                userInput = userInput.substring(0,iter);
            }
        }
        for(int i = 0; i < userInput.length(); ++i)
        {
            if(userInput.charAt(i) < 65 || userInput.charAt(i) > 122)
            {
                System.out.println("ERROR: not a word");
                return;
            }
            else if(userInput.charAt(i) > 90 && userInput.charAt(i) < 97 )
            {
                System.out.println("ERROR: not a word");
                return;
            }
        }
        
        int vowelCount = 0;
        int vowInRow = 0;
        
        for(int lter = 0; lter <  userInput.length(); ++lter)
        {
            switch( userInput.charAt(lter))
            {
                case 'a':
                case 'A':
                    vowelCount = vowelCount + 1;
                    vowInRow = vowInRow + 1;
                    break;
                case 'e':
                case 'E':
                    vowelCount = vowelCount + 1;
                    vowInRow = vowInRow + 1;
                    if( lter == (userInput.length() - 1) && vowelCount != 2 )
                    {
                     vowelCount = vowelCount - 1;   
                    }
                    break;
                case 'i':
                case 'I':
                    vowelCount = vowelCount + 1;
                    vowInRow = vowInRow + 1;
                    break;
                case 'o':
                case 'O':
                    vowelCount = vowelCount + 1;
                    vowInRow = vowInRow + 1;
                    break;
                case 'u':
                case 'U':
                    vowelCount = vowelCount + 1;
                    vowInRow = vowInRow + 1;
                    break;
                case 'y':
                case 'Y':
                    vowelCount = vowelCount + 1;
                    vowInRow = vowInRow + 1;
                default:
                    vowInRow = 0; 
                    break;
            }
            if ( vowInRow > 1 )
            {
                vowelCount = vowelCount - 1;
                vowInRow = 0;
            }
       
        }
        if( vowelCount == 0 )
        {
            vowelCount = vowelCount + 1;
        }
        System.out.println( userInput + ": " + vowelCount  );
        
       
        return;
    }
}
