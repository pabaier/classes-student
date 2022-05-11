import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
 
public class MyProgramOutputTest {
 
    @Test
    public void testOutput() throws Exception {
        MyProgram mp = new MyProgram();

        // used for capturing the output stream
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // save current output stream
        PrintStream oldOut = System.out;
        // change System.out to point to our output stream
        System.setOut(new PrintStream(baos));
        // run main method        
        mp.main(new String[0]);
        // grab our output stream and split it by line
        String[] mpOutput = baos.toString().split("\r\n");
        //revert to original output stream
        System.setOut(oldOut);

        String[] expectedOutput = {"Hello, world!", "I'm Steve!"};

        for(int i = 0; i < mpOutput.length; i++) {
            System.out.println("Check MyProgram Output " + (i + 1) + ":");
            try {
                assertTrue(expectedOutput[i].equals(mpOutput[i]));
                System.out.println("\tMyProgram output test passed - 10 points");
            }
            catch (AssertionError e) {
                System.out.println("\tMyProgram output test " + (i + 1) + " failed - 0 points");
            }
            System.out.println();
        }
    }
}