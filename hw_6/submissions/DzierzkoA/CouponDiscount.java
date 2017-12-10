/*
    Class stores coupon value and number of uses, calculates discount based on given quantity and cost

    author: Adam Dzierzko
 */

public class CouponDiscount extends DiscountPolicy {

    private double couponValue;
    private int uses;

    public CouponDiscount(double couponValue, int uses){
        this.couponValue = couponValue;
        this.uses = uses;

    }
    @Override
    double computeDiscount(int quantity, double itemCost) {
        return quantity >= uses ?  uses * couponValue : quantity * couponValue;
    }
}
