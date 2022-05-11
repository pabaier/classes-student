
/**
 * Write a description of class HW1Part2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;

public class HW1Part2
{
    public static void main (String [] args)
    {
        Scanner scnr = new Scanner(System.in);
        
       
        String userInput = "";
        String userInput2 = "";
        String finalOutput = "";
        
        System.out.println("Please enter the first number: ");
        userInput = scnr.nextLine();
        System.out.println("Please enter the second number: ");
        userInput2 = scnr.nextLine();
        
        userInput = userInput.trim();
        userInput2 = userInput2.trim();
        
        System.out.println( "Input one: " + userInput + " " + "Input two: " + userInput2 );
        
        for( int iter = 0; iter < userInput.length(); ++iter)
        {
            if( userInput.charAt(iter) > 57 || userInput.charAt(iter) < 48 )
            {
                System.out.print("ERROR: Enter a valid number. ");
            }
        }
        for( int iter = 0; iter < userInput2.length(); ++iter)
        {
            if( userInput2.charAt(iter) > 57 || userInput2.charAt(iter) < 48 )
            {
                System.out.print("ERROR: Enter a valid number. ");
            }
        }
        int tempLength = 0;
        if( userInput.length() > userInput2.length())
        {
            tempLength = userInput.length() - 1;
        }
        else
        {
            tempLength = userInput2.length() - 1;
        }
        
        int tempLength1 = userInput.length() - 1;
        int tempLength2 = userInput2.length() - 1;
        for( int iter = tempLength; iter > -1; --iter)
        {
            int temp1 = 0;
            int temp2 = 0;
            int tempResult = 0;
            int overFlow = 0;
            if(tempLength1 > -1)
            {
                switch( userInput.charAt(tempLength1))
                {
                    case '0':
                        temp1 = 0;
                        break;
                    case '1':
                        temp1 = 1;
                        break;
                    case '2':
                        temp1 = 2;
                        break;
                    case '3':
                        temp1 = 3;
                        break;
                    case '4':
                        temp1 = 4;
                        break;
                    case '5':
                        temp1 = 5;
                        break;
                    case '6':
                        temp1 = 6;
                        break;
                    case '7':
                        temp1 = 7;
                        break;
                    case '8':
                        temp1 = 8;
                        break;
                    case '9':
                        temp1 = 9;
                        break;
                    default:
                        temp1 = 0;
                }
            }
            else
            {
                temp1 = 0;
            }
            
            if(tempLength2 > -1)
            {
                switch( userInput2.charAt(tempLength2))
                {
                    case '0':
                        temp2 = 0;
                        break;
                    case '1':
                        temp2 = 1;
                        break;
                    case '2':
                        temp2 = 2;
                        break;
                    case '3':
                        temp2 = 3;
                        break;
                    case '4':
                        temp2 = 4;
                        break;
                    case '5':
                        temp2 = 5;
                        break;
                    case '6':
                        temp2 = 6;
                        break;
                    case '7':
                        temp2 = 7;
                        break;
                    case '8':
                        temp2 = 8;
                        break;
                    case '9':
                        temp2 = 9;
                        break;
                    default:
                        temp2 = 0;
                }
            }
            else 
            {
                temp2 = 0;
            }
            
            
            
            tempResult = temp1 + temp2 + overFlow;
            
            if (tempResult > 9 )
            {
                
                overFlow = 1;
                tempResult = tempResult - 10;
                finalOutput = finalOutput + tempResult;
            }
             else   
            {
                finalOutput = finalOutput + tempResult;
                overFlow = 0;
            }
            
            
            --tempLength1;
            --tempLength2;
        }
        
        finalOutput = new StringBuilder(finalOutput).reverse().toString();
        System.out.println( "Result: " + finalOutput );
    }
}
