
/**
 * Class CombinedDiscount - A class for combined discounts finding the better of the two
 *
 * @author Richard Marshall
 * @version 11/17/17
 */
public class CombinedDiscount extends DiscountPolicy
{
    private DiscountPolicy discountOne; //the first discount
    private DiscountPolicy discountTwo; //the second discount

    /**
     * Constructor for objects of class CombinedDiscount
     */
    public CombinedDiscount(DiscountPolicy discountOne, DiscountPolicy discountTwo)
    {
        this.discountOne = discountOne;
        this.discountTwo = discountTwo;
    }

    /**
     * computeDiscount - Finds the maximum discount between the two discount parameters
     * @param  quantity  the number of items being purchased
     * @param  itemCost  the cost of each individual item being purchased
     * @return    The maximum value between each DiscountPolicy parameter's computeDiscount methods. The bigger of the two discounts.
     */
    @Override
    public double computeDiscount(int quantity, double itemCost)
    {
        double discount = discountOne.computeDiscount(quantity, itemCost);
        if (discount < discountTwo.computeDiscount(quantity, itemCost)) {
            discount = discountTwo.computeDiscount(quantity, itemCost);
        }
        return discount;
    }
}
