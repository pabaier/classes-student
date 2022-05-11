/*Tyler Gray
 * HW1Part1
 * Counts the number of syllables
 * Calculated by checking for indexes of vowels and calculating from that
 * 
 * 
 * 
 * 
 * 
 * 
 */

// package edu.cofc.tylergray;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;



public class HW1Part1 {
	
	//Declare Vars
	private static String userInput;
	private static int sylCount;
	private static String vowels = "aeiouy";
	private ArrayList<Integer> indOfVow[];

	
	//Main Function
	public static void main(String[] args) {
		//Instantiate Objs
		ArrayList<Integer> indOfVow = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		
		//Get User Input
		userInput = getUserInput();
		//System.out.println("Please enter a word");
		//userInput = sc.nextLine();
		//userInput = userInput.trim();
		//userInput = userInput.toLowerCase();
		//Check if word is valid and reask for user input
		while(!isValidWord(userInput)) {
			System.out.println("ERROR: THE WORD YOU ENTERED CONTAINED ILLEGAL CHARACTERS");
			userInput = getUserInput();
			//System.out.println("Please enter a VALID word");
			//userInput = sc.nextLine();
			//userInput = userInput.trim();
			//userInput = userInput.toLowerCase();
		}
		
		//Loop through to find vowels
		for(int i = 0; i < userInput.length(); i++) {
			//System.out.println(userInput.charAt(i));
			if(vowels.indexOf(userInput.charAt(i)) != -1) {
				//If its a vowel, adds its index
				//System.out.println("Adding");
				indOfVow.add(i);
			}
			
			
			
		}//End For
		//Needed for appropriate calculations
		indOfVow.add(0);
		//See if vowels are consecutive or not
		for(int i = 0; i < indOfVow.size()-1; i++) {
			//System.out.println("Checking " + indOfVow.get(i) + " to " + indOfVow.get(i+1));
			if(indOfVow.get(i) != (indOfVow.get(i+1)-1)) {
				//System.out.println(indOfVow.get(i));
				//System.out.println(indOfVow.get(i)+1);
				//System.out.println("ADding to sylCount");
				//If the vowels aren't next to each other, add to sylCount
				sylCount ++;
			}
			
		}
		//Check for ending in e
		if(userInput.charAt(userInput.length()-1) == 'e' && vowels.indexOf(userInput.charAt(userInput.length()-2)) == -1) {
			//System.out.println(userInput.charAt(userInput.length()-1) + " " + userInput.charAt(userInput.length()-2) );
			//System.out.println(userInput.charAt(userInput.length()-1) == 'e');
			//System.out.println(vowels.indexOf(userInput.charAt(userInput.length()-2)) == -1);
			sylCount--;
		}
		//Can't allow sylCount to be 1
		if(sylCount == 0) {
			sylCount++;
		}
		//System.out.println(indOfVow);
		//Print out the number of syllables
		System.out.printf("%s has %d syllable(s)\n", userInput, sylCount);
		

	} 
	//Checks for validity of word being entered
	public static boolean isValidWord(String s) {
	
		for(int i = 0; i < s.length() ; i++) {
			if(s.charAt(i) > 'z' || s.charAt(i) < 'a') {
				return false;
			}
		}
		return true;
	}
	
	//Gets the users input and cleans it up
	public static String getUserInput() {
		String s = "";
		Scanner sc = new Scanner(System.in);	
		//Get User Input
		System.out.println("Please enter a word");
		s = sc.next();
		s = s.trim();
		s = s.toLowerCase();
		
		return  s;
	}

}
