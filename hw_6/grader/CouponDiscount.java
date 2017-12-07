
/**
 * Calculates discount using coupons
 *
 * @author Jacob Mattox
 * @version 11/13/17
 */
public class CouponDiscount extends DiscountPolicy
{
    //instance variables
    private double couponValue;
    private int maxUses;
    
    //constructor
    public CouponDiscount(double couponValue, int uses){
        this.couponValue = couponValue;
        maxUses = uses;
    }
    
    //overrides computeDiscount using instance variables to determine discount
    public double computeDiscount(int quantity, double itemCost){
        double discount = 0;
        if(quantity > maxUses)
            discount = maxUses * couponValue;
        else
            discount = quantity * couponValue;
        return discount;
    }
    
}
