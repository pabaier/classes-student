
/**
 * Provides a discount for items with multiple applicable discount, giving the discount with the greatest discount amount.
 * 
 * @author Carson Barber
 */
public class CombinedDiscount extends DiscountPolicy
{
    private DiscountPolicy dis1;
    private DiscountPolicy dis2;
    public CombinedDiscount(DiscountPolicy d1, DiscountPolicy d2)
    {
        dis1 = d1;
        dis2 = d2;
    }
    public double computeDiscount(int quantity, double itemCost){
        double dis1Discount = dis1.computeDiscount(quantity, itemCost);
        double dis2Discount = dis2.computeDiscount(quantity, itemCost);
        if(dis1Discount>dis2Discount)return dis1Discount;
        return dis2Discount;
    }
}
