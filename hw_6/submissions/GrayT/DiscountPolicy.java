/*
 * Tyler Gray
 * Abstract class for all the other discounts being applied
 * 
 */

public abstract class DiscountPolicy {

	
	public abstract double computeDiscount(int quantity , double itemCost);
	
}
