import java.util.ArrayDeque;
import java.util.Deque;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/*
 * Driver for stacks and deques and practicing using them
 * Mary Washington
 * Eclipse Oxygen 4.7
 */



public class HW7 {
	
	public static void main(String[] args) {
		Deque<String>stack = new ArrayDeque<>(); //stack of Strings
		Scanner input = new Scanner(System.in);
		String fileName = "";
		String words = " ";
		String str = "";
		String line = "";
		
		System.out.println("Please enter in file");
		fileName = input.nextLine();
		input.close();
		
		try {//using a try and catch block to see if file is present
			//Problem 1
			
			Scanner fileInput = new Scanner(new File (fileName));
			
			while(fileInput.hasNextLine()) {
				
				words = fileInput.nextLine();
				System.out.print(" The reverse " + "\"" + words + "\"" + " is ");
				String [] sentence = words.split(" ");//forming an array of Strings
				for(String word : sentence) {
					stack.push(word);//pushing the words from the array onto the stack
				}
				System.out.print("\"");
				for(String phrase : stack) {
					
					System.out.print(stack.pop());
					if(!stack.isEmpty()) {
						System.out.print(" ");
					}
				}
				System.out.print("\".");
				System.out.println();
				
			}
			
			System.out.println();
			
			//problem 2
			fileInput.reset();//reseting the txt file back to it's orginal format
			fileInput = new Scanner(new File (fileName));
			
			while(fileInput.hasNextLine()) {
				str = fileInput.nextLine();
				boolean isPalindrome = prob2Palindrome(str);//using method
				System.out.print("\"" + str + "\"");
				if(isPalindrome) {
					System.out.println(" is a palindrome.");
				}
				else {
					System.out.println(" is not a palindrome.");
				}
			
			}
			System.out.println();
			
			//Problem 3
			fileInput.reset();//resetting the txt file back to original format
			fileInput = new Scanner(new File(fileName));
			
			while(fileInput.hasNextLine()) {
				line = fileInput.nextLine();
				boolean isPalindrome = prob3Palindrome(line);//using method
				System.out.print("\"" + line + "\"");
				if(isPalindrome) {
					System.out.println(" is a palindrome.");
				}
				else{
					System.out.println(" is not a palindrome.");
				}
				
			}
		
			fileInput.close();
		}
		catch(FileNotFoundException e) {//checking to see if file exists
			System.out.println("Sorry that file was not found.  Please try again.");
		}
		
	}
	
	//method for problem 2
	public static boolean prob2Palindrome(String str){
	
		Deque<String>stack = new ArrayDeque<>();
		boolean palindrome = true;
	
		stack.push(str);
		
		while(!stack.isEmpty()) {
			
			
			String word = stack.pop();
			if ((word.length() == 0) || (word.length() == 1)) {
				return palindrome;
			}
			else {
				//forcing all letters to be of same case
				if (Character.toUpperCase(word.charAt(0)) ==
						Character.toUpperCase(word.charAt(word.length()-1))) {
					stack.push(word.substring(1, (word.length()-1)));
				}
				else {
					palindrome = false;
					return palindrome;
				}
			}
		}
	
		return palindrome;
	}
	
	//method for problem 3
	public static boolean prob3Palindrome(String line) {
		String[] words = line.split(" ");//forming a an array
		Deque<String> queue = new ArrayDeque<>();
		Deque<String> stack = new ArrayDeque<>();
		boolean palindrome = true;
		
		for(String word : words) {
			queue.addLast(word);//building queue from the back
			stack.push(word);//building stack
		}
		while(!(queue.isEmpty() && stack.isEmpty())) {
			String word1 = queue.removeFirst();//removing from front of queue
			String word2 = stack.pop();//popping off from the top of the stack
			
			if(!word1.equalsIgnoreCase(word2)) {//ignores the case difference if present
				palindrome = false;
				return palindrome;
			}
		}
		
		return palindrome;
	}
	
}
