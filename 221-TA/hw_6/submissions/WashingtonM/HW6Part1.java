/*
 * Test driver for all discounts
 * Author: Mary Washington
 * Version: Eclipse Oxygen 4.7
 */

import java.text.NumberFormat;
public class HW6Part1 {

	public static void main(String[] args) {
		BulkDiscount bd1 = new BulkDiscount(3, 5); 
		BulkDiscount bd2 = new BulkDiscount(25, 10);
		BuyNItemsGetOneFree bogo = new BuyNItemsGetOneFree(3);
		CouponDiscount couponDis1 = new CouponDiscount(.25, 3);
		CouponDiscount couponDis2 = new CouponDiscount(5, 15); 
		CombinedDiscount cd1 = new CombinedDiscount(bd1, bogo);
		
		System.out.println("Bulk discount bd1: " + NumberFormat.getCurrencyInstance().format(bd1.computeDiscount(100,2.5)));
		System.out.println("Bulk discount bd2: " + NumberFormat.getCurrencyInstance().format(bd2.computeDiscount(100, 2.5)));
		System.out.println("Combinded discount cd1: " + NumberFormat.getCurrencyInstance().format(cd1.computeDiscount(100, 2.5)));
		System.out.println("Buy n items get one free bogo: " + NumberFormat.getCurrencyInstance().
				format(bogo.computeDiscount(100, 2.5)));
		System.out.println("Coupon discount couponDis: " + NumberFormat.getCurrencyInstance().
				format(couponDis1.computeDiscount(100, 2.5)));
		System.out.println("Coupon discount couponDis: " + NumberFormat.getCurrencyInstance().
				format(couponDis2.computeDiscount(100, 2.5)));

	}

}
