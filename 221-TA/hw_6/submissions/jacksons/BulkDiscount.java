/* 
 * Sydney Jackson
 * BulkDiscount class is derived from DiscountPolicy and gives the 
 * bulk discount to a purchase if it exceeds the minimum purchase required
 * Methods: computeDiscount()
 */
public class BulkDiscount extends DiscountPolicy{
    private int minimum;
    private double percent;
    public BulkDiscount(int min, int perc){
        minimum = min;
        percent = perc;
        
    }
    public double computeDiscount(int quantity, double itemCost){
        double discount = 0.0;
        double discountPrice = 0.0;
        double price = 0.0;
        if (quantity > minimum){
            price = quantity * itemCost;
            discountPrice = price * (percent / 100);
        }
        return discountPrice;
    }
}