
/**
 * BulkDiscountClass
 * Returns the value of a discount based on how many items were purchased.
 *
 * Ashley Woods
 */
public class BulkDiscount extends DiscountPolicy
{
    int minimum;
    int percent;
    
    public BulkDiscount(int min, int perc) {
        minimum = min;
        percent = perc;
    }
    
    public double computeDiscount(int quantity, double itemCost) {
        double discount;
        if (quantity > this.minimum) {
            discount = ((double)percent/100) * (itemCost*quantity);
        }
        else {
            discount = 0;
        }
        return discount;
    }
}
