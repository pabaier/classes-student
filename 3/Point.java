/******************************************************************************
 *  Compilation:  javac Point.java
 *  Execution:    java Point
 *  Dependencies: none
 *  
 *  An immutable data type for points in the plane.
 *  For use on Coursera, Algorithms Part I programming assignment.
 *
 ******************************************************************************/

import java.util.Comparator;
import java.util.Arrays;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Point implements Comparable<Point> {

    private final int x;     // x-coordinate of this point
    private final int y;     // y-coordinate of this point

    /**
     * Initializes a new point.
     *
     * @param  x the <em>x</em>-coordinate of the point
     * @param  y the <em>y</em>-coordinate of the point
     */
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    /**
     * Draws this point to standard draw.
     */
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    /**
     * Draws the line segment between this point and the specified point
     * to standard draw.
     *
     * @param that the other point
     */
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    /**
     * Returns the slope between this point and the specified point.
     * Formally, if the two points are (x0, y0) and (x1, y1), then the slope
     * is (y1 - y0) / (x1 - x0). For completeness, the slope is defined to be
     * +0.0 if the line segment connecting the two points is horizontal;
     * Double.POSITIVE_INFINITY if the line segment is vertical;
     * and Double.NEGATIVE_INFINITY if (x0, y0) and (x1, y1) are equal.
     *
     * @param  that the other point
     * @return the slope between this point and the specified point
     */
    public double slopeTo(Point that) {
        if (this.x == that.x && this.y == that.y)
            return Double.NEGATIVE_INFINITY;
        if (this.y == that.y)
            return 0;
        if (this.x == that.x)
            return Double.POSITIVE_INFINITY;

        return (that.y - (double) this.y)/(that.x - this.x);
    }

    /**
     * Compares two points by y-coordinate, breaking ties by x-coordinate.
     * Formally, the invoking point (x0, y0) is less than the argument point
     * (x1, y1) if and only if either y0 < y1 or if y0 = y1 and x0 < x1.
     *
     * @param  that the other point
     * @return the value <tt>0</tt> if this point is equal to the argument
     *         point (x0 = x1 and y0 = y1);
     *         a negative integer if this point is less than the argument
     *         point; and a positive integer if this point is greater than the
     *         argument point
     */
    public int compareTo(Point that) {
        if (this.y == that.y)
            return this.x - that.x;
        return this.y - that.y;
    }

    /**
     * Compares two points by the slope they make with this point.
     * The slope is defined as in the slopeTo() method.
     *
     * @return the Comparator that defines this ordering on points
     */
    public Comparator<Point> slopeOrder() {
        Comparator<Point> p = new BySlope();
        return p;
    }

    private class BySlope implements Comparator<Point> {
        public int compare(Point a, Point b) {
            if (slopeTo(a) < slopeTo(b))
                return -1;
            else if (slopeTo(a) > slopeTo(b))
                return 1;
            else
                return 0;

            // return (int) (slopeTo(a) - slopeTo(b));
        }
    }


    /**
     * Returns a string representation of this point.
     * This method is provide for debugging;
     * your program should not rely on the format of the string representation.
     *
     * @return a string representation of this point
     */
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    /**
     * Unit tests the Point data type.
     */
    public static void main(String[] args) {
        
        StdDraw.setScale(-1000, 31000);
        StdDraw.setPenRadius(0.02);

        int inputs = StdIn.readInt();
        Point[] pointArray = new Point[inputs];
        for (int i = 0; i < inputs; i++) { 
            pointArray[i] = new Point (StdIn.readInt(), StdIn.readInt());
        }

        StdDraw.setPenColor(10, 170, 10);
        // 1. print the points as inputed
        StdOut.println("Input");
        for (int i = 0; i < pointArray.length; i++) {
            StdOut.println(pointArray[i]);
        }

        StdOut.println();
        Arrays.sort(pointArray);

        // 2. print is natural sorted order
        StdOut.println("Natural Ordering");
        for (int i = 0; i < pointArray.length; i++) {
            StdOut.println(pointArray[i]);
        }

        StdOut.println();
        Arrays.sort(pointArray, pointArray[3].slopeOrder());

        // 2. print is slope ordered
        StdOut.println("By Slope");
        for (int i = 0; i < pointArray.length; i++) {
            StdOut.println(pointArray[i]);
        }

        StdDraw.enableDoubleBuffering();
        while (true) {
            StdDraw.clear();
            StdDraw.text(10000, 15000, (int) StdDraw.mouseX() + ", " + (int) StdDraw.mouseY());


            for (int i = 0; i < pointArray.length; i++)            
                pointArray[i].draw();

            StdDraw.show();    
            StdDraw.pause(20);
        }

    }
}
