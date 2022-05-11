//Asa Perryman
import java.text.NumberFormat;

public class HW6Part1{
    public static void main(String[] args){
        System.out.println("Total dicounts on transactions assuming a 5 item");
        System.out.println("quanity at $3.00 per item");
        System.out.println();
        
        BulkDiscount bulkTest1 = new BulkDiscount(4, .10);
        System.out.println("BulkDiscount of 10 % with 4 item min: " + 
                   NumberFormat.getCurrencyInstance().format(bulkTest1.computeDiscount(5, 3)));
        
        BuyNItemsGetOneFree getOneFreeTest1 = new BuyNItemsGetOneFree(3);
        System.out.println("BuyNItemsGetOneFree Discount of 3 item min: " +
                 NumberFormat.getCurrencyInstance().format(getOneFreeTest1.computeDiscount(5, 3)));
        
        CombinedDiscount combinedTest1 = new CombinedDiscount(bulkTest1, getOneFreeTest1);
        System.out.println("CombinedDiscount using above discounts: " +
                 NumberFormat.getCurrencyInstance().format(combinedTest1.computeDiscount(5, 3)));
        
        CouponDiscount couponTest1 = new CouponDiscount(1, 3);
        System.out.println("CouponDiscount of $1.00 with 3 use limit: " +
                 NumberFormat.getCurrencyInstance().format(couponTest1.computeDiscount(5, 3)));
        
                 
        System.out.println();
        System.out.println();
        
        System.out.println("Total dicounts on transactions assuming a 10 item");
        System.out.println("quanity at $5.00 per item");
        System.out.println();
        
        BulkDiscount bulkTest2 = new BulkDiscount(5, .15);
        System.out.println("BulkDiscount of 15 % with 6 item min: " + 
                   NumberFormat.getCurrencyInstance().format(bulkTest2.computeDiscount(10, 5)));
        
        BuyNItemsGetOneFree getOneFreeTest2 = new BuyNItemsGetOneFree(5);
        System.out.println("BuyNItemsGetOneFree Discount of 5 item min: " +
                 NumberFormat.getCurrencyInstance().format(getOneFreeTest2.computeDiscount(10, 5)));
        
        CombinedDiscount combinedTest2 = new CombinedDiscount(bulkTest2, getOneFreeTest2);
        System.out.println("CombinedDiscount using above discounts: " +
                 NumberFormat.getCurrencyInstance().format(combinedTest2.computeDiscount(10, 5)));
        
        CouponDiscount couponTest2 = new CouponDiscount(2, 4);
        System.out.println("CouponDiscount of $2.00 with 4 use limit: " +
                 NumberFormat.getCurrencyInstance().format(couponTest2.computeDiscount(10, 5)));
        
                 
        System.out.println();
        System.out.println();
        
        
        
        
        
        
        
    }
}