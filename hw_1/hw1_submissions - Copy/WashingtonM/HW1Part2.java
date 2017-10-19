package edu.cofc.csci221.washingtonmary;


/**
 * Add two string of numbers together
 *
 * Mary Washington
 * Eclipse Oxygen 4.7.0 
 *
 */
import java.util.Scanner;
public class HW1Part2
{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String str1 = "";
        String str2 = "";
        String strSum = "";
        char ch1 = ' ';
        char ch2 = ' ';
        int excessValue = 0;

        System.out.println("Please enter your first string");
        str1 = input.next();

        System.out.println("Please enter your second string.");
        str2 = input.next();
        
        //initializing it to start at the end of the string and work from right to left
        int numOneIndex = str1.length() -1;
        int numTwoIndex = str2.length() -1;

        while((numOneIndex >= 0) || (numTwoIndex >= 0)){
            int digit1 = 0;
            int digit2 = 0;
            int digitSum = 0;
            if(numOneIndex >= 0){
            	//what is the character at the right most element in the first string
                ch1 = str1.charAt(numOneIndex);
                //System.out.println(ch1);
                if(Character.isDigit(ch1)){
                	//getting the integer value at that index of string
                    digit1 = Character.getNumericValue(ch1);

                }
                else{
                    System.out.println("Please enter in only numbers in string one.");
                }
            }
            //what is the character at the right most element in the second string
            if(numTwoIndex >= 0){
                ch2 = str2.charAt(numTwoIndex);
                //System.out.println(ch2);
                if(Character.isDigit(ch2)){
                	//getting the integer value at the index of string two
                    digit2 = Character.getNumericValue(ch2);
                }
                else{
                    System.out.println("Please enter in only numbers in string two.");
                }
            }
            //System.out.println(digit1 + "+" + digit2);
            digitSum = digit1 + digit2 + excessValue;
           
            excessValue = digitSum / 10;
            digitSum = digitSum % 10;
            strSum = digitSum + strSum;

            numOneIndex--;
            numTwoIndex--;
        }
        if(excessValue > 0){
            strSum = excessValue + strSum;
        }
        System.out.println(strSum);

        input.close();
    }
}
