
/**
 * Write a description of class HW1Part1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */


import java.util.Scanner;
public class HW1Part2 {
	
	public static void main(String[] args) {
		Scanner myScan = new Scanner(System.in);
		Scanner myScan2 = new Scanner(System.in);
		
		System.out.println("Enter two numbers: ");
		String num1 = myScan.next();
		String num2 = myScan.next();
		String result1 = " ";
		
		int x = 0;
		int y = 0;
		int result = 0;
		x = Integer.parseInt(num1);
		y = Integer.parseInt(num2);
		result = x + y;
		result1 = Integer.toString(result);
		
		System.out.println(num1 + " + " + num2 + " = " + result1);
		
		myScan.close();
		myScan2.close();
		

	}

}