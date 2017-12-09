import java.lang.reflect.Field;

import edu.cofc.grader.*;

public class TestsCombinedDiscount {
    public static class Structure extends SingleTest{
        public void exec() {
            int full = 2;
            int half = 1;
            setTotalPoints(full);
            
            System.out.print(indent() + "Extends DiscountPolicy? - ");
            Class bdSuper = CombinedDiscount.class.getSuperclass();
            if(bdSuper.equals(DiscountPolicy.class)){
                System.out.println(C.CORRECT + "yes! - " + full + "/" + full + C.RESET);
                addPoints(full);
            }
            else{
                System.out.println(C.PARTCORRECT + "no - " + half + "/" + full + C.RESET);
                addPoints(half);
            }
        }

    }

    public static class Constructor extends SingleTest{
        public void exec() {
            int full = 3;
            int half = 2;
            setTotalPoints(full);

            System.out.print(indent() + "Creates CombinedDiscount? - ");

            Class[] params = CombinedDiscount.class.getConstructors()[0].getParameterTypes();
            if (params.length == 2) {
                if(params[0].equals(DiscountPolicy.class) && params[1].equals(DiscountPolicy.class)) {
                    System.out.println(C.CORRECT + "yes! - " + full + "/" + full + C.RESET);
                    addPoints(full);
                }
                else {
                    System.out.println(C.PARTCORRECT + "no - incorrect parameter types - " + (half) + "/" + full + C.RESET);
                    addPoints(half);
                }
            }
            else {
                System.out.println(C.INCORRECT + "no - need 2 parameters in constructor - " + (half-1) + "/" + full + C.RESET);
                addPoints(half - 1);
            }
        }
    }

    public static class InstanceVariables extends SingleTest{
        public void exec() {
            int full = 3;
            int half = 2;
            setTotalPoints(full * 2);

            System.out.print(indent() + "DiscountPolicy \"dis1\" instance variable? - ");
            try {
                Field min = CombinedDiscount.class.getDeclaredField("dis1");
                if(min.getType().equals(DiscountPolicy.class)) {
                    addPoints(full);
                    System.out.println(C.CORRECT + "yes! - " + full + "/" + full + C.RESET);
                }
                else {
                    addPoints(half);
                    System.out.println(C.PARTCORRECT + "yes but wrong type - " + (half) + "/" + full + C.RESET);

                }
            }
            catch (NoSuchFieldException e) {
                try {
                    Field[] allMin = CombinedDiscount.class.getDeclaredFields();
                    if(allMin[0].getType().equals(DiscountPolicy.class)) {
                        addPoints(full - 1);
                        System.out.println(C.PARTCORRECT + "see class diagram for variable name - " + (full - 1) + "/" + full + C.RESET);
                    }
                    else {
                        addPoints(half - 1);
                        System.out.println(C.PARTCORRECT + "wrong name and type - " + (half - 1) + "/" + full + C.RESET);
                    }
                }
                catch (Throwable f) {
                    addPoints(half - 1);
                    System.out.println(C.PARTCORRECT + "does not exist - " + (half - 1) + "/" + full + C.RESET);
                }
            }

            System.out.print(indent() + "DiscountPolicy \"dis2\" instance variable? - ");
            try {
                Field percent = CombinedDiscount.class.getDeclaredField("dis2");
                if(percent.getType().equals(DiscountPolicy.class)) {
                    addPoints(full);
                    System.out.println(C.CORRECT + "yes! - " + full + "/" + full + C.RESET);
                }
                else {
                    addPoints(half);
                    System.out.println(C.PARTCORRECT + "yes but wrong type - " + (half) + "/" + full + C.RESET);

                }
            }
            catch (NoSuchFieldException e) {
                try {
                    Field[] allPercent = CombinedDiscount.class.getDeclaredFields();
                    if(allPercent[1].getType().equals(DiscountPolicy.class)) {
                        addPoints(full - 1);
                        System.out.println(C.PARTCORRECT + "see class diagram for variable name - " + (full - 1) + "/" + full + C.RESET);
                    }
                    else {
                        addPoints(half - 1);
                        System.out.println(C.PARTCORRECT + "wrong name and type - " + (half - 1) + "/" + full + C.RESET);
                    }
                }
                catch (Throwable f) {
                    addPoints(half - 1);
                    System.out.println(C.PARTCORRECT + "does not exist - " + (half - 1) + "/" + full + C.RESET);
                }
            }
        }
    }

