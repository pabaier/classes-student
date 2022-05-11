
/**
 * @author Corey Taylor
 * @version 9/30/17
 */
import java.util.Scanner;
public class HW1part2
{
        	public static void main(String[] args) {
		Scanner scnrOne = new Scanner(System.in);
		Scanner scnrTwo = new Scanner(System.in);
		Scanner scnrThree = new Scanner(System.in);
		
		int stringOneInt = 0, stringTwoInt = 0, stringSum = 0;
		
		System.out.println("Please enter the values of your two strings: ");
		String stringOne = scnrOne.nextLine(), stringTwo = scnrTwo.nextLine();
		String newString = " ", newStringName = " ";
		
		stringOneInt = Integer.parseInt(stringOne);
		stringTwoInt = Integer.parseInt(stringTwo);
		stringSum = stringOneInt + stringTwoInt;
		newString = Integer.toString(stringSum);
		
		System.out.println("Please input a name for the string");
		newStringName = scnrThree.next();
		
		System.out.println("String " + newStringName + " = " + newString);
		scnrOne.close();
		scnrTwo.close();
		

	}

}
        
        
        
    
    
    
