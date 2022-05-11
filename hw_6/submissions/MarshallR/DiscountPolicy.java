
/**
 * Abstract class DiscountPolicy - an abstract class to serve as a base for various discount types
 *
 * @author Richard Marshall
 * @version (11/17/17)
 */
public abstract class DiscountPolicy
{

    /**
     * computeDiscount - abstract method, different discounts will calculate this differently
     *
     * @param  quantity  the number of items being purchased
     * @param  itemCost  the cost of each individual item being purchased
     */
    public abstract double computeDiscount(int quantity, double itemCost);
}
