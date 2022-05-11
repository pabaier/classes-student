/* 
 * Sydney Jackson
 * CouponDiscount class is derived from DiscountPolicy and applies a discount
 * from a given coupon
 * Methods: computeDiscount()
 */
public class CouponDiscount extends DiscountPolicy{
    private double couponValue;
    private int maxUses;
    public CouponDiscount(double couponVal, int uses){
        couponValue = couponVal;
        maxUses = uses;
    }
    @Override
    public double computeDiscount(int quantity, double itemCost){
        double discount= 0.0;
        if (quantity >= maxUses){
            discount = maxUses * couponValue;
        }
        else if (quantity < maxUses){
            discount = couponValue * quantity;
        }
        return discount;
    }
}