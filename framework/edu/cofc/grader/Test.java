package edu.cofc.grader;

public abstract class Test {
    private int pointsEarned;
    private int totalPoints;
    private int indent;
    private String name;

    public Test(String name) {
        this.name = name;
    }

    public abstract void run();

    public void printTest() {
        System.out.println(getIndent() + name);
    }

    public void printResult() {
        System.out.println(getIndent() + pointsEarned + "/" + totalPoints);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getTotalPoints() {
        return totalPoints;
    }
    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }
    public int getPointsEarned() {
        return pointsEarned;
    }
    public void setPointsEarned(int pointsEarned) {
        this.pointsEarned = pointsEarned;
    }
    public int getIndentLevel() {
        return indent;
    }
    public void setIndent(int indent) {
        this.indent = indent;
    }
    public String getIndent() {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < indent; i++)
            s.append("   ");
        return s.toString();
    } 
}