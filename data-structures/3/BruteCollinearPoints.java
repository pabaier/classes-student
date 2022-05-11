import java.util.ArrayList;
import java.util.Arrays;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;


public class BruteCollinearPoints {

    private final ArrayList<LineSegment> lineSegments = new ArrayList<>();

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        if (points == null)
            throw new IllegalArgumentException();

        // copy array
        // check for null points
        Point[] pointsCopy = new Point[points.length];
        for (int i = 0; i < pointsCopy.length; i++) {
            if (points[i] == null)
                throw new IllegalArgumentException();
            pointsCopy[i] = points[i];
        }

        Arrays.sort(pointsCopy);

        // check for duplicate points
        for (int i = 0; i < pointsCopy.length - 1; i++) {
            if (pointsCopy[i].compareTo(pointsCopy[i + 1]) == 0)
                throw new IllegalArgumentException();
        }

        // brute force algorithm
        for (int w = 0; w < pointsCopy.length - 3; w++) {
            for (int x = w + 1; x < pointsCopy.length - 2; x++) {
                for (int y = x + 1; y < pointsCopy.length - 1; y++) {
                    if (pointsCopy[w].slopeTo(pointsCopy[x]) != pointsCopy[x].slopeTo(pointsCopy[y]))
                        continue;
                    for (int z = y + 1; z < pointsCopy.length; z++) {
                        if (pointsCopy[w].slopeTo(pointsCopy[x]) == pointsCopy[y].slopeTo(pointsCopy[z]))
                            lineSegments.add(new LineSegment(pointsCopy[w], pointsCopy[z]));
                    }
                    
                }
            }
        }
    }


    // // print the slopes
    // private void print(int w, int x, int y, int z) {
    //     System.out.println(pointsCopy[w].slopeTo(pointsCopy[x]) + " " +
    //     pointsCopy[x].slopeTo(pointsCopy[y]) + " " + pointsCopy[y].slopeTo(pointsCopy[z]));

    // }

    // // print the slopes
    // private void print(int w, int x, int y) {
    //     System.out.println(pointsCopy[w].slopeTo(pointsCopy[x]) + " " +
    //     pointsCopy[x].slopeTo(pointsCopy[y]) + " " + pointsCopy[w] + " " + pointsCopy[x] + " " + pointsCopy[y]);

    // }

    // the number of line segments
    public int numberOfSegments() {
        return lineSegments.size();

    }

    // the line segments
    public LineSegment[] segments() {
        return lineSegments.toArray(new LineSegment[lineSegments.size()]);
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

        BruteCollinearPoints b = new BruteCollinearPoints(pointArray);
        LineSegment[] segs = b.segments();

        System.out.println(b.numberOfSegments());

        StdDraw.enableDoubleBuffering();
        while (true) {
            StdDraw.clear();
            StdDraw.text(10000, 15000, (int) StdDraw.mouseX() + ", " + (int) StdDraw.mouseY());

            StdDraw.setPenColor(10, 10, 170);
            for (int i = 0; i < segs.length; i++)            
                segs[i].draw();

            
            StdDraw.setPenColor(10, 170, 10);
            for (int i = 0; i < pointArray.length; i++)            
                pointArray[i].draw();


            StdDraw.show();    
            StdDraw.pause(20);
        }

    }
}