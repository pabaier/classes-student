
/**
 * RandomIncrementer
 * randomly incriments a value
 * Ashley Woods
 */
import java.util.Random;
public class RandomIncrementer implements Incrementable
{
    int value;
    Random rand = new Random();
    
    public RandomIncrementer(){
        value = rand.nextInt();
    }
    
    public void increment(){
        value = rand.nextInt();
    }
    
    public int getValue(){
        return value;
    }
}
