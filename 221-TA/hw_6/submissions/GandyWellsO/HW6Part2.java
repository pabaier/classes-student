
/**
 * Orianna Gandy-Wells
 * 
 * This class is a tester class for the other
 * classes in the second part of the homework 
 * to show they work properly
 */
public class HW6Part2
{
   public static void main(String [] args){
       
       SequentialIncrementer seq1 = new SequentialIncrementer();
       System.out.println("SequentialIncrementer start: " + seq1.getValue());
       seq1.increment();
       System.out.println("SequentialIncrementer has incremented");
       System.out.println("SequentialIncrementer end: " + seq1.getValue());
       
       System.out.println();
       
       RandomIncrementer rand1 = new RandomIncrementer();
       System.out.println("RandomIncrementer start: " + rand1.getValue());
       rand1.increment();
       System.out.println("RandomIncrementer has incremented");
       System.out.println("RandomIncrementer end: " + rand1.getValue());
    }
}
