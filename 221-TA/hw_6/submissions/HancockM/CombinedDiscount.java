
/**
 * Write a description of class CombinedDiscount here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CombinedDiscount extends DiscountPolicy
{
    private DiscountPolicy dis1;
    private DiscountPolicy dis2;

    /**
     * Constructor for objects of class CombinedDiscount
     */
    public CombinedDiscount(DiscountPolicy dis1, DiscountPolicy dis2)
    {
        this.dis1 = dis1;
        this.dis2 = dis2;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public double computeDiscount(int quantity, double itemCost)
    {
        if(dis1.computeDiscount(quantity, itemCost) > dis2.computeDiscount(quantity, itemCost)){
            return dis1.computeDiscount(quantity, itemCost);
        }else{
            return dis2.computeDiscount(quantity, itemCost);
        }
    }
}
