/*
 * Discount for buying a certain number of items and getting one free
 * Author: Mary Washington
 * Version: Eclipse Oxygen 4.7
 */

public class BuyNItemsGetOneFree extends DiscountPolicy { //inherits from DiscountPolicy
	private int n;
	
	//constructor
	public BuyNItemsGetOneFree(int n) {
		this.n = n;
	}
	
	//overrides method in DiscountPolicy
	@Override
	public double computeDiscount(int quantity, double itemCost) {
		double discount = 0.0;
		int x = 0;
		x = quantity/(n);  //how many items can be free of charge
		discount = x * itemCost;
		
		return discount;
	}

}
