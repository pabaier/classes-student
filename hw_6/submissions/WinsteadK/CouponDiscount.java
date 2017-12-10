/*
 * Name: Kyle Winstead
 * 
 * 
 */
public class CouponDiscount extends DiscountPolicy {

	
	private double couponValue;
	private int maxUses;
	
	public CouponDiscount(double couponValue, int maxUsers) {
		this.couponValue = couponValue;
		this.maxUses = maxUses;
		
	}
	public double computeDiscount(int quantity, double itemCost) {
	
			return Math.max(maxUses, quantity) * couponValue;
		
		
	}
	
	
	
}
