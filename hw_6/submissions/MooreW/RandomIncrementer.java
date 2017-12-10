//Elex Moore
import java.util.Random;
public class RandomIncrementer implements Incrementable{
	private int raValue = 0;
	@Override
	public void increment(int value) {
		raValue += value;
		Random rValue = new Random();
		raValue += rValue.nextInt();
		
	}
	
	public int getValue(){
		return raValue;
	}

}
