
/**
 * When first created, value is zero.  When incremented it goes up by one.
 *
 * Jonathan Rabiu
 * 
 */
public class SequentialIncrementer implements Incrementable
{
  private int val;
  public SequentialIncrementer(){
      val = 0;  
  }
  @Override
  public void increment(){
      val ++; 
   }
  @Override
  public int getValue(){
      return val;
   }
  
}
