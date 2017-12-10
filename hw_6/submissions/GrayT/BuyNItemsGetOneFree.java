/*Tyler Gray
 * Extends Discount Policy
 * Makes every nth item purchased free. 
 * Does int division to determine how many items will be discounted
 */
public class BuyNItemsGetOneFree extends DiscountPolicy{

	private int n;
	
	public BuyNItemsGetOneFree(int n) {
		this.n = n;
	}

	@Override
	public double computeDiscount(int quantity, double itemCost) {
		return (quantity/n)*itemCost;
	}

}
