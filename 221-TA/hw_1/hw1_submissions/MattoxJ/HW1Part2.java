import java.util.Scanner;
/**
 * Adding numeric strings
 * Jacob Mattox
 * 9/27/17
 */
public class HW1Part2
{
    public static void main(String[] args)
    {
        Scanner scnr = new Scanner(System.in); //initializing needed scanner and variables
        String numericOne = "";
        String numericTwo = "";
        String addedUp = "";
        int carryOver = 0; 
        int lengthNOne;
        boolean checkingString = true;
        
        System.out.println("This program will add two numerics using grade school math\n");
        
        while(checkingString){ //checks first string for valid input
            System.out.println("Please enter first numeric string: ");
            numericOne = scnr.next();
            for(int i = 0; i < numericOne.length(); i++){
                if(numericOne.charAt(i) != '0' && numericOne.charAt(i) != '1'
                &&numericOne.charAt(i) != '2' && numericOne.charAt(i) != '3'
                &&numericOne.charAt(i) != '4' && numericOne.charAt(i) != '5'
                &&numericOne.charAt(i) != '6' && numericOne.charAt(i) != '7'
                && numericOne.charAt(i) !='8' && numericOne.charAt(i) != '9')
            {
                    System.out.println("Error: You entered a non-numeric string character\n");
                    checkingString = true;
                    break;
            }
                else
                    checkingString = false;
            }
          
            }
        checkingString = true;
        while(checkingString){ // checks second string for valid input
            System.out.println("Please enter second numeric string: ");
            numericTwo = scnr.next();
            for(int i = 0; i < numericTwo.length(); i++){
                if(numericTwo.charAt(i) != '0' && numericTwo.charAt(i) != '1'
                &&numericTwo.charAt(i) != '2' && numericTwo.charAt(i) != '3'
                &&numericTwo.charAt(i) != '4' && numericTwo.charAt(i) != '5'
                &&numericTwo.charAt(i) != '6' && numericTwo.charAt(i) != '7'
                && numericTwo.charAt(i) !='8' && numericTwo.charAt(i) != '9')
            {
                    System.out.println("Error: You entered a non-numeric string character\n");
                    checkingString = true;
                    break;
            }
                else
                    checkingString = false;
            }
          
            }
            
        while(numericOne.length() != numericTwo.length()){ //adds zeroes to the front of the strings so that lengths match
            if(numericOne.length() > numericTwo.length()){
                numericTwo = '0' + numericTwo;
            }
            else
                numericOne = '0' + numericOne;
            }
        
        for(int i = numericOne.length() - 1; i >= 0; i--) // performs calculations
        {
            int valueOne = numericOne.charAt(i) - '0';
            int valueTwo = numericTwo.charAt(i) - '0';
            int combinedValues = valueOne + valueTwo + carryOver;
            if(combinedValues <= 9){
                char newChar = (char)(combinedValues + '0');
                addedUp = newChar + addedUp;
                carryOver = 0;
            }
            else
            {
                combinedValues = combinedValues - 10;
                char newChar = (char)(combinedValues + '0');
                addedUp = newChar + addedUp;
                carryOver = 1;
            }

        }
        if(carryOver == 1) //adds correct carryover to the front of the last string
        {
            addedUp = '1' + addedUp;
        }
        System.out.println(addedUp);

        return;
    }
    
}
