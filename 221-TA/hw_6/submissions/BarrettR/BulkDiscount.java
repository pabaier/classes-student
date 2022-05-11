//Ryan Barrett
//gives a certain percent off
public class BulkDiscount extends DiscountPolicy {
	private int percent;
	private int minimum;
	public BulkDiscount(int m, int p) {
		percent = m;
		minimum = p;
	}
	@Override
	public double computeDiscount(int quantity, double itemCost) {
			if(minimum <= quantity)
					return itemCost * quantity * percent / 100;
			return 0;
	}
}