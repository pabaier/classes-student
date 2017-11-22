import java.util.TreeSet;
import java.util.ArrayList;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import java.util.NoSuchElementException;

public class PointSET {

    private TreeSet<Point2D> set;

    // construct an empty set of points 
    public PointSET() {
        set = new TreeSet<>();
    }

    // is the set empty? 
    public boolean isEmpty() {
        return set.isEmpty();
    }

    // number of points in the set 
    public int size() {
        return set.size();
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        if (p == null)
            throw new IllegalArgumentException();
        set.add(p);
    }

    // does the set contain point p? 
    public boolean contains(Point2D p) {
        if (p == null)
            throw new IllegalArgumentException();
        return set.contains(p);
    }

    // draw all points to standard draw 
    public void draw() {

        StdDraw.setScale(-0.05, 1.05);
        StdDraw.setPenRadius(0.02);
        StdDraw.setPenColor(StdDraw.BLUE);
        
        for(Point2D p : set){
            StdDraw.point(p.x(), p.y());
        }
    }

    // all points that are inside the rectangle (or on the boundary) 
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null)
            throw new IllegalArgumentException();
        ArrayList<Point2D> p = new ArrayList<Point2D>();

        for (Point2D point : set) {
            if (rect.contains(point))
                p.add(point);
        }

        return p;
    }

    // a nearest neighbor in the set to point p; null if the set is empty 
    public Point2D nearest(Point2D p) {
        if (p == null)
            throw new IllegalArgumentException();

        if (isEmpty())
            return null;
        Point2D closest = set.first();
        double dist = closest.distanceTo(p);
        

        for (Point2D point : set) {
            // System.out.println(point.distanceTo(p) + "   " + point);
            if (Double.compare(point.distanceTo(p), dist) < 0) {
                closest = point;
                dist = point.distanceTo(p);
            }
        }
        return closest;
    }

    // unit testing of the methods (optional) 
    public static void main(String[] args) {
        PointSET p = new PointSET();
        RectHV r = new RectHV(0.01, 0, 0.8, 0.5);

         // create initial board from file
        In in = new In(args[0]);
        while (in.hasNextLine()) {
                try{
                    p.insert(new Point2D(in.readDouble(), in.readDouble()));
                }
                catch (NoSuchElementException e){}
        }

        // StdDraw.setScale(-0.05, 1.05);
        // StdDraw.setPenRadius(0.02);
        // StdDraw.setPenColor(StdDraw.BLUE);
        p.draw();

        StdDraw.setPenColor(StdDraw.GREEN);
        for (Point2D points : p.range(r))
            points.draw();
        
        StdDraw.setPenColor(StdDraw.BLUE);
        r.draw();
        
        StdDraw.setPenColor(StdDraw.RED);
        Point2D x = new Point2D(0.4, 0.17);
        x.draw();
        p.nearest(x).draw();
    }
}