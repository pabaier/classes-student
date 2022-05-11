
/**
 * Provides a discount for items with a buy n get one free policy.
 * 
 * @author Carson Barber
 */
public class BuyNItemsGetOneFree extends DiscountPolicy
{
    private int n;
    
    public BuyNItemsGetOneFree(int num)
    {
        n = num;
    }
    
    public double computeDiscount(int quantity, double itemCost){
        int numFree = quantity/n;
        return numFree * itemCost;
    }
}
