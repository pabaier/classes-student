
/**
 * Write a description of class BulkDiscount here.
 *
 * Steven Higgins
 * 
 */
public class BulkDiscount extends DiscountPolicy
{
    // instance variables - replace the example below with your own
    private int minimum;
    private int percent;

    public BulkDiscount(int minimum, int percent)
    {
        this.minimum = minimum;
        this.percent = percent;
    }
    public double computeDiscount(int quantity, double itemCost){
        double discount = 0;
        if(quantity >= minimum){
            discount = (itemCost * (percent/100.0)) * quantity;
        }
        return discount;
    }
    
}
