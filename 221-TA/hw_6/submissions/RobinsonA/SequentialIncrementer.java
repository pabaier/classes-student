
/**
 * Ariel Robinson
 *
 * implements the Incrementable interface
 * returns a number incremented by 1
 * 
 */
public class SequentialIncrementer implements Incrementable
{
    private int x;

    /**
     * Constructor for objects of class SequentialIncrementer
     */
    public SequentialIncrementer(int x)
    {
        this.x=x;
        x=0;

    }
    //increments x
    public void increment()
    {
        x++;
    }

    //returns x

    public int getValue(){
        return x;
    }
}
