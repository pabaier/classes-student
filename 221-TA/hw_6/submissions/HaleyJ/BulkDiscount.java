public class BulkDiscount extends DiscountPolicy
{
    protected int minimum = 0;
    protected int percent = 0;
    
    public BulkDiscount(int min, int pct)
    {
        minimum = min;
        percent = pct;
    }

    public double computeDiscount(int q, double cost)
    {
        double discount =0;
        if (q > minimum){
            discount = cost * (percent/100.00);
        }
        return discount;
    }
}
