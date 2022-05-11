/*
 * Tyler Gray
 * Increments value by 1 each time its called to increment
 * implements the Icrementable interface
 */
public class SequentialIncrementer implements Incrementable {

	private int value;
	
	public SequentialIncrementer() {
		value = 0;
	}

	@Override
	public void increment() {
		value++;

	}

	@Override
	public int getValue() {
		return value;
	}

}
