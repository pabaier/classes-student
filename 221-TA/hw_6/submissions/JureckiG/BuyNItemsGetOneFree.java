//Gabe Jurecki
public class BuyNItemsGetOneFree extends DiscountPolicy {
    private int n;
    public BuyNItemsGetOneFree(int n) {
        this.n = n;
    }

    @Override
    double computeDiscount(int quantity, double itemCost) {
        double discount = 0.0;
        discount = quantity / n;
        return discount;
    }

    @Override
    public String toString() {
        return "discount: " + n ;
    }
}
