import java.util.Random;
/**
 * Write a description of class RandomIncrementer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RandomIncrementer implements Incrementable
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class RandomIncrementer
     */
    public RandomIncrementer()
    {
        Random randGen = new Random();
        x = randGen.nextInt();
    }

    public void increment(){
        Random randGen = new Random();
        x = randGen.nextInt();
    }
    public int getValue(){
        return x;
    }
}
