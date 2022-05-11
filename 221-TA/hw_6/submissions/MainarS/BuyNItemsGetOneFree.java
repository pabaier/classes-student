public class BuyNItemsGetOneFree extends DiscountPolicy {
    private int n;
    public BuyNItemsGetOneFree(int n){
        this.n = n;
    }
    @Override
    public double computeDiscount(int quantity, double itemCost){
        return quantity/n*itemCost;
    }
}
