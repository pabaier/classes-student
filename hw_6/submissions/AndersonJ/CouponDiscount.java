
/**
 * Jonathan Anderson
 * Calcualte the discount from a coupon
 */
public class CouponDiscount extends DiscountPolicy
{
    double couponValue;
    int maxUses;
    public CouponDiscount(double couponValue, int maxUses)
    {
       this.couponValue =  couponValue;
       this.maxUses = maxUses;
    }
    public double computeDiscount(int quantity, double itemCost)
    {
        couponValue = couponValue*maxUses;
        return couponValue;
    }
}
