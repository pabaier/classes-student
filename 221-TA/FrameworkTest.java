import edu.cofc.grader.*;

public class FrameworkTest {
    public static void main(String[] args) {
        TestOutline t = new TestOutline("Test test");
        t.setTotalPoints(5);
        t.setPointsEarned(3);
        t.run();
    }
}