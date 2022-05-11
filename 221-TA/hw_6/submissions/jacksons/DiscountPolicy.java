/* 
 * Sydney Jackson
 * Abstract class DiscountPolicy will be extended by classes BulkDiscount,
 * BuyNItemsGetOneFree, CombinedDiscount, and CouponDiscount
 * Methods: computeDiscount()
 */

public abstract class DiscountPolicy{
    abstract double computeDiscount(int quantity,double itemCost);
}