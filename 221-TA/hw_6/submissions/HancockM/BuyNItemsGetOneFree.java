import java.util.*;
/**
 * Write a description of class BuyNItemsGetOneFree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BuyNItemsGetOneFree extends DiscountPolicy
{
    // instance variables - replace the example below with your own
    private int n;

    /**
     * Constructor for objects of class BuyNItemsGetOneFree
     */
    public BuyNItemsGetOneFree(int n)
    {
        this.n = n;
    }

    public double computeDiscount(int quantity, double itemCost)
    {
        int freebies = quantity / n;
        return freebies * itemCost;
    }
}
