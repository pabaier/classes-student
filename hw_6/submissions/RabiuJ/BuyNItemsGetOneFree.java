
/**
 * Computes a discount so that every nth item is free
 *
 * Jonathan Rabiu
 * 
 */
public class BuyNItemsGetOneFree extends DiscountPolicy
{
    private int n;
    
    public BuyNItemsGetOneFree(int n){
        this.n = n;
    }
    
    @Override
    public double computeDiscount(int quantity, double itemCost){
        double discount = 0;
        discount = (quantity / n) * itemCost;
        return discount;
    }
    
}
