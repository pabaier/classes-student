/*
 * Sydney Jackson
 * HW6Part2 tests Sequential and Random Incrementers that implement interface
 * Incrementable
 */
public class HW6Part2{
    public static void main(String[] args){
        SequentialIncrementer val1 = new SequentialIncrementer();
        val1.increment();
        System.out.println("SequentialIncrementer = " + val1.getValue());
        
        RandomIncrementer val2 = new RandomIncrementer();
        val2.increment();
        System.out.println("RandomIncrementer = " + val2.getValue());
        RandomIncrementer val3 = new RandomIncrementer();
        val3.increment();
        System.out.println("RandomIncrementer2 = " + val3.getValue());
        
    }
}