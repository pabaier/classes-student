import java.util.Scanner;
public class HW1Part2 {
/*
 * Purpose: Taking a string integer and making it into an int and only calculate positive numbers 
 * Author: Angelica Rodriguez
 * Date: 29 September 2017
 */
	public static void main(String[] args) {
		Scanner word = new Scanner(System.in);
		String wordNumOne =" ";
		String wordNumTwo=" ";
		String negative = "-";
		
		
		System.out.print("Enter first positive number: ");
		wordNumOne= word.next();
		System.out.println(wordNumOne);
		System.out.print("Enter second positive number: ");
		wordNumTwo= word.next();
		System.out.println(wordNumTwo);
		
		// equalsIgnoreCase allows me to ignore a string, so it allows me to ignore the negative sign and only print/add positive numbers.
		// Integer.valueOf helps me convert string wordNumOne and wordNumTwo into an integer. Also if it is not a number it will give the error message.
		if(wordNumOne.equalsIgnoreCase(negative) && wordNumTwo.equalsIgnoreCase(negative)){
			int numWordOne = Integer.valueOf(wordNumOne);
			int numWordTwo=Integer.valueOf(wordNumTwo);
			
			System.out.println(wordNumOne+ " + " + wordNumTwo);
			System.out.print(numWordOne + numWordTwo + " ");
			
		
		}
		else{
			System.out.println("Error");
		}
		
	 
		

		return;

       
		
		
		
	
		
	
		
		
		
		

	}
}