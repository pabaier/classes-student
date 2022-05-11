/*
 * If you have two discounts which one to use
 * Author: Mary Washington
 * Version: Eclipse Oxygen 4.7
 */
public class CombinedDiscount extends DiscountPolicy{ //inherits from DiscountPolicy
	
	private DiscountPolicy dis1;
	private DiscountPolicy dis2;
	
	//constructor
	public CombinedDiscount(DiscountPolicy dis1, DiscountPolicy dis2) {
		this.dis1 = dis1;
		this.dis2 = dis2;
	}
	
	//overrides method in DiscountPolicy
	@Override
	public double computeDiscount(int quantity, double itemCost){
		double discount = 0.0;
		if((dis1.computeDiscount(quantity, itemCost) >= dis2.computeDiscount(quantity, itemCost))) {
			discount = dis1.computeDiscount(quantity, itemCost);
		}
		else {
			discount = dis2.computeDiscount(quantity, itemCost);
		}
		
		return discount;
	}

}
