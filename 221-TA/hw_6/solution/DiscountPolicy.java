
/**
 * Abstract class DiscountPolicy - creates a single method for derived
 * classes to use
 *
 * @author Jacob Mattox
 * @version 11-11-17
 */
public abstract class DiscountPolicy
{
    public abstract double computeDiscount(int quantity, double itemCost);
}
