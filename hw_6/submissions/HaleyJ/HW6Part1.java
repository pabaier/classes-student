import java.text.NumberFormat;
public class HW6Part1{
    public static void main(String[] args){
        DiscountPolicy d1 = new BulkDiscount(10, 10);
        DiscountPolicy d2 = new BuyNItemsGetOneFree(5);
        DiscountPolicy d3 = new CombinedDiscount(d1, d2);
        DiscountPolicy d4 = new CouponDiscount(3,2);

        //Combined Discount Objects for comparison
        DiscountPolicy d5 = new BulkDiscount(7, 25);
        DiscountPolicy d6 = new BuyNItemsGetOneFree(10);

        DiscountPolicy d7 = new CombinedDiscount(d5, d6);

        DiscountPolicy d8 = new CouponDiscount(5, 2);




//      --------- BULK DISCOUNT ---------------
        System.out.println("Bulk Discount, Minimum(10), %Discount(10), Quantity(15), Price(5): " +  NumberFormat.getCurrencyInstance().format(d1.computeDiscount(15, 5)) + "\n");
        System.out.println("Bulk Discount, Minimum(10), %Discount(10), Quantity(10), Price(5): " + NumberFormat.getCurrencyInstance().format(d1.computeDiscount(10, 5)) + "\n");
        System.out.println("Bulk Discount, Minimum(10), %Discount(10), Quantity(5), Price(5): " + NumberFormat.getCurrencyInstance().format(d1.computeDiscount(5, 5)) + "\n");


        //      --------- BUY N ITEMS DISCOUNT ---------------
        System.out.println("Buy N Items Discount, N(5), Quantity(20), Price(5): " + NumberFormat.getCurrencyInstance().format(d2.computeDiscount(20, 5)) + "\n");
        System.out.println("Buy N Items Discount, N(5), Quantity(5), Price(5): " + NumberFormat.getCurrencyInstance().format(d2.computeDiscount(5, 5)) + "\n");
        System.out.println("Buy N Items Discount, N(5), Quantity(3), Price(5): " + NumberFormat.getCurrencyInstance().format(d2.computeDiscount(3, 5)) + "\n");

        // ----------------- COMBINED DISCOUNT ------------
        //      BULK DISCOUNT IS GREATER
        System.out.println("Bulk v. BuyNGetOneFree\nN(10), Minimum(7), Quantity(8), Price(5): \n" + "Discount: " + NumberFormat.getCurrencyInstance().format(d7.computeDiscount(8,5)));
        //      Buy N ITEMS DISCOUNT IS GREATER
        System.out.println("Bulk v. BuyNGetOneFree\nN(10), Minimum(7), Quantity(10), Price(5): \n" + "Discount: " + NumberFormat.getCurrencyInstance().format(d7.computeDiscount(10,5)));

        // ----------------- COUPON DISCOUNT ----------------
        System.out.println("Coupon Discount, Max Uses(2), Value(5), Quantity(10), Price(10): " + NumberFormat.getCurrencyInstance().format(d8.computeDiscount(10, 10)) + "\n");

        System.out.println("Coupon Discount, Max Uses(2), Value(5), Quantity(2), Price(10): " + NumberFormat.getCurrencyInstance().format(d8.computeDiscount(2, 10)) + "\n");

        System.out.println("Coupon Discount, Max Uses(2), Value(5), Quantity(1), Price(10): " + NumberFormat.getCurrencyInstance().format(d8.computeDiscount(1, 10)) + "\n");


    }
}