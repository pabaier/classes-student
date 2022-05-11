//Asa Perryman

public class BulkDiscount extends DiscountPolicy{   
    private double minimum;
    private double percent;
     
    public BulkDiscount(int minimum, double percent){
        this.minimum = minimum;
        this.percent = percent;
    }
     
    
    public double computeDiscount(int quantity, double itemCost){   
        double discount = 0;
         
         if (quantity > minimum){
           discount = percent;
           return percent*itemCost*quantity;
         }
          
         else{
           return 0;
        }
    }
    
}
