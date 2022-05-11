
/**
 * SequentialIncrementor increments a number by 1 when increment is called.
 *
 * @author Andrea Lingenfelter
 * @version 11/15/17
 */
public class SequentialIncrementer implements Incrementable{
    // instance variables - replace the example below with your own
    private int n = 0;

    
    public SequentialIncrementer(){
        this.n = n;
    }

    
    public int increment(){
        n = n+ 1;
        return n;
    }
    
    public int getValue(){
        return n;
    }
}
