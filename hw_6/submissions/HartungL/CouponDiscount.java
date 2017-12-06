
/**
 * class CouponDiscount - Ment to extend DiscountPolicy to include coupons
 *
 * @author Lexus Hartung
 */
public class CouponDiscount extends DiscountPolicy{
    private double couponValue;
    private int maxUses;

    //Constructor for objects of class CouponDiscount
    public CouponDiscount(double couponValue, int maxUses){
        this.couponValue = couponValue;
        this.maxUses = maxUses;
    }
    
    //Uses quantity to determine how many coupons can be used
    public double computeDiscount (int quantity,double itemCost){
        if (quantity >= maxUses){
            return couponValue * maxUses;
        }
        else{
            return couponValue * quantity;
        }
    }
}
