
/**
 * Increments a randomly generated number.
 *
 * Claire Gerwatowski
 */
import java.util.Random;
public class RandomIncrementer implements Incrementable
{
    private int value;
    public RandomIncrementer()
    {
        Random rand = new Random();
        value = rand.nextInt();
    }
    
    public void increment() 
    {
        value += 1;
    }
    
    public int getValue()
    {
        return value;
    }
}
