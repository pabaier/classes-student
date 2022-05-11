
/**
 * Calculates discount for buying n items
 *
 *
 * @author Jacob Mattox
 * @version 11/13/17
 */
public class BuyNItemsGetOneFree extends DiscountPolicy
{
    //instance variable
    private int n;
    
    //constructor
    public BuyNItemsGetOneFree(int n){
        this.n = n;
    }
    
    //overrides computeDiscount using instance variables to determine discount
    public double computeDiscount(int quantity, double itemCost){
        return (quantity/n) * itemCost;
    }
}
