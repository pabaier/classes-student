package fractionassignment;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class encapsulates mathematical fractions (or rational numbers).
 * Fractions have a numerator and a denominator, both of type long.
 * All fractions are normalized when they are constructed.  A normalized
 * fraction has a positive denominator and is in reduced form.  For
 * example, the fraction 2/4 is normalized to 1/2, and the fraction
 * 3/(-4) is normalized to (-3)/4.  Also, all fraction objects are
 * immutable;  they cannot be changed once they have been constructed.
 */
public final class Fraction implements Comparable<Fraction>
{
    private final long numerator;
    private final long denominator;

    public static final Fraction ZERO = new Fraction(0);
    public static final Fraction ONE = new Fraction(1);

    /**
     * Construct a fraction with the given numerator and with a denominator of 1.
     * @ param numerator the numerator of the fraction.
     */
    public Fraction(long numerator)
    {
        this.numerator = numerator;
        this.denominator = 1;
    }

    /** 
     * Constructs a fraction with the given numerator and denominator.
     * @param numerator the numerator of the fraction.
     * @param denominator the denominator of the fraction.
     * @throws IllegalArgumentException if the denominator is 0.
     */
    public Fraction(long numerator, long denominator)
    {
        if(denominator == 0)
            throw new IllegalArgumentException("Denominator can't be 0");

        if(numerator == 0)
        {
            this.numerator = 0;
            this.denominator = 1;
        }
        else
        {
            if(denominator < 0)
            {
                numerator *= -1;
                denominator *= -1;
            }

            long greatest = gcd(numerator, denominator);
            this.numerator = numerator / greatest;
            this.denominator = denominator / greatest;
        }
    }

    /**
     * Returns the value of the fraction's numerator.
     */
    public long getNumerator()
    {
        return numerator;
    }

    /**
     * Returns the value of the fraction's denominator.
     */
    public long getDenominator()
    {
        return denominator;
    }

    /**
     * Returns value of the fraction converted to a double, where
     * the numerator is divided by the denominator.
     */
    public double toDouble()
    {
        return (double)numerator / denominator;
    }

    /**
     * Returns a new Fraction that is the result of adding the
     * specified Fraction to this Fraction.
     * 
     * @param f the Fraction to be added.
     */
    public Fraction add(Fraction f)
    {
        long topOne = numerator * f.getDenominator();
        long topTwo = denominator * f.getNumerator();
        long bottom = denominator * f.getDenominator();

        long top = topOne + topTwo;

        return new Fraction (top, bottom);
    }

    /** 
     * Returms a new Fraction that is the result of subtracting the
     * specified Fraction from this Fraction.
     * 
     * @param f the Fraction to be subtracted.
     */
    public Fraction subtract(Fraction f)
    {
        long topOne = numerator * f.getDenominator();
        long topTwo = denominator * f.getNumerator();
        long bottom = denominator * f.getDenominator();

        long top = topOne - topTwo;

        return new Fraction (top, bottom);
    }

    /** 
     * Returms a new Fraction that is the result of multiplying the
     * specified Fraction from this Fraction.
     * 
     * @param f the Fraction to be multiplied.
     */
    public Fraction multiply(Fraction f)
    {
        return new Fraction(numerator * f.getNumerator(), denominator * f.getDenominator());
    }

    /** 
     * Returms a new Fraction that is the result of dividing this
     * Fraction by the specified Fraction.
     * 
     * @param f the Fraction to be used as the divisor.
     *
     * @throws IllegalArgumentException if the specified fraction
     *         is Fraction(0, 1).
     */
    public Fraction divide(Fraction f)
    {
        if(f.equals(ZERO))
            throw new IllegalArgumentException("Can't divide by zero!");
  
        return new Fraction(numerator * f.getDenominator(), denominator * f.getNumerator());
    }

    /**
     * Returns a new Fraction that is the result of adding 1 to this Fraction.
     */
    public Fraction inc()
    {
        return new Fraction(numerator + denominator, denominator);
    }

    /** 
     * Returns the negation of this Fraction.
     */
    public Fraction negate()
    {
        return new Fraction(numerator * -1, denominator);
    }

    /**
     * Returns a string representation for the fraction of the form
     * "n/d", where n is the numerator and d is the denominator.
     */
    @Override
    public String toString()
    {
        return numerator + "/" + denominator;
    }

    /**
     * Compares this Fraction with the specified Fraction.
     *
     * @param f the Fraction to be compared.
     * 
     * @return a negative integer, zero, or positive integer as this
     *         Fraction is less than, equal to, or greater than the
     *         specified Fraction.
     */
    public int compareTo(Fraction f)
    {
        Fraction result = this.subtract(f);
        if (result.getNumerator() > 0)
            return 1;
        else if (result.getNumerator() < 0)
            return -1;
        else
            return 0; 
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;

        result = prime * result + (int) (denominator ^ (denominator >>> 32));
        result = prime * result + (int) (numerator ^ (numerator >>> 32));

        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof Fraction) {
            Fraction f = (Fraction)obj;
            return this.numerator == f.getNumerator() && this.denominator == f.getDenominator();
        }
    }

    /** 
    * Compute the gratest common divisor of two longs.
    */
    private static long gcd(long a, long b)
    {
        long a1 = Math.abs(a);
        long b1 = Math.abs(b);
        long temp;

        while(b1 != 0)
        {
            temp = a1;
            a1 = b1;
            b1 = temp % b1;
        }
        return a1;
    }

    /**
     * Returns a new Fraction that is the result of adding the specified
     * Fraction's numerator and denominator to this Fraction's
     * numerator and denominator.
     * 
     * @param f the Fraction to be added.
     */
    public Fraction fareyAdd(Fraction f)
      {
        long numer = this.numerator + f.getNumerator();
        long denom = this.denominator + f.getDenominator();

        return new Fraction(numer, denom);
      }

    /**
     * Returns an ArrayList of fractions in a Farey sequence of order n.
     * 
     * @param n the order of the Farey sequence
     */
    public static ArrayList<Fraction> fareySequence(int n)
    {
      ArrayList<Fraction> fList = new ArrayList<>();
      if (n <= 0)
        return fList;
      fList.add(new Fraction(0,1));
      fList.add(new Fraction(1,1));
      if (n == 1)
        return fList;

      for(int i = 1; i < n; i++) {
        int den = (int) fList.get(1).getDenominator() + 1;
        for(int j = 0; j < den; j++) {
          Fraction f = new Fraction(j, den);
          if(f.getDenominator() == den)
            fList.add(f);
        }
        Collections.sort(fList);
      }

      return fList;
      

    }
}