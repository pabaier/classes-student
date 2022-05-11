
/**
 * creates a 0 value and can increment it by 1 each time
 *
 * @author Jacob Mattox
 * @version 11-13-17
 */
public class SequentialIncrementer implements Incrementable
{
    //instance variable
    private int value;
    
    //constructor
    public SequentialIncrementer(){ 
        value = 0;
    }
    //overridden methods
    public void increment(){
        value++;
    }
    public int getValue(){
        return value;
    }
}
