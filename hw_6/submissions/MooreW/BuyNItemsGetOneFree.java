
public class BuyNItemsGetOneFree extends DiscountPolicy{
	private int n;
	
	public BuyNItemsGetOneFree(int n){
		this.n = n;
		
	}
	
	@Override
	double coumputeDiscount(int quantity, double itemCost) {
		for(int i = 0; i < quantity; i++){
			if (i%n == 0){
				itemCost += 0;
			}
			else{
				itemCost += itemCost;
			}
		}
		return itemCost;
	}

}
