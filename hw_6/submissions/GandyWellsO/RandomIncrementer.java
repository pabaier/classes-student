import java.util.Random;
/**
 *Orianna Gandy-Wells
 *
 *This class is derived from the interface Incrementable
 *and allows for random incrementing of a number and to
 *then return that value
 */
public class RandomIncrementer implements Incrementable
{
    private int num;
    
    public RandomIncrementer()
    {
        Random rand = new Random();
        num = rand.nextInt();
        
       
    }

    public void increment(){
       Random rand = new Random();
       num = rand.nextInt(); 
   }
    public int getValue(){
       return num;
   }
}
