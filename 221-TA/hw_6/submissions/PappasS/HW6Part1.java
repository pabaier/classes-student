/*
* Stephen Pappas
*
* This class is a driver class that tests the different discount classes.
*
 */

public class HW6Part1 {
    public static void main(String[] args) {
        BulkDiscount ds1 = new BulkDiscount(4, 10);
        System.out.println("Bulk Discount: " + ds1.computeDiscount(3, 25));
        BuyNItemsGetOneFree ds2 = new BuyNItemsGetOneFree(1);
        System.out.println("BuyN Discount: " + ds2.computeDiscount(2, 9));
        CombinedDiscount ds3 = new CombinedDiscount(ds1, ds2);
        System.out.println("Combined Discount: " + ds3.computeDiscount(2, 3.50));
        CouponDiscount ds4 = new CouponDiscount(5, 3);
        System.out.println("Coupon Discount: " + ds4.computeDiscount(2, 9));
    }
}
