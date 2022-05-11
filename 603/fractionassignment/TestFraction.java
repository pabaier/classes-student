package fractionassignment;

import java.util.*;


public class TestFraction
  {
    public static void main(String[] args)
      {
        long numerator, denominator;
        Scanner in = new Scanner(System.in);
        Fraction f1, f2;

        do
          {
            System.out.println("Enter four integers representing two fractions (\"0 1 0 1\" to terminate):  ");

            numerator = in.nextLong();
            denominator = in.nextLong();
            f1 = new Fraction(numerator, denominator);

            numerator = in.nextInt();
            denominator = in.nextInt();
            f2 = new Fraction(numerator, denominator);

            if (!f1.equals(Fraction.ZERO) || !f2.equals(Fraction.ZERO))
              {
                System.out.println("f1 = " + f1 + "    f2 = " + f2);
                System.out.println();

                System.out.println("f1.toDouble() = " + f1.toDouble()
                    + "    f2.toDouble() = " + f2.toDouble());
                System.out.println();

                System.out.println("f1 == f2 is " + (f1 == f2));
                System.out.println("f1.equals(f2) is " + f1.equals(f2));
                System.out.println("f1.compareTo(f2) is " + f1.compareTo(f2));
                System.out.println();

                System.out.println("-f1 = " + f1.negate());
                System.out.println();

                System.out.println("f1 + f2 = " + f1.add(f2));
                System.out.println("f1 - f2 = " + f1.subtract(f2));
                System.out.println("f1 * f2 = " + f1.multiply(f2));
                System.out.println("f1 / f2 = " + f1.divide(f2));

                System.out.println();
              }
          }
        while (!f1.equals(Fraction.ZERO) && !f2.equals(Fraction.ZERO));

        // Fraction f = new Fraction(6.2);      // should not be permitted
        in.close();

        // Farey Fun!
        // Uses Princeton's StdDraw class to plot all denominators of a Farey Sequence
        int trials = 0;

        // get argument from command line
        if (args.length > 0)
          trials = Integer.parseInt(args[0]);

        // sets pen radius and color
        StdDraw.setPenRadius(0.02 );
        StdDraw.setPenColor(StdDraw.BLUE);
        
        // gets the Farey sequence up to specified number of trials
        ArrayList<Fraction> f = Fraction.fareySequence(trials);

        // sets the scale of the window
        StdDraw.setXscale(-5, f.size() + 5);
        StdDraw.setYscale(-5, trials + 5);

        // draws all the points in the Farey sequence
        for(int i = 1; i <= f.size(); i++) {
          StdDraw.point(i, f.get(i - 1).getDenominator());
        }
      }
  }
