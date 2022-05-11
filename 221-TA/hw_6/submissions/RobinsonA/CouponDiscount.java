
/**
 * Ariel Robinson
 *
 *returns the discount based on the coupon limit and how many uses it has
 *
 */
public class CouponDiscount extends DiscountPolicy
{
    // instance variables 
    private double couponValue;
    private int maxUses;

    /**
     * Constructor for objects of class CouponDiscount
     */
    public CouponDiscount(double couponValue, int maxUses)

    {

        this.couponValue=couponValue;
        this.maxUses=maxUses;
    }

    public double computeDiscount(int quantity, double itemCost)
    {
        double discount=0;
        if(quantity<maxUses){
            discount=(couponValue)*quantity;

        }
        else{
            discount=(couponValue)*maxUses;
        }
        return discount ;
    }
}
