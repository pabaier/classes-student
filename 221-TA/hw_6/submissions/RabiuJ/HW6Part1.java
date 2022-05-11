
/**
 * Test driver to test discounts
 *
 * Jonathan Rabiu
 * 
 */
public class HW6Part1
{
   public static void main(String[] args){
       BulkDiscount trip1 = new BulkDiscount(5, 20);
       System.out.println("Bulk Discount: " + trip1.computeDiscount(6,31));// should have discount
       System.out.println("Bulk Discount (no discount): " + trip1.computeDiscount(4,22));// no discount
       
       BuyNItemsGetOneFree trip2 = new BuyNItemsGetOneFree(3);
       System.out.println("Buy 3 Items Get One Free discount: " + trip2.computeDiscount(3,10));
       System.out.println("Buy 6 Items discount: " + trip2.computeDiscount(6,10));
       System.out.println("Buy 8 Items discount: " + trip2.computeDiscount(8,10));
       System.out.println("Buy 5 Items discount: " + trip2.computeDiscount(5,10));
       System.out.println("Buy 7 Items discount: " + trip2.computeDiscount(7,10));
       System.out.println("Buy 9 Items discount: " + trip2.computeDiscount(9,10));
       BuyNItemsGetOneFree trip2b = new BuyNItemsGetOneFree(4);
       System.out.println("(N4) Buy 4 Items discount: " + trip2b.computeDiscount(4,10));
       
       CombinedDiscount trip3 = new CombinedDiscount(trip1, trip2b);
       System.out.println("Combined Discount: " + trip3.computeDiscount(10,10));
       
       CouponDiscount trip4 = new CouponDiscount(5, 2);
       System.out.println("Coupon Discount: " + trip4.computeDiscount(13, 41));
    }
       
}
