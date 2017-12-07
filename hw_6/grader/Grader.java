import java.util.Scanner;
import edu.cofc.grader.*;

public class Grader {
    public static void main(String[] args) {
        C.colors(true);
        TestOutline root = new TestOutline("Homework 6");
        TestOutline part1 = new TestOutline("Part 1");
        TestOutline part2 = new TestOutline("Part 2");
        // part 1
        TestOutline discountPolicy = new TestOutline(C.UNDERLINE + "DiscountPolicy" + C.RESET);
        TestOutline bulkDiscount = new TestOutline(C.UNDERLINE + "BulkDiscount" + C.RESET);
        TestOutline buyNItemsGetOneFree = new TestOutline(C.UNDERLINE + "BuyNItemsGetOneFree" + C.RESET);
        TestOutline combinedDiscount = new TestOutline(C.UNDERLINE + "CombinedDiscount" + C.RESET);
        TestOutline couponDiscount = new TestOutline(C.UNDERLINE + "CouponDiscount" + C.RESET);
        // part 2
        TestOutline incrementable = new TestOutline(C.UNDERLINE + "Incrementable" + C.RESET);
        TestOutline sequentialIncrementer = new TestOutline(C.UNDERLINE + "SequentialIncrementer" + C.RESET);
        TestOutline randomIncrementer = new TestOutline(C.UNDERLINE + "RandomIncrementer" + C.RESET);

        root.add(part1);
        root.add(part2);
        part1.add(discountPolicy);
        part1.add(bulkDiscount);
        part1.add(buyNItemsGetOneFree);
        part1.add(combinedDiscount);
        part1.add(couponDiscount);
        part2.add(incrementable);
        part2.add(sequentialIncrementer);
        part2.add(randomIncrementer);

        // tests

        // bulk discount
        TestsBulkDiscount.Structure bdStruct = new TestsBulkDiscount.Structure();
        bdStruct.setName("Structure");
        bulkDiscount.add(bdStruct);
        TestsBulkDiscount.Constructor bdConst = new TestsBulkDiscount.Constructor();
        bdConst.setName("Constructor");
        bulkDiscount.add(bdConst);
        TestsBulkDiscount.InstanceVariables bdInst = new TestsBulkDiscount.InstanceVariables();
        bdInst.setName("Instance Variables");
        bulkDiscount.add(bdInst);
        TestsBulkDiscount.ComputeDiscount bdCompDis = new TestsBulkDiscount.ComputeDiscount();
        bdCompDis.setName("ComputeDiscount()");
        bulkDiscount.add(bdCompDis);
        
        // discount policy
        TestsDiscountPolicy.Constructor dpConst = new TestsDiscountPolicy.Constructor();
        dpConst.setName("Constructor");
        discountPolicy.add(dpConst);

        TestsDiscountPolicy.ComputeDiscount dpCompute = new TestsDiscountPolicy.ComputeDiscount();
        dpCompute.setName("ComputeDiscount");
        discountPolicy.add(dpCompute);

        root.run();
        System.out.println("Extra: ");
        // Scanner in = new Scanner(System.in);
        // String comments = in.nextLine(); 
        // if(!comments.equals("-"))
        //     root.addPoints(in.nextInt());
        // // in.nextLine();
        // System.out.println("Final Score: " + root.getPointsEarned() + "/" + root.getTotalPoints());
        // double percent = Math.ceil(((double)root.getPointsEarned())/root.getTotalPoints() * 100);
        // System.out.println(C.BLUE + (int)percent + "%");
        // System.out.println();
    }

}