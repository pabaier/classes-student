
/**
 * Algorism Algorithms
 *
 * Julie Yib
 */
import java.util.Scanner; 
public class HW1Part2
{
    public static void main (String [ ] args){
        Scanner scnr = new Scanner(System.in);
        String num1 = "";
        String num2 = "";
        StringBuilder sumNum = new StringBuilder();
        System.out.println("Enter the first number: ");
        num1 = scnr.next();
        System.out.println("Enter a second number: ");
        num2 = scnr.next();  

        int carry = 0;
        char c = (char) carry;
        int x = num1.length()-1;
        int y = num2.length()-1;
        int value1 = 0;
        int value2 = 0;
        int sum = 0;  
        
        while (x>=0 || y>=0) {

            if (x >= 0){
                value1 = num1.charAt(x--)-'0';
            }
              
            if (y >= 0){
                value2 = num2.charAt(y--)-'0';
            }
                sum = value1 + value2 + carry;
                
                if (sum >= 10){
                    carry = sum / 10;
                    sum = sum % 10;
                }
                    else {
                        carry = 0;
                    }  

            sumNum.insert(0,sum);

       }

       
       sum = carry + sum;
       sumNum.insert(0,sum);
       
       System.out.println(num1);
       System.out.println("+ " +num2);
       System.out.println("is "+sumNum);
    }
}
       

            

    

 
            

             
            

        
        


