
/**
 * BuyNItemsGetOneFree
 * Calculates the discount based on how many items are bought, the item cost, and how many are in the "Buy N get one free" sale
 *
 * Ashley Woods
 */
public class BuyNItemsGetOneFree extends DiscountPolicy
{
    int n;
    
    public BuyNItemsGetOneFree(int N) {
        n = N;
    }
    
    public double computeDiscount (int quantity, double itemCost) {
        double discount = (quantity / n) * itemCost;
        return discount;
    }
}
