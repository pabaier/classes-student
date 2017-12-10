
/**
 * testing the interface methods
 *
 * Julie Yib
 * 
 */
public class HW6Part2
{
    public static void main(String [] args){
        SequentialIncrementer si1 = new SequentialIncrementer();
        si1.increment(10);
        System.out.println(si1.getValue());
        
        RandomIncrementer ri1 = new RandomIncrementer();
        ri1.increment(1);
        System.out.println(ri1.getValue());
        
        SequentialIncrementer si2 = new SequentialIncrementer();
        System.out.println(si2.getValue());
        si2.increment(7);
        System.out.println(si2.getValue());
    }
    
}
