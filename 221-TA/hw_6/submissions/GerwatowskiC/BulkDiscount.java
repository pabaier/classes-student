
/**
 * Creates a discount of a given percent if the quantity is bigger than the minimum necessary
 *
 * Claire Gerwatowski
 */
public class BulkDiscount extends DiscountPolicy
{
    private int minimum;
    private int percent;
    public BulkDiscount(int min, int per)
    {
        minimum = min;
        percent = per;
    }
    
    public double computeDiscount(int quantity,double itemCost) 
    {
        double discount;
        if (quantity > minimum) {
            discount = percent;
        }
        else {
            discount = 0;
        }
        return discount;
    }
}
