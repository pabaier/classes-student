import java.util.Random;
/**
 * class RandomIncrementer - stores a value, generated randomly, replacing it with another value generated randomly when the increment method is called.
 *
 * @author Richard Marshall
 * @version 11/1717
 */
public class RandomIncrementer implements Incrementable
{
    // instance variables - replace the example below with your own
    private int value;

    /**
     * Constructor for objects of class RandomIncrementer
     */
    public RandomIncrementer()
    { 
        value = new Random().nextInt(); //this initializes value to a random int
    }

    /**
     * increment - replaces value with another random int.
     */
    @Override
    public void increment()
    {
        value = new Random().nextInt();
        return;
    }
    
    @Override
    public int getValue() {
        return value;
    }
}
