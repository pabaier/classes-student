//Ryan Barrett
//keeps incrementing a value from 0
public class SequentialIncrementer implements Incrementable {
	int value;
	public SequentialIncrementer() {value = 0;}
	@Override
	public void incrementable() {value++;}
	@Override
	public int getValue() {return value;}
}