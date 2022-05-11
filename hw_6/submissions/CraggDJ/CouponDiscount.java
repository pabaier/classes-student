
/**
 * takes in a couponValue and maxuses to find the discount.
 *
 * @Dustin Cragg
 * @11/16/2017
 */
public class CouponDiscount extends DiscountPolicy
{
    double couponValue;
    int maxUses;
    //constructor takes two parameters 
    void CouponDiscount(double couponValue, int maxUses)
    {
        this.couponValue = couponValue;
        this.maxUses = maxUses;
    }
    //define computeDiscount
    double computeDiscount(int quantity, double itemCost)
    {
        double discount;
        if( quantity > maxUses)
        {
            discount = maxUses * couponValue;
        }
        else
        {
            discount = quantity * couponValue;
        }
        return discount;
    }
}
