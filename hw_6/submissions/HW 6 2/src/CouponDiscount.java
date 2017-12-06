//@author: Stefan Veloff
//CSCI 221:HW6Part1
//This is the CouponDiscount class:
//I discussed this homework assignment with: CSCI tutors (Daniel & Anthony M.), Paul B. & Kyle W. 

//CouponDiscount class:
public class CouponDiscount extends DiscountPolicy{

		//fields:
		private double couponValue;
		private int maxUses;
		
		
		//constructor:
		public CouponDiscount(double couponValue , int maxUses) {
			this.couponValue = couponValue;
			this.maxUses = maxUses;		 			
		}

		//methods:
		public double computeDiscount(int quantity, double itemCost) {
			if(maxUses <=  quantity) {
				return (maxUses * couponValue);
			}
			else {
				return (quantity * couponValue);
				
			}
		}

		

}
