
/**
 * Enters a certain item you get free if applicable overrides the computeDiscount
 *
 * Julie Yib
 * 
 */
public class BuyNItemsGetOneFree extends DiscountPolicy
{
    private int n;
    
    public BuyNItemsGetOneFree(int n){ 
        this.n = n;
    }
    
    public double computeDiscount(int quantity, double itemCost){
        double discount = 0;
        
        if (n < quantity){
            discount = itemCost * (quantity/n);
        }
        else {
            discount = 0;
        }
         
        return discount;
    }
           
    }

