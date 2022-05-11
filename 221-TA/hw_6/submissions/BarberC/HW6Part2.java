/**
 * Tester for part 2 of HW6.
 * 
 * @author Carson Barber
 */
import java.util.Scanner;
public class HW6Part2
{
    public static void main(String[] args)
    {
        Scanner scnr = new Scanner(System.in);
        System.out.println("HW6Part2 Testing Starting...");
        System.out.println();
        System.out.println("Creating new SequentialIncrementer...");
        SequentialIncrementer si = new SequentialIncrementer();
        do{
            System.out.println("SequentialIncrementer's value: " + si.getValue());
            System.out.println("To proceed to next test, press n. To increment, press any other key");
            si.increment();
        } while (!scnr.next().equals("n"));
        System.out.println("Exiting SequentialIncrementer's test...");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Creating new RandomIncrementer...");
        RandomIncrementer ri = new RandomIncrementer();
        do{
            System.out.println("RandomIncrementer's value: " + ri.getValue());
            System.out.println("To exit, press n. To increment, press any other key");
            ri.increment();
        } while (!scnr.next().equals("n"));
        System.out.println("Exiting RandomIncrementer's test...");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Testing finished. Terminating...");
    }
}
