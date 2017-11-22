import java.util.Arrays;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class BruteCollinearPoints {

    private final LineSegment[] lines;
    private int linesIndex;

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        if (points == null)
            throw new IllegalArgumentException();
        
        Point[] pCopy = new Point[points.length];

        // copy points into its own array and check for null values
        for (int i = 0; i < points.length; i++) {
            if(points[i] == null)
                throw new IllegalArgumentException();
            pCopy[i] = points[i];

        }
        
        Arrays.sort(pCopy);
        // print(pCopy);

        // check for duplicates
        for (int i = 0; i < pCopy.length - 1; i++) {
            if (pCopy[i].compareTo(pCopy[i + 1]) == 0)
                throw new IllegalArgumentException();
        }

        double delta = 0.001;

        // Point testPoint = new Point(1000, 17000);
        
        lines = new LineSegment[points.length * points.length];
        linesIndex = 0;
        for (int i = 0; i < points.length - 3; i++) {
            for (int j = i + 1; j < points.length - 2; j++) {
                for (int k = j + 1; k < points.length - 1; k++) {
                    for (int m = k + 1; m < points.length; m++) {
                        // if (pCopy[i].compareTo(testPoint) == 0)
                        //     StdOut.println(pCopy[j] + ", " + pCopy[k] + ", " + pCopy[m]);
                        if (Math.abs(pCopy[i].slopeTo(pCopy[j]) - pCopy[j].slopeTo(pCopy[k])) < delta ||
                            pCopy[i].slopeTo(pCopy[j]) == pCopy[j].slopeTo(pCopy[k])) {
                            if (Math.abs(pCopy[i].slopeTo(pCopy[j]) - pCopy[k].slopeTo(pCopy[m])) < delta ||
                                pCopy[i].slopeTo(pCopy[j]) == pCopy[k].slopeTo(pCopy[m])) {
                                lines[linesIndex] = new LineSegment(pCopy[i], pCopy[m]);
                                // StdOut.println("Connection: " + pCopy[i] + "--" + pCopy[m] + "\t" + i + ", " + j + ", " + k + ", " + m);
                                // StdOut.println(pCopy[i].slopeTo(pCopy[j]));
                                // StdOut.println(pCopy[j].slopeTo(pCopy[k]));
                                // StdOut.println(pCopy[k].slopeTo(pCopy[m]));
                                linesIndex++;
                            }
                        }
                    }
                }
            }
        }

    }
    
    // the number of line segments
    public int numberOfSegments() {
        return linesIndex;
    }
    
    // the line segments
    public LineSegment[] segments() {
        LineSegment[] temp = new LineSegment[linesIndex];
        for (int i = 0; i < linesIndex; i++)
            temp[i] = lines[i];
        return temp;
    }

    // private static void print(Point[] p) {
    //     for (int i = 0; i < p.length; i++)
    //         StdOut.println(p[i]);
    // }

    public static void main(String[] args) {

        int inputs = StdIn.readInt();
        Point[] pointArray = new Point[inputs];
        for (int i = 0; i < inputs; i++) { 
            pointArray[i] = new Point (StdIn.readInt(), StdIn.readInt());
        }
        BruteCollinearPoints b = new BruteCollinearPoints(pointArray);
        
        for (int i = 0; i < b.segments().length; i++) {
            StdOut.println(b.segments()[i]);
        }

        StdDraw.setScale(-1000, 25000);
        StdDraw.setPenRadius(0.02);
        
        StdDraw.enableDoubleBuffering();
        while (true) {
            StdDraw.clear();
            StdDraw.text(10000, 22000, (int) StdDraw.mouseX() + ", " + (int) StdDraw.mouseY());
            
            StdDraw.setPenColor(10, 170, 10);
            for (int i = 0; i < b.segments().length; i++) {
                b.segments()[i].draw();
                // StdOut.println(b.segments()[i]);
            }

            StdDraw.setPenColor(10, 10, 170);
            for(int i = 0; i < pointArray.length; i++) {
                pointArray[i].draw();
            }
        
            StdDraw.show();    
            StdDraw.pause(20);
            StdDraw.setPenColor(10, 170, 10);
            for (int i = 0; i < b.segments().length; i++) {
                b.segments()[i].draw();
                // StdOut.println(b.segments()[i]);
            }

            StdDraw.setPenColor(10, 10, 170);
            for(int i = 0; i < pointArray.length; i++) {
                pointArray[i].draw();
            }
        
            StdDraw.show();    
            StdDraw.pause(100);
        }
        
        
    }
}