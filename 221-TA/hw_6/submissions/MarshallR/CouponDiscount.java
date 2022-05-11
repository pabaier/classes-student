
/**
 * Class CouponDiscount - A class for finding discounts based on coupons being used in a purchase
 *
 * @author Richard Marshall
 * @version 11/17/17
 */
public class CouponDiscount extends DiscountPolicy
{
    private double couponValue; //value of each use of the coupon
    private int maxUses; //maximum number of times a coupon can be used on a single purchase

    /**
     * Constructor for objects of class CouponDiscount
     */
    public CouponDiscount(double couponValue, int maxUses)
    {
        this.couponValue = couponValue;
        this.maxUses = maxUses;
    }

    /**
     * computeDiscount - computes the discount value of a coupon from a purchase
     * 
     * @param  quantity  the number of items being purchased
     * @param  itemCost  the cost of each individual item being purchased
     * @return    the coupon value times the max number of uses it can be used on a purchase, either limited by the maxUses or the quantity if that's lower than maxUses
     */
    @Override
    public double computeDiscount(int quantity, double itemCost)
    {
        double discount = couponValue * maxUses;
        
        if (quantity < maxUses) {
            discount = couponValue * quantity;
        }
        
        return discount;
    }
}
