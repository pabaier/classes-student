import java.util.Scanner;
/**
 * A program to take two numbers as user input strings and add them.
 * 
 *
 * @author Richard Marshall
 * 
 */

public class HW1Part2
{
    public static boolean isNumeric (String str) {
        boolean isNumbers = true;
        
        for(char ch : str.toCharArray()) {
            if (!Character.isDigit(ch)){
                isNumbers = false;
            }
        }
        
        return isNumbers;
    }
    
    public static void main (String[] args) {
        String numberOne = "";
        String reverseOne;
        String numberTwo = "";
        String reverseTwo;
        Scanner scnr = new Scanner(System.in);
        String sumOfNums ="";
        boolean inputInvalid = true;
        int minLength = 0;
        int maxLength = 0;
        String longerNum = "";
        boolean carry = false;
        
        while(inputInvalid) {
            System.out.println("Please enter the first number to be added:");
            numberOne += scnr.next();
            System.out.println("Please enter the second number to be added:");
            numberTwo += scnr.next();
            
            // one can add these conditionals to the if statement below to eliminate 
            //the possibilty of leading zeros
            // && numberOne.charAt(0) != '0' && numberTwo.charAt(0) != '0')
            if (isNumeric(numberOne) && isNumeric(numberTwo))   {
                inputInvalid = false;
            }
            else {
                numberOne = numberOne.replaceAll(numberOne, "");
                numberTwo = numberTwo.replaceAll(numberTwo, "");
                
                System.out.println("Invalid input. Please be sure to only enter a positive integer with no spaces.");
            }
        }
        
        reverseOne = new StringBuffer(numberOne).reverse().toString();
        reverseTwo = new StringBuffer(numberTwo).reverse().toString();
        
        if(numberOne.length() > numberTwo.length()) {
            minLength = numberTwo.length();
            maxLength = numberOne.length();
            longerNum += reverseOne;
            
        }
        else{
            minLength = numberOne.length();
            maxLength = numberTwo.length();
            longerNum += reverseTwo;
        }
        
        int[] sumArray = new int[maxLength];
        
        for (int index = 0; index < minLength; index++){
            int numIndexOne = reverseOne.charAt(index) - '0';
            int numIndexTwo = reverseTwo.charAt(index) - '0';
            
            int newNumber = numIndexOne + numIndexTwo;
            
            if (carry) {
                newNumber++;
                carry = false;
            }
            
            if (newNumber >= 10) {
                newNumber -= 10;
                carry = true;
            }
            
            sumArray[index] = newNumber;
        }
        
        if (maxLength > minLength) {
                
            for (int index = minLength; index < maxLength; index++) {
                int newNumber = longerNum.charAt(index) - '0';
                
                if (carry) {
                    newNumber++;
                    carry = false;
                }
                
                if (newNumber >= 10) {
                    newNumber -= 10;
                    carry = true;
                }
                
                sumArray[index] = newNumber;
            }
        }
        
        for (int index = maxLength - 1; index >= 0; index--) {
                sumOfNums += sumArray[index];
        }
        
        if (carry) {
            sumOfNums = '1' + sumOfNums;
        }
        
        
        System.out.println(numberOne + " + " + numberTwo + " = " + sumOfNums);
    }
}
