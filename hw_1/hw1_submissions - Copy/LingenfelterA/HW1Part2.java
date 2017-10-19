/**
 * FILE: HW1Part2.java
 * Purpose: Add digits stored in two strings
 * Author: Andrea Lingenfelter
 */

// package HW1Part2;

import java.util.Arrays;
import java.util.Scanner;

public class HW1Part2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String num1 = " ";
		String num2 = " ";
		char ch = ' ';
		int length = 0;
		String total = " ";
		
		
		System.out.println("Please enter a number: ");
		num1 = input.nextLine();
		num1 = num1.trim();
		
		if (num1.length() == 0) {
			System.out.println("No number entered. Try again.");
		}
		
		if (num1.indexOf(' ') >= 0) {
			num1 = num1.substring(0, num1.indexOf(' ' ));
		}
		
		// validate all characters are numbers for num1
		for (int i = 0; i < num1.length(); i++) {
			ch = num1.charAt(i);
			if(!Character.isDigit(ch)) {
				System.out.println("Invalid Entry:" + ch);
				break;
			}
//			else {
//				System.out.println(ch + " is a valid number");
//			}
		}
		System.out.println("Please enter second number: ");
		num2 = input.nextLine();
		num2 = num2.trim();
		
		if (num2.length() == 0) {
			System.out.println("No number entered. Try again.");
		}
		
		if (num2.indexOf(' ') >= 0) {
			num1 = num1.substring(0, num1.indexOf(' ' ));
		}
		
		// validate all characters are numbers for num2
		for (int i = 0; i < num2.length(); i++) {
			ch = num2.charAt(i);
			if(!Character.isDigit(ch)) {
				System.out.println("Invalid Entry:" + ch);
				break;
			}
//			else {
//				System.out.println(ch + " is a valid number");
//			}
		}
		//print out numbers entered
		//System.out.println("1: " + num1 + " 2: " + num2);
		
		
		//handle different lengths
		length = Math.max(num1.length(), num2.length());
		if (num1.length() < length) {
			for (int i = num1.length(); i < length; i++) {
				num1 = ("" + 0 + num1);
			}
		}
		if (num2.length() < length) {
			for (int i = num2.length(); i < length; i++) {
				num2 = ("" + 0 + num2);
			}
		}
		//test padded strings
		//System.out.println("After padding num1: " + num1);
		//System.out.println("After padding num2: " + num2);
		
		//create sum array
		int [] sum = new int[length + 1];
		
		 
		//add left to right
		int val = 0;
		
		int carry = 0;
		for (int i = num1.length()-1; i >= 0; i--) {
			//System.out.println(num1.charAt(i) + "+" + num2.charAt(i));
			
			int int1 = Integer.parseInt(num1.substring(i, i+1));
			int int2 = Integer.parseInt(num2.substring(i,  i+1));
			val = int1 + int2 + carry;
			
			//System.out.println(int1 + " + " + int2 + "carry" + carry + " = " + val);
			// carrying
			if (val > 9) {
				val = val % 10;
				carry = 1;
			}
			else {
				carry = 0;
			}
			//System.out.println("carry: " + carry);
			sum[i+1] = val;
			//System.out.println("val is : " + val);
			//System.out.println(Arrays.toString(sum));
 		}
		sum[0] = carry;
		//System.out.println(Arrays.toString(sum));
//		//convert back to String
		total = Arrays.toString(sum);
		//System.out.println("total: " + total);
		total = total.replace(", ", "");
		//System.out.println("After replace , : " + total);
		total = total.substring(1, total.length() - 1);
		//System.out.println("After remove braces: " + total);
		
		//remove leading 0
		if (total.startsWith("0")) {
			total = total.substring(1);
		}
		System.out.println("the sum of " + num1 + " + " + num2 + " is: " + total);
	}
}
