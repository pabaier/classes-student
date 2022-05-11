//Asa Perryman

public class CombinedDiscount extends DiscountPolicy{
    
    private DiscountPolicy dis1;
    private DiscountPolicy dis2;
     
    public CombinedDiscount(DiscountPolicy dis1, DiscountPolicy dis2){
        this.dis1 = dis1;
        this.dis2 = dis2;
    }
     
    
    public double computeDiscount(int quantity, double itemCost){
        double discount = 0.0;
        double discount1 = dis1.computeDiscount(quantity, itemCost);
        double discount2 = dis2.computeDiscount(quantity, itemCost);
        
        if(discount1 >= discount2){
            discount = discount1;
            return discount;
        }
        
        else{
            discount = discount2;
            return discount;
        }
    }
 
}