/**
 * Incrementer which starts with a random int and changes to a random int every increment call
 * 
 * @author Carson Barber
 */
import java.util.Random;
public class RandomIncrementer implements Incrementable
{
    Random rand = new Random();
    int intVal;
    public RandomIncrementer()
    {
        intVal = rand.nextInt();
    }
    public void increment(){
        intVal = rand.nextInt();
    }
    public int getValue(){
        return intVal;
    }
}
