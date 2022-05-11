//This is a program to convert a string into an int that does basic addition:
//I discussed this with Paul B. (for loops to check at position i) , && 
//Angelica, and Kyle from our class (pseudocode on how to start this program)
//NO answers were directly given in any shape or form. I found this through reading Java's API online(link listed): 



//import statement:
import java.util.Scanner;


//class named HW1Part2:
public class HW1Part2 {

	//main():
	public static void main(String[] args) {
	//numOne as a string:
	String numOne = "";
	//numTwo as a string:
	String numTwo = "";
	//Scanner:
	Scanner number = new Scanner(System.in);
	
	//print statement:
	System.out.println("Enter a number: ");
	//gets the next number the user has entered:
	numOne = number.next();
	//print statement:
	System.out.println("Enter a second number: ");
	//gets the next number the user has entered:
	numTwo = number.next();
	//if statement: if the length of numOne && numTwo are greater than 0:
	if (numOne.length() >= 0 && numTwo.length() >= 0) {
		//I found this online while reading the API for java. This is called casting. 
		//This class aso can convert an int to a string and a string into an int as well
		//https://docs.oracle.com/javase/7/docs/api/java/lang/Integer.html:
		int digi1 = Integer.parseInt(numOne);
		int digi2 = Integer.parseInt(numTwo);
	
	//print statement:	
	System.out.println(digi1+digi2);

}

	}

}
