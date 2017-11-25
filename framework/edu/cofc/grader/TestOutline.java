package edu.cofc.grader;

import java.util.List;
import java.util.ArrayList;

public class TestOutline extends Test {
    private List<Test> testList = new ArrayList<>();

    public TestOutline(String name) {
        super(name);
    }

    public void addTest(Test test) {
        testList.add(test);
    }

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