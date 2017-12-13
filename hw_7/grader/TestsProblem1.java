import edu.cofc.grader.*;
import java.util.Scanner;

public class TestsProblem1 {
    public static class Tests extends SingleTest {
        public void exec() {

            String[] expectedOutput = { "it do can you it dream can you if",
                                        "waddle",
                                        "saw ti rat tar it was",
                                        "kayak",
                                        "float like a butterfly a like float"
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
            String[] tests = { "Read the line",
                                "Push each word to stack",
                                "Pop each word from the stack" 
                            };

            setTotalPoints(tests.length);
                            
            for(int i = 0; i < tests.length; i++) {
                System.out.print(indent(2) + C.RESET + tests[i] + ": " + C.CYAN);
                addPoints(in.nextInt());
            }
        }
    }


}