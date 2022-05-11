//Elex Moore
public class CouponDiscount extends DiscountPolicy{
	private double couponValue;
	private int maxUses;
	
	public CouponDiscount(double couponValue, int uses){
		this.couponValue = couponValue;
		maxUses = uses;
	}

	@Override
	double coumputeDiscount(int quantity, double itemCost) {
		itemCost -= ((couponValue/100.0) * maxUses)*itemCost * quantity;
		return itemCost;
	}
	

}
