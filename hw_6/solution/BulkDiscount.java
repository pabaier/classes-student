
/**
 * Calculates discount off bulk number of items
 *
 * @author Jacob Mattox
 * @version 11/13/17
 */
public class BulkDiscount extends DiscountPolicy
{
    //instance variables
    private int minimum; 
    private int percent; 
    
    //constructor
    public BulkDiscount(int minimum, int percent){
        this.minimum = minimum;
        this.percent = percent;
    }
    public BulkDiscount(int minimum){
        this.minimum = minimum;
    }
    public BulkDiscount(){
    }
    //overrides computeDiscount using instance variables to determine discount
    public double computeDiscount(int quantity, double itemCost){
        double discount = 0;
        if(quantity > minimum){
            discount = (quantity * itemCost) * (percent * .01);
        }
        return discount;
    }
}
