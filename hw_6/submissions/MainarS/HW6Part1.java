public class HW6Part1 {

    public static void main(String[] args){
        DiscountPolicy bulk = new BulkDiscount(10, 10);
        System.out.println("Demonstrating BulkDiscount");
        System.out.println("11 items for $10.00 each. Discount is " + bulk.computeDiscount(11, 10.0));
        System.out.println("100 items for $5.00 each. Discount is " + bulk.computeDiscount(100, 5.0));
        System.out.println("5 items for $10.00 each. Discount is " + bulk.computeDiscount(5,10.0) + "\n");

        DiscountPolicy n = new BuyNItemsGetOneFree(3);
        System.out.println("Demonstrating BuyNItemsGetOneFree");
        for(int i = 0; i < 9; ++i){
            System.out.println(i + " items at $10.00. Discount is " + n.computeDiscount(i, 10.0));

        }
        System.out.println();

        DiscountPolicy combo = new CombinedDiscount(n, bulk);
        System.out.println("Demonstrating CombinedDiscount");
        System.out.println("Policy 1: Every third item is free");
        System.out.println("Policy 2: 10% on 10 items \n");
        for(int i = 2; i < 15; i++) {
            System.out.println(i + " items at 5.0; "
                    + ";  discount 1 is " + n.computeDiscount(i, 5.0)
                    + ";  discount 2 is " + bulk.computeDiscount(i, 5.0)
                    + ";  combined gives  " + combo.computeDiscount(i, 5.0));

        }
        System.out.println();

        DiscountPolicy coup = new CouponDiscount(10.0, 2);
        System.out.println("Demonstrating CouponDiscount");
        for(int i = 0; i < 10; ++i){
            System.out.println(i + " items at $5.00 discount is " + coup.computeDiscount(i, 5.0));
        }




    }
}
