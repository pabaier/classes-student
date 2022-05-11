
/**
 * Write a description of class HW6Part2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HW6Part2
{

    /**
     * Constructor for objects of class HW6Part2
     */
    public static void main(String[] args)
    {
        RandomIncrementer x = new RandomIncrementer();
        SequentialIncrementer y = new SequentialIncrementer();
        int i = 0;
        System.out.println("Sequential Incrementer");
        System.out.println(y.getValue());
        for(i = 0; i < 10 ; ++i){
            y.increment();
            System.out.println(y.getValue());
        }
        System.out.println("");
        System.out.println("Random Incrementer");
        System.out.println(x.getValue());
        for(i = 0; i < 10 ; ++i){
            x.increment();
            System.out.println(x.getValue());
        }
    }


}
