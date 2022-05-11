
/**
 * Provides a discount to items purchased of couponValue, up to maxUses times per purchase
 * 
 * @author Carson Barber
 */
public class CouponDiscount extends DiscountPolicy
{
    private double couponValue;
    private int maxUses;
    public CouponDiscount(double val, int uses)
    {
        couponValue = val;
        maxUses = uses;
    }
    public double computeDiscount(int quantity, double itemCost){
        double discount = 0;
        int itemsLeft = quantity;
        int usesLeft = maxUses;
        while(usesLeft>0 && itemsLeft>0){
            discount+=couponValue;
            itemsLeft--;
            usesLeft--;
        }
        //prevent discount from exceeding total cost of purchase
        if(couponValue>itemCost)discount-=(couponValue-itemCost)*quantity;
        return discount;
    }
}
