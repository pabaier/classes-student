
/**
 * Jonathan Anderson
 * class to calculate the discount of items bought in bulk
 */
public class BulkDiscount extends DiscountPolicy
{
    private int minimum;
    private int percent;
    public BulkDiscount(int minimum, int percent)
    {
      this.minimum = minimum;
      this.percent = percent;
    }
    public double computeDiscount(int quantity, double itemCost)
    {
        if (quantity > minimum){
            itemCost = (itemCost*quantity)/percent;
        }else{
            itemCost = 0;
        }
        return itemCost;
    }
}