import java.util.Scanner;
/**
 *  Add two numeric strings.
 *
 * @author (McCauley)
 */
public class AlgorismSolution
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
          // Make both numbers the same length
          int length1 = number1.length();
          int length2 = number2.length();
          if (length1 != length2)
             if (length1 < length2)
                for (int i = 0; i < length2 - length1; i++)
                   number1 = "0" + number1; // pad with 0's
             else
                for (int i = 0; i < length1 - length2; i++)
                   number2 = "0" + number2; // pad with 0's
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
