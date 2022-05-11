
/**
 * Code for Homework1 Part 2
 *
 * @author (Steven Higgins)
 */
import java.util.Scanner;
public class HW1Part2
{
    public static void main(String[] args)
    {
        String longNum = "";
        String longNum1 = "";
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your first number: ");
        longNum = input.next();
        System.out.println("Enter your second number: ");
        longNum1 = input.next();
        int workingNum;
        int workingNum1;
        int i = 0;
        int j = 0;
        int lengthOfNum = longNum.length();
        int lengthOfNum1 = longNum1.length();
        int carry = 0;
        int value;
        int length = 0;
        int numZeros;
        String result = "";
       
        if(lengthOfNum == lengthOfNum1){
            length = lengthOfNum;
        }
        else if(lengthOfNum > lengthOfNum1){
            length = lengthOfNum;
            numZeros = lengthOfNum - lengthOfNum1;
            for(i = 0; i < numZeros; i++){
                longNum1 = 0 + longNum1;
            }
        }
        else if(lengthOfNum1 > lengthOfNum){
            length = lengthOfNum1;
            numZeros = lengthOfNum1 - lengthOfNum;
            for(i = 0; i < numZeros; i++){
                longNum = 0 + longNum;           
            }
        }
        
        for(i = length - 1; i >= 0; i--)
        {
            workingNum = (longNum.charAt(i) - '0') + carry;
            workingNum1 = longNum1.charAt(i) - '0';
            //System.out.println("workingNum = " + workingNum); test code
            //System.out.println("workingNum1 = " + workingNum1); test code
            if((workingNum + workingNum1) > 9){
                value = workingNum + workingNum1 - 10;
                carry = 1;
                result = value + result;
            } 
            else {
                result = (workingNum + workingNum1) + result;
                carry = 0;
            }
            if(i == 0 && (workingNum + workingNum1) > 9){
                result = 1 + result; 
            }
            
            
         }
        System.out.println(result);
    }
}
