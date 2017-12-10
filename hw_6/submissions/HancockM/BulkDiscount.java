
/**
 * Write a description of class BulkDiscount here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BulkDiscount extends DiscountPolicy
{
    // instance variables - replace the example below with your own
    private int percent;
    private int minimum;

    /**
     * Constructor for objects of class BulkDiscount
     */
    public BulkDiscount(int percent, int minimum)
    {
        this.percent = percent;
        this.minimum = minimum;
    }

    public double computeDiscount(int quantity, double itemCost)
    {
        // if(quantity > minimum){
            return (itemCost * quantity)*percent / 100;
        // }
        // else{
            // return 0;
        // }
    }
    
}
