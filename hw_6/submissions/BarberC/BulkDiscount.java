
/**
 * Provides a discount of a certain percentage percent when more than number of items minimum are being purchased
 * 
 * @author Carson Barber
 */
public class BulkDiscount extends DiscountPolicy
{
    // instance variables - replace the example below with your own
    private int minimum;
    private int percent;
    
    public BulkDiscount(int min, int perc)
    {
        minimum = min;
        percent = perc;
    }
    public double computeDiscount(int quantity, double itemCost){
        if(quantity>minimum)return itemCost*quantity*percent/100;
        return 0;
    }
}
