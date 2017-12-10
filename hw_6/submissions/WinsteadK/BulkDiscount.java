/*
 * Name: Kyle Winstead
 * 
 * Gets the bulk discount of the item cost
 * derrived from discount policy
 */
public class BulkDiscount extends DiscountPolicy {
	
	private int minimum;
	private double percentage;
	public BulkDiscount(int minimum, int discountRate) {
		minimum=minimum;
		percentage = discountRate/100;
	}
	public double computeDiscount(int quantity, double itemCost) {
		double discount = 0.0;
		if(quantity>minimum) {
			double totalCost=quantity*itemCost;
			discount=totalCost*percentage/100;
		}
	return discount;
	}

}
