
/**
 * Testing the abstract methods
 *
 * Julie Yib
 * 
 */
import java.text.NumberFormat;
public class HW6Part1
{
    public static void main(String [] args){
        BulkDiscount bd1 = new BulkDiscount(3, 5);
        System.out.println("Bulk Discount: " + 
        NumberFormat.getCurrencyInstance().format(bd1.computeDiscount(100, 1.5)));
        
        BulkDiscount bd2 = new BulkDiscount(25, 10);
        System.out.println("Bulk Discount: " + 
        NumberFormat.getCurrencyInstance().format(bd2.computeDiscount(100, 1.5)));
        
        BulkDiscount bd3 = new BulkDiscount(101, 5);
        System.out.println("Bulk Discount: " + 
        NumberFormat.getCurrencyInstance().format(bd3.computeDiscount(100, 1.5)));
        
        BuyNItemsGetOneFree bogo = new BuyNItemsGetOneFree(3);
        System.out.println("Bogo: " + 
        NumberFormat.getCurrencyInstance().format(bogo.computeDiscount(100, 1.5)));        
        
        BuyNItemsGetOneFree bogo2 = new BuyNItemsGetOneFree(102);
        System.out.println("Bogo: " + 
        NumberFormat.getCurrencyInstance().format(bogo2.computeDiscount(100, 1.5)));
        
        CouponDiscount cd1 = new CouponDiscount(.25, 3);
        System.out.println("Coupon Discount: " + 
        NumberFormat.getCurrencyInstance().format(cd1.computeDiscount(100, 1.5)));
        
        CouponDiscount cd2 = new CouponDiscount(5, 15);
        System.out.println("Coupon Discount: " + 
        NumberFormat.getCurrencyInstance().format(cd2.computeDiscount(100, 1.5)));
        
        CombinedDiscount comd1 = new CombinedDiscount(bd1, bogo);
        System.out.println("Combined Discount: " + 
        NumberFormat.getCurrencyInstance().format(comd1.computeDiscount(100, 1.5)));
        
        CombinedDiscount comd2 = new CombinedDiscount(bd2, bd1);
        System.out.println("Combined Discount: " + 
        NumberFormat.getCurrencyInstance().format(comd2.computeDiscount(100, 1.5)));
    }
    
}
