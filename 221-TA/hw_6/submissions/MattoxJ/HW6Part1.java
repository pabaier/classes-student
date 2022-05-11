import java.text.NumberFormat;
/**
 * Tests different discount classes 
 *
 * @ author Jacob Mattox
 * @version 11/13/2017
 */
public class HW6Part1
{
    public static void main(){
        //instances of each class
        DiscountPolicy bulk = new BulkDiscount(25, 10);
        DiscountPolicy buyN = new BuyNItemsGetOneFree(4);
        DiscountPolicy coupon = new CouponDiscount(5, 15);
        DiscountPolicy combinedBulkAndBuyN = new CombinedDiscount(bulk, buyN);
        DiscountPolicy combinedBulkAndCoupon = new CombinedDiscount(bulk, coupon);
        DiscountPolicy combinedCouponAndBuyN = new CombinedDiscount(coupon, buyN);
        
        
        //testing discounts and choosing largest discount
        System.out.println("1. " + NumberFormat.getCurrencyInstance().format(bulk.computeDiscount(100, 2.5)));
        System.out.println("2. " + NumberFormat.getCurrencyInstance().format(buyN.computeDiscount(100, 2.5)));
        System.out.println("3. " + NumberFormat.getCurrencyInstance().format(coupon.computeDiscount(100, 2.5)));
        System.out.println("Between 1 and 2: " + NumberFormat.getCurrencyInstance().format(combinedBulkAndBuyN.computeDiscount(100, 2.5)));//should return 0.9
        System.out.println("Between 1 and 3: " + NumberFormat.getCurrencyInstance().format(combinedBulkAndCoupon.computeDiscount(100, 2.5)));//should return 0.9
        System.out.println("Between 2 and 3: " + NumberFormat.getCurrencyInstance().format(combinedCouponAndBuyN.computeDiscount(100, 2.5)));//should return 0.75
        System.out.println("");
        
        System.out.println("1. " + NumberFormat.getCurrencyInstance().format(bulk.computeDiscount(10, 5)));
        System.out.println("2. " + NumberFormat.getCurrencyInstance().format(buyN.computeDiscount(10, 5)));
        System.out.println("3. " + coupon.computeDiscount(10, 5));
        System.out.println("Between 1 and 3: " + NumberFormat.getCurrencyInstance().format(combinedBulkAndCoupon.computeDiscount(10, 5)));//should return 2.5
        System.out.println("");
        
        System.out.println("1. " + NumberFormat.getCurrencyInstance().format(bulk.computeDiscount(25, 7)));
        System.out.println("2. " + NumberFormat.getCurrencyInstance().format(buyN.computeDiscount(25, 7)));
        System.out.println("3. " + NumberFormat.getCurrencyInstance().format(coupon.computeDiscount(25, 7)));
        System.out.println("Between 2 and 3: " + NumberFormat.getCurrencyInstance().format(combinedCouponAndBuyN.computeDiscount(25, 7)));//should return 21.0
        System.out.println("");
        
        
        
        
    }
}
