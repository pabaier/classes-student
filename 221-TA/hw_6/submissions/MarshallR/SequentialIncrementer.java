
/**
 * class SequentialIncrementer - stores a value starting at zero which counts up by one each time the increment method is called.
 *
 * @author Richard Marshall
 * @version 11/17/17
 */
public class SequentialIncrementer implements Incrementable
{
    private int value; //the value the incrementer is at. This starts at 0;

    /**
     * Constructor for objects of class SequentialIncrementer
     */
    public SequentialIncrementer()
    {
        this.value = 0;
    }

    /**
     * increment - adds one to value.
     */
    @Override
    public void increment() {
        value++;
        return;
    }
    
    @Override
    public int getValue() {
        return value;
    }
}
