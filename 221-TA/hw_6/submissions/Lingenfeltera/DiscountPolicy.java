
/**
 * Abstract class DiscountPolicy provides the computeDiscount() method 
 * to be used by all derived classes
 * 
 *
 * @author Andrea Lingenfelter
 * @version November 11, 2017
 */
public abstract class DiscountPolicy{
     
    public abstract double computeDiscount(int quantity, double itemCost);  
    
      
}
