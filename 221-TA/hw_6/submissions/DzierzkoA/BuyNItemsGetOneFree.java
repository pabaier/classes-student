/*
    Class stores number of time coupon can be used and calculates discount based on that information and given price

    author: Adam Dzierzko
 */

public class BuyNItemsGetOneFree extends DiscountPolicy  {

    private int n;

    public BuyNItemsGetOneFree(int n) {
        this.n = n;
    }

    @Override
    double computeDiscount(int quantity, double itemCost) {
        return (int)(quantity/n) * itemCost;
    }
}
