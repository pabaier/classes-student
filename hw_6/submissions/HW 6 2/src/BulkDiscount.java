//@author: Stefan Veloff;
//CSCI 221:HW6Part1:
//This is the BulkDiscount class:
//I discussed this homework assignment with: CSCI tutors (Daniel & Anthony M.), Paul B. & Kyle W. 
public class BulkDiscount extends DiscountPolicy {
	
	//fields:
	private int minimum;
	private int percentage;
	
	//Constructor:
	public BulkDiscount (int minimum, int percent) {
		this.minimum = minimum;
		this.percentage = percent;
	}
	//Methods:
	public double computeDiscount(int quantity, double itemCost) {	
		double discount = 0.0;
		if (quantity > minimum) {
			double totalCost = quantity * itemCost;
			discount = (totalCost * percentage / 100);
		}
		//return statement:
		return discount;
	}
}
