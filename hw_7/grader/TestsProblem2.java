import edu.cofc.grader.*;
import java.util.Scanner;

public class TestsProblem2 {
    public static class Tests extends SingleTest {
        public void exec() {
            setTotalPoints(5);

            String[] expectedOutput = { "not a palindrome",
                                        "not a palindrome",
                                        "palindrome",
                                        "palindrome",
                                        "not a palindrome"
                                        };
    
            System.out.println(indent() + C.BLUE + "1 is correct, 0 in incorrect" + C.RESET);
            Scanner in = new Scanner(System.in);
            for(int i = 0; i < expectedOutput.length; i++) {
                System.out.print(indent(2) + C.RESET + (i + 1) + ". Expected: " + C.MAGENTA + expectedOutput[i] + " - " + C.CYAN);
                addPoints(in.nextInt());
            }
        }
    }
    
    public static class Algorithm extends SingleTest {
        public void exec() {
            setTotalPoints(10);
    
            System.out.println(indent() + C.BLUE + "1 is correct, 0 in incorrect" + C.RESET);
            Scanner in = new Scanner(System.in);
            String[] tests = { "reads the line",
                                "pushes the line onto the stack",
                                "sets up a loop", 
                                "pops the line from the stack", 
                                "checks the length", 
                                "returns true if length < 2", 
                                "otherwise checks the fist and last character", 
                                "if they are the same, get substring without first and last char", 
                                "pop substring", 
                                "otherwise return false" 
                            };
            for(int i = 0; i < tests.length; i++) {
                System.out.print(indent(2) + C.RESET + tests[i] + ": " + C.CYAN);
                addPoints(in.nextInt());
            }
        }
    }


}