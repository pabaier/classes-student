//Asa Perryman

public class BuyNItemsGetOneFree extends DiscountPolicy{
 
    private int n;
     
    public BuyNItemsGetOneFree(int n){
        this.n = n;
    }
     
    
    public double computeDiscount(int quantity, double itemCost){
        double discount = 0.0;
         
        if(quantity >= n){
            discount = itemCost * (quantity/n);
        }
         
        return discount;
    }
    
}