/* 
 * Sydney Jackson
 * CombinedDiscount class is derived from DiscountPolicy and chooses the highest
 * discount to be applied to a purchase
 * Methods: computeDiscount()
 */
public class CombinedDiscount extends DiscountPolicy{
    private DiscountPolicy discount1;
    private DiscountPolicy discount2;
    
    public CombinedDiscount(DiscountPolicy dis1, DiscountPolicy dis2){
        discount1 = dis1;
        discount2 = dis2;
    }
    
    @Override
    public double computeDiscount(int quantity, double itemCost){
        double option1 = discount1.computeDiscount(quantity, itemCost);
        double option2 = discount2.computeDiscount(quantity, itemCost);
        
        if (option1 >= option2){
            return option1;
        }
        else { 
            return option2;
        }
    }
}