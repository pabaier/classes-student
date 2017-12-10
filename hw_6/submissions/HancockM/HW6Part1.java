
/**
 * Write a description of class HW6Part1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HW6Part1
{

    public static void main(String[] args)
    {
        BulkDiscount dis1 = new BulkDiscount(10, 10);
        BuyNItemsGetOneFree dis2 = new BuyNItemsGetOneFree(7);
        CombinedDiscount com = new CombinedDiscount(dis1,dis2);
        CouponDiscount dis3 = new CouponDiscount(.50, 4);
        
        System.out.println("Bulk Discount of 100 Items at $9.99 Each: " + dis1.computeDiscount(100, 9.99));
        System.out.println("Buy 7 get one free Discount of 100 Items at $9.99 Each: " + dis2.computeDiscount(100, 9.99));
        System.out.println("Which of these is better? : " + com.computeDiscount(100,9.99));
        System.out.println("5 things cost $2 each. I have a $.50 i can use up to 4 times?: " + dis3.computeDiscount(5, 2.0));
        System.out.println("4 things cost $2 each. I have a $.50 i can use up to 4 times?: " + dis3.computeDiscount(4, 2.0));
        System.out.println("3 things cost $2 each. I have a $.50 i can use up to 4 times?: " + dis3.computeDiscount(3, 2.0));
        
    }


}
