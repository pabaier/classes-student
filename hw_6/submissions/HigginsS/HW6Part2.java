
/**
 * Write a description of class HW6Part2 here.
 *
 *Steven Higgins
 * 
 */
public class HW6Part2
{
   
    public static void main(String args[])
    {
        SequentialIncrementer a = new SequentialIncrementer(4);
        System.out.println(a.getValue());
        a.increment();
        System.out.println(a.getValue());
        a.increment();
        System.out.println(a.getValue());
        
        RandomIncrementer b = new RandomIncrementer();
        System.out.println(b.getValue());
        b.increment();
        System.out.println(b.getValue());
        b.increment();
        System.out.println(b.getValue());
    }

    
}
