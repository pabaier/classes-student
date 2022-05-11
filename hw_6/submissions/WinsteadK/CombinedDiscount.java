/*
 * Name: Kyle Winstead
 * 
 * compute discount to return max value returned by computeDiscount for each of its two instance variables
 * 
 */
public class CombinedDiscount extends DiscountPolicy{
	
	private DiscountPolicy bulkDiscount;
	private DiscountPolicy buyNItemsDiscount;
	
	public CombinedDiscount(DiscountPolicy dis1, DiscountPolicy dis2) {
		bulkDiscount = dis1;
		buyNItemsDiscount = dis2;
	}
	
	public double computeDiscount(int quantity, double itemCost) {
		double dis1 = bulkDiscount.computeDiscount(quantity, itemCost);
		double dis2 = buyNItemsDiscount.computeDiscount(quantity, itemCost);
		
		if(dis1>= dis2) {
			return dis1;
		}
		else {
			return dis2;
		}
	}

}
