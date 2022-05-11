/*
 * Does an increment by 1 and uses methods that is implemented in Incrementable
 * Author: Mary Washington
 * Version: Eclipse Oxygen 4.7
 */
public class SequentialIncrementer implements Incrementable {

	private int a;
	
	public SequentialIncrementer() {
		
		a = 0;
	}
	
	//overrides method in Incrementable
	@Override
	public void increment() {
		a++;
	}
	
	//overrides method in Incrementable
	@Override
	public int getValue() {
		return a;
	}

}
