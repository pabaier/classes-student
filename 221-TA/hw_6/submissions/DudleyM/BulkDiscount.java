public class BulkDiscount extends DiscountPolicy {
    private int minimum;
    private int percent;

    public BulkDiscount(int minimum,int percent){
        this.minimum = minimum;
        this.percent = percent;
    }

    public double computeDiscount(int quantity, double percent) {
        if (quantity >= minimum) {
            return this.percent;
        }else{
            return 0;
        }
    }
}
