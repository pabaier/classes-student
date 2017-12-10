/**
 * class BulkDiscount - Ment to extend DiscountPolicy to include bulk
 * purchases
 *
 * @author Lexus Hartung
 */
public class BulkDiscount extends DiscountPolicy{
    // instance variables - replace the example below with your own
    private int minimum;
    private int percent;
    
    //Constructor for objects of class BulkDiscount
    public BulkDiscount(int minimum,int percent){
        this.minimum = minimum;
        this.percent = percent;
    }
    
    //Uses quantity to make sure you bought enough to get a discount
    public double computeDiscount (int quantity,double itemCost){
        if (quantity > minimum){
            double PropPerc = (double) percent;
            PropPerc /= 100;
            double dis = PropPerc * itemCost;
            return dis;
        }
        else{
            return 0;
        }
    }
}
