
/**
 * CombinedDiscount compares discount of 2 discount policies and returns largest.
 *
 * @author Andrea Lingenfelter
 * @version November 11, 2017
 */
public class CombinedDiscount extends DiscountPolicy{
    private DiscountPolicy dis1;
    private DiscountPolicy dis2;
          
    public CombinedDiscount(DiscountPolicy dis1, DiscountPolicy dis2){
       this.dis1 = dis1;
       this.dis2 = dis2;
    }

    
    public double computeDiscount(int quantity, double itemCost)
    {
        double discount;
        double disc1 = dis1.computeDiscount(quantity, itemCost);
        double disc2 = dis2.computeDiscount(quantity, itemCost);
        discount = Math.max(disc1, disc2);
        return discount;
    }
}
