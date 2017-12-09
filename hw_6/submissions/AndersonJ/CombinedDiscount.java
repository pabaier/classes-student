
/**
 *Jonathan Anderson
 * 
 */
public class CombinedDiscount extends DiscountPolicy
{
    DiscountPolicy dis1;
    DiscountPolicy dis2;
    public CombinedDiscount(DiscountPolicy dis1, DiscountPolicy dis2)
    {
        this.dis1 = dis1;
        this.dis2 = dis2;
    }
    public double computeDiscount(int quantity, double itemCost)
    {
        return 0;
    }
}
