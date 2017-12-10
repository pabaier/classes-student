//@author: Stefan Veloff
//CSCI 221:HW6Part1:
//This is the CombinedDiscount class:
//I discussed this homework assignment with: CSCI tutors (Daniel & Anthony M.), Paul B. & Kyle W. 

//CombinedDiscount class:
public class CombinedDiscount extends DiscountPolicy {
	
	//fields:
	private DiscountPolicy dis1;
	private DiscountPolicy dis2;
	
	//constructor:
	public CombinedDiscount (DiscountPolicy dis1, DiscountPolicy dis2) {
		this.dis1 = dis1;
		this.dis2 = dis2;
	}
	
	//methods: can also return Math.max(dis1,dis2);
	public double computeDiscount(int quantity, double itemCost) {
		double dis1 = this.dis1.computeDiscount(quantity, itemCost);
		double dis2 = this.dis2.computeDiscount(quantity, itemCost);
		
		//if statement:
		if (dis1 >= dis2) {
			//return discount1:
			return dis1;
		}
		//else return discount2 
		else {
			return dis2;
		}
	}

}
