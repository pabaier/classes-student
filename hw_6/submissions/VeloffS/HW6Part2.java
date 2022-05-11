//@author: Stefan Veloff;
//CSCI 221:HW6Part2 driver:
//This is a program which is our test driver for RandomIncrementer and SequentialIncrementer:
//I discussed this homework assignment with: CSCI tutors (Daniel & Anthony), Paul B. & Kyle W. 

public class HW6Part2 {

	public static void main(String[] args) {
		SequentialIncrementer sequential = new SequentialIncrementer();
		
		//print statement:
		System.out.println("SequentialIncrementer test: ");
		//for loop to test out SequentialIncrementet:
		int i = 0;
		for(i = 0; i < 6; i++) {
			sequential.increment();
			//print statement of sequential values:
			System.out.println(sequential.getValue());
		}
		
		//print statement for neatness:
		System.out.println("------------------------");
		RandomIncrementer randomNum = new RandomIncrementer();
		//print statement:
		System.out.println("RandomIncrementer test:");
		//for loop to test out RandomIncrementer:
		for(int j = 0 ; j < 6; j++) {
			randomNum.increment();
			//print statement of randomNum:
			System.out.println(randomNum.getValue());	
		}

	}

}
