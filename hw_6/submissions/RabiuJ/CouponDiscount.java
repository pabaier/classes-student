
/**
 * Computes the discount based on the number of items purchased and the coupon limit
 * 
 * Jonathan Rabiu
 * 
 */
public class CouponDiscount extends DiscountPolicy
{
    private double couponValue;
    private int maxUses;
    
    public CouponDiscount(double couponValue, int uses){
        this.couponValue = couponValue;
        maxUses = uses;
    }
    
    @Override
    public double computeDiscount(int quantity, double itemCost){
        //returns discount by the number of times a coupon can be used and its value
        return maxUses * couponValue;
    }
}
