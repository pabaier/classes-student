import java.util.Scanner;
/**
 * by: Michael Dudley
 * Description: Add numbers as strings.
 */

public class HW1Part2
{
    public static String addString(String num1, String num2){
        String totalString = "";
        boolean carry = false;
        for(int i = num1.length()-1; i >= 0; i--){
            int str1digit = num1.charAt(i)-'0';
            int str2digit = num2.charAt(i)-'0';
            int total = str1digit + str2digit;
            if(carry){
               total++;
               carry = false;
            }if(total > 9){
                total -= 10;
                totalString += total;
                carry = true;
            }else{
               totalString += total;
            }
        }
        String returnString = "";
        for(int i =totalString.length()-1; i >= 0; i--){
            returnString += totalString.charAt(i);
        }
        return returnString;
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String num1 = scan.next();
        String num2 = scan.next();
        String totalNum = addString(num1,num2);
        System.out.println("number 1: " + num1);
        System.out.println( "number 2: " + num2);
        System.out.println("Total Number: " + totalNum);
    }
}
