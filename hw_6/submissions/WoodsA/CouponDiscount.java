
/**
 * CuponDiscount
 * Calculates the discount based on a cupon's value and how many times it can be used.
 *
 * Ashley Woods
 */
public class CouponDiscount extends DiscountPolicy
{
    double cuponValue;
    int maxUses;
    
    public CuponDiscount(double cuponVal, int MaxUse){
        cuponValue = cuponVal;
        maxUses = MaxUse;
    }
    
    public double computeDiscount(int quantity, double itemCost) {
        double discount = 0;
        int counter1 = quantity;
        int counter2 = maxUses;
        while (counter1>0 && counter2>0) {
            discount += cuponValue;
            counter1--;
            counter2--;
        }
        return discount;
    }
}
