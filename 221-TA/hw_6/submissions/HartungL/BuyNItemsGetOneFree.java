
/**
 * class BuyNItemsGetOneFree - Ment to extend DiscountPolicy to include buy x get y
 * free deals
 *
 * @author Lexus Hartung
 */
public class BuyNItemsGetOneFree extends DiscountPolicy{
    private int n;
    
    //Constructor for objects of class BuyNItemsGetOneFree
    public BuyNItemsGetOneFree(int n){
        this.n = n;
    }

    //Uses quantity to determine how many items you get for free
    public double computeDiscount (int quantity,double itemCost){
        int disAmount = quantity / n;
        return itemCost * disAmount;
    }
}
