
/**
 * Increments a value starting at 0
 *
 * Claire Gerwatowski
 */
public class SequentialIncrementer implements Incrementable
{
    private int value;
    
    public SequentialIncrementer() 
    {
        value = 0;
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
