import edu.princeton.cs.algs4.StdDraw;


public class testing {

    public static void main(String[] args) {

        StdDraw.setXscale(0.0, 10.0);
        StdDraw.setYscale(0.0, 10.0);
        StdDraw.setPenRadius(0.02);
        Point p1 = new Point(3, 4);
        Point p2 = new Point(3,7);
        Point p3 = new Point(5, 4);
        Point p4 = new Point(5,7);
        p1.draw();
        p2.draw();

        System.out.println(p1.slopeTo(p2));
        System.out.println(p3.slopeTo(p4));
        System.out.println(Math.abs(p1.slopeTo(p2) - p3.slopeTo(p4)));
        
    }






}