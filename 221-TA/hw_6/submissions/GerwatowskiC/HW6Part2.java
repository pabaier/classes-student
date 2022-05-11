
/**
 * Test driver for SequentialIncrementer and RandomIncrementer
 *
 * Claire Gerwatowski
 */
public class HW6Part2
{
    public static void main(String [] args)
    {
        SequentialIncrementer si = new SequentialIncrementer();
        System.out.println("SequentialIncrementer: value = " + si.getValue());
        si.increment();
        System.out.println("Incremented once: value = " + si.getValue());
        si.increment();
        System.out.println("Incremented twice: value = " + si.getValue());
        System.out.println("");
        
        RandomIncrementer ri = new RandomIncrementer();
        System.out.println("RandomIncrementer: value = " + ri.getValue());
        ri.increment();
        System.out.println("Incremented once: value = " + ri.getValue());
        ri.increment();
        System.out.println("Incremented twice: value = " + ri.getValue());
        System.out.println("");
        
        RandomIncrementer ri2 = new RandomIncrementer();
        System.out.println("RandomIncrementer: value = " + ri2.getValue());
        ri2.increment();
        System.out.println("Incremented once: value = " + ri2.getValue());
        ri2.increment();
        System.out.println("Incremented twice: value = " + ri2.getValue());
    }
}
