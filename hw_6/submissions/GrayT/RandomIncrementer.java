/*Tyler Gray
 * RandomIncrementer implements interface to give a random int each time its incremented
 */
import java.util.Random;

public class RandomIncrementer implements Incrementable {

	private int value;
	private Random rand = new Random();
	public RandomIncrementer() {
		value = rand.nextInt();
	}

	@Override
	public void increment() {
		value = rand.nextInt();

	}

	@Override
	public int getValue() {
		return value;
	}

}
