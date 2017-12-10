
/**
 *  Class BuyNItemsGetOneFree - a discount class for describing the discount for getting every nth item free as part of a deal
 *
 * @author Richard Marshall
 * @version 11/17/2017
 */
public class BuyNItemsGetOneFree extends DiscountPolicy
{
    private int n; //this number is such that every nth item is free in a purchase of multiple items

    /**
     * Constructor for objects of class BuyNItemsGetOneFree
     */
    public BuyNItemsGetOneFree(int n)
    {
        this.n = n;
    }

    /**
     * computeDiscount - Overrides the discount policy abstract method. This will compute the discount from the purchase for having every nth item free.
     *
     * @param  quantity  the number of items being purchased
     * @param  itemCost  the cost of each individual item being purchased
     * @return    returns the number of free items times the itemCost as the total discount
     */
    @Override
    public double computeDiscount(int quantity, double itemCost)
    {
        double discount = 0.0;
        
        if(quantity >= n) {
           int itemsFree = quantity / n;
           discount = itemsFree * itemCost;
        }
        
        return discount;
    }
}
