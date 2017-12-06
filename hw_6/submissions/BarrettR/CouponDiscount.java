//Ryan Barrett
//gives a certain number of 
public class CouponDiscount extends DiscountPolicy {
	double couponValue;
	int maxUses;
	public CouponDiscount(double c, int m) {
		couponValue = c;
		maxUses = m;
	}
	@Override
	public double computeDiscount(int quantity, double itemCost) {
		if(quantity > maxUses)
			return maxUses * couponValue;
		return quantity * couponValue;
	}
}