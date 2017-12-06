
/**
 * CombinedDiscount
 * Calculates the value of two discounts that apply and returns the value of the greater discount.
 *
 * Ashley Woods
 */
import java.lang.Math;
public class CombinedDiscount extends DiscountPolicy
{
    DiscountPolicy dis1;
    DiscountPolicy dis2;
    public CombinedDiscount (DiscountPolicy D1, DiscountPolicy D2) {
        dis1 = D1;
        dis2 = D2;
    }
    
    public double computeDiscount(int quantity, double itemCost) {
        double discount = Math.max(dis1.computeDiscount(quantity,itemCost),dis2.computeDiscount(quantity,itemCost));
        return discount;
    }
}
