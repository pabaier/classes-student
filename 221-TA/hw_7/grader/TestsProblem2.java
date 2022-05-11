import edu.cofc.grader.*;
import java.util.Scanner;

public class TestsProblem2 {
    public static class Tests extends SingleTest {
        public void exec() {

            String[] expectedOutput = { "not a palindrome",
                                        "not a palindrome",
                                        "palindrome",
                                        "palindrome",
                                        "not a palindrome"
                                        };

            setTotalPoints(expectedOutput.length);                                        
                                        
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
    
            System.out.println(indent() + C.BLUE + "1 is correct, 0 in incorrect" + C.RESET);
            Scanner in = new Scanner(System.in);
            String[] tests = { "read the line",
                                "push the line onto the stack",
                                "set up a loop", 
                                "pop the line from the stack", 
                                "check the length", 
                                "return true if length < 2", 
                                "otherwise check the fist and last character", 
                                "if they are the same, get substring without first and last char", 
                                "push substring", 
                                "otherwise return false" 
                            };

            setTotalPoints(tests.length);
                            
            for(int i = 0; i < tests.length; i++) {
                System.out.print(indent(2) + C.RESET + tests[i] + ": " + C.CYAN);
                addPoints(in.nextInt());
            }
        }
    }


}