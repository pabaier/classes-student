
/**
 * derives Incrementable for a random number and randomly increments it.
 *
 * @Dustin Cragg
 * @11/17/2017
 */
import java.util.Random;
public class RandomIncrementer implements Incrementable
{
    Random rand = new Random();
    int randInt = rand.nextInt(2147483647);
   public void Increment()
  {
      //randomly increments number
      randInt = rand.nextInt(2147483647);
  }
  public int getValue()
  {
      //returns number
      return randInt;
  }
}
