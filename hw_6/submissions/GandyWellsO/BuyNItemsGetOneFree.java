import java.text.NumberFormat;
/**
 * Orianna Gandy-Wells
 * 
 * This class extends DiscountPolicy and constructs a computeDiscount 
 * to override the one in DiscountPolicy
 */
public class BuyNItemsGetOneFree extends DiscountPolicy
{
    private int n;
   
    public BuyNItemsGetOneFree(int n)
    { 
     this.n = n;
    }

    
     @Override
    public double computeDiscount(int quantity, double itemCost){
        double discount = 0.0;
        for(int i = 1; i<= quantity; i++){
            if( (i % n) == 0){
                discount+=itemCost;
            }
        }
        return discount;
    }
}
