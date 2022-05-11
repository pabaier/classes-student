
/**
 * Write a description of class HW6Part1 is a test driver to demo HW6 part 1 code.
 *
 * @author Andrea Lingenfelter
 * @version 11/14/17
 */
public class HW6Part1 {
    public static void main(String[] args) {
        BulkDiscount BD3 = new BulkDiscount(3, 10);
        BulkDiscount BD5 = new BulkDiscount(5, 20);
        BulkDiscount BD8 = new BulkDiscount(8, 30);
        BuyNItemsGetOneFree B2G1 = new BuyNItemsGetOneFree(2);
        BuyNItemsGetOneFree B5G2 = new BuyNItemsGetOneFree(5);
        CouponDiscount CD1 = new CouponDiscount(10, 3);
        CouponDiscount CD2 = new CouponDiscount(25, 2);
        CombinedDiscount C1 = new CombinedDiscount(BD3, B2G1);
        CombinedDiscount C2 = new CombinedDiscount(CD2, BD5);
                
        double test1 = BD3.computeDiscount(3,10.00);
        double test2 = BD5.computeDiscount(5, 20.00);
        double test3 = BD8.computeDiscount(9, 20.00);
        double test4 = B2G1.computeDiscount(4, 10.00);
        double test5 = B5G2.computeDiscount(5, 20.00);
        double test6 = CD1.computeDiscount(2, 13.00);
        double test7 = CD2.computeDiscount(4, 15.00);
        double test8 = C1.computeDiscount(5, 20.00);
        double test9 = C1.computeDiscount(2, 60.00);
        double test10 = C2.computeDiscount(7, 50.00);
                
        System.out.println("Discount for 3 items priced at $10 with a 10% discount: $ " + test1);
        System.out.println("Discount for 5 items priced at $20 with a 20% discount: $ " + test2);
        System.out.println("Discount for 9 items priced at $20 with a 30% discount: $ " + test3);
        System.out.println("Discount for 4 items priced at $10 with buy2 get 1 free: $ " + test4);
        System.out.println("Discount for 5 items priced at $20 with buy2 get 1 free: $ " + test5);
        System.out.println("Discount for 2 items priced at $13 with coupon discount: $ " + test6);
        System.out.println("Discount for 4 items priced at $15 with coupon discount: $ " + test7);
        System.out.println("Discount for 5 items priced at $20 with bulk 3 or B2G1: $ " + test8);
        System.out.println("Discount for 2 items priced at $60 with bulk 3 or B2G1: $ " + test9);
        System.out.println("Discount for 7 items priced at $50 with coupon disc2 or bulk 5: $ " + test10);
               
    }
    
}
