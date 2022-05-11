/* Asa Perryman
 * CSCI 221
 * Pupose: To add numbers represented as strings and return that sum as
 *          as a string
 */

import java.util.Scanner;

public class HW1Part2 {
    public static void main (String [] args) {
        
        //intializing loop varibales
        int i = 0;

        //Scans in first number
        System.out.print("Enter your first number: ");
        Scanner scnr = new Scanner(System.in);
        String userNumber1 = scnr.next();

        //loop through the first number to ensre that it contains only digits
        for(i = 0; i < userNumber1.length(); i++){
            if(!(Character.isDigit(userNumber1.charAt(i)))){
                
                //If contains illegal characters, ask for a new number
                System.out.print("Enter a different number: ");
                
                i = 0;
                //scan in new number 
                userNumber1 = scnr.next();
                
                
            }
        } 

        //Scans in second number
        System.out.print("Enter your second number: ");
        String userNumber2 = scnr.next();

        //loop through the second number to ensre that it contains only digits
        for(i = 0; i < userNumber2.length(); i++){
            if(!(Character.isDigit(userNumber2.charAt(i)))){
                
                //If contains illegal characters, ask for a new number
                System.out.print("Enter a different number: ");
                
                i = 0;
                //scan in new number
                userNumber2 = scnr.next();
                
            }
        } 
        
        //initialize varaible for differnce in lengths
        int firstLarger = userNumber1.length() - userNumber2.length();
        int secondLarger = userNumber2.length() - userNumber1.length();
        
        //adds zeros to second number if the first is larger
        if(firstLarger >= 1){
            for(i = 0; i < firstLarger; i++){
                userNumber2 = "0" + userNumber2;
            }
        }
        
        //adds zeros to first number if the second is larger
        if(secondLarger >1){
            for(i = 0; i < secondLarger; i++){
                userNumber1 = "0" + userNumber1;
            }
        }
        
        //variables assigned for use in loos and conditionals
        String totalSum = "";
        char tempSumString = ' ';
        boolean carry1 = false;
        int tempSum = 0;
        
        //loop for adding numbers
        for( i = userNumber2.length()-1; i >= 0;  i--){
            boolean doNotOverride = false;
            
            //statments reassigning numbers as ints
            int value1 = userNumber1.charAt(i) - '0';
            int value2 = userNumber2.charAt(i) - '0';
            
            //finding the sum of ints
            tempSum = value1 + value2;
            
            //conditionals if carrying is needed
            if( value1 + value2 > 9){
                //subtract 10 from the current temporary sum
                tempSum = tempSum - 10;
            }
            if(carry1){
                //adds one to the next coulmnn 
                tempSum++;
                //conditional if carrying needs to happens again
                if(tempSum>9){
                    tempSum = tempSum -10;
                    
                    carry1 = true;
                    doNotOverride = true;
                }
            }
            if( value1 + value2 > 9){
                carry1 = true;
            }
            
            //conditional if no carrying is needed
            if(value1 + value2 <= 9){
                if(!(doNotOverride)){
                    carry1 = false;
                }

            }
            
            //change the temporary sum back to a string
            tempSumString = (char)(tempSum + '0');
            //add the temporary sum back to the existing number
            totalSum = tempSumString + totalSum;
        }
        
        //if a carry is needed beyond the number of digits avaliabe,
        //add a one to the beginning of your number
        if(carry1){
            totalSum= '1' + totalSum;
        }
        
        //print statement for the sum
        System.out.println(" ");
        System.out.println("The sum is " + totalSum);
    }
}

