//Elex Moore
public class BulkDiscount extends DiscountPolicy{
	private int minimum;
	private int percent;

	public BulkDiscount(int minimum, int percent){
		this.minimum = minimum;
		this.percent = percent;
	}

	@Override
	double coumputeDiscount(int quantity, double itemCost) {
		if(quantity >= minimum){
			return  itemCost -=(percent/100)*itemCost;
		}
		else{
			return 0;
		}
	}

}
