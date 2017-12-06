public class BulkDiscount extends DiscountPolicy {
    private int minimum;
    private int percent;
    public BulkDiscount(int minimum, int percent){
        this.minimum = minimum;
        this.percent = percent;
    }

    @Override
    public double computeDiscount(int quantity, double itemCost){
        if(quantity > this.minimum) {
            return percent/100.0*quantity*itemCost;
        }
        return 0;
    }

}
