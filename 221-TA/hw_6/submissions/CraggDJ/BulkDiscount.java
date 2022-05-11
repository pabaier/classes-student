
/**
 * Takes in a minimum amount and percent to instantiate and then use to calculate
 * the discount.
 *
 * @Dustin Cragg
 * @11/16/2017
 */
public class BulkDiscount extends DiscountPolicy
{
    //two instance variables
    int minimum;
    int percent;
    
    //constructor that has two param and defines instance
    void BulkDiscount(int minimum, int percent)
    {
        this.minimum = minimum;
        this.percent = percent;
    }
    
    
    //define computeDiscount
    double computeDiscount(int quantity, double itemCost)
    {
        if(quantity > minimum) 
        {
            double discount = percent;
            return discount;
        }
        else
        {
            return 0;
        }
    }
}
