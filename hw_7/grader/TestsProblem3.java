import edu.cofc.grader.*;
import java.util.Scanner;

public class TestsProblem3 {
    public static class Tests extends SingleTest {
        public void exec() {

            String[] expectedOutput = { "not a palindrome",
                                        "palindrome",
                                        "not palindrome",
                                        "palindrome",
                                        "palindrome"
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
                            "split the line into words",
                            "push each word onto the stack",
                            "push each word onto the queue",
                            "set up loop",
                            "pop the word from the stack", 
                            "pop the word from the queue", 
                            "compare word from stack and queue", 
                            "correct return statements" 
                            };
            setTotalPoints(tests.length);
            for(int i = 0; i < tests.length; i++) {
                System.out.print(indent(2) + C.RESET + tests[i] + ": " + C.CYAN);
                addPoints(in.nextInt());
            }
        }
    }


}