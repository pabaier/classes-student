
/**
 * Overides the largest discount
 *
 * Julie Yib 
 * 
 */

public class CombinedDiscount extends DiscountPolicy
{
    private DiscountPolicy dis1;
    private DiscountPolicy dis2;
    
    public CombinedDiscount(DiscountPolicy dis1, DiscountPolicy dis2){
        this.dis1 = dis1;
        this.dis2 = dis2;
    }
    
    public double computeDiscount(int quantity, double itemCost){
        
        double discountOne = dis1.computeDiscount(quantity, itemCost);
        double discountTwo = dis2.computeDiscount(quantity, itemCost);
        
        double discount = 0;
        if (discountOne > discountTwo){
            
            discount = discountOne;
        }
        else {
            discount = discountTwo;
        }
        
       
        return discount;
    }
    
    
}
