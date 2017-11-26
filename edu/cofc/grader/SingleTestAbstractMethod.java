package edu.cofc.grader;

/**
 * SingleTestAbstractMethod provides an interface for creating a {@link edu.cofc.grader.SingleTest}<br>
 * The test name and result are printed within the run method, so a SingleTest
 * just needs to specify the logic of the test to run and the points for the test
 * in an {@link #exec()} method.
 * @author Paul Baier
 */

public abstract class SingleTestAbstractMethod extends Test {

    public SingleTestAbstractMethod(String name) {
        super(name);
    }
    public SingleTestAbstractMethod() {
        super();
    }

    /**
     * Runs a SingleTest
     * Wraps the test in the test's name a result
     */
    public void run() {
        printTest();
        exec();
        printResult();
    }

    /**
     * To be implemented by a {@link edu.cofc.grader.SingleTest}
     * This is the logic to be carried out by the test
     */
    public abstract void exec();
}