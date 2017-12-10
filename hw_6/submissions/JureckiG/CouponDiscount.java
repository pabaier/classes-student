//Gabe Jurecki
public class CouponDiscount extends DiscountPolicy {
    private double couponValue;
    private int maxUses;

    public CouponDiscount(double couponValue,int maxUses ) {
        this.couponValue = couponValue;
        this.maxUses = maxUses;
    }

    @Override
    double computeDiscount(int quantity, double itemCost) {
        double discount = 0.0;
         discount = maxUses * couponValue;
        return discount;
    }

    @Override
    public String toString() {
        return "Discount:";
    }
}
