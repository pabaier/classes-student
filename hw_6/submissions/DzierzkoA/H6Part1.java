/*
    Test class for the first part of Homework

    author: Adam Dzierzko
 */

public class H6Part1 {

    public static void main(String[] args) {

        BulkDiscount bulkDiscount = new BulkDiscount(5, 10);
        BulkDiscount bulkDiscount2 = new BulkDiscount(5, 10);
        BuyNItemsGetOneFree buyNItemsGetOneFree = new BuyNItemsGetOneFree(2);
        BuyNItemsGetOneFree buyNItemsGetOneFree2 = new BuyNItemsGetOneFree(3);
        CombinedDiscount combinedDiscount = new CombinedDiscount(buyNItemsGetOneFree2, buyNItemsGetOneFree);
        CouponDiscount couponDiscount = new CouponDiscount(5, 5);

        System.out.println("BulkDiscount with minimum of 5 and 10% discount, given 6 items and price 10, discount equals: " + bulkDiscount.computeDiscount(6, 10));
        System.out.println("BulkDiscount with minimum of 5 and 10% discount, given 2 items and price 10, discount equals: " + bulkDiscount.computeDiscount(2, 10));
        System.out.println("BuyNItemsGetOneFree with n = 2, given 10 items and price 10, discount equals: " + buyNItemsGetOneFree.computeDiscount(10, 10));
        System.out.println("CombinedDiscount taking two different BuyNItemsGetOneFree, one with every second item free and other with every third item free (price = 20) : " + combinedDiscount.computeDiscount(10, 20));
        System.out.println("CouponDiscount with coupon value 5 and 5 uses when buying 10 items: " + couponDiscount.computeDiscount(10, 10));
        System.out.println("CouponDiscount with coupon value 5 and 5 uses when buying 2 items: " + couponDiscount.computeDiscount(2, 10));

    }

}
