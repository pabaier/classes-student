//Ryan Barrett
//creates a random value within 1-100
public class RandomIncrementer implements Incrementable {
	int value;
	public RandomIncrementer() {value = (int)(Math.random() * 100) + 1;}
	@Override
	public void incrementable() {value = (int)(Math.random() * 100 + 1);}
	@Override
	public int getValue() {return value;}
}