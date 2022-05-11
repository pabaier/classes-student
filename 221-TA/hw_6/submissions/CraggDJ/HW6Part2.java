
/**
 * used to test incrementable and all subclasses.
 *
 * @Dustin Cragg
 * @11/17/2017
 */
public class HW6Part2
{
    public static void main(String[] args)
    {
        SequentialIncrementer one = new SequentialIncrementer();
        System.out.println(one.getValue());
        RandomIncrementer two = new RandomIncrementer();
        System.out.println(two.getValue());
        
        for(int iter = 0; iter < 10; ++iter)
        {
           one.Increment(); 
           System.out.println(one.getValue());
        }
        
        for(int iter = 0; iter < 10; ++iter)
        {
            two.Increment();
            System.out.println(two.getValue());
        }
    }
}
