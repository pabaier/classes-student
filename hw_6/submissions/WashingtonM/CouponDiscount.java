/*
 * What is the discount for coupons that have a finite number of uses
 * Author: Mary Washington
 * Version: Eclipse Oxygen 4.7
 */
public class CouponDiscount extends DiscountPolicy{ //inherits from DiscountPolicy
	private double couponValue;
	private int maxUses;
	
	//constructor
	public CouponDiscount(double value, int uses) {
		couponValue = value;
		maxUses = uses;
	}
	
	public double computeDiscount(int quantity, double itemCost) {
		double discount = 0.0;
		if(quantity > maxUses) { //checks to see if you have bought more items than number of uses
		discount = maxUses * couponValue;
		}
		else { //ensures that you're not getting free money
			discount = quantity * couponValue;
		}
		return discount;
	}

}
