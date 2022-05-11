
/**
 * Ariel Robinson
 * returns the discount if the minimum is greater than quantity then
 * percent is returned
 * 
 */
public class BulkDiscount extends DiscountPolicy {
    private int minimum;
    private int percent;  

    /**
     * Constructor for objects of class BulkDiscount
     */
    public BulkDiscount(int minimum, int percent){

        {
            this.minimum=minimum;
            this.percent=percent;

        }
    }

    public double computeDiscount(int quantity, double itemCost){
        double discount;
        if (quantity > minimum){
            discount=percent/100.0;

        }
        else{
            discount=0;
        }
        return (discount*itemCost)*quantity;

    }
}

