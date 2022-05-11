/*
 * Name: Kyle Winstead
 * 
 * takes amount of items 
 * sets limit on alloted discounted items
 * gives discount
 */
public class BuyNItemsGetOneFree extends DiscountPolicy{
	
	private int n;
	public BuyNItemsGetOneFree(int n) {
		this.n=n;
	}
	public double computeDiscount(int count, double itemCost) {
		double discount = (count/n) * itemCost;
		return discount;
	}

}
