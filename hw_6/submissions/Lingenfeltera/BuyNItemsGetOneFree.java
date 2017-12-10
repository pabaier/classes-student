
/**
 * BuyNItemsGetOneFree extends the Discount Policy class.  
 * Every x item is free.  ComputeDiscount computes discount based on number of items.
 *
 * @author Andrea Lingenfelter
 * @version 11/16/17
 */
public class BuyNItemsGetOneFree extends DiscountPolicy{

    private int n;

    public BuyNItemsGetOneFree(int n){
        this.n = n;
    }

    
    public double computeDiscount(int quantity, double itemCost){
        double discount;
        
        if (quantity > 0){
            discount = (quantity/(n+1) * itemCost);
        }
        else {
            discount = 0;
        } 
        
        return discount;
    }
}
