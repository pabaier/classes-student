
/**
 * RandomIncrementer- produces a random integer when called
 *
 * Julie Yib
 * 
 */
import java.util.Random;
public class RandomIncrementer implements Incrementable
{
   private int value;
    
   public void increment(int inc){
       Random rand = new Random();
       value = rand.nextInt();
    }
    
   public int getValue(){
       return value;
   }
}
