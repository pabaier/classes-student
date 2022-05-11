//Elex Moore
public class HW6Part1 {

	public static void main(String[] args) {
		BulkDiscount waterBottles = new BulkDiscount(10, 30);
		System.out.println("The cost of the item is: " + waterBottles.coumputeDiscount(20, 40));
		
		CouponDiscount food = new CouponDiscount(1.0, 2);
		System.out.println("Food cost is: " + food.coumputeDiscount(3, 10));
		
		BuyNItemsGetOneFree free = new BuyNItemsGetOneFree(10);
		System.out.println(free.coumputeDiscount(0, 10));
		
		
		

	}

}
