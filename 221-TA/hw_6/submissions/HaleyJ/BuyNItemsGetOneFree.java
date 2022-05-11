public class BuyNItemsGetOneFree extends DiscountPolicy{
    private int n=0;
    public BuyNItemsGetOneFree(int n){
        this.n=n;
    }
    public double computeDiscount(int q, double cost){
        int numItems = q / n;
        return cost * numItems;
    }
}