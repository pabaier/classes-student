
/**
 * HW6Part2 is a test driver for the Incrementable interface and the methods
 * SequentialInterface and RandomInterface.
 *
 * @author Andrea Lingenfelter
 * @version 11/16/17
 */
public class HW6Part2{
          
    public static void main (String[] args){ 
    SequentialIncrementer A = new SequentialIncrementer();
    System.out.println("The value of A when created is: " + A.getValue());
    A.increment();
    System.out.println("The value of A after calling increments once is: " + A.getValue());
    A.increment();
    A.increment();
    A.increment(); 
    System.out.println("The value of A after calling increment a total of 4 times is: " + A.getValue());
    
    RandomIncrementer B = new RandomIncrementer();
    System.out.println("The initial value of B is: " + B.getValue());
    B.increment();
    System.out.println("The value of B after calling increment once is: " + B.getValue());
    B.increment();
    System.out.println("The value of B after calling increment again is: " + B.getValue());
    }
}
