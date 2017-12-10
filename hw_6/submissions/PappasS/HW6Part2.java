/*
* Stephen Pappas
*
* This class is a driver class that tests the different incrementable classes.
*
 */
public class HW6Part2 {
    public static void main(String[] args){
        SequentialIncrementer inc1 = new SequentialIncrementer();
        System.out.println("Seq val: " + inc1.getValue());
        inc1.increment();
        System.out.println("Seq val incremented: " + inc1.getValue());

        RandomIncrementer inc2 = new RandomIncrementer();
        System.out.println("Rand val: " + inc2.getValue());
        inc2.increment();
        System.out.println("Rand val increment: " + inc2 .getValue());
    }
}
