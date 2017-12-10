/*
 * Generates and increments a random number using the methods that implents Incrementable
 * Author: Mary Washington
 * Version: Eclipse Oxygen 4.7
 */

import java.util.Random;
public class RandomIncrementer implements Incrementable{
	private Random randGen = new Random();
	private int x = 0;
	
	public RandomIncrementer() {
		
		x = randGen.nextInt();
	}
	
	//overrides method in Incrementable
	@Override
	public void increment() {
		
		x = randGen.nextInt();
	}
	
	//overrides method in Incrementable
	@Override
	public int getValue() {
		
		return x;
	}


	

}
