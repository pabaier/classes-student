
/**
 * A program to add two strings together using algorism addition
 *
 * @author (Riley Moore)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class HW1Part2
{
    public static void main (String[] args)
    {
        String val1 = "";
        String val2 = "";
        Scanner scnr = new Scanner(System.in);
        int i = 0;
        int lengthVal1 = 0;
        int lengthVal2 = 0;
        System.out.println("Enter the first number to be added: ");
        val1 = scnr.nextLine();
        System.out.println("Enter the second number to be added: ");
        val2 = scnr.nextLine();
        lengthVal1 = val1.length();
        lengthVal2 = val2.length();
        String finalVal = "";
        int numVal1 = 0;
        int numVal2 = 0;
        int carryOver = 0;
        for(i=lengthVal1 -1; i>=0; i--){ 
            numVal1 = (val1.charAt(i) - '0')+carryOver;
            numVal2 = (val2.charAt(i) - '0');
            if((numVal1 + numVal2) > 9){
                carryOver = 1;
                finalVal = (numVal1 + numVal2) - 10 + finalVal;
            }
            else{
                carryOver = 0;
                finalVal = (numVal1 + numVal2) + finalVal;
            }
    }
       System.out.println(finalVal);
}
}