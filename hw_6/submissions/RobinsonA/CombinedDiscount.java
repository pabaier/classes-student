
/**
 * Ariel Robinson
 * compares two discounts and returns the maximium discount
 * 
 */ 
public class CombinedDiscount extends DiscountPolicy
{
    // instance variables 
    private DiscountPolicy dis1;
    private DiscountPolicy dis2;

    /**
     * Constructor for objects of class CombinedDiscount
     */
    public CombinedDiscount(DiscountPolicy dis1, DiscountPolicy dis2)
    {
        this.dis1=dis1;
        this.dis2=dis2;

    }

    /**

     */
    //computes the discount
    public double computeDiscount(int quantity, double itemCost)
    {
        double discount1=dis1.computeDiscount(quantity, itemCost);
        double discount2=dis2.computeDiscount(quantity, itemCost);
        double discount=0;

        if(discount1>discount2){
            discount=discount1;

        }
        else{
            discount=discount2;

        }
        return discount;

    }
}
