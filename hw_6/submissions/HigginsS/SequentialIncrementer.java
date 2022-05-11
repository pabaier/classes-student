
/**
 * Write a description of class SequentialIncrementer here.
 *
 * Steven Higgins
 * 
 */
public class SequentialIncrementer implements Incrementable
{
    private int value;
    public SequentialIncrementer(int value)
    {
        this.value = value;
    }
    public int getValue(){
        return value;
    }
    public void increment(){
        value = value + 1;
    }

}
