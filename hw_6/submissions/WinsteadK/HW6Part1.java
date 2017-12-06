/*
 * Name: Kyle Winstead
 * 
 * Part 1 Tester
 */
public class HW6Part1 {

	public static void main(String[] args) {
		
		double couponValues = .5;
		int maxUses = 5;
		int nthItemToAllowDiscount = 3;
		int minimumQuan = 5;
		int discountRate = 10;
		
		//BuyNItem
		BuyNItemsGetOneFree getOneFree = new BuyNItemsGetOneFree(nthItemToAllowDiscount);
		BulkDiscount bulkDisc = new BulkDiscount(minimumQuan, discountRate);
		
		
		int itemCount = 20;
		double itemCost = 5;
		
		//Display discount
		System.out.printf("Get one free Discount: $%.2f\n" , getOneFree.computeDiscount(itemCount, itemCost));
		//Display bulk discount
		System.out.printf("Bulk discount: $%.2f\n" , bulkDisc.computeDiscount(itemCount, itemCost));
		//display combined discount
		CombinedDiscount combinedDiscount = new CombinedDiscount(getOneFree, bulkDisc);
		System.out.printf("Combined discount: $%.2f\n" , combinedDiscount.computeDiscount(itemCount, itemCost));
		//display coupon discount
		CouponDiscount coupdisc = new CouponDiscount(couponValues, maxUses);
		System.out.printf("Coupon Discount: $%.2f\n", coupdisc.computeDiscount(itemCount, itemCost));
	}

}
