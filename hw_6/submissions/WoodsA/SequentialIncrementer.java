
/**
 * SequentialIncrementer
 *incriments a value by one
 *
 * Ashley Woods
 */
public class SequentialIncrementer implements Incrementable
{
    int value;
    public SequentialIncrementer(){
        value = 0;
    }
    
    public void increment(){
        value++;
    }
    
    public int getValue(){
        return value;
    }
}
