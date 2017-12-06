import java.text.NumberFormat;
/**
 * Write a description of class CouponDiscount here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CouponDiscount extends DiscountPolicy
{
    private double coupVal;
    private int numOfUses;
   
    public CouponDiscount(double coupVal, int numOfUses)
    {
        this.coupVal = coupVal;
        this.numOfUses = numOfUses;
    }
     @Override
    public double computeDiscount(int quantity, double itemCost){
        double discount = 0.0;
        for (int i = 1; (i <= numOfUses && i <= quantity); i++){
            discount+=coupVal;
        }
        return discount;
        }

    
    
}
