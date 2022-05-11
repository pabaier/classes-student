
/**
 * Jonathan Anderson
 * Test driver for HW6Part2
 */
public class HW6Part2
{
    public static void main(String[] args){
      Incrementable incr1 = new SequentialIncrementer();
      Incrementable incr2 = new RandomIncrementer();
      
      incr1.increment();
      System.out.println(incr1.getValue());
      incr1.increment();
      System.out.println(incr1.getValue());
      incr1.increment();
      System.out.println(incr1.getValue());
      incr2.increment();
      System.out.println(incr2.getValue());
      incr2.increment();
      System.out.println(incr2.getValue());

    }
}