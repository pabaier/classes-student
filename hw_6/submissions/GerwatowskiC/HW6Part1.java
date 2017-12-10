
/**
 * Test driver for discounts
 *
 * Claire Gerwatowski
 */
public class HW6Part1
{
    public static void main(String [] args)
    {
        BulkDiscount bd = new BulkDiscount(5,10);
        BuyNItemsGetOneFree bni = new BuyNItemsGetOneFree(4);
        CombinedDiscount cd = new CombinedDiscount(bd,bni);
        CouponDiscount coupd = new CouponDiscount(10,3);
        System.out.println("BulkDiscount\nMinimum: 5, Percent: 10, Quantity: 40, Item Cost: 10, Discount: " + bd.computeDiscount(40,10)+ "\n");
        System.out.println("BuyNItemsGetOneFree Discount\nN: 4, Quantity: 20, Item Cost: 5, Discount: " + bni.computeDiscount(20,5) + "\n");
        System.out.println("CombinedDiscount with Bulk Discount and BuyNItemsGetOneFree\nQuantity: 30, Item Cost: 15, Discount: " + cd.computeDiscount(30,15) + "\n");
        System.out.println("CouponDiscount\nCoupon Value: 10, Max Uses: 3, Quantity: 25, Item Cost: 12, Discount: " + coupd.computeDiscount(25,12));
    }
}
