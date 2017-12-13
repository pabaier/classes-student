//@author: Stefan Veloff;
//CSCI220 : Homework #7;
//This is a program that reads from a file. Then it reverses the words on each line,
//reverses the word on a character level, then checks to see if it is a palindrome:
//I discussed this assignment with: Mackenzie from the CSCI tutoring lab, Paul B. and Kyle W.

//import statements:
import java.util.*;
import java.io.*;

//reverseString class:
public class HW7 {
	public static void main (String [] args) {
		Scanner scnr = new Scanner(System.in);
		//print statement asking user to enter the file name:
		System.out.println("Please enter a file name with .txt attached to the end: ");
		String file = scnr.next();
		//reading from file:
		File infile = new File(file);
		
		//try statement:
		try {
			//initializing scanner to read from file:
			scnr = new Scanner(infile);
			//while looping through each line:
			while (scnr.hasNextLine()) {	
				String words = scnr.nextLine();
				//calling reverseWord():
				String revWord = reverseWord(words);
				//print statement:
				System.out.println(revWord);	
				//calling method:
				String reverseLetters = StringReverseLettters(words);
				//print statement:
				System.out.println(reverseLetters);
				//calling on 
				isAPalindrome(words);
				//testing:
				//isAPalindrome("zybooks");
				//isAPalindrome("racecar");
			}		
		}
			//catch statement if the file is not found:
			catch (FileNotFoundException e) {
				//print statement:
				System.out.println("***File not found in directory please try again***");		
			}
	}
	//reverseWord method:
	public static String reverseWord(String sentence) {
		//splitting the string by " ":
		String [] parts = sentence.split(" "); 
		//StringBuilder:
		StringBuilder string = new StringBuilder();
		//appending the string:
		string.append(parts[parts.length - 1]);
		//for loop (if not -2 then this gives me an out of bounds error!!):
		for (int i = parts.length - 2; i >=0; i--) {
			//appending the string:
			string.append(" ").append(parts[i]);
		}
		//returns statement:
		return string.toString();	
	}
	//isAPalindrome method:
	public static boolean isAPalindrome(String words) {
		//initializing the stack:
		Stack<String> stack = new Stack<String>();
		//pushing words onto a stack:
		stack.push(words);
		String popString = " ";
		//while the stack is not empty:
		while(!stack.isEmpty()) {
			//popping onto the stack:
			popString = stack.pop();
			
			
			//testing my popString:
			//System.out.println(popString);
			
			
			//if the popString is < 2 then this is a palindrome:
			if (popString.length() < 2) {
				//print statements:
				System.out.println(words + " is a palindrome");
				System.out.println("-------------------------------------");
				//return statement:
				return true;
			}
			//else statement:
			else {
				//if statement comparing the first and last characters of the substring:
				if (popString.substring(0, 1).compareTo(popString.substring(popString.length()-1)) == 0) {
					//pushing these onto the stack:
					stack.push(popString.substring(1,popString.length()-1));
				}
				//else statement:
				else {
					//print statement:
					System.out.println(words + " is NOT a palindrome");
					System.out.println("-------------------------------------");
					//return statement:
					return false;
				}
			}
		}
		//print statement:
		System.out.println(words + " is a palindrome");
		System.out.println("-------------------------------------");
		//return statement:
		return true;
	}
	//reversing the string:
	private static String StringReverseLettters(String sentence) {
		String stringReversed = " ";
		Stack<String> stack = new Stack<String>(); 
		sentence.split(" ");	
		//for loop:
		for(int i = 0; i< sentence.length(); i++) {
			//push onto the stack:
			stack.push(sentence.substring(i, i+1));
		}
		//while loop:
		while(!stack.isEmpty()) {
			stringReversed += stack.pop();
		}
		//print statement:
		System.out.println("Reverse is: " + stringReversed);
		//return statement:
		return stringReversed;
	}
}
