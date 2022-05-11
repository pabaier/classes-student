import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        // runs the test classes
        // test classes need to test parts of the program
        // test classes need to be in directory listed in system CLASSPATH
        Result result = JUnitCore.runClasses(MyProgramOutputTest.class);
            
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println();
        System.out.println("Run successful: " + result.wasSuccessful());
        System.out.println("Time: " + result.getRunTime()/1000.);
   }
} 