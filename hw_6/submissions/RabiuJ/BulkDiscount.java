
/**
 * Computes a discount so that if the quantity is over the minimum, then the percent is returned
 * otherwise it is 0
 *
 * Jonathan Rabiu
 * 
 */
public class BulkDiscount extends DiscountPolicy //derived from DiscountPolicy abstract
{
    private int minimum;
    private int percent;
    
    public BulkDiscount(int min, int percent){
        minimum = min;
        this.percent = percent;
    }
    
    @Override
    public double computeDiscount(int quantity, double itemCost){
        if(quantity > minimum){
           return percent;
        }else{
           return 0;
        }
    }
}
