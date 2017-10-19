/*
 * Kyle Winstead
 * Homework 1 Part 2
 * McCauley 12:30p
 * 
 * 
 * Pseudocode
 * int numberOne, numberTwo, total
 * String numOne, numTwo
 * 
 * Prompt the user for two positive integers
 * read in the two integers
 * take the value of the first string and convert to number. do the same for the second string
 * set total equal to both numberOne and numberTwo
 * if the total is greater than or equal to zero, print out total
 * if not, print out error
 * if the program has been given something other than an integer, the program quits.
 * 
 */

import java.util.*;
public class HW1Part2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String numOne = "";
		String numTwo = "";
		Scanner in = new Scanner (System.in);
		int numberOne, numberTwo, total;
		
		System.out.println("Please enter two positive numbers: ");
		numOne = in.next();
		numTwo = in.next();
		
		
		
		numberOne = Integer.valueOf(numOne);
		numberTwo = Integer.valueOf(numTwo);
		
		total = numberOne + numberTwo;
			if(total >=0) {
				System.out.println(total);
			}
			else {
			 System.out.print("Error");
			}
		
		
		
		
		}
	}


