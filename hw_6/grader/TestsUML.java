import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

import edu.cofc.grader.*;

public class TestsUML extends SingleTest{
    public void exec() {
        int full = 2;
        int half = 1;
        setTotalPoints(6);
        int points = 0;
        
        Scanner in = new Scanner(System.in);
        System.out.println(indent() + "Incrementable Interface");
        System.out.print(indent(2) + "increment() - ");
        points += in.nextInt();
        System.out.print(indent(2) + "getValue() - ");
        points += in.nextInt();
        
        System.out.println(indent() + "SequentialIncrementer");
        System.out.print(indent(2) + "getValue() - ");
        points += in.nextInt();
        System.out.print(indent(2) + "inherits from Incrementable - ");
        points += in.nextInt();
        
        System.out.println(indent() + "RandomIncrementer");
        System.out.print(indent(2) + "getValue() - ");
        points += in.nextInt();
        System.out.print(indent(2) + "inherits from Incrementable - ");
        points += in.nextInt();

        addPoints(points);
    }
}