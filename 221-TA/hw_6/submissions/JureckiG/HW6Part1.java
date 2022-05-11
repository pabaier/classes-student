//Gabe Jurecki
public class HW6Part1 {
    public static void main(String[] args) {
        DiscountPolicy disc1 = new BulkDiscount(3,2);
        DiscountPolicy disc2 = new CouponDiscount(9.8, 3);
        DiscountPolicy disc3 = new CombinedDiscount(disc1, disc2);
        DiscountPolicy disc4 = new BulkDiscount(3, 4);
        DiscountPolicy disc5 = new BuyNItemsGetOneFree(3);
    }
}
