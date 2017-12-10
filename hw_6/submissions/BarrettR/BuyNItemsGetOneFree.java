//Ryan Barrett
//gives an item for free once every n items
public class BuyNItemsGetOneFree extends DiscountPolicy {
	int n;
	public BuyNItemsGetOneFree(int number) {
		n = number;
	}
	@Override
	public double computeDiscount(int quantity, double itemCost) {
		return quantity / n * itemCost;
	}
}