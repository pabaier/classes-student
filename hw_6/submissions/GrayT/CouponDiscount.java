/*
 * Tyler Gray
 * Determines discount using coupons
 * Extends DiscountPolicy
 * Allows a max amount of coupons to be used
 */
public class CouponDiscount extends DiscountPolicy {

	private double couponValue;
	private int maxUses;
	public CouponDiscount(double couponValue, int maxUses) {
		// TODO Auto-generated constructor stub
		this.couponValue = couponValue;
		this.maxUses = maxUses;
	}

	@Override
	public double computeDiscount(int quantity, double itemCost) {
		if(quantity < maxUses) {
			return couponValue*quantity;
		}
		return couponValue*maxUses;
	}

}
