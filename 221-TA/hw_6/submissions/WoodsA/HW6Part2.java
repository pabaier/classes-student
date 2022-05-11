
/**
 * HW6Part2
 * Tests the incrementer classes
 *
 * Ashley Woods
 */
public class HW6Part2
{
    public static void main(String[] args){
        System.out.println("Testing SequentialIncrementer: ");
        Incrementable I1 = new SequentialIncrementer();
        System.out.println("Origional Value: " + I1.getValue());
        I1.increment();
        System.out.println("Value after increment is run once: " + I1.getValue());
        I1.increment();
        System.out.println("Value after increment is run twice: " + I1.getValue());
        I1.increment();
        System.out.println("Value after increment is run three times: " + I1.getValue());
        I1.increment();
        System.out.println("Value after increment is run four times: " + I1.getValue());
        I1.increment();
        System.out.println("Value after increment is run five times: " + I1.getValue());
        System.out.println();
        
        
        System.out.println();
        System.out.println("Testing RandomIncrementer:");
        Incrementable I2 = new RandomIncrementer();
        System.out.println("Origional Value: " + I2.getValue());
        I2.increment();
        System.out.println("Value after increment is run once: " + I2.getValue());
        I2.increment();
        System.out.println("Value after increment is run twice: " + I2.getValue());
        I2.increment();
        System.out.println("Value after increment is run three times: " + I2.getValue());
        I2.increment();
        System.out.println("Value after increment is run four times: " + I2.getValue());
        I2.increment();
        System.out.println("Value after increment is run five times: " + I2.getValue());
    }
}
