import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJunit {
   
    @Test
    public void testAdd() {
        String str = "Junit is working fine";
        System.out.println("Check String Test:");
        try{
            assertEquals("Junit is working fine",str);
            System.out.println("\tTest 1 Complete - 10 points");
        }
        catch(AssertionError e) {
            System.out.println("\tTest 1 Fail - 0 points");
        }
    }
}