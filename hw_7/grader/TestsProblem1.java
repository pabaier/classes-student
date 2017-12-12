import edu.cofc.grader.*;
import java.util.Scanner;

public class TestsProblem1 {
    public static class Tests extends SingleTest {
        public void exec() {
            setTotalPoints(5);

            String[] expectedOutput = { "it do can you it dream can you if",
                                        "waddle",
                                        "saw i rat a it was",
                                        "kayak",
                                        "float like a butterfly a like float"
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
            setTotalPoints(3);
    
            System.out.println(indent() + C.BLUE + "1 is correct, 0 in incorrect" + C.RESET);
            Scanner in = new Scanner(System.in);
            String[] tests = { "Reads the line",
                                "Pushes each word to stack",
                                "Pops each word from the stack" 
                            };
            for(int i = 0; i < tests.length; i++) {
                System.out.print(indent(2) + C.RESET + tests[i] + ": " + C.CYAN);
                addPoints(in.nextInt());
            }
        }
    }


}