
/**
 * Creates a discount that gives the nth item free
 *
 * Claire Gerwatowski
 */
public class BuyNItemsGetOneFree extends DiscountPolicy
{
    private int n;
    
    public BuyNItemsGetOneFree(int n)
    {
        this.n = n;
    }
    
    public double computeDiscount(int quantity, double itemCost)
    {
        double discount = 0;
        discount = ((quantity/n)*itemCost);
        return discount;
    }
}
