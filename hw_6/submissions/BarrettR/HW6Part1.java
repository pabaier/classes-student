//Ryan Barrett
//Tests HW6 Part 1 classes
public class HW6Part1 {
	public static void main(String[]args) {
		BulkDiscount bulk = new BulkDiscount(3, 50);
		CouponDiscount coupons = new CouponDiscount(10, 25);
		CombinedDiscount combine = new CombinedDiscount(bulk, coupons);
		BuyNItemsGetOneFree bogo = new BuyNItemsGetOneFree(2);
		
		System.out.println("Bulk Discount: " + bulk.computeDiscount(10, 5));
		System.out.println("Coupon Discount: " + coupons.computeDiscount(10, 5));
		System.out.println("Combined Discount: " + combine.computeDiscount(10, 5));
		System.out.println("Buy one get one free discount: " + bogo.computeDiscount(10, 5));
	}
}