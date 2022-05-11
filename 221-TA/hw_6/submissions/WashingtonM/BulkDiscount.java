/*
 * If buying items in bulk what would the discount be?
 * Author: Mary Washington
 * Version: Eclipse Oxygen 4.7
 */
public class BulkDiscount extends DiscountPolicy{ //inherits from DiscountPolicy
	
	private int minimum;
	private int percent;
	
	//constructor
	public BulkDiscount(int minimum, int percent) {
		this.minimum = minimum;
		this.percent = percent;
		
	}
	
	//overrides method in DiscountPolicy
	@Override
	public double computeDiscount(int quantity, double itemCost) {
		double discount = 0.0;
		if (quantity > minimum) { // checking to see if a discount is even permitted
			discount = (quantity*itemCost)*(percent*0.01);
		}
		else { // no discount permitted
			discount = 0;
		}
		return discount;
	}

}
