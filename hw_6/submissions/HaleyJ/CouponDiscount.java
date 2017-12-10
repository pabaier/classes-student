public class CouponDiscount extends DiscountPolicy{
    private double couponValue=0.0;
    private int maxUses = 0;
    public CouponDiscount(double val, int uses){
        couponValue = val;
        maxUses = uses;
    }
    public double computeDiscount(int q, double cost){
        if(q >= maxUses) {
            cost = couponValue * maxUses;
        }else if(q < maxUses){
            cost = q*couponValue;
        }
        return cost;
    }
}