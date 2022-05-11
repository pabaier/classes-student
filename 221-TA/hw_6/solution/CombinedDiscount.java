
/**
 * Takes 2 DiscountPolicy objects and returns the highest discount
 *
 * @author Jacob Mattox
 * @version 11/13/17
 */
public class CombinedDiscount extends DiscountPolicy
{
    //instance variables
    private DiscountPolicy dis1;
    private DiscountPolicy dis2;
    
    //constructor
    public CombinedDiscount(DiscountPolicy dis1, DiscountPolicy dis2){
        this.dis1 = dis1;
        this.dis2 = dis2;
    }
    
    //overrides computeDiscount using instance variables to determine discount
    public double computeDiscount(int quantity, double itemCost){
        double returnVal = 0;
        if(dis1.computeDiscount(quantity, itemCost) > dis2.computeDiscount(quantity, itemCost))
            returnVal = dis1.computeDiscount(quantity, itemCost);
        else
            returnVal = dis2.computeDiscount(quantity, itemCost);
        return returnVal;
    }
    
}
