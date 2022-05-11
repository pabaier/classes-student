
/**
 * Test driver for incremental classes
 *
 * @author Jacob Mattox
 * @version 11/13/17
 */
public class HW6Part2
{
    public static void main(){
        Incrementable sequential = new SequentialIncrementer();//create sequential object
        Incrementable random = new RandomIncrementer();//create random object
        
        System.out.println(sequential.getValue());//get initial values
        System.out.println(random.getValue());
        
        //loop to change values and print new values
        for(int i = 0; i < 5; i++){
            sequential.increment();
            random.increment();
            System.out.printf("%d, %d \n", sequential.getValue(), random.getValue());
        }
        
    }
}
