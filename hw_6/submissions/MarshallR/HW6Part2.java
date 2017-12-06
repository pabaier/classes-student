
/**
 * A test driver for the classes which implement Incrementable
 *
 * @author Richard Marshall
 * @version 11/17/17
 */
public class HW6Part2
{
   public static void main() {
       SequentialIncrementer seq = new SequentialIncrementer();
       RandomIncrementer rand = new RandomIncrementer();
       
       System.out.println("The value of the SequentialIncrementer before incrementing is: " + seq.getValue());
       seq.increment();
       System.out.println("After one time: " + seq.getValue());
       seq.increment();
       System.out.println("After two times: " + seq.getValue());
       
       System.out.println();
       
       System.out.println("The value of the RandomIncrementer before incrementing is: " + rand.getValue());
       rand.increment();
       System.out.println("After one time: " + rand.getValue());
       rand.increment();
       System.out.println("After two times: " + rand.getValue());
       return;
    }
}
