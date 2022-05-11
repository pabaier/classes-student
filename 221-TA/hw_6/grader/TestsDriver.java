import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

import edu.cofc.grader.*;

public class TestsDriver extends SingleTest{
    public void exec() {
        int full = 2;
        int half = 1;
        setTotalPoints(5);

        System.out.print(indent() + "Test driver - ");
        Scanner in = new Scanner(System.in);
        int points = in.nextInt();
        addPoints(points);
    }
}