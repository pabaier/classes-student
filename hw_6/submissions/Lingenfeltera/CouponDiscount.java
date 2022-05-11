
/**
 * CouponDiscount extends DiscountPolicy.  Takes the coupon value and the
 * number of times the coupon can be used on a single puchase.
 *
 * @author Andrea Lingenfelter
 * @version November 12, 2017
 */
public class CouponDiscount extends DiscountPolicy{

    // instance variables - replace the example below with your own
    private double couponValue;
    private int maxUses;

    public CouponDiscount(double couponValue, int maxUses){
         this.couponValue = couponValue;
         this.maxUses = maxUses;
    }

    
    public double computeDiscount(int quantity, double itemCost) {
        double discount;
        discount = (Math.min(maxUses, quantity) * couponValue);
        
        return discount;
    }
}
