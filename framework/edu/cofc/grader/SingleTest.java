package edu.cofc.grader;

/**
 * SingleTest is a test that runs within a {@link edu.cofc.grader.TestOutline}
 * @author Paul Baier
 */

public abstract class SingleTest extends SingleTestAbstractMethod {
    /**
     * Initializes a new SingleTest object with the specified name
     * @param name the name of the test
     */
    public SingleTest(String name) {
        super(name);
    }

    /**
     * Initializes a new SingleTest object with the default name specified in
     * {@link edu.cofc.grader.Test}
     */
    public SingleTest() {
        super();
    }

    /**
     * Abstract method called to run the SingleTest
     */
    public abstract void exec();

}