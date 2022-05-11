/*Tyler Gray
 * HW1Part2
 * Calculates two strings being added together alphanumerically
 * 
 * 
 * 
 * 
 * 
 * 
 */
// package edu.cofc.tylergray;


import java.util.Scanner;

public class HW1Part2 {

	public static void main(String[] args) {
		//Variables
		boolean num1Valid = false;
		boolean num2Valid = false;
		String num1 = "";
		String num1Show = "";
		String num2 = "";
		String num2Show = "";
		String total = "";
		
		//Instantiates Objects
		Scanner sc = new Scanner(System.in);
		//Get User Input
		while(!num1Valid) {
			System.out.println("Please enter the first number for calculation");
			num1 = sc.nextLine();
			num1Show = num1;
			if(checkIfAllDigits(num1)) {
				num1Valid = true;
			}
			else {
				System.out.println("ERROR: INPUT WASN'T A VALID NUMBER");
				
			}
		}
		while(!num2Valid) {
			System.out.println("Please enter the second number for calculation");
			num2 = sc.nextLine();
			num2Show = num2;
			if(checkIfAllDigits(num2)) {
				num2Valid = true;
			}
			else {
				System.out.println("ERROR: INPUT WASN'T A VALID NUMBER");
				
			}
		}
		if(num1.length() == num2.length()) {
			//No need to pad with zeroes1
		}
		else if(num1.length() < num2.length()) {
			num1 = padWithZero(num1, num2.length()-num1.length());
		}
		else {
			num2 = padWithZero(num2, num1.length()-num2.length());
		}
		  
		//System.out.println(num1 + "\n" + num2);
		boolean carOv = false;
		for(int i = num1.length()-1; i >= 0 ; i--) {
			int temp1 = Character.getNumericValue(num1.charAt(i));
			int temp2 = Character.getNumericValue(num2.charAt(i));
			int tempTot;
			//Check for carry over
			if(carOv) {
				tempTot = temp1 + temp2 + 1;
			}
			else {
				tempTot = temp1 + temp2;
			}
			if(tempTot > 9) {
				carOv = true;
				tempTot = tempTot % 10;
			}
			else {
				carOv = false;
			}
			total = Integer.toString(tempTot) + total;
		}
		if(carOv) {
			total = "1" + total;
		}
		
		System.out.printf("%s plus %s equals %s\n", removeZeros(num1), removeZeros(num2), removeZeros(total) );
		

	}//End Main
	
	public static boolean checkIfAllDigits(String s) {
		
		if(s.length() == 0) {
			return false;
		}
		//Loop through String
		for(int i = 0; i < s.length(); i++) {
			if(!Character.isDigit(s.charAt(i))) {
				//If it isnt a digit, return false
				return false;
			}//End If
		}//End For
		return true;
	}//End CheckIfAllDigits
	
	public static String padWithZero(String s, int length) {
		
		String zeros = "0";
		for(int i = 0; i < length-1; i++) {
			zeros += '0';
		}
		return zeros + s;
	}
	
	public static String removeZeros(String s) {
		
		for(int i = 0; i < s.length() ; i++) {
			if(s.charAt(i) != '0') {
				return s.substring(i);
			}
		}
		return "0";
	}

}//End Class
