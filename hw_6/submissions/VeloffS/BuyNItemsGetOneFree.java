//@author: Stefan Veloff;
//CSCI 221:HW6Part1:
//This class gets the nth item free (named BuyNItemsGetOneFree): 
//I discussed this homework assignment with: CSCI tutors (Daniel & Anthony M.), Paul B. & Kyle W. 
public class BuyNItemsGetOneFree extends DiscountPolicy{
	
	//fields:
	private int n;
	
	//Constructor:
	public BuyNItemsGetOneFree(int n) {
		this.n = n;
	}
	//Methods:
	public double computeDiscount(int quantity, double itemCost) {
		//use of integer division for discount:
		double discount = ((quantity / n) * itemCost);
		//return statement:
		return discount;
	}
	

}
