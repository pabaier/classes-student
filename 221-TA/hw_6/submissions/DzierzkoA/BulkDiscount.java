/*
    Class stores discount percent and minimum items that need to be bought in order for the discount to be applied,
    calculates discount based on this information and given price

    author: Adam Dzierzko
 */

public class BulkDiscount extends DiscountPolicy {

    private int minimum;
    private int percent;

    public BulkDiscount(int minimum, int percent) {
        this.minimum = minimum;
        this.percent = percent;
    }

    @Override
    double computeDiscount(int quantity, double itemCost) {

        return quantity > minimum ? quantity * itemCost * percent / 100.0 : 0;
    }
}