    public static class ComputeDiscount extends SingleTest{
        public void exec() {
            int full = 3;
            int half = 2;
            setTotalPoints(full * 2);
            CombinedDiscount b;
            int quantity = 32;
            double itemCost = 23.5;
            
            double receivedOutput;
            double[] expectedOutputs = new double[2];
            int i = 0;
            String[] dis1Details = new String[2];
            String[] dis2Details = new String[2];

            DiscountPolicy[] dis1policies = new DiscountPolicy[2];
            DiscountPolicy[] dis2policies = new DiscountPolicy[2];

            // setting biggest values
            try {
                dis1policies[0] = new BulkDiscount(30, 10);
                dis2policies[1] = new BulkDiscount(30, 10);
                dis1Details[0] = "BulkDiscount(30,10)";
                dis2Details[1] = "BulkDiscount(30,10)";
                expectedOutputs[0] = 75.2;
                expectedOutputs[1] = 75.2;
            }
            catch(Throwable t) {
                try {
                    dis1policies[0] = new BuyNItemsGetOneFree(5);
                    dis2policies[1] = new BuyNItemsGetOneFree(5);
                    dis1Details[0] = "BuyNItemsGetOneFree(5)";
                    dis2Details[1] = "BuyNItemsGetOneFree(5)";
                    expectedOutputs[0] = 141;
                    expectedOutputs[1] = 141;
                }
                catch(Throwable u) {
                    try {
                        dis1policies[0] = new CouponDiscount(9, 8);
                        dis2policies[1] = new CouponDiscount(9, 8);
                        dis1Details[0] = "CouponDiscount(9,8)";
                        dis2Details[1] = "CouponDiscount(9,8)";
                        expectedOutputs[0] = 72;
                        expectedOutputs[1] = 72;
                    }
                    catch(Throwable v) {
                        System.out.println(indent() + C.INCORRECT + "Could not initialize a DiscountPolicy");
                        return;
                    }
                }
            }
            
            // setting smallest values
            try {
                dis1policies[1] = new BuyNItemsGetOneFree(10);
                dis2policies[0] = new BuyNItemsGetOneFree(10);
                dis1Details[1] = "BuyNItemsGetOneFree(10)";
                dis2Details[0] = "BuyNItemsGetOneFree(10)";
            }
            catch(Throwable t) {
                try {
                    dis1policies[1] = new CouponDiscount(4, 3);
                    dis2policies[0] = new CouponDiscount(4, 3);
                    dis1Details[1] = "CouponDiscount(4,3)";
                    dis2Details[0] = "CouponDiscount(4,3)";
                }
                catch(Throwable u) {
                    try {
                        dis1policies[1] = new BulkDiscount(30, 5);
                        dis2policies[0] = new BulkDiscount(30, 5);
                        dis1Details[1] = "BulkDiscount(30,5)";
                        dis2Details[0] = "BulkDiscount(30,5)";
                    }
                    catch(Throwable v) {
                        System.out.println(indent() + C.INCORRECT + "Could not initialize a DiscountPolicy");
                        return;
                    }
                }
            }

            String titleFormat = indent() + "| %-23s | %-23s | %-8s | %-8s | %-8s | %-8s |%n";
            String dataFormat = indent() + "| %-23s | %-23s | %-8d | %-8.2f | %-8.2f | %-17s |%n";

            try{
                b = new CombinedDiscount(dis1policies[0], dis2policies[0]);
            }
            catch(Throwable t) {
                System.out.println(indent() + C.INCORRECT + "Could not initialize CombinedDiscount object" + C.RESET);
                addPoints(getTotalPoints() / 2);
                return;
            }
            
            try{
                receivedOutput = b.computeDiscount(quantity, itemCost);
            }
            catch(Throwable t) {
                System.out.println(indent() + C.INCORRECT + "Could not run computeDiscount() method" + C.RESET);
                addPoints(getTotalPoints() / 2);
                return;    
            }
            String resultColor = C.CORRECT;
            System.out.format(titleFormat,"dis1", "dis2", "quantity", "itemCost", "expected", "returned");
            do {
                b = new CombinedDiscount(dis1policies[i], dis2policies[i]);
                receivedOutput = b.computeDiscount(quantity, itemCost);
                
                if (receivedOutput == expectedOutputs[i]) {
                    resultColor = C.CORRECT;
                    addPoints(full);
                }
                else {
                    resultColor = C.PARTCORRECT;
                    addPoints(half);
                }
                System.out.format(dataFormat, dis1Details[i], dis2Details[i], quantity, itemCost, expectedOutputs[i], resultColor + String.format("%.2f", receivedOutput) + C.RESET);
                i++;
            } while(i < dis1policies.length);
        }
    }

}