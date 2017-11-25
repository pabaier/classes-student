package edu.cofc.grader;

/**
 * Test provides an interface for creating different types of Test objects.
 * When extending Test, a @see run() method must be implemented.
 * @author Paul Baier
 */

public abstract class Test {
    private int pointsEarned;
    private int totalPoints;
    private int indentLevel;
    private String name;

    /**
     * Initializes a new Test object with the specified name
     * @param name the name of the test
     */
    public Test(String name) {
        this.name = name;
    }

    /**
     * Abstract method called to run the test
     */
    public abstract void run();

    /**
     * Prints the name of the test with the proper indentation
     */
    public void printTest() {
        System.out.println(getIndent() + name);
    }

    /**
     * Prints the results of the test using the proper indentation
     */
    public void printResult() {
        System.out.println(getIndent() + pointsEarned + "/" + totalPoints);
    }

    /**
     * Returns the name of the test
     * @return The name of the test
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the name of the test
     * @param name the name of the test
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Returns the total points assigned to this test
     * @return The total points assigned to this test
     */
    public int getTotalPoints() {
        return totalPoints;
    }

    /**
     * Sets the total points for this test
     * @param totalPoints the total points for this test
     */
    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }
    /**
     * Returns the points earned for this test
     * @return The points earned for this test
     */
    public int getPointsEarned() {
        return pointsEarned;
    }
    /**
     * Sets the points earned for this test
     * @param pointsEarned the points earned for this test
     */
    public void setPointsEarned(int pointsEarned) {
        this.pointsEarned = pointsEarned;
    }
    /**
     * Returns the indentation level for this test
     * @return The indentation level for this test
     */
    public int getIndentLevel() {
        return indentLevel;
    }
    /**
     * Sets the indentation level for this test
     * @param indentLevel the indentation level for this test
     */
    public void setIndent(int indentLevel) {
        this.indentLevel = indentLevel;
    }
    /**
     * Returns the string representation of the indentation level for this test
     * @return The string representation of the indentation level for this test
     */
    public String getIndent() {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < indentLevel; i++)
            s.append("   ");
        return s.toString();
    } 
}