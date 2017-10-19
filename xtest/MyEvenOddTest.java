import org.junit.Test;
import static org.junit.Assert.assertEquals;
 
public class MyEvenOddTest {
 
    @Test
    public void testEvenOddNumber(){
        MyEvenOdd meo = new MyEvenOdd();
        System.out.println("Check EvenOdd Test:");
        try {
            assertEquals("10 is a even number", true, meo.isEvenNumber(10));
            System.out.println("\tEvenOdd test passed - 10 points");
        }
        catch (AssertionError e) {
            System.out.println("\tEvenOdd test failed - 0 points");
        }
    }
}