
/**
 * Homework 1 Part 2
 *
 * Claire Gerwatowski
 * 9/26/17
 */
import java.util.Scanner;
public class HW1Part2
{
    public static void main (String[] args)
    {
        Scanner scnr = new Scanner(System.in);
        String num1 = scnr.next();
        String num2 = scnr.next();
        
        boolean digits = true;
        for (int i=0; i<num1.length();i++){
            if (Character.isDigit(num1.charAt(i)))
                digits = true;
            else {
                digits = false;
                System.out.println("Enter only digits");
                break;
            }
                
        }
        for (int i=0; i<num2.length();i++){
            if (Character.isDigit(num2.charAt(i)))
                digits = true;
            else {
                digits = false;
                System.out.println("Enter only digits");
                break;
            }
                
        }
        int sum = 0;
        int carry = 0;
        String newSum = "";
        int num1len = num1.length();
        int num2len = num2.length();
        int longerlen = 0;
        if (num1len>=num2len) {
            longerlen = num1len;
        }
        else {
            longerlen = num2len;
        }
        String num1diff = num1;
        String num2diff = num2;
        
        if (num1len>num2len){
            int difference = num1len-num2len;
            for (int i=0; i<=difference-1; i++){
                num2diff = '0' + num2diff;
            }
            }
        else {
            int difference = num2len-num1len;
            for (int i=0; i<=difference-1; i++){
                num1diff = '0' + num1diff;
            }
            }
        if (digits = true){
            
            for (int i=longerlen-1; i>=0; i--){
                int value = num1diff.charAt(i) - '0';
                int value2 = num2diff.charAt(i) - '0';
                sum = value + value2 + carry;
                if (sum>9){
                    carry = 1;
                    sum = sum - 10;
                    char ch = (char)(sum + '0');
                    newSum += ch;
                }
                else{
                    carry = 0;
                    char ch = (char)(sum + '0');
                    newSum += ch;
                }
            }
            String finalSum = "";
            for (int i = newSum.length()-1; i >= 0 ; i--){
                finalSum += newSum.charAt(i);
            }
            if (num1diff.charAt(0)+num2diff.charAt(0)>'9'){
                    finalSum = '1' + finalSum;
                    System.out.print(finalSum);}
                    
        }
}
}