public class BuyNItemsGetOneFree extends DiscountPolicy{

    private int n;

    public BuyNItemsGetOneFree(int n){
        this.n = n;
    }

    public double computeDiscount(int quantity, double itemCost) {
        double totalDiscount = 0;
        for(int i = n; i <= quantity; i++){
            if(i % n == 0){
                totalDiscount += itemCost;
            }
        }
        return totalDiscount;
    }
}
