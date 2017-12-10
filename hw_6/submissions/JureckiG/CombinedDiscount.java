//Gabe Jurecki
public class CombinedDiscount extends DiscountPolicy {
    private DiscountPolicy dis1;
    private DiscountPolicy dis2;
    public CombinedDiscount(DiscountPolicy dis1, DiscountPolicy dis2) {
        this.dis1 = dis1;
        this.dis2 = dis2;
    }


    double computeDiscount(int quantity, double itemCost) {
       //double disc1 = dis1.();
        double discount = 0.0;

        return discount;
    }

    @Override
    public String toString() {
        return "Discount: ";
    }
}
