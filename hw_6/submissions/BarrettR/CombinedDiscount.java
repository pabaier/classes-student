//Ryan Barrett
//combines two discounts
public class CombinedDiscount extends DiscountPolicy {
	DiscountPolicy d1;
	DiscountPolicy d2;
	public CombinedDiscount(DiscountPolicy dis1, DiscountPolicy dis2) {
		d1 = dis1;
		d2 = dis2;
	}
	@Override
	public double computeDiscount(int quantity, double itemCost) {
		if(d1.computeDiscount(quantity, itemCost) > d2.computeDiscount(quantity, itemCost))
			return d1.computeDiscount(quantity, itemCost);
		return d2.computeDiscount(quantity, itemCost);
	}
}