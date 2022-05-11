/*
 * Name: Kyle winstead
 */
public class RandomIncrementer implements Incrementable{
	
	double value;
	public void increment() {
		this.value=(int)(Math.random()*1000);
		value = value + (int)(Math.random()*1000);
	}

	public double getValue() {
		return value;
	}
}
