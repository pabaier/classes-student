
/**
 * class CombinedDiscount - Ment to extend DiscountPolicy to include a way to find 
 * the larger of two discounts
 *
 * @author Lexus Hartung
 */
public class CombinedDiscount extends DiscountPolicy{
    private DiscountPolicy dis1;
    private DiscountPolicy dis2;
    
    //Constructor for objects of class CombinedDiscount
    public CombinedDiscount(DiscountPolicy dis1,DiscountPolicy dis2){
        this.dis1 = dis1;
        this.dis2 = dis2;
    }

    //Uses computeDiscount of two DiscountPolicy objects to find the larger discount
    public double computeDiscount (int quantity,double itemCost){
        double d1 = dis1.computeDiscount(quantity, itemCost);
        double d2 = dis2.computeDiscount(quantity, itemCost);
        if(d1 > d2){
           return d1; 
        }
        else{
           return d2; 
        }
    }
}

