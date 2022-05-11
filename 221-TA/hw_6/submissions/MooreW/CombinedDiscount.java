
public class CombinedDiscount extends DiscountPolicy{
	private DiscountPolicy dis1;
	private DiscountPolicy dis2;

	public CombinedDiscount(DiscountPolicy dis1, DiscountPolicy dis2){
		this.dis1 = dis1;
		this.dis2 = dis2;
	}
	double coumputeDiscount(int quantity, double itemCost) {
		if(dist1 > dist2){
		 return ((dis1+ dis2)/100);
		}
	}

}
