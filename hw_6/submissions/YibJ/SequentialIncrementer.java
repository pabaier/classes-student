
/**
 * SequentialIcrementer increments the value by one 
 *
 * Julie Yib
 * 
 */
public class SequentialIncrementer implements Incrementable
{
    private int value;
    
    public void increment(int inc){
        inc++;
        value = inc;
    }
    
    public int getValue(){
        return value;
    }
}
