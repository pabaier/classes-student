package edu.cofc.grader;

import java.util.List;
import java.util.ArrayList;

/**
 * TestOutline is a container for all {@link edu.cofc.grader.Test} objects that need to be run
 * within the context of this test. Use the {@link #addTest(Test test)} method to add tests
 * to the container and, once all tests are added, run the container.
 * TesetOutline can also contain other test outlines.
 * Indentation levels are kept automatically.
 * @author Paul Baier
 */

public class TestOutline extends Test {
    private List<Test> testList = new ArrayList<>();

    /**
     * Initializes a new TestOutline object with the specified name
     * @param name - the name of the test
     */
    public TestOutline(String name) {
        super(name);
    }
    /**
     * Initializes a new TestOutline object with the default name specified in
     * {@link edu.cofc.grader.Test}
     */
    public TestOutline() {
        super();
    }

    /**
     * Adds a new {@link edu.cofc.grader.Test} object to the TestOutline
     * @param test the Test added to the TestOutline
     */
    public void addTest(Test test) {
        testList.add(test);
    }

    /**
     * Runs all of the test added to this TestOutline.
     * <br>Prints the test name, sets the indent level of the test being run,
     * runs the test, updates this TestOutline's total points and points earned,
     * and prints the results
     */
    public void run() {
        printTest();
        for(Test t : testList) {
            t.setIndent(getIndentLevel() + 1);
            t.run();
            setTotalPoints(getTotalPoints() + t.getTotalPoints());
            setPointsEarned(getPointsEarned() + t.getPointsEarned());
        }
        printResult();
    }
}