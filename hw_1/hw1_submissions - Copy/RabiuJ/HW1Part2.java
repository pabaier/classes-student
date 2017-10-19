
/**
 * Algorism Algorithms
 * 
 * Jonathan Rabiu 
 * @version (a version number or a date)
 */

import java.util.Scanner;
public class HW1Part2{
   public static void main (String [] args) {
       String numString1 = "";
       String numString2 = "";
       int num1 = 0;
       int num2 = 0;
       int sum = 0;
       String answer = ""; 
       int difference = 0;
       int carry = 1;
       
       Scanner scnr = new Scanner(System.in);
       
       System.out.println("Enter any nonnegative number without commas");
       numString1 = scnr.nextLine();
       System.out.println("Enter another nonnegative number without commas");
       numString2 = scnr.nextLine();
       
       for(int i = numString1.length() - 1; i>= 0; --i){
          if(numString1.length() < numString2.length()){
            difference = numString2.length() - numString1.length();
            for(i = 0; i < difference; ++i){
              numString1 = "0" + numString1;
            
            }
          }
          else if(numString2.length() < numString1.length()){
            difference = numString1.length() - numString2.length();
            for(i = 0; i < difference; ++i){
              numString2 = "0" + numString2;
            }
          }
          
           num1 = (numString1.charAt(i) - '0');
           num2 = (numString2.charAt(i) - '0');

           sum = num1 + num2; 
           answer = Integer.toString(sum)+answer;

        }
       System.out.println("");
       System.out.println("The sum of those numbers are " + (answer));

     }   
   }

