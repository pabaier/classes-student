
/**
 * Write a description of class CouponDiscount here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CouponDiscount extends DiscountPolicy
{
    // instance variables - replace the example below with your own
    private double couponValue;
    private int maxUses;

    /**
     * Constructor for objects of class CouponDiscount
     */
    public CouponDiscount(double couponValue, int maxUses)
    {
        this.couponValue = couponValue;
        this.maxUses = maxUses;
    }

    public double computeDiscount(int quantity, double itemCost)
    {
        if(maxUses < quantity){
            return couponValue * maxUses;
        }else{
            return couponValue * quantity;
        }
    }
}
