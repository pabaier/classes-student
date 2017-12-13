import java.util.Scanner;
import edu.cofc.grader.*;

public class Grader {
    public static void main(String[] args) {
        C.colors(true);
        System.out.println("Test Cases:" + C.GREEN);
        System.out.println("\t1. if you can dream it you can do it");
        System.out.println("\t2. waddle");
        System.out.println("\t3. was it tar rat ti saw");
        System.out.println("\t4. kayak");
        System.out.println("\t4. float like a butterfly a like float" + C.RESET);

        TestOutline root = new TestOutline("Homework 7");
        TestOutline problem1 = new TestOutline(C.UNDERLINE + "Problem 1" + C.RESET);
        TestOutline problem2 = new TestOutline(C.UNDERLINE + "Problem 2" + C.RESET);
        TestOutline problem3 = new TestOutline(C.UNDERLINE + "Problem 3" + C.RESET);

        root.add(problem1);
        root.add(problem2);
        root.add(problem3);

        TestsProblem1.Tests p1T = new TestsProblem1.Tests();
        p1T.setName("Test Cases");
        problem1.add(p1T);
        TestsProblem1.Algorithm p1A = new TestsProblem1.Algorithm();
        p1A.setName("Algorithm");
        problem1.add(p1A);

        TestsProblem2.Tests p2T = new TestsProblem2.Tests();
        p2T.setName("Test Cases");
        problem2.add(p2T);
        TestsProblem2.Algorithm p2A = new TestsProblem2.Algorithm();
        p2A.setName("Algorithm");
        problem2.add(p2A);

        TestsProblem3.Tests p3T = new TestsProblem3.Tests();
        p3T.setName("Test Cases");
        problem3.add(p3T);
        TestsProblem3.Algorithm p3A = new TestsProblem3.Algorithm();
        p3A.setName("Algorithm");
        problem3.add(p3A);

        root.run();
        System.out.println("Extra: ");
        Scanner in = new Scanner(System.in);
        String comments = in.nextLine(); 
        if(!comments.equals("-"))
            root.addPoints(in.nextInt());
        System.out.println("Final Score: " + root.getPointsEarned() + "/" + root.getTotalPoints());
        double percent = Math.ceil(((double)root.getPointsEarned())/root.getTotalPoints() * 100);
        System.out.println(C.BLUE + (int)percent + "%");
        System.out.println();



    }
}