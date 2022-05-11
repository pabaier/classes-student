
/**
 * Test driver for Homework 6 Part 1
 * tests the discount classes
 *
 * Ashley Woods
 */
public class HW6Part1
{
    public static void main(String[] args){
        //BulkDiscount test 1-- computes a discount
        System.out.println("BulkDiscount Test1(min = 10, percent = 5%, quantity = 20, price = $2.00): ");
        DiscountPolicy d1 = new BulkDiscount(10, 5);
        System.out.println("Discount: "+ d1.computeDiscount(20, 2.00) + " Total Price: " + ((2.00*20) - d1.computeDiscount(20, 2.00)));
        System.out.println();
        
        //BulkDiscount test 2 -- computes a discount of 0
        System.out.println("BulkDiscount Test2(min = 10, percent = 5%, quantity = 9, price = $2.00): ");
        DiscountPolicy d2 = new BulkDiscount(10, 5);
        System.out.println("Discount: "+ d2.computeDiscount(9, 2.00) + " Total Price: " + ((2.00*9) - d2.computeDiscount(9, 2.00)));
        System.out.println();
        
        //BuyNItemsGetOneFree test 1-- computes a discount
        System.out.println("BuyNItemsGetOneFree Test1(n = 5, quantity = 10, price = $2.00): ");
        DiscountPolicy d3 = new BuyNItemsGetOneFree(5);
        System.out.println("Discount: "+ d3.computeDiscount(10, 2.00) + " Total Price: " + ((2.00*10) - d3.computeDiscount(10, 2.00)));
        System.out.println();
        
        //BuyNItemsGetOneFree test 2 -- computes a discount of 0
        System.out.println("BuyNItemsGetOneFree Test2(n = 5, quantity = 4, price = $2.00): ");
        DiscountPolicy d4 = new BuyNItemsGetOneFree(5);
        System.out.println("Discount: "+ d4.computeDiscount(4, 2.00) + " Total Price: " + ((2.00*4) - d4.computeDiscount(4, 2.00)));
        System.out.println();
        
        //CombinedDiscount test 1 -- discount 1 is chosen
        System.out.println("CombinedDiscount Test1(using BulkDiscount Test1 and BuyNItemsGetOneFree Test1, Quantity = 10 and Price = $2.00): ");
        DiscountPolicy d5 = new CombinedDiscount(d1, d3);
        System.out.println("Discount: "+ d5.computeDiscount(10, 2.00) + " Total Price: " + ((2.00*10) - d5.computeDiscount(10, 2.00)));
        System.out.println();
        
        //CombinedDiscount test 2 -- discount 2 is chosen
        System.out.println("CombinedDiscount Test2(using BuyNItemsGetOneFree Test1 and BulkDiscount Test1, Quantity = 10 and Price = $2.00): ");
        DiscountPolicy d6 = new CombinedDiscount(d3, d1);
        System.out.println("Discount: "+ d6.computeDiscount(10, 2.00) + " Total Price: " + ((2.00*10) - d6.computeDiscount(10, 2.00)));
        System.out.println();
        
        //CuponDiscount test 1 -- number of items runs out first
        System.out.println("CuponDiscount Test1(cupon Value = $1, cupon Uses = 7, quantity = 5, price = $2.00): ");
        DiscountPolicy d7 = new CuponDiscount(1.00, 7);
        System.out.println("Discount: "+ d7.computeDiscount(5, 2.00) + " Total Price: " + ((2.00*5) - d7.computeDiscount(5, 2.00)));
        System.out.println();
        
        //CuponDiscount test 1 -- cupon uses runs out first     
        System.out.println("CuponDiscount Test1(cupon Value = $1, cupon Uses = 4, quantity = 5, price = $2.00): ");
        DiscountPolicy d8 = new CuponDiscount(1.00, 4);
        System.out.println("Discount: "+ d8.computeDiscount(5, 2.00) + " Total Price: " + ((2.00*5) - d8.computeDiscount(5, 2.00)));
        System.out.println();
        
    }
}
