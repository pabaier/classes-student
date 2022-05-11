import java.util.Arrays;
import java.lang.NoSuchMethodError;
import java.lang.ArrayIndexOutOfBoundsException;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab4_grader {
    public static void main(String[] args) {

        Lab4Solution key = new Lab4Solution();
        Lab4 s = new Lab4();
        double expected, student;
        int points = 0;
        double[][] data = new double[][]{
            {-5,200,1,3,5,7}, // min first, max second
            {-73,-23,-65,-2,-7,0}, //min first, max last
            {123,456,-2,76,98,67,2,5432,54,2,76,163}, //min middle, max middle
            {5000,-700,43,5,7,7,45,2,25,874,-7}, // max first, min second
            {5000,7,43,5,7,7,45,2,25,874,-7}, // max first, min last
            {234,43,22,5234,54,1,2543,7,54,345,243}, // max middle, min middle
        };
        
        System.out.println("+50 for submission");
        points += 50;

        // checks what is being printed by the main method
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream newStream = new PrintStream(baos);
        PrintStream original = System.out;
        System.setOut(newStream);
        s.main(args); // running main method
        System.out.flush();
        System.setOut(original);
        String results = baos.toString();
        System.out.println(results);

        // // get name then check file for name
        // File f = new File("Lab4.java");
        // String name = "";
        // try {
        //     Scanner in = new Scanner(f);
        //     while (in.hasNextLine()) {
        //         name = in.nextLine();
        //     }
        // }
        // catch(FileNotFoundException e){}
        // name = name.substring(2);
        // boolean found = false;
        // try {
        //     Scanner inTwo = new Scanner(f);
        // while (inTwo.hasNextLine()) {
        //     String line = inTwo.nextLine();
        //     if (line.toLowerCase().contains(name.toLowerCase())) {
        //         System.out.println("+2 for name");
        //         found = true;
        //     }
        // }
        // } catch(FileNotFoundException e){}
        // if(!found)
        //     System.out.println("+0 no name");

        // tests
        for(int i = 0; i < data.length; i++) {
            System.out.println("\nTest " + (i + 1) + "\n" + Arrays.toString(data[i]));
            
            // minimum
            expected = key.minimum(data[i]);
            try{
                student = s.minimum(data[i]);
                if (eql(expected, student)) {
                    System.out.println("\t+1 Minimum Method Passed!");
                    points += 1;
                }
                else {
                    System.out.println("\t+0 Minimum Method Failed");
                    System.out.println("\t\tExpected Value: " + expected );
                    System.out.println("\t\tReturned Value: " + student );
                }
            }
            catch (NoSuchMethodError | ArrayIndexOutOfBoundsException e) {
                System.out.println("\t+0 No Minimum Method Defined or array index out of bounds");
            }

            // maximum
            expected = key.maximum(data[i]);
            try {
                student = s.maximum(data[i]);
                if (eql(expected, student)) {
                    System.out.println("\t+1 Maximum Method Passed!");
                    points += 1;
                }
                else {
                    System.out.println("\t+0 Maximum Method Failed");
                    System.out.println("\t\tExpected Value: " + expected );
                    System.out.println("\t\tReturned Value: " + student );
                }
            }
            catch (NoSuchMethodError | ArrayIndexOutOfBoundsException e) {
                System.out.println("\t+0 No Maximum Method Defined or array index out of bounds");
            }
            
            // Average
            expected = key.average(data[i]);
            try{
                student = s.average(data[i]);
                if (eql(expected, student)) {
                    System.out.println("\t+1 Average Method Passed!");
                    points += 1;
                }
                else {
                    System.out.println("\t+0 Average Method Failed");
                    System.out.println("\t\tExpected Value: " + expected );
                    System.out.println("\t\tReturned Value: " + student );
                }
            }
            catch (NoSuchMethodError | ArrayIndexOutOfBoundsException e) {
                System.out.println("\t+0 No Average Method Defined or array index out of bounds");
            }
            
            // Variance
            expected = key.variance(data[i], key.average(data[i]));
            try {
                student = s.variance(data[i], key.average(data[i]));
                if (eql(expected, student)) {
                    System.out.println("\t+1 Variance Method Passed!");
                    points += 1;
                }
                else {
                    System.out.println("\t+0 Variance Method Failed");
                    System.out.println("\t\tExpected Value: " + expected );
                    System.out.println("\t\tReturned Value: " + student );
                }
            }
            catch (NoSuchMethodError | ArrayIndexOutOfBoundsException e) {
                System.out.println("\t+0 No Variance Method Defined or array index out of bounds");
            }
        }
        System.out.println("Total: " + points);
    }

    public static boolean eql(double a, double b) {
        return Math.abs(a - b) < 0.0001;
    }
}