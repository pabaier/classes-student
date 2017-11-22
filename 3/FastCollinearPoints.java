import java.util.Collections;
import java.util.Arrays;
import java.util.ArrayList;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

public class FastCollinearPoints {

    private final ArrayList<LineSegment> lineSegments = new ArrayList<>();


    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {

        if (points == null)
            throw new IllegalArgumentException();

        // copy array
        // check for null points
        ArrayList<Point> pointsCopy = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null)
                throw new IllegalArgumentException();
            pointsCopy.add(points[i]);
        }

        Collections.sort(pointsCopy);

        // check for duplicate points
        for (int i = 0; i < pointsCopy.size() - 1; i++) {
            if (pointsCopy.get(i).compareTo(pointsCopy.get(i + 1)) == 0)
                throw new IllegalArgumentException();
        }

        Point check = new Point(13000, 0);

        for (int i = 0; i < points.length; i++) {
            ArrayList<Double> slopes = new ArrayList<>();
            Point origin = points[i];

            // get all of the slopes
            for (int j = i + 1; j < points.length; j++) {
                slopes.add(origin.slopeTo(points[j]));
            }

            // sort slopes low to hig
            Collections.sort(slopes);

            // sort points relative to slope with origin (origin is at index 0)
            Collections.sort(pointsCopy, origin.slopeOrder());

            if (origin.compareTo(check) == 0) {
                for(int q = 0; q < slopes.size(); q++)
                    System.out.println(slopes.get(q));
                for(int q = 0; q < pointsCopy.size(); q++)
                    System.out.println(pointsCopy.get(q));
            }
 
            // check how many in a row for slopes
            boolean hit = false;
            ArrayList<Point> lineSeg = new ArrayList<>();
            lineSeg.add(origin);
            for (int j = 0; j < slopes.size() - 1; j++) {
            
                if (slopes.get(j).equals(slopes.get(j + 1))) {
                    lineSeg.add(pointsCopy.get(j + 1));
                    hit = true;

                    if (j == slopes.size() - 2) {
                        lineSeg.add(pointsCopy.get(j + 1));
                        if (lineSeg.size() >= 4) {
                            lineSegments.add(getMaxSegment(lineSeg));
                        }

                    }
                }
                else {
                    if (origin.compareTo(check) == 0)
                        System.out.println(lineSeg);
                    if (hit) {
                        lineSeg.add(pointsCopy.get(j + 1));
                        hit = false;
                    }
                    if (lineSeg.size() >= 4) {
                        lineSegments.add(getMaxSegment(lineSeg));
                    }
                    lineSeg = new ArrayList<>();
                    lineSeg.add(origin);
                }
            }
            pointsCopy.remove(0);
        }

    }

    // returns the maximum line segment from an array list of points
    private LineSegment getMaxSegment(ArrayList<Point> pointList) {
        Collections.sort(pointList);
        return new LineSegment(pointList.get(0), pointList.get(pointList.size() - 1));
    }

    // the number of line segments 
    public int numberOfSegments() {
        return lineSegments.size();
    }

    // the line segments      
    public LineSegment[] segments() {
                return lineSegments.toArray(new LineSegment[lineSegments.size()]);
    }

    public static void main(String[] args) {
        
        StdDraw.setScale(-1000, 31000);
        StdDraw.setPenRadius(0.02);

        int inputs = StdIn.readInt();
        Point[] pointArray = new Point[inputs];
        for (int i = 0; i < inputs; i++) { 
            pointArray[i] = new Point (StdIn.readInt(), StdIn.readInt());
        }

        FastCollinearPoints b = new FastCollinearPoints(pointArray);
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