
/**
 * used to test all extensions of the Discount Policy abstract class.
 *
 * @Dustin Cragg
 * @11/17/2017
 */
public class HW6Part1
{
    public static void main(String[] args)
    {
        BulkDiscount discountOne = new BulkDiscount();
        discountOne.minimum = 5;
        discountOne.percent = 5;
        
        BuyNItemsGetOneFree discountTwo = new BuyNItemsGetOneFree();
        discountTwo.n = 5;
        
        //CombinedDiscount discountThree = new CombinedDiscount();
        //discountThree.one = discountOne.computeDiscount(20,5);
        //discountThree.two = discountTwo.computeDiscount(20,5);
        CouponDiscount discountFour = new CouponDiscount();
        discountFour.couponValue = 5;
        discountFour.maxUses = 2;
        
        
        
        System.out.println(discountOne.computeDiscount(20,5));
        System.out.println(discountTwo.computeDiscount(20,5));
        System.out.println(discountFour.computeDiscount(20,5));
    }
}
