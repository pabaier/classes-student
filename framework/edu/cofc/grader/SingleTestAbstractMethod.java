package edu.cofc.grader;

public abstract class SingleTestAbstractMethod extends Test {

    public SingleTestAbstractMethod(String name) {
        super(name);
    }

    public void run() {
        printTest();
        exec();
        printResult();
    }

    public abstract void exec();
}