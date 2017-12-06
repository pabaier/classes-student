
/**
 * Ariel Robinson
 * implements the Incrementable interface
 * returns an number that is randomly incremented, the value can also be
 * returned
 */
import java.util.Random;
public class RandomIncrementer implements Incrementable
{
    // instance variables 
    private int x=0;
    Random rand= new Random();

    /**
     * Constructor for objects of class RandomIncrementer
     */
    public RandomIncrementer()
    {

        x = rand.nextInt();
    }
    //increments the number randomly
    public void increment()

    {

        x=rand.nextInt();

    }
    //returns the value

    public int getValue(){
        return x;
    }
}
