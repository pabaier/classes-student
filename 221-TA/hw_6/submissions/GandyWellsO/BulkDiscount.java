import java.text.NumberFormat;
/**
 * Orianna Gandy-Wells
 * 
 * This class constructs a new discount and overrides the 
 * computeDiscount function of DiscountPolicy
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
    @Override
    public double computeDiscount(int quantity, double itemCost){
        double discount = 0.0;
        if(quantity > minimum){
            discount = (quantity*itemCost) * (percent / 100.0);
        }
        else{
            discount = 0.0;
        }
        return discount;
        }
    }

