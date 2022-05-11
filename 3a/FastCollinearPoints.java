import java.util.Arrays;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;


public class FastCollinearPoints {

    private final LineSegment[] lines;
    private int linesIndex;

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) { 
        lines = new LineSegment[points.length];
        linesIndex = 0;
        double delta = 0.001;
        
        Point[] pCopy = new Point[points.length];
        Point testUpper = new Point(32767, 32767);
        Point testLower = new Point(0, 0);

        // copy points into its own array and check for null values and range
        for (int i = 0; i < points.length; i++) {
            if(points[i] == null || points[i].compareTo(testLower) < 0 || points[i].compareTo(testUpper) > 0)
                throw new IllegalArgumentException();
            pCopy[i] = points[i];
        }

        Arrays.sort(pCopy);

        // check for duplicates
        for (int i = 0; i < pCopy.length - 1; i++) {
            if (pCopy[i].compareTo(pCopy[i + 1]) == 0)
                throw new IllegalArgumentException();
        }

        for (int i = 0; i < points.length - 1; i++) {

            
            Point origin = pCopy[i];
            double[] slopes = new double[pCopy.length - 1];
            int slopeIndex = 0;
            Arrays.sort(pCopy, origin.slopeOrder());

            // get first slope from origin
            slopes[slopeIndex] = origin.slopeTo(pCopy[i + 1]);
            slopeIndex++;

            int inARow = 0;

            // get all the slopes from the origin
            // keeps track of previous, current, and next
            for (int j = i + 2; j < pCopy.length; j++) {
                slopes[slopeIndex] = origin.slopeTo(pCopy[j]);

                if (Math.abs(slopes[slopeIndex] - slopes[slopeIndex - 1]) < delta) {
                    inARow++;
                    if (inARow >= 3)
                        lines[linesIndex] = new LineSegment(origin, pCopy[j]);
                }
                else {
                    if (inARow >= 3)
                        linesIndex++;
                    inARow = 0;
                }

                // StdOut.println(slopes[slopeIndex] + "\t" + pCopy[j]);
                slopeIndex++; 
            }
            
            
        }
    }

    // the number of line segments
    public int numberOfSegments() {
        return linesIndex;
    }

    // the line segments
    public LineSegment[] segments() {
        LineSegment[] temp = new LineSegment[lines.length];
        for (int i = 0; i < lines.length; i++)
            temp[i] = lines[i];
        return temp;
    }

    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();

        FastCollinearPoints f = new FastCollinearPoints(points);
    }

}