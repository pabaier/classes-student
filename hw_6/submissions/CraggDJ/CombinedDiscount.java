
/**
 * takes in two discountPolicy instances and combines them to make a new discount.
 *
 * @Dustin Cragg
 * @11/16/2017
 */
public class CombinedDiscount extends DiscountPolicy
{
    double cDiscount;
    //constructor takes two discount policy instances
    void CombinedDiscount(double one, double two)
    {
        cDiscount = one + two;
    }
    //define computeDiscount
    double computeDiscount(int quantity, double itemCost)
    {
        double discount = (quantity * itemCost) * cDiscount;
        return discount;
    }
}
