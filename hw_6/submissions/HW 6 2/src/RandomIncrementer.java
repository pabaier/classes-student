//@author: Stefan Veloff;
//CSCI 221:HW6Part2
//This is a program that produces a random int
//I discussed this homework assignment with: CSCI tutors (Daniel & Anthony), Paul B. & Kyle W. 
//import statement:
import java.util.Random;

//RandomIncrementer:
public class RandomIncrementer implements Incrementable{

	private Random random = new Random();
	private int value = random.nextInt();
	
	public void increment() {
		value = random.nextInt();
	}
	public int getValue() {
		return value;
	}
}
