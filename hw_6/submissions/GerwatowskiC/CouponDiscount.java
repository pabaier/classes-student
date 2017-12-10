
/**
 * Calculates discount of a coupon based on max number of uses
 *
 * Claire Gerwatowski
 */
public class CouponDiscount extends DiscountPolicy
{
    private double couponValue;
    private int maxUses;
    public CouponDiscount(double coupValue, int max) 
    {
        couponValue = coupValue;
        maxUses = max;
    }
    
    public double computeDiscount(int quantity,double itemCost) 
    {
        double discount;
        if (maxUses > quantity) {
            discount = (quantity*couponValue);
        }
        else {
            discount = (maxUses*couponValue);}
        
        return discount;
    }
}
