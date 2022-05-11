
/**
 * Write a description of class HW6Part1 here.
 *
 * Steven Higgins
 * 
 */
import java.text.NumberFormat;
public class HW6Part1
{
    
    public static void main(String args[])
    {
        BulkDiscount a = new BulkDiscount(5, 20);
        System.out.println("Bulk Discount: " + NumberFormat.getCurrencyInstance().format(a.computeDiscount(4,20.0)));
        System.out.println("Bulk Discount: " + NumberFormat.getCurrencyInstance().format(a.computeDiscount(7,20.0)));
        
        BuyNItemsGetOneFree b = new BuyNItemsGetOneFree(4);
        System.out.println("BOGO Discount: " + NumberFormat.getCurrencyInstance().format(b.computeDiscount(4,20.0)));
        System.out.println("BOGO Discount: " + NumberFormat.getCurrencyInstance().format(b.computeDiscount(16,20.0)));
        System.out.println("BOGO Discount: " + NumberFormat.getCurrencyInstance().format(b.computeDiscount(2,20.0)));
        
        CombinedDiscount c = new CombinedDiscount(a, b);
        System.out.println("Combined Discount: " + NumberFormat.getCurrencyInstance().format(c.computeDiscount(9,20.0)));
        System.out.println("Combined Discount: " + NumberFormat.getCurrencyInstance().format(c.computeDiscount(2,30.0)));
        System.out.println("Combined Discount: " + NumberFormat.getCurrencyInstance().format(c.computeDiscount(5,20.0)));
        System.out.println("Combined Discount: " + NumberFormat.getCurrencyInstance().format(c.computeDiscount(20,10.0)));
        
        CouponDiscount d = new CouponDiscount(20.0, 3);
        System.out.println("Coupon Discount: " + NumberFormat.getCurrencyInstance().format(d.computeDiscount(1,90.0)));
        System.out.println("Coupon Discount: " + NumberFormat.getCurrencyInstance().format(d.computeDiscount(5,100.0)));
    }

    
}
