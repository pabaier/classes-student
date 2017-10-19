
/**
 * This program adds two numeric strings input by the user.
 *
 * Connor Matthews
 * September 29, 2017
 */
import java.util.Scanner;
public class HW1Part2
{
   public static void main (String [ ] args) {
   Scanner scnr = new Scanner(System.in);
   String string1 = "";
   String string2 = "";
   System.out.println("Enter a number: ");
   string1 = scnr.next();
   System.out.println("Enter another number: ");
   string2 = scnr.next();
   int i = 0;
   int j = 0;
   char character1 = ' ';
   char character2 = ' ';
   int value1 = 0;
   int value2= 0;
   int length1 = string1.length();
   int length2 = string2.length();
   System.out.println(string1 + " " + "+" + " " + string2);
  
   for(i= length1-1; i >= 0; i--){
            if(Character.isDigit(string1.charAt(i)) == false){
                System.out.println("Error: Input 1 contains character that is not digit");
                break;
            }
            character1 = string1.charAt(i); 
            value1 = character1 - '0';
            System.out.print(value1);
        }  
   System.out.println();
   for(i= length2 -1; i >= 0; i--){
            if(Character.isDigit(string2.charAt(i)) == false){
                System.out.println("Error: Input 2 contains character that is not digit");
                break;
            }
            character2 = string2.charAt(i);
            value2 = character2 - '0';
            System.out.print(value2);
        } 
   System.out.println();
   if(length1 > length2){
    int bigLength = length1;
    if(length2>length1){
        bigLength = length2;
    }
        else{
            bigLength = length1;
        }
        
    for(i = 0; i < bigLength; i++){
       int add = value1 + value2;
       System.out.println(add);
      }
   }
  }
}


  




