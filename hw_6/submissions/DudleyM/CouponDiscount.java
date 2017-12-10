public class CouponDiscount extends DiscountPolicy {

    private double couponValue;
    private int maxUses;

    public CouponDiscount(double couponValue, int uses){
        this.couponValue = couponValue;
        maxUses = uses;
    }

    public double computeDiscount(int quantity, double itemCost) {
        int discount = 0;
        for (int i = 1; i <= quantity; i++) {
            if (i <= maxUses) {
                discount += couponValue;
            }
        }
        return discount;
    }
}
