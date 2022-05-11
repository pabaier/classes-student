
/**
 * RandomIncrementer increments a random int to another random int each time increment method is called.
 *
 * @author Andrea Lingenfelter
 * @version 11/16/17
 */


public class RandomIncrementer implements Incrementable{
    private int n = (int) Math.floor(Math.random() * Integer.MAX_VALUE);

    public RandomIncrementer(){
        this.n = n;
    }

    
    public int increment(){
        n = (int) Math.floor(Math.random() * Integer.MAX_VALUE);
        return n;
    }
    
    public int getValue(){
        return n;
    }
}
