
/**
 * takes in n which is the number of items to be purchased to get a free one,
 * it then uses that to calculate the discount using quantity, n and itemcost.
 *
 * @Dustin Cragg
 * @11/16/2017
 */
public class BuyNItemsGetOneFree extends DiscountPolicy
{
    int n;
    //constructor with single parameter n 
    void BuyNItemsGetOneFree( int n )
    {
        this.n = n;
    }
    //define computeDiscount
    double computeDiscount(int quantity, double itemCost)
    {
        double discount = 0;
        discount = ( quantity / n ) * itemCost;
        
        return discount;
    }
}
