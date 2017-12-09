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
        TestsDriver td1 = new TestsDriver();
        td1.setName(C.UNDERLINE + "HW6Part1" + C.RESET);
        
        // part 2
        TestOutline incrementable = new TestOutline(C.UNDERLINE + "Incrementable" + C.RESET);
        TestOutline sequentialIncrementer = new TestOutline(C.UNDERLINE + "SequentialIncrementer" + C.RESET);
        TestOutline randomIncrementer = new TestOutline(C.UNDERLINE + "RandomIncrementer" + C.RESET);
        TestsDriver td2 = new TestsDriver();
        TestsUML tUML = new TestsUML();
        td2.setName(C.UNDERLINE + "HW6Part2" + C.RESET);
        tUML.setName(C.UNDERLINE + "UML Diagram" + C.RESET);

        root.add(part1);
        root.add(part2);
        part1.add(discountPolicy);
        part1.add(bulkDiscount);
        part1.add(buyNItemsGetOneFree);
        part1.add(combinedDiscount);
        part1.add(couponDiscount);
        part1.add(td1);
        part2.add(incrementable);
        part2.add(sequentialIncrementer);
        part2.add(randomIncrementer);
        part2.add(td2);
        part2.add(tUML);


        // Part 2 test
        
        // random incrementer
        TestsRandomIncrementer.Structure randStruct = new TestsRandomIncrementer.Structure();
        randStruct.setName("Structure");
        randomIncrementer.add(randStruct);

        TestsRandomIncrementer.InstanceVariables randInst = new TestsRandomIncrementer.InstanceVariables();
        randInst.setName("Instance Variables");
        randomIncrementer.add(randInst);

        TestsRandomIncrementer.Increment randInc = new TestsRandomIncrementer.Increment();
        randInc.setName("Increment()");
        randomIncrementer.add(randInc);

        TestsRandomIncrementer.GetValue randGetValue = new TestsRandomIncrementer.GetValue();
        randGetValue.setName("GetValue()");
        randomIncrementer.add(randGetValue);

        // sequential incrementer
        TestsSequentialIncrementer.Structure secStruct = new TestsSequentialIncrementer.Structure();
        secStruct.setName("Structure");
        sequentialIncrementer.add(secStruct);
        TestsSequentialIncrementer.InstanceVariables secInst = new TestsSequentialIncrementer.InstanceVariables();
        secInst.setName("Instance Variables");
        sequentialIncrementer.add(secInst);
        TestsSequentialIncrementer.Increment secInc = new TestsSequentialIncrementer.Increment();
        secInc.setName("Increment()");
        sequentialIncrementer.add(secInc);
        TestsSequentialIncrementer.GetValue secGetValue = new TestsSequentialIncrementer.GetValue();
        secGetValue.setName("GetValue()");
        sequentialIncrementer.add(secGetValue);

        // incrementable
        TestsIncrementable.Structure incStruct = new TestsIncrementable.Structure();
        incStruct.setName("Structure");
        incrementable.add(incStruct);
        TestsIncrementable.Increment incInc = new TestsIncrementable.Increment();
        incInc.setName("Increment()");
        incrementable.add(incInc);
        TestsIncrementable.GetValue incGetValue = new TestsIncrementable.GetValue();
        incGetValue.setName("GetValue()");
        incrementable.add(incGetValue);


        // Part 1 tests

        // coupon discount
        TestsCouponDiscount.Structure cpdStruct = new TestsCouponDiscount.Structure();
        cpdStruct.setName("Structure");
        couponDiscount.add(cpdStruct);
        TestsCouponDiscount.Constructor cpdConst = new TestsCouponDiscount.Constructor();
        cpdConst.setName("Constructor");
        couponDiscount.add(cpdConst);
        TestsCouponDiscount.InstanceVariables cpdInst = new TestsCouponDiscount.InstanceVariables();
        cpdInst.setName("Instance Variables");
        couponDiscount.add(cpdInst);
        TestsCouponDiscount.ComputeDiscount cpdCompDis = new TestsCouponDiscount.ComputeDiscount();
        cpdCompDis.setName("ComputeDiscount()");
        couponDiscount.add(cpdCompDis);

        // combined discount
        TestsCombinedDiscount.Structure cdStruct = new TestsCombinedDiscount.Structure();
        cdStruct.setName("Structure");
        combinedDiscount.add(cdStruct);
        TestsCombinedDiscount.Constructor cdConst = new TestsCombinedDiscount.Constructor();
        cdConst.setName("Constructor");
        combinedDiscount.add(cdConst);
        TestsCombinedDiscount.InstanceVariables cdInst = new TestsCombinedDiscount.InstanceVariables();
        cdInst.setName("Instance Variables");
        combinedDiscount.add(cdInst);
        TestsCombinedDiscount.ComputeDiscount cdCompDis = new TestsCombinedDiscount.ComputeDiscount();
        cdCompDis.setName("ComputeDiscount()");
        combinedDiscount.add(cdCompDis);

        // buy n items
        TestsBuyNItemsGetOneFree.Structure bnStruct = new TestsBuyNItemsGetOneFree.Structure();
        bnStruct.setName("Structure");
        buyNItemsGetOneFree.add(bnStruct);
        TestsBuyNItemsGetOneFree.Constructor bnConst = new TestsBuyNItemsGetOneFree.Constructor();
        bnConst.setName("Constructor");
        buyNItemsGetOneFree.add(bnConst);
        TestsBuyNItemsGetOneFree.InstanceVariables bnInst = new TestsBuyNItemsGetOneFree.InstanceVariables();
        bnInst.setName("Instance Variables");
        buyNItemsGetOneFree.add(bnInst);
        TestsBuyNItemsGetOneFree.ComputeDiscount bnCompDis = new TestsBuyNItemsGetOneFree.ComputeDiscount();
        bnCompDis.setName("ComputeDiscount()");
        buyNItemsGetOneFree.add(bnCompDis);

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
        Scanner in = new Scanner(System.in);
        String comments = in.nextLine(); 
        if(!comments.equals("-"))
            root.addPoints(in.nextInt());
        System.out.println("Final Score: " + root.getPointsEarned() + "/" + root.getTotalPoints());
        double percent = Math.ceil(((double)root.getPointsEarned())/root.getTotalPoints() * 100);
        System.out.println(C.BLUE + (int)percent + "%");
        System.out.println();
    }

}