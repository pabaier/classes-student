
/**
 * Uses a discount if the quantity is over the minimum that is purchased 
 * overrides the computeDiscount from abstract
 *
 * Julie Yib
 * 
 */

public class BulkDiscount extends DiscountPolicy
{
    private int minimum;
    private int percent;
    
    public BulkDiscount(int mininmum, int percent){
        this.minimum = mininmum;
        this.percent = percent;
    }
    
    public double computeDiscount(int quantity, double itemCost){
        double discount = 1;
        if (quantity > minimum) {
            discount = (percent * itemCost * quantity) / 100;
        }
        else {
            discount = 0;
        }
        return discount;
    }
}
