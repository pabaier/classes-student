//Gabe Jurecki
public class BulkDiscount extends DiscountPolicy{
    private int minimum;
    private int percent;
    public BulkDiscount(int minimum, int percent){
        this.minimum = minimum;
        this.percent = percent;
    }
    @Override
    double computeDiscount(int quantity, double itemCost) {
        if(quantity > minimum){
            return percent;
        }
        return 0.0;
    }
    @Override
    public String toString() {
        return "Percent: " + percent;
    }
}
