import java.text.NumberFormat;
/**
 * Orianna Gandy-Wells
 * 
 * This class takes two discount policies, finds and returns the
 * better of the two
 * 
 */
public class CombinedDiscount extends DiscountPolicy
{ 
    private DiscountPolicy dis1;
    private DiscountPolicy dis2;
    
    public CombinedDiscount(DiscountPolicy dis1, DiscountPolicy dis2)
    {
        this.dis1 = dis1;
        this.dis2 = dis2;
        
    }

     @Override
    public double computeDiscount(int quantity, double itemCost){
        double discount = 0.0;
        if(dis1.computeDiscount(quantity, itemCost) > dis2.computeDiscount(quantity, itemCost)){
        discount = dis1.computeDiscount(quantity, itemCost);
        }
        else{
            discount = dis2.computeDiscount(quantity, itemCost);
        }
        
        return discount;
    }
    
}
