
/**
 * Test driver to test increments
 *
 * Jonathan Rabiu
 * 
 */
public class HW6Part2
{
    public static void main(String[] args){
       SequentialIncrementer num1 = new SequentialIncrementer();
       num1.increment();
       System.out.println("SI: " + num1.getValue()); //1
       num1.increment();
       System.out.println("SI: " + num1.getValue()); //2
       
       RandomIncrementer num2 = new RandomIncrementer();
       System.out.println("Random number: " + num2.getValue());//show current random number
       num2.increment();
       System.out.println("New random number: " + num2.getValue());//show new random number
       num2.increment();
       System.out.println("Newest random number: " + num2.getValue());
    }
}
