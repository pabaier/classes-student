public class CombinedDiscount extends DiscountPolicy{
    private DiscountPolicy dis1;
    private DiscountPolicy dis2;
    public CombinedDiscount(DiscountPolicy p, DiscountPolicy q){
        dis1 = p;
        dis2 = q;
    }
    public double computeDiscount(int q, double cost){
        double discount1 = dis1.computeDiscount(q,cost);
        double discount2 = dis2.computeDiscount(q,cost);
        double rtnVal = 0.0;
        if(discount1 >= discount2){
            rtnVal = discount1;
        }else{
            rtnVal = discount2;
        }
        return rtnVal;
    }
}