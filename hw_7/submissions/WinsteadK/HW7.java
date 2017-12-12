//Kyle Winstead
//Assignment: HW7
import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;
public class HW7 {

	public static void main(String[] args) {
		
		//Problem 1
		Stack stack = new Stack(); 
		Scanner in = new Scanner((System.in));
		System.out.print("Enter a file name ending in .txt: ");
		String file = in.next();
		File infile = new File(file);
		try {
			in = new Scanner(infile);
			while(in.hasNextLine()) {
				
			//part 1
			
				
				
		    String s = in.nextLine();
		    String revWord = StringLevWord(s);
		    System.out.println(revWord);
		  //part 2
		    String revLett = StringRevLet(s);

		    System.out.println(revLett);
		    //part 3
	        for (int i = 0; i < s.length(); i++) {
	            stack.push(s.charAt(i));
	            
	        }

	        String reverseString = "";

	        while (!stack.isEmpty()) {
	            reverseString = reverseString+stack.pop();
	        }

	        if (s.equals(reverseString))
	            System.out.println("The input String is a palindrome.");
	        else
	            System.out.println("The input String is not a palindrome.");
		    System.out.println(" ");

		    
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//method for part 1
	public static String StringLevWord(String sentence) {
	    String[] parts = sentence.split(" ");

	    StringBuilder builder = new StringBuilder();
	    builder.append(parts[parts.length - 1]);

	    for (int i = parts.length - 2; i >= 0; --i) {
	        builder.append(" ").append(parts[i]);
	    }

	    return builder.toString();
	}
	//method for part 2
	private static String StringRevLet(String sentence) {
		 	String reverse = null;
	        String stringReversed = "";
	        Stack<String> stack= new Stack<String>();
	        sentence.split(" ");
	        for(int i=0;i<sentence.length(); i++)
	        {
	            stack.push(sentence.substring(i, i+1));
	        }

	        while(!stack.isEmpty())
	        {
	            stringReversed += stack.pop();
	        }

	        System.out.println("Reverse is: " + stringReversed);


	        return reverse;
	}
	

}
