/*
 * Sydney Jackson
 * Test driver for Part1 of HW6, tests each Discount class and method
 */
public class HW6Part1{
    public static void main(String [] args){
        int minPurchase = 10;
        int nthFree = 4;
        int discountNum = 15;
        double coupVal = 15.0;
        int maxUses = 3;
        
        BulkDiscount discount1 = new BulkDiscount(minPurchase, discountNum);
        BuyNItemsGetOneFree discount2 = new BuyNItemsGetOneFree(4);
        CouponDiscount discount3 = new CouponDiscount(coupVal, maxUses);
        
        int purchased1 = 15;
        int purchased2 = 9;
        int purchased3 = 2;
        double price = 5;
        
        double discounted1 = discount1.computeDiscount(purchased1, price);
        double discounted2 = discount1.computeDiscount(purchased2, price);
        double discounted3 = discount2.computeDiscount(purchased1, price);
        double discounted4 = discount2.computeDiscount(purchased2, price);
        double discounted5 = discount3.computeDiscount(purchased1, price);
        double discounted6 = discount3.computeDiscount(purchased3, price);
        System.out.println(discounted1);
        System.out.println(discounted2);
        System.out.println(discounted3);
        System.out.println(discounted4);
        System.out.println(discounted5);
        System.out.println(discounted6);
    }
}