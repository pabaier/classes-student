import java.text.NumberFormat;
/**
 * A test driver for the classes which extend Discount Policy.
 * 
 *  NumberFormat.getCurrencyInstance().format(balance)
 *
 * @author Richard Marshall
 * @version 11/17/17
 */
public class HW6Part1
{
    public static void main() {
        int numItems = 30;
        double itemPrice = 5.0;
        
        BulkDiscount bulk = new BulkDiscount(20, 25);
        BuyNItemsGetOneFree oneFree = new BuyNItemsGetOneFree(5);
        CombinedDiscount combo = new CombinedDiscount(bulk, oneFree);
        CouponDiscount coupon = new CouponDiscount(3.0, 4);
        
        System.out.println("Original total price is: " + NumberFormat.getCurrencyInstance().format(numItems * itemPrice));
        System.out.println("Bulk discount for " + numItems + " items at " + NumberFormat.getCurrencyInstance().format(itemPrice) + " each is: " + NumberFormat.getCurrencyInstance().format(bulk.computeDiscount(numItems, itemPrice)));
        System.out.println("BuyNGetOne discount for " + numItems + " items at " + NumberFormat.getCurrencyInstance().format(itemPrice) + " each is: " + NumberFormat.getCurrencyInstance().format(oneFree.computeDiscount(numItems, itemPrice)));
        System.out.println("Combined discount for " + numItems + " items at " + NumberFormat.getCurrencyInstance().format(itemPrice) + " each is: " + NumberFormat.getCurrencyInstance().format(combo.computeDiscount(numItems, itemPrice)));
        System.out.println("Coupon discount for " + numItems + " items at " + NumberFormat.getCurrencyInstance().format(itemPrice) + " each is: " + NumberFormat.getCurrencyInstance().format(coupon.computeDiscount(numItems, itemPrice)));
        
        return;
    }
}
