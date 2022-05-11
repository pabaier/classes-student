import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AlgorismTest {
    // @Test
    // public void testMain() throws IOException {
    //     System.out.println("main");
    //     String[] args = null;
    //     final InputStream original = System.in;
    //     final FileInputStream fips = new FileInputStream(new File("HW 1/Algorism.class"));
    //     System.setIn(fips);
    //     Main.main(args);
    //     System.setIn(original);
    // }

    //OR

    @Test
    public void shouldTakeUserInput() {
        InputOutput inputOutput= new InputOutput();

        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("5", inputOutput.getInput());
    }
}