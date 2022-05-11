
/**
 * Returns the bigger of two given discounts
 *
 * Claire Gerwatowski
 */
public class CombinedDiscount extends DiscountPolicy
{
    private DiscountPolicy discount1;
    private DiscountPolicy discount2;
    public CombinedDiscount(DiscountPolicy d1, DiscountPolicy d2) 
    {
        discount1 = d1;
        discount2 = d2;
    }
   
    public double computeDiscount(int quantity,double itemCost)
    {
        double disc1 = discount1.computeDiscount(quantity,itemCost);
        double disc2 = discount2.computeDiscount(quantity,itemCost);
        if (disc1>disc2) {
            return disc1;
        }
        else {
            return disc2;
        }
    }
}
