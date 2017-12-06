
/**
 * Value starts as a random integer.  When incremented, value changes to a new random
 * integer
 *
 * Jonathan Rabiu
 * 
 */
import java.util.Random;
public class RandomIncrementer implements Incrementable
{
    private int val;
    Random randNum = new Random();
    public RandomIncrementer(){
       val = randNum.nextInt(); 
    }
    
    @Override 
    public void increment(){
        val ++;
        val = randNum.nextInt(); 
    }
    @Override 
    public int getValue(){
        return val;
    }
    
}
