
/**
 * Write a description of class BuyNItemsGetOneFree here.
 *
 * Steven Higgins
 *
 */
public class BuyNItemsGetOneFree extends DiscountPolicy
{
    private int n;
    public BuyNItemsGetOneFree(int n)
    {
        this.n = n;
    }
    public double computeDiscount(int quantity, double itemCost){
        double discount = 0;
        int freeItems = quantity / n;
        discount = freeItems * itemCost;
        return discount;
    }

}
