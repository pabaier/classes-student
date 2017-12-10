
/**
 * Compares two discounts and returns the discount instance that has the highest discount.
 *
 * Jonathan Rabiu
 * 
 */
public class CombinedDiscount extends DiscountPolicy
{
    //dis1: DiscountPolicy
    private DiscountPolicy dis1;  

    //dis2: DiscountPolicy
    private DiscountPolicy dis2;
    
    public CombinedDiscount(DiscountPolicy dis1, DiscountPolicy dis2){
        this.dis1 = dis1;
        this.dis2 = dis2; 
    }
    
    @Override
    public double computeDiscount(int quantity, double itemCost){
        //return max val for two instance variables
        double discount1 = dis1.computeDiscount(quantity, itemCost);
        double discount2 = dis2.computeDiscount(quantity, itemCost);
        if(discount1 > discount2){
           return discount1;
        }else{
           return discount2;
        }
    }
}
