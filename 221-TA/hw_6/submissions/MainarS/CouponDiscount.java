public class CouponDiscount extends DiscountPolicy {
    private double couponValue;
    private int uses;
    public CouponDiscount(double couponValue, int uses){
        this.couponValue = couponValue;
        this.uses = uses;
    }
    @Override
    public double computeDiscount(int quantity, double itemCost){
        if(quantity < uses){
            return quantity*couponValue;
        }
        return uses*couponValue;
    }
}
