
/**
 * Ariel Robinson
 * if a certain amount of items are bought the discount is determined by 
 * the number of items and n
 */
public class BuyNItemsGetOneFree extends DiscountPolicy
{
    // instance variable
    private int n;

    /**
     * Constructor for objects of class BuyNItemsGetOneFree
     */
    public BuyNItemsGetOneFree(int n)
    {
        this.n=n;

    }

    public double computeDiscount(int quantity, double itemCost)
    {
        double discount=0;
        for(int i=n; i<=quantity; i+=n){
            discount+=itemCost;

        }

        return discount;
    }
}
