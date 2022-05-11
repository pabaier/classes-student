
/**
 * Finds the sum of two strings
 *
 * Orianna Gandy-Wells 
 * 9/25/17
 */

import java.util.Scanner;
public class HW1Part2{
    
    public static String addTwoInputs(String str1, String str2){
       String addedString = "";
       int str1End = str1.length() - 1;
       int str2End = str2.length() - 1;
       int carry = 0;
       
       
       for (int i = str1End; i >= 0; i--){
           int value1 = str1.charAt(i) - '0';
           int value2 = str2.charAt(i) - '0';
           int value = value1 + value2 + carry;
           
           if(value > 9){
               carry = 1;
               value = value - 10;
              }
               else {
                   carry = 0;
                }
      
           char ch = (char) (value + '0');
           addedString = ch + addedString;
        
           if(i == 0 && carry > 0){
               char remainder = (char) (carry + '0');
               addedString = remainder + addedString ;
               break;
            }
        }
    
   
       return addedString; 
    }
    
    public static boolean isANumber(char ch){
            if ((ch >= '0' && ch <= '9')){
            return true;
            }
        else{
            return false;
        }
        }
        
    public static void main (String [] args){
        String number1 = "";
        String number2 = "";
        String zero = "0";
        Scanner scnr = new Scanner(System.in);
 
        System.out.println("Enter a number: ");
        number1 = scnr.nextLine();
        System.out.println("Enter another number: ");
        number2 = scnr.nextLine();
        
        while (number1.length() != number2.length()){
           if(number1.length() > number2.length()){
               number2 = zero + number2;
            }
           if(number1.length() < number2.length()){
               number1 = zero + number1;
            }
        }
        
        for (int i = 0; i < number1.length(); i++){
            
         if((isANumber(number1.charAt(i)) == true) && (isANumber(number2.charAt(i)) == true)){
             addTwoInputs(number1, number2);
            }
            else{
                System.out.print("Invalid entry. Not a number");
            }
        }
        System.out.println("The two strings sum up to: " + addTwoInputs(number1, number2));
    
   }
}