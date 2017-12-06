
/**
 * BulkDiscount is derived from DiscountPolicy.  It has 2 instance variable and a constructor
 * with 2 parameters.
 *
 * @author Andrea Lingenfelter
 * @version November 11, 2107
 */
public class BulkDiscount extends DiscountPolicy{

    // instance variables - replace the example below with your own
    private int minimum;
    private int percent;

    
    public BulkDiscount(int minimum, int percent){
        this.minimum = minimum;
        this.percent = percent;
    }

    
    public double computeDiscount(int quantity, double itemCost){
        double discount;
        double retVal;
        if (quantity >= minimum){
            discount = (((double)percent/100) * itemCost * quantity);
            retVal = discount;
        }
         else{
             retVal = 0;
        }
        discount = retVal;
        return discount;
    }
}
