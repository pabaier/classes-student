
/**
 * Write a description of class RandomIncrementer here.
 *
 * Steven Higgins
 * 
 */
import java.util.Random;
public class RandomIncrementer implements Incrementable
{
    private int value;
    private Random rand = new Random();
    public RandomIncrementer()
    {
        this.value = rand.nextInt();  
    }
    public int getValue(){
        return value;
    }
    public void increment(){
        
        value = rand.nextInt();
    }
}
