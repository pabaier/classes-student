/*
    Class stores two Discount policies, calculates discount based on which policy is better

    author: Adam Dzierzko
 */


public class CombinedDiscount extends DiscountPolicy {

    private DiscountPolicy dis1;
    private DiscountPolicy dis2;

    public CombinedDiscount(DiscountPolicy dis1, DiscountPolicy dis2){
        this.dis1 = dis1;
        this.dis2 = dis2;
    }

    @Override
    double computeDiscount(int quantity, double itemCost) {
        double discount1 = dis1.computeDiscount(quantity, itemCost);
        double discount2 = dis2.computeDiscount(quantity, itemCost);
        return discount1 >= discount2 ? discount1 : discount2;
    }
}
