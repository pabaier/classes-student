/*Tyler Gray
 * HW6Part1 tests the ability of all the discounts. 
 * Shows the outputs of the discounts
 * 
 * 
 */
public class HW6Part1 {

	public static void main(String args[]) {
		double itemCost = 100;
		int itemBought = 5;
		int minimum = 2;
		int percent = 10;
		//Bulk Discount
		System.out.println("BULK DISCOUNT");
		//Buying 5 Items , Total before dis is 500, After should be 450
		BulkDiscount bkDis = new BulkDiscount(minimum, percent);
		double totalCost = itemCost * itemBought - bkDis.computeDiscount(itemBought, itemCost);
		double costBeforeDiscount = itemCost * itemBought;
		displayInfo(itemBought, itemCost, costBeforeDiscount, totalCost);
		//No Discount since we didnt buy enough
		itemCost = 100;
		itemBought = 1;
		totalCost = itemCost * itemBought - bkDis.computeDiscount(itemBought, itemCost);
		costBeforeDiscount = itemCost * itemBought;
		displayInfo(itemBought, itemCost, costBeforeDiscount, totalCost);
		//BuyNItemsGetOneFree
		System.out.println("Nth DISCOUNT");
		int n = 3;
		itemCost = 10;
		itemBought = 10;
		BuyNItemsGetOneFree buyNDis = new BuyNItemsGetOneFree(n);
		//Buying 10 items, every third free, paying for 7, cost should be 70
		costBeforeDiscount = itemCost * itemBought;
		totalCost = itemCost * itemBought - buyNDis.computeDiscount(itemBought, itemCost);
		displayInfo(itemBought, itemCost, costBeforeDiscount, totalCost);
		//Buying 10 item, every other is free, cost should be 50
		n = 2;
		buyNDis = new BuyNItemsGetOneFree(n);
		costBeforeDiscount = itemCost * itemBought;
		totalCost = itemCost * itemBought - buyNDis.computeDiscount(itemBought, itemCost);
		displayInfo(itemBought, itemCost, costBeforeDiscount, totalCost);
		//Coupon Discount
		System.out.println("COUPON DISCOUNT");
		//dollar off, max uses 5, 
		double couponValue = 1;
		int maxUses = 5;
		CouponDiscount coupDis = new CouponDiscount(couponValue, maxUses);
		//Discounted 5 of them so total should be 95
		itemCost = 10;
		itemBought = 10;
		costBeforeDiscount = itemCost * itemBought;
		totalCost = itemCost * itemBought - coupDis.computeDiscount(itemBought, itemCost);
		displayInfo(itemBought, itemCost, costBeforeDiscount, totalCost);
		//Buying 5 so total should be 45
		itemCost = 10;
		itemBought = 5;
		costBeforeDiscount = itemCost * itemBought;
		totalCost = itemCost * itemBought - coupDis.computeDiscount(itemBought, itemCost);
		displayInfo(itemBought, itemCost, costBeforeDiscount, totalCost);
		//Combined Discounts
		//Coupon Discount Does Nothing and bulk should take half off
		//Half off should happen since its the greater discount
		coupDis = new CouponDiscount(0,1);
		bkDis = new BulkDiscount(1,50);
		CombinedDiscount combineDis = new CombinedDiscount(coupDis, bkDis);
		itemCost = 10;
		itemBought = 1;
		costBeforeDiscount = itemCost * itemBought;
		totalCost = itemCost * itemBought - combineDis.computeDiscount(itemBought, itemCost);
		displayInfo(itemBought, itemCost, costBeforeDiscount, totalCost);
		//Coupon Discount to be 90% off of item and blk to be 50 so coupon will work
		coupDis = new CouponDiscount(9,1);
		bkDis = new BulkDiscount(1,50);
		combineDis = new CombinedDiscount(coupDis, bkDis);
		itemCost = 10;
		itemBought = 1;
		costBeforeDiscount = itemCost * itemBought;
		totalCost = itemCost * itemBought - combineDis.computeDiscount(itemBought, itemCost);
		displayInfo(itemBought, itemCost, costBeforeDiscount, totalCost);
		
		
		
		
		
		
		
		
		
		
		
	}
	public static void displayInfo(int itemBought, double itemCost, double costBeforeDiscount, double totalCost) {
		System.out.println("Items Bought: " + itemBought + " Cost: $" + itemCost + "0 ");
		System.out.println("Total Before Discount: $" + costBeforeDiscount + "0 Total Cost After Discount: $" + totalCost + "0");
	}

}
