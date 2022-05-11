/*
 * Abstract class that provides the framework for the rest of it's subclasses
 * Author: Mary Washington
 * Version: Eclipse Oxygen 4.7
 */
public abstract class DiscountPolicy {
	
	//method that all subclasses must implement
	public abstract double computeDiscount(int quantity, double itemCost);

}
