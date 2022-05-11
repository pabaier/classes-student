import java.util.TreeSet;
import java.util.ArrayList;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import java.util.NoSuchElementException;

public class KdTree {

    private class Node {
        private double key;
        private Point2D value;
        private Node left;
        private Node right;
        private boolean orientation;

        // vertical nodes, use x value for key
        // horizontal nodes, use y value for key
        public Node(Point2D k, boolean o) {
            value = k;
            if (o)
                key = k.x();
            else
                key = k.y();
            orientation = o;
            left = null;
            right = null;
        }

    }

    private Node root;
    private int entries;
    private static final boolean VERTICAL = true;
    private static final boolean HORIZONTAL = false;

    // construct an empty set of points 
    public KdTree() {
        root = null;
        entries = 0;
    }

    // is the set empty? 
    public boolean isEmpty() {
        return entries == 0;
    }

    // number of points in the set 
    public int size() {
        return entries;
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        if (p == null)
            throw new IllegalArgumentException();
        if (root == null) {
            root = new Node(p, VERTICAL);
            entries++;
        }
        else {
            if (p.equals(root.value)){}
            else if (p.x() < root.key)
                root.left = put(root.left, p, root.orientation);
            else //if (p.x() > root.key )
                root.right = put(root.right, p, root.orientation);
        }
    }

    private Node put(Node n, Point2D p, boolean prev) {

        if (n == null) {
            entries++;
            return new Node(p, !prev);
        }
        else if (n.value.equals(p))
            return n;
        else {
            // vertical so check x values left and right
            if (n.orientation == VERTICAL) {
                if (p.x() < n.value.x()) {
                    n.left = put(n.left, p, n.orientation);
                }
                else
                    n.right = put(n.right, p, n.orientation);
            }
            // horizontal so check y values up and down
            else {
                if (p.y() < n.value.y())
                    n.left = put(n.left, p, n.orientation);
                else
                    n.right = put(n.right, p, n.orientation);
            }
            return n;
        }


    }

    // does the set contain point p? 
    public boolean contains(Point2D p) {
        if (p == null)
            throw new IllegalArgumentException();
        return container(root, p);
    }

    private boolean container(Node n, Point2D p) {
        if (n == null)
            return false;
        if (n.value.equals(p))
            return true;
        else if (n == null)
            return false;
        else {
            if (n.orientation == VERTICAL) {
                if (n.key > p.x())
                    return container(n.left, p);
                else
                    return container(n.right, p);
            }
            else {
                if (n.key > p.y())
                    return container(n.left, p);
                else
                    return container(n.right, p);
            }
        }
    }

    // draw all points to standard draw 
    public void draw() {
        draw(root);
    }

    private void draw(Node n) {
        n.value.draw();
        if (n.left != null)
            draw(n.left);
        if (n.right != null)
            draw(n.right);
    }

    // all points that are inside the rectangle (or on the boundary) 
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null)
            throw new IllegalArgumentException();

        ArrayList<Point2D> p = new ArrayList<Point2D>();

        inside(p, rect, root);

        return p;
    }

    private void inside(ArrayList<Point2D> arr, RectHV rect, Node n) {
        if (n == null)
            return;
        if (rect.contains(n.value)) {
            arr.add(n.value);
            inside(arr, rect, n.left);
            inside(arr, rect, n.right);
        }
        else if (n.orientation == VERTICAL) {
            if (rect.xmax() < n.key)
                inside(arr, rect, n.left);
            else if (rect.xmin() > n.key)
                inside(arr, rect, n.right);
            else {
                inside(arr, rect, n.left);
                inside(arr, rect, n.right);
            }
        }
        else {
            if (rect.ymax() < n.key)
                inside(arr, rect, n.left);
            else if (rect.ymin() > n.key)
                inside(arr, rect, n.right);
            else {
                inside(arr, rect, n.left);
                inside(arr, rect, n.right);
            }
            

        }
    }

    // // a nearest neighbor in the set to point p; null if the set is empty 
    public Point2D nearest(Point2D p) {
        if (p == null)
            throw new IllegalArgumentException();

        if (isEmpty())
            return null;


        Node closest = nearest(p, root, root);
        
        return closest.value;
    }

    private Node nearest(Point2D p, Node test, Node closest) {
        if (test == null)
            return closest;
        if (p.equals(test.value))
            return test;
        if (p.distanceSquaredTo(test.value) < p.distanceSquaredTo(closest.value)) {
            closest = test;
        }
        if (test.orientation == VERTICAL) {
            if (p.x() < test.key) {
                closest = nearest(p, test.left, closest);
                if (test.key - p.x() < p.distanceTo(test.value))
                    closest = nearest(p, test.right, closest);
            }
            else {
                closest = nearest(p, test.right, closest);
                if (p.x() - test.key < p.distanceTo(test.value))
                    closest = nearest(p, test.left, closest);
            }
        }
        else {
            if (p.y() < test.key) {
                closest = nearest(p, test.left, closest);
                if (test.key - p.y() < p.distanceTo(test.value))
                    closest = nearest(p, test.right, closest);
            }
            else {
                closest = nearest(p, test.right, closest);
                if (p.y() - test.key < p.distanceTo(test.value))
                    closest = nearest(p, test.left, closest);
            }

        }
        return closest;
        
    }

    // unit testing of the methods (optional) 
    public static void main(String[] args) {
        KdTree k = new KdTree();
        RectHV r = new RectHV(0.01, 0.5, 0.8, 0.9);

         // create initial board from file
        In in = new In(args[0]);
        while (in.hasNextLine()) {
                try{
                    k.insert(new Point2D(in.readDouble(), in.readDouble()));
                }
                catch (NoSuchElementException e){}
        }
        System.out.println(k.size());

        StdDraw.setScale(-0.05, 1.05);
        StdDraw.setPenRadius(0.02);
        StdDraw.setPenColor(StdDraw.BLUE);
        k.draw();

        StdDraw.setPenColor(StdDraw.GREEN);
        for (Point2D points : k.range(r))
            points.draw();
        
        StdDraw.setPenColor(StdDraw.BLUE);
        r.draw();
        
        StdDraw.setPenColor(StdDraw.RED);
        Point2D x = new Point2D(0.2, 0.3);
        x.draw();
        k.nearest(x).draw();


        // set.insert((0.0, 0.0))
        // set.insert((1.0, 0.0))
        // set.size()  ==>  2
        // set.nearest((0.0, 1.0))   ==>  (0.0, 0.0)
        // set.insert((0.0, 1.0))
        // set.nearest((1.0, 1.0))   ==>  (1.0, 0.0)
        // set.contains((1.0, 1.0))  ==>  false
        // set.insert((1.0, 1.0))
        // set.size()  ==>  3
    }
}