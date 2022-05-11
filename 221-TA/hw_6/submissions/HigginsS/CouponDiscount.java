
/**
 * Write a description of class CouponDiscount here.
 *
 * Steven Higgins
 * 
 */
public class CouponDiscount extends DiscountPolicy
{
    private double couponValue;
    private int maxUses;
    public CouponDiscount(double couponValue, int maxUses)
    {
        this.couponValue = couponValue;
        this.maxUses = maxUses;
    }
    public double computeDiscount(int quantity, double itemCost){
        double discount = 0;
        if(quantity < maxUses){
            discount = quantity * couponValue;
        }
        else if(quantity >= maxUses){
            discount = couponValue * maxUses;
        }
        return discount;
    }
}
