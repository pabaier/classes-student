import java.text.NumberFormat;
/**
 * Orianna Gandy-Wells 
 * 
 * This is a test driver class to show that all 
 * my previous classes work properly
 * 
 */
public class HW6Part1
{
   public static void main(String [] args){
       
       BulkDiscount bd1 = new BulkDiscount(3,10);
       System.out.println("BulkDiscount: " + NumberFormat.getCurrencyInstance().format(bd1.computeDiscount(5, 5)));
       
       BuyNItemsGetOneFree buyN1 = new BuyNItemsGetOneFree(3);
       System.out.println("BuyNItemsGetOneFree: " + NumberFormat.getCurrencyInstance().format(buyN1.computeDiscount(5, 5)));
       
       CombinedDiscount comDis1 = new CombinedDiscount(bd1, buyN1);
       System.out.println("CombinedDiscount: " + NumberFormat.getCurrencyInstance().format(comDis1.computeDiscount(5, 5)));
       
       CouponDiscount coupDis1 = new CouponDiscount(2.0, 5);
       System.out.println("CouponDiscount: " + NumberFormat.getCurrencyInstance().format(coupDis1.computeDiscount(10, 5)));
       
    }
    }
