/*
* Stephen Pappas
*
* This class is an extension of Discount Policy. It creates an object, BulkDiscount that takes in a minimum amount and a percent to discount.
*
 */

public class BulkDiscount extends DiscountPolicy  {
    private int minimum;
    private int percent;

    public BulkDiscount(int minimum, int percent){
        this.minimum = minimum;
        this.percent = percent;
    }

    public double computeDiscount(int quantity, double itemCost){
        double discount;
        if(quantity > minimum)
            discount = (((double) itemCost * quantity) * (.01 * (double) percent));
        else
            discount = 0;

        return discount;
    }
}
