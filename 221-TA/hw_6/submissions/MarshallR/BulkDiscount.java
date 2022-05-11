
/**
 * Class BulkDiscount - a class for discounts derived from buying items in bulk
 *
 * @author Richard Marshall
 * @version 11/17/17
 */
public class BulkDiscount extends DiscountPolicy
{
    
    private int minimum; //minimum number of purchased items
    private int percent; //percent discounted

    /**
     * Constructor for objects of class BulkDiscount
     */
    public BulkDiscount(int minimum, int percent)
    {
        this.minimum = minimum;
        this.percent = percent;
    }

    /**
     * computeiscount - Overrides the abstract method. If the item quantity is 
     *  over the minimum, this method will compute the total amount to be
     *  discounted from the original total price of the purchase.
     *
     * @param  quantity  the number of items to be purchased
     * @param  itemCost  the cost of each individual item
     * @return    0.0 if the quantity of the item is below the minimum, 
     *  otherwise it gets the percent of the total purchases to be 
     *  discounted based on the percent field
     */
    @Override
    public double computeDiscount(int quantity, double itemCost)
    {
        double discount = 0.0;
        
        if (quantity >= minimum) {
            discount = (quantity * itemCost) * (percent / 100.0);
        }
        return discount;
    }
}
