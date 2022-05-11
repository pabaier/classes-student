
/**
 * derives incrementable, sets number to 0 and increments it by one every time.
 *
 * @Dustin Cragg
 * @11/17/2017
 */
public class SequentialIncrementer implements Incrementable
{
  int incremented = 0;
  public void Increment()
  {
      //increments variable
      ++incremented;
  }
  public int getValue()
  {
      //returns variable
      return incremented;
  }
}
