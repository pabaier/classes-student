
/**
 * Jonathan Anderson
 * test driver
 */
public class HW6Part1
{
    public static void main(String[] args) {
        DiscountPolicy dis1 = new BulkDiscount(5, 20);
        DiscountPolicy dis2 = new BuyNItemsGetOneFree(3);
        DiscountPolicy dis3 = new CombinedDiscount(dis1, dis2);
        DiscountPolicy dis4 = new CouponDiscount(20, 2);
        System.out.println(dis1.computeDiscount(6,7));
        System.out.println(dis2.computeDiscount(6,7));
        System.out.println(dis3.computeDiscount(6,7));
        System.out.println(dis4.computeDiscount(6,7));
    }
}
