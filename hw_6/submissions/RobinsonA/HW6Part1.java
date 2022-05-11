
/**
 * Ariel Robinson
 *
 * Test driver for the different discount policies
 */
import java.text.NumberFormat;
public class HW6Part1
{

    public static void main(String [] args)
    {
        BulkDiscount dis1= new BulkDiscount(2,5);
        System.out.println("Bulk Discount: "+ NumberFormat.getCurrencyInstance().format(dis1.computeDiscount(4,150)));
        BulkDiscount dis7= new BulkDiscount(3,9);
        System.out.println("Bulk Discount Test 2: "+ NumberFormat.getCurrencyInstance().format(dis7.computeDiscount(10,20)));

        CouponDiscount dis3= new CouponDiscount(5,10);

        System.out.println("Coupon Discount: " + NumberFormat.getCurrencyInstance().format(dis3.computeDiscount(10,50)));

        CouponDiscount dis6= new CouponDiscount(4,10);

        System.out.println("Coupon Discount Test 2: " + NumberFormat.getCurrencyInstance().format(dis6.computeDiscount(5,10)));

        BuyNItemsGetOneFree dis4= new BuyNItemsGetOneFree(3);
        System.out.println("Buy N Items: " + NumberFormat.getCurrencyInstance().format(dis4.computeDiscount(8,10)));
        BuyNItemsGetOneFree dis9= new BuyNItemsGetOneFree(4);
        System.out.println("Buy N Items Test 2: " + NumberFormat.getCurrencyInstance().format(dis9.computeDiscount(6,10)));

        CombinedDiscount dis5= new CombinedDiscount(dis3,dis6);
        System.out.println("Combined Discount: " + NumberFormat.getCurrencyInstance().format(dis5.computeDiscount(5,10)));

        CombinedDiscount dis8= new CombinedDiscount(dis7,dis1);
        System.out.println("Combined Discount Test 2: " + NumberFormat.getCurrencyInstance().format(dis8.computeDiscount(10,10)));

    }
}
