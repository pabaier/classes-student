/**
 * This class will be adding strings 
 *
 * Lexus Hartung
 * 9-28-17
 */
import java.util.Scanner;

public class HW1Part2{
   public static void main(String [] args){
       int i = 0;
       int numOne = 0;
       int numTwo = 0;
       int total = 0;
       int extra = 0;
       String userStringOne = " ";
       String userStringTwo = " ";
       String tot = " ";
       boolean Isbigger = true;
       Scanner scnr = new Scanner(System.in);
       
       System.out.println("I will add two numbers for you.");
       System.out.println("What is the first number?");
       userStringOne = scnr.next();
       System.out.println("What is the second number?");
       userStringTwo = scnr.next();
       
       if (isNumValid(userStringOne) && isNumValid(userStringTwo)){
           while (Isbigger){
           if(userStringOne.length() > userStringTwo.length()){
               userStringTwo = makeBigger(userStringTwo);
           }
           else if (userStringOne.length() < userStringTwo.length()){
               userStringOne = makeBigger(userStringOne);
           }
           else{
               Isbigger = false;  
           }
        }
        for(i = userStringOne.length() - 1; i >= 0; --i){
            numOne = charToNum(userStringOne.charAt(i));
            numTwo = charToNum(userStringTwo.charAt(i));
            if (numOne + numTwo >= 10 && extra == 0){
                total = numOne + numTwo - 10;
                extra = 1;
            }
            else if (numOne + numTwo >= 10 && extra == 1){
                total = numOne + numTwo - 10 + extra;
                extra = 1;
            }
            else if (extra == 1){
                total = numOne + numTwo + extra;
                extra = 0;
            }
            else{
                total = numOne + numTwo;
                extra = 0;
            }
            tot = tot.concat("" + total + "");
        }
       for(i = tot.length() - 1; i >= 0; --i){
           System.out.print(tot.charAt(i));
        }
        System.out.println("");
       }
       else{
           System.out.println("Invalid Number");
       }
   }
   public static boolean isNumValid (String num){
       int i = 0;
       boolean valid = false;
       for (i = 0; i < num.length(); ++i){
           if (num.charAt(i) >= 48 && num.charAt(i) <= 57){
               valid = true;
            }
            else{
               valid = false;
               break;
            }
        }
       return valid;
   }
   public static int charToNum (char ch){
       int value = Character.getNumericValue(ch);
       return value;
   }
   public static String makeBigger (String little){
       String filler = "0" + little;
       return filler;
   }
}
