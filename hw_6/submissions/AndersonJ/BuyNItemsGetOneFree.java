
/**
 * Jonathan Anderson
 * Calculate the discount with every n-th item for free
 */
public class BuyNItemsGetOneFree extends DiscountPolicy
{
    int n;
    public BuyNItemsGetOneFree(int n)
    {
        this.n = n;
    }
    public double computeDiscount(int quantity, double itemCost)
    {
        itemCost = itemCost*(n/quantity);
        return itemCost;
    }
}
