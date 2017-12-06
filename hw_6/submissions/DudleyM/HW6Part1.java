public class HW6Part1 {
    public static void main(String[] args) {
        DiscountPolicy discount = new BulkDiscount(10,20);
        DiscountPolicy discount2 = new BuyNItemsGetOneFree(3);
        DiscountPolicy discount3 = new CouponDiscount(10,2);
        DiscountPolicy discount4 = new CouponDiscount(10,4);
        DiscountPolicy discount5 = new CombinedDiscount(discount,discount2);
        System.out.println(discount.computeDiscount(15,5));
        System.out.println(discount2.computeDiscount(15,5));
        System.out.println(discount3.computeDiscount(13,10));
        System.out.println(discount4.computeDiscount(8,10));
        System.out.println(discount5.computeDiscount(15,5));
    }
}
