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
     * Initializes a new Test object with the default name "Test"
     */
    public Test() {
        this("Test");
    }

    /**
     * Abstract method called to run the test
     */
    public abstract void run();

    /**
     * Prints the name of the test with the proper indentation
     */
    public void printTest() {
        System.out.println(getIndent() + C.TITLES[indentLevel%C.TITLES.length] + name + C.RESET);
    }

    /**
     * Prints the results of the test using the proper indentation
     */
    public void printResult() {
        System.out.println(getIndent() + C.RESULTS[indentLevel%C.RESULTS.length] + pointsEarned + "/" + totalPoints + C.RESET);
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
     * Adds the points to the pointsEarned for this test
     * @param points the points being added to pointsEarned for this test
     */
    public void addPoints(int points) {
        this.pointsEarned += points;
    }   
     /**
     * Subtracts the points from the pointsEarned for this test
     * @param points the points being removed from pointsEarned for this test
     */
    public void removePoints(int points) {
        this.pointsEarned -= points;
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
     * Indents the current line one indentation more than current indent level
     * @return The string representation of the indentation level plus one for this test
     */
    public String indent() {
        return getIndent(indentLevel + 1);
    }
    /**
     * Indents the current line n indentation levels more than current indent level
     * @param n the number of indentation levels to add
     * @return The string representation of the indentation level plus n for this test
     */
    public String indent(int n) {
        return getIndent(indentLevel + n);
    }
    /**
     * Returns the string representation of the indentation level for this test
     * @return The string representation of the indentation level for this test
     */
    public String getIndent() {
        return getIndent(indentLevel);
    }
    /**
     * Returns the string representation of the indentation level for the given indentLevel
     * @param indentLevel the indentation level
     * @return The string representation of the indentation level for this test
     */
    public static String getIndent(int indentLevel) {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < indentLevel; i++)
            s.append("   ");
        return s.toString();
    }
}