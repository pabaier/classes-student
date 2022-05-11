
/**
 * Write a description of class SequentialIncrementer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SequentialIncrementer implements Incrementable
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class SequentialIncrementer
     */
    public SequentialIncrementer()
    {
        this.x = 0;
    }

    public void increment(){
        ++x;
    }
    public int getValue(){
        return x;
    }
}
