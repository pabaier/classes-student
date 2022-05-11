/*
* Stephen Pappas
*
* This class is an extension of Discount Policy. It creates an object, BuyNItemsGetOneFree that takes in an amount and a method to calculate the discount.
*
 */

public class BuyNItemsGetOneFree extends DiscountPolicy {

    private int n;

    public BuyNItemsGetOneFree(int n){
        this.n = n;
    }

    public double computeDiscount(int quantity, double itemCost){
        double discount = 0;

        while(quantity >= n){
            discount += itemCost;
            quantity -= n;
        }

        return discount;
    }
}
