import java.util.Random;
/**
 * Creates a random number and can change that to another random number
 *
 * @author Jacob Mattox
 * @version 11-13-17
 */
public class RandomIncrementer implements Incrementable
{
    //instance variables
    private Random random;
    private int value;
    //constuctor
    public RandomIncrementer(){
        random = new Random();
        value = random.nextInt();
    }
    //overridden methods
    public void increment(){
        value = random.nextInt();
    }
    public int getValue(){
        return value;
    }
}
