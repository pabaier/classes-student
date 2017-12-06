
/**
 * Write a description of class CombinedDiscount here.
 *
 * Steven Higgins
 *
 */
public class CombinedDiscount extends DiscountPolicy
{
    private DiscountPolicy a;
    private DiscountPolicy b;
    public CombinedDiscount(DiscountPolicy a, DiscountPolicy b)
    {
        this.a = a;
        this.b = b;
    }
    public double computeDiscount(int quantity, double itemCost){
        double discount = 0;
        double disa = a.computeDiscount(quantity, itemCost);
        double disb = b.computeDiscount(quantity, itemCost);
        if(disa == disb){
            discount = disa;
        }
        else if(disa > disb){
            discount = disa;
        }
        else if(disa < disb){
            discount = disb;
        }
        return discount;
    }

}
