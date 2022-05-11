
/**
 * Orianna Gandy-Wells
 * 
 * This class is derived from the Incrementable
 * interface and allows for incrementation of a 
 * number and to return that number
 */
public class SequentialIncrementer implements Incrementable
{
    private int num;
   public SequentialIncrementer()
   {
        int num = 0;
   }
    public void increment(){
       num++; 
   }
    public int getValue(){
       return num;
   }
}
