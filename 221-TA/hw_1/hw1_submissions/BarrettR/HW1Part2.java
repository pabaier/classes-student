/**
 * Adds two numbers that are stored as Strings.
 *
 * @author (Ryan Barrett)
 */
import java.util.*;
public class HW1Part2
{
    public static void main(String[]args)
    {
        Scanner scan = new Scanner(System.in);
        int carryOver = 0;
        String firstNum = "";
        String secondNum = "";
        String finalNum = "";
        int totalNumIndex = 0;
        int fNum = 0;
        int sNum = 0;
        int totalNum = 0;
        int indexDif = 0;
        boolean isGoodInput = true;
        
        System.out.print("Enter a number with no non-digit characters: ");
        firstNum = scan.next();
        for(int i = 0; i < firstNum.length(); i++)
        {
            char ch = firstNum.charAt(i);
            if(!Character.isDigit(ch))
                isGoodInput = false;
        }
        
        System.out.print("Enter a second number with no non-digit characters: ");
        secondNum = scan.next();
        for(int i = 0; i < secondNum.length(); i++)
        {
            char ch = secondNum.charAt(i);
            if(!Character.isDigit(ch))
                isGoodInput = false;
        }
        
        if(!isGoodInput)
        {
            System.out.println("One of your numbers contained a non-digit character.");
            return;
        }
        
        if(firstNum.length() > secondNum.length())
            totalNumIndex = firstNum.length();
        else
            totalNumIndex = secondNum.length();
        
        indexDif = Math.abs(firstNum.length() - secondNum.length());
            
        for(int i = totalNumIndex - 1; i >= -1; i--)
        {
            if(firstNum.length() < secondNum.length())
                if(i - indexDif >= 0)
                    fNum = firstNum.charAt(i - indexDif) - 48;
                 else
                    fNum = 0;
            else
                if(i >= 0)
                    fNum = firstNum.charAt(i) - 48;
                else
                    fNum = 0;
            
            if(secondNum.length() < firstNum.length())
                if(i - indexDif >= 0)
                    sNum = secondNum.charAt(i - indexDif) - 48;
                else
                    sNum = 0;
            else
                if(i >= 0)
                    sNum = secondNum.charAt(i) - 48;
                else
                    sNum = 0;
            
            totalNum = fNum + sNum + carryOver;
            
            if(totalNum >= 10)
            {
                totalNum -= 10;
                carryOver = 1;
            }
            else
                carryOver = 0;
            
            finalNum = "" +  totalNum + finalNum;
        }
        if(finalNum.charAt(0) == 48)
            finalNum = finalNum.substring(1);
        
        System.out.print("The total of " + firstNum + " and " + secondNum +
                         " is " + finalNum);
        
        return;
    }
}
