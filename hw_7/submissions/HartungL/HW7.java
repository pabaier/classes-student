
/**
 * HW7 is the driver of all of the stack and queue problems
 *
 * Lexus Hartung
 */
import java.io.*;
import java.util.*;
public class HW7{
    public static void main(String [] args){
        System.out.println("Please provide an input file: ");
        Scanner scnrK = new Scanner(System.in);
        String file = scnrK.nextLine();
        System.out.println("Problem 1");
        Prob1.problem1(file);
        System.out.println("Problem 2");
        Prob2.problem2(file);
        System.out.println("Problem 3");
        Prob3.problem3(file);
    }
}
