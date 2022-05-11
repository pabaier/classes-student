
import java.util.Scanner;
/**
 *  Add two numeric strings.
 *
 * @author (McCauley)
 */
public class Algorism
{
    public static void main(String [] args){
       
       Scanner scnr = new Scanner(System.in);
       System.out.print("Enter a number: ");
       String number1 = scnr.next( );
       number1 = number1.trim();
       System.out.print("Enter another number: ");
       String number2 = scnr.next( );
       number2 = number2.trim();
       String result = "";
       
       // Verify that both strings are valid numbers
       boolean goodNumber = true;
       int position = 0;
       while (goodNumber && position < number1.length()){
           if (!Character.isDigit(number1.charAt(position)))
              goodNumber = false;
           else
               position++;
       }
       position = 0;
       while (goodNumber && position < number2.length()){
           if (!Character.isDigit(number2.charAt(position)))
              goodNumber = false;
           else
               position++;
       }
       
       if (!goodNumber)
          System.out.println("Error in input, one or more inputs invalid.");
       else {  // do the addition
          // assumes both numbers are same length, and no carrying required
          position = number1.length()-1;
          int carry = 0;
          while (position >= 0){
              int value1 = number1.charAt(position) - '0';
              int value2 = number2.charAt(position) - '0';
              int res = value1 + value2 + carry;
              carry = res / 10;
              result = (char)(res % 10 + '0') + result;
              position--;
          } // while
          result = (char)(carry + '0') + result;
          System.out.println("The sum of the numbers below:");
          System.out.println("\t " + number1);
          System.out.println("\t " + number2);
          System.out.println("\t--------------");
          System.out.println("\t " + result);
              
        } // else    
       
      }
}
