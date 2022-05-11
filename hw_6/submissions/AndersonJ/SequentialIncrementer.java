
/**
 * Jonathan Anderson
 * Increments value by one after every increment()
 */
public class SequentialIncrementer implements Incrementable
{
    private int i;
    public SequentialIncrementer()
    {
       i = 0;
    }
    
    public int increment(){
        i = i + 1;
        return i;
    }
    public int getValue(){
        return this.i;
    }
}
