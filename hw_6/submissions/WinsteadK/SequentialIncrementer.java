/*
 * Name: Kyle Winstead
 */
public class SequentialIncrementer implements Incrementable{
	
	double value = 0;
	
	public void increment() {
		value = value + 1;
	}
	
	public double getValue() {
		return value;
	}
}
