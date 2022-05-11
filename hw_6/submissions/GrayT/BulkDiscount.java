/*
 * Tyler Gray
 * Extends DiscountPolicy
 * As long as a certain amount is purchased, a discount is applied to the whole order
 */
public class BulkDiscount extends DiscountPolicy{

	private int minimum;
	private int percent;
	
	public BulkDiscount(int minimum, int percent) {
		this.minimum = minimum;
		this.percent = percent;
	}

	@Override
	public double computeDiscount(int quantity, double itemCost) {
		if(quantity >= minimum) {
			return percent*itemCost/100*quantity;
		}else {
			return 0.0;
		}
		
	}
	
	

}
