import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Arrays;
import java.io.PrintStream;
import java.io.OutputStream;

public class SubmissionTest {
	
	public static final int NUM_PLAYERS = 5;   
	public static int[] jerseyNumber = {84, 23, 4,  30, 66};
	public static int[] rating = {7, 4, 5, 2, 9};
	public static Scanner input;
		
	

	public static		  int updateJNumber = 0;
	public static		  int updateRating = 0;
	public static		  int compareRate = 0;
				
	
	
	
	public static void main(String args[]){
		runTest1();
		System.out.println();
		reset();
		
		runTest2();
		reset();
		runTest3();
	
	}
		
	public static void test1() {
		char userInput = 'u';
		
		
         if (userInput == 'u'){
             System.out.print("Enter a jersey number:");
             updateJNumber = input.nextInt();
             System.out.println(updateJNumber);
             
             for (int i = 0; i < NUM_PLAYERS; i++){
                if (jerseyNumber[i] == updateJNumber) {
                   System.out.print("Enter a new rating for player: ");
                   updateRating = input.nextInt();
                   System.out.println(updateRating);
                   rating[i] = updateRating;
                } 
             }
             System.out.println("Jersey number: " + updateJNumber + ", Rating: "+ updateRating);
          }

		  
		  
	}
	////////////////////////////////////////////////////////////////
	
	public static void test2() {
		char userInput = 'a';
		
          if (userInput == 'a'){
             System.out.println("Enter a rating: ");
             compareRate = input.nextInt();
             System.out.println();
             System.out.println("Above" +compareRate);
             for (int i = 0; i < NUM_PLAYERS; i++){
                if (rating[i] > compareRate) {

                  System.out.println("Player " + (i +1) + " -- Jersey number: " + jerseyNumber[i] + ", Rating: "+ rating[i]);

                }
             }
          }
		  
		  
	}
	
	////////////////////////////////////////////////////////////////
	
	public static void test3() {
		char userInput = 'r';
			
           if (userInput == 'r'){
             System.out.print("Enter a jersey number :");
             updateJNumber = input.nextInt();
             System.out.println(updateJNumber);     
            for (int i = 0; i < NUM_PLAYERS; i++) {
               if (jerseyNumber[i] == updateJNumber){
                  System.out.println("Enter a new jersey number:");
                  int newJNumber = input.nextInt();
                  System.out.println("Enter a rating for the new player:");
                  int newRating = input.nextInt();
                  //rating[i] =
               }
            }
          }
            
				   
	}
	
	public static void runTest1() {
		
		// test 1 input
		int[] testOne = {84, 9, 
							1, 0, 
							23, 30,
							30, 1,
							20, 0,
							66, 15};
		
		String test = Arrays.toString(testOne);
		test = test.replaceAll(", ", "\n");
		test = test.replace("[", "");
		test = test.replace("]", "");
		
		PrintStream oldOut = System.out;
		System.setOut(new PrintStream(new ByteArrayOutputStream()));
		
		input = new Scanner(test);
		while(input.hasNext()) {
			test1();
		}

		System.setOut(oldOut);
		print();
	}
	
	public static void runTest2() {
	
		// test 2 input
		int[] testOne = {1,4,7,10,9,8,6,5,3,2};
		
		String test = Arrays.toString(testOne);
		test = test.replaceAll(", ", "\n");
		test = test.replace("[", "");
		test = test.replace("]", "");
		
		// PrintStream oldOut = System.out;
		// System.setOut(new PrintStream(new ByteArrayOutputStream()));
		
		input = new Scanner(test);
		while(input.hasNext()) {
			test2();
		}

		// System.setOut(oldOut);
		// print();
	}
	
	public static void runTest3() {
		// test 3 input
		int[] testOne = {	30, 7, 66,
							23, 10, 9,
							8, 0, 0,
							4, 5, 10,
							7, 2, 9,
							4, 0, 0
							};
		
		String test = Arrays.toString(testOne);
		test = test.replaceAll(", ", "\n");
		test = test.replace("[", "");
		test = test.replace("]", "");
		
		PrintStream oldOut = System.out;
		System.setOut(new PrintStream(new ByteArrayOutputStream()));
		
		input = new Scanner(test);
		while(input.hasNext()) {
			test3();
		}

		System.setOut(oldOut);
		print();
	}
	

	
	// resets jerseyNumber and rating arrays to original values
	public static void reset() {		
		int[] jerseyNumberDefault = {84, 23, 4,  30, 66};
		int[] ratingDefault= {7, 4, 5, 2, 9};
		
		for(int i = 0; i < jerseyNumber.length; i++) {
				jerseyNumber[i] = jerseyNumberDefault[i];
				rating[i] = ratingDefault[i];
		}
	}
	
	// prints jerseyNumber and rating as is
	public static void print() {
		System.out.print("[");
		for(int i = 0; i < jerseyNumber.length - 1; i++)
			System.out.print(jerseyNumber[i] + ", ");
		System.out.print(jerseyNumber[jerseyNumber.length - 1] + "]");
		
		System.out.println();
		
		System.out.print("[");
		for(int i = 0; i < rating.length - 1; i++)
			System.out.print(rating[i] + ", ");
		System.out.print(rating[rating.length - 1] + "]");
		System.out.println();

	}
}