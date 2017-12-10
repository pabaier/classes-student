/*
 * Sydney Jackson
 * BuyNItemsGetOneFree class is derived from DiscountPolicy and gives a free 
 * item of specified type
 * Methods: computeDiscount()
 */
public class BuyNItemsGetOneFree extends DiscountPolicy{
    private int number;
    public BuyNItemsGetOneFree(int n){
        number = n;
    }
    @Override
    public double computeDiscount(int quantity, double itemCost){
        double discount = 0.0;
        if (quantity > number){
            discount = (quantity / number) * itemCost;
        }
        return discount;
    }
}        