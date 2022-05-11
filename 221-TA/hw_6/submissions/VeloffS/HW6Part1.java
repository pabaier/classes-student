//@author: Stefan Veloff;
//CSCI 221:HW6
//This is the test driver for all of part 1:
//I discussed this homework assignment with: CSCI tutors (Daniel & Anthony M.), Paul B. & Kyle W. 

//test driver for part 1:
public class HW6Part1 {
	public static void main (String [] args) {
		//initializing variables:
		int minQuantity = 3;
		int n = 3;
		int discount = 10;
		double itemCost = 10.0;
		double couponVal = 0.3;
		int maxUses = 3;
		
		
		BulkDiscount bulkDiscount = new BulkDiscount(minQuantity, discount);
		BuyNItemsGetOneFree getOneFree = new BuyNItemsGetOneFree(n);	
		CombinedDiscount combinedDiscount = new CombinedDiscount(getOneFree, bulkDiscount);
		CouponDiscount  couponDiscount = new CouponDiscount(couponVal, maxUses);
		
		//testing:
		System.out.printf("Testing bulk discount: $%.2f\n" , bulkDiscount.computeDiscount(1, itemCost));
		System.out.printf("Testing buy-one get-one free: $%.2f\n" , getOneFree.computeDiscount(1, itemCost));
		System.out.printf("Testing combined discount: $%.2f\n" , combinedDiscount.computeDiscount(1, itemCost));
		System.out.printf("Testing coupon discount: $%.2f\n" , couponDiscount.computeDiscount(1, itemCost));
		
		System.out.println("-------------------------------------");
		
		//testing:
		System.out.printf("Testing bulk discount: $%.2f\n" , bulkDiscount.computeDiscount(2, itemCost));
		System.out.printf("Testing buy-one get-one free: $%.2f\n" , getOneFree.computeDiscount(2, itemCost));
		System.out.printf("Testing combined discount: $%.2f\n" , combinedDiscount.computeDiscount(2, itemCost));
		System.out.printf("Testing coupon discount: $%.2f\n" , couponDiscount.computeDiscount(2, itemCost));
		
		System.out.println("-------------------------------------");
		
		//testing:
		System.out.printf("Testing bulk discount: $%.2f\n" , bulkDiscount.computeDiscount(3, itemCost));
		System.out.printf("Testing buy-one get-one free: $%.2f\n" , getOneFree.computeDiscount(3, itemCost));
		System.out.printf("Testing combined discount: $%.2f\n" , combinedDiscount.computeDiscount(3, itemCost));
		System.out.printf("Testing coupon discount: $%.2f\n" , couponDiscount.computeDiscount(3, itemCost));
		
		System.out.println("-------------------------------------");
		
		//testing:
		System.out.printf("Testing bulk discount: $%.2f\n" , bulkDiscount.computeDiscount(4, itemCost));
		System.out.printf("Testing buy-one get-one free: $%.2f\n" , getOneFree.computeDiscount(4, itemCost));
		System.out.printf("Testing combined discount: $%.2f\n" , combinedDiscount.computeDiscount(4, itemCost));
		System.out.printf("Testing coupon discount: $%.2f\n" , couponDiscount.computeDiscount(4, itemCost));
		
		
		
		


		
		
		

		
	}

}

