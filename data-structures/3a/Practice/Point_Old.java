import java.util.Comparator;

public class Point implements Comparable<Point> {

    private final double x, y;

   // constructs the point (x, y)
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // draws this point
    public void draw() {
        StdDraw.setPenRadius(0.05);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.point(x, y);

    }

    // draws the line segment from this point to that point
    public void drawTo(Point that) {
        
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // string representation
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // compare two points by y-coordinates, breaking ties by x-coordinates
    public int compareTo(Point that) {
        if (this.y < that.y)
            return -1;
        else if (this.y > that.y)
            return 1;
        else if (this.x < that.x)
            return -1;
        else if (this.x > that.x)
            return 1;
        else
            return 0;
    }

    // the slope between this point and that point
    public double slopeTo(Point that) {
        if (this.x == that.x)
            return Double.POSITIVE_INFINITY;
        if (this.compareTo(that) == 0)
            return Double.NEGATIVE_INFINITY;
        
        return (that.y - this.y) / (that.x - this.x);
    }

    // compare two points by slopes they make with this point
    public Comparator<Point> slopeOrder() {
        Comparator<Point> p = new BySlope();
        return p;
    }

    public static void main (String[] args) {
        Point my1 = new Point(0,0);
        Point my2 = new Point(500,100);
        StdDraw.setPenRadius(0.5);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.point(200, 400);
        my1.draw();

        // StdDraw.setPenRadius(0.05);
        // StdDraw.setPenColor(StdDraw.BLUE);
        //    StdDraw.point(0.5, 0.5);
        //    StdDraw.setPenColor(StdDraw.MAGENTA);
        //    StdDraw.line(0.2, 0.2, 0.8, 0.2);
    }

    private class BySlope implements Comparator<Point> {
 
        public int compare(Point a, Point b) {
            double m1 = (a.y - y) / (a.x - x);
            double m2 = (b.y - y) / (b.x - x);
            if (m1 < m2)
                return -1;
            else if (m1 > m2)
                return 1;
            else
                return 0;
        }
    }
}