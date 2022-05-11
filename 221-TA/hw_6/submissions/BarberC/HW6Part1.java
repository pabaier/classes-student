/**
 * Tester for part 1 of HW6
 * 
 * @author Carson Barber
 */
public class HW6Part1
{
    public static void main(String[] args)
    {
        System.out.println("HW6Part1 Testing Starting...");
        System.out.println();
        System.out.println("Testing BulkDiscount...");
        System.out.println("Creating new BulkDiscount with minimum of 3 and discount of 60...");
        BulkDiscount bd = new BulkDiscount(3, 60);
        System.out.println("Discount with 2 items, cost of 10: " + bd.computeDiscount(2, 10) + " (expected 0.0)");
        System.out.println("Discount with 3 items, cost of 10: " + bd.computeDiscount(3, 10) + " (expected 0.0)");
        System.out.println("Discount with 4 items, cost of 10: " + bd.computeDiscount(4, 10) + " (expected 24.0)");
        System.out.println("Discount with 30 items, cost of 5: " + bd.computeDiscount(30, 5) + " (expected 90.0)");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Testing BuyNItemsGetOneFree...");
        System.out.println("Creating new BuyNItemsGetOneFree with n of 3...");
        BuyNItemsGetOneFree bn = new BuyNItemsGetOneFree(3);
        System.out.println("Discount with 2 items, cost of 10: " + bn.computeDiscount(2, 10) + " (expected 0.0)");
        System.out.println("Discount with 3 items, cost of 10: " + bn.computeDiscount(3, 10) + " (expected 10.0)");
        System.out.println("Discount with 4 items, cost of 10: " + bn.computeDiscount(4, 10) + " (expected 10.0)");
        System.out.println("Discount with 30 items, cost of 5: " + bn.computeDiscount(30, 5) + " (expected 50.0)");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Testing CouponDiscount...");
        System.out.println("Creating new CouponDiscount with couponValue of 4.0 and maxUses of 3...");
        CouponDiscount cd1 = new CouponDiscount(4.0, 3);
        System.out.println("Discount with 2 items, cost of 10: " + cd1.computeDiscount(2, 10) + " (expected 8.0)");
        System.out.println("Discount with 3 items, cost of 10: " + cd1.computeDiscount(3, 10) + " (expected 12.0)");
        System.out.println("Discount with 4 items, cost of 10: " + cd1.computeDiscount(4, 10) + " (expected 12.0)");
        System.out.println("Discount with 30 items, cost of 5: " + cd1.computeDiscount(30, 5) + " (expected 12.0)");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Testing CombinedDiscount...");
        System.out.println("Creating new CouponDiscount with discounts of BulkDiscount(3,60) and CouponDiscount(4.0,3)");
        CombinedDiscount cd2 = new CombinedDiscount(bd, cd1);
        System.out.println("Discount with 2 items, cost of 10: " + cd2.computeDiscount(2, 10) + " (expected 8.0)");
        System.out.println("Discount with 3 items, cost of 10: " + cd2.computeDiscount(3, 10) + " (expected 12.0)");
        System.out.println("Discount with 4 items, cost of 10: " + cd2.computeDiscount(4, 10) + " (expected 24.0)");
        System.out.println("Discount with 30 items, cost of 5: " + cd2.computeDiscount(30, 5) + " (expected 90.0)");
        System.out.println("Discount with 4 items, cost of 4: " + cd2.computeDiscount(4, 4) + " (expected 12.0)");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Testing finished. Terminating...");
    }
}