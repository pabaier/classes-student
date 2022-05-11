/*
* Stephen Pappas
*
* This class is an extension of Discount Policy. It creates an object, CombinedDiscount that takes in two discount classes. Its method checks to see which one gives a greater discount and it returns that discount.
*
 */

public class CombinedDiscount extends DiscountPolicy {

    private DiscountPolicy dis1;
    private DiscountPolicy dis2;

    public CombinedDiscount(DiscountPolicy dis1, DiscountPolicy dis2){
        this.dis1 = dis1;
        this.dis2 = dis2;
    }

    public double computeDiscount(int quantity, double itemCost){
        double discount = 0;

        if(dis1.computeDiscount(quantity, itemCost) > dis2.computeDiscount(quantity, itemCost))
            return dis1.computeDiscount(quantity, itemCost);
        else
            return dis2.computeDiscount(quantity, itemCost);
    }
}