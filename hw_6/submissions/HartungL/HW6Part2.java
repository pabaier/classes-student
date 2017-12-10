
/**
 * class HW6Part2 - Tests all of the classes that impliment 
 * Incrementable
 *
 * @author Lexus Hartung
 */
public class HW6Part2
{
    public static void main(String[] args){
        SequentialIncrementer seq = new SequentialIncrementer();
        RandomIncrementer rand = new RandomIncrementer();
        
        //Test SequentialIncrementer run 10 times
        for(int i = 0; i < 10; ++i){
            seq.increment();
            System.out.println("Sequential Incrementer ran " + (i + 1) + " times " 
            + seq.getValue()); 
        }
        
        //Test RandomIncrementer run 10 times
        for(int j = 0; j < 10; ++j){
            rand.increment();
            System.out.println("Random Incrementer ran " + (j + 1) + " times " +
            rand.getValue());
        }
    }
}
