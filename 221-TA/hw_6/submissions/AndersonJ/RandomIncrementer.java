

/**
 * Jonathan Anderson
 * Gives a random number after incremented
 */
import java.util.Random;
public class RandomIncrementer implements Incrementable
{
    int randVal;
    Random rand = new Random();
    public RandomIncrementer()
    {
        randVal = rand.nextInt();
    }
    public int increment(){
        randVal = rand.nextInt();
        return randVal;
    }
    public int getValue(){
        return this.randVal;
    }
}
