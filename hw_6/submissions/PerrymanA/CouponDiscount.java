//Asa Perryman

public class CouponDiscount extends DiscountPolicy{
    private double couponValue;
    private int maxUses;
    
    public CouponDiscount(double couponValue, int maxUses){
        this.couponValue = couponValue;
        this.maxUses = maxUses;
    }
    
    public double computeDiscount(int quantity, double itemCost){
        double discount = couponValue * maxUses;
        return discount;
    }
    
}