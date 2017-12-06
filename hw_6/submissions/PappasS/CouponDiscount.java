/*
* Stephen Pappas
*
* This class is an extension of Discount Policy. It creates an object, CouponDiscount that takes in a coupon's value and the number of uses
* . Its method computes the discount.
*
 */

public class CouponDiscount extends DiscountPolicy{
    private double couponValue;
    private int maxUses;

    public CouponDiscount(double couponValue, int maxUses){
        this.couponValue = couponValue;
        this.maxUses = maxUses;
    }

    public double computeDiscount(int quantity, double itemCost){
        if(quantity > maxUses)
            return couponValue * maxUses;
        else
            return couponValue * quantity;
    }
}
