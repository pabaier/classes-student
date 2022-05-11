import java.util.Scanner;

public class HW1Part2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter first number.");
		String firstNum = sc.next();

		// transform first entered string into char array
		char[] FirstCharArray = firstNum.toCharArray();

		// use for loop with Unicode Table to check if numeric or not
		// display ERROR if not numeric input and end program.
		for (int i = 0; i < FirstCharArray.length; i++) {
			if ((int) FirstCharArray[i] < 48 || (int) FirstCharArray[i] > 57) {
				System.out.println("Error: You are only allowed to enter numeric values!");
				return;
			}
		}

		System.out.println("Enter second number.");
		String secondNum = sc.next();

		// transform second entered string into char array
		char[] SecondCharArray = firstNum.toCharArray();

		// use for loop with Unicode Table to check if numeric or not
		// display ERROR if not numeric input and end program.
		for (int i = 0; i < SecondCharArray.length; i++) {
			if ((int) SecondCharArray[i] < 48 || (int) SecondCharArray[i] > 57) {
				System.out.println("Error: You are only allowed to enter numeric values!");
				return;
			}
		}
		
		// call on method to add the 2 Strings, and print out the result
		add(firstNum, secondNum);
	}

	// Method to print the final answer
	public static void add(String a, String b) {
		// at maximum length of the final answer "MaxAnswerLength", the "+1" is intended
		// for when the length of the number increases
		// Example: if you add 400 + 600 = 1000, so length 3 turns to length 4
		int MaxAnswerLength = 1 + Math.max(a.length(), b.length());
		int[] answer = new int[MaxAnswerLength];
		int[] arrayA = new int[MaxAnswerLength];
		int[] arrayB = new int[MaxAnswerLength];

		// loop to insert characters of "String a" into arrayA
		// while having a leading zero / or several zeros, 
		//(this zero is needed for carrying).
		// here i force both arrays (arrayA and arrayB) to have the same length, with
		// leading zeros if necessary
		for (int i = MaxAnswerLength, j = a.length(), c = 0; j > 0; i--, j--, c++)
			arrayA[i - 1] = a.charAt(a.length() - 1 - c) - '0'; // '0' casts it to an int

		// loop to insert characters of "String b" into arrayB
		// while having a leading zero / or several zeros, 
		//(this zero is needed for carrying).
		// here i force both arrays (arrayA and arrayB) to have the same length, with
		// leading zeros if necessary
		for (int i = MaxAnswerLength, j = b.length(), c = 0; j > 0; i--, j--, c++)
			arrayB[i - 1] = b.charAt(b.length() - 1 - c) - '0'; // '0' casts it to an int

		int carryCounter = 0; // counter is for carry

		// Calculation of each Index position
		for (int i = MaxAnswerLength; i > 0; i--) {
			answer[i - 1] = carryCounter + (arrayA[i - 1]) + (arrayB[i - 1]);

			if (carryCounter > 0)
				carryCounter--;

			// carry if number bigger than 9
			if (answer[i - 1] > 9) {
				answer[i - 1] -= 10;
				++carryCounter;
			}

		}

		// if leading number is a 0, don't print the 0
		// Ex: 0123 turns to 123
		if (answer[0] == 0) {
			for (int i = 1; i < MaxAnswerLength; i++) {
				System.out.print(answer[i]);
			}
		} else
			for (int i = 0; i < MaxAnswerLength; i++) {
				System.out.print(answer[i]);
			}

	}

}
