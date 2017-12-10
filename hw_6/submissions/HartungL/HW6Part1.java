
/**
 * class HW6Part1 - Used to test all of the classes derived from 
 * DiscountPolicy
 *
 * @author Lexus Hartung
 */
public class HW6Part1{
    public static void main(String[] args){
        BulkDiscount bulk = new BulkDiscount(2,10);
        BuyNItemsGetOneFree oneFree = new BuyNItemsGetOneFree(4);
        CombinedDiscount combine = new CombinedDiscount(bulk,oneFree);
        CouponDiscount coupon = new CouponDiscount(5,3);
        
        //Tests BulkDiscount with more items than the minimum
        System.out.println("Bulk Discount get discount " + 
        bulk.computeDiscount(3,15.0));
        //Tests BulkDiscount with less items than the minimum
        System.out.println("Bulk Discount don't get discount " + 
        bulk.computeDiscount(1,15.0));
        
        //Tests BuyNItemsGetOneFree with more than enough items
        System.out.println("Buy N Items Get One Free more than enough " + 
        oneFree.computeDiscount(9,15.0));
        //Tests BuyNItemsGetOneFree with just enough items
        System.out.println("Buy N Items Get One Free just enough " + 
        oneFree.computeDiscount(4,15.0));
        //Tests BuyNItemsGetOneFree with not enough items
        System.out.println("Buy N Items Get One Free not enough " + 
        oneFree.computeDiscount(2,15.0));
        
        //Tests CombinedDiscount with first discount larger
        System.out.println("Combined Discount d1 (BulkDiscount) bigger " + 
        combine.computeDiscount(3,15.0));
        //Tests CombinedDiscount with second discount larger
        System.out.println("Combined Discount d2 (BuyNItemsGetOneFree) bigger " + 
        combine.computeDiscount(9,15.0));
        
        //Tests CouponDiscount with more items than coupons
        System.out.println("Coupon Discount more items " + 
        coupon.computeDiscount(4,10));
        //Tests CouponDiscount with less items than coupons
        System.out.println("Coupon Discount less items " + 
        coupon.computeDiscount(2,10));
    }
}
