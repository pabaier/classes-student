import java.lang.reflect.Field;

import edu.cofc.grader.*;

public class TestsBuyNItemsGetOneFree {
    public static class Structure extends SingleTest{
        public void exec() {
            int full = 2;
            int half = 1;
            setTotalPoints(full);
            
            System.out.print(indent() + "Extends DiscountPolicy? - ");
            Class bdSuper = BuyNItemsGetOneFree.class.getSuperclass();
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

            System.out.print(indent() + "Creates BuyNItemsGetOneFree? - ");

            Class[] params = BuyNItemsGetOneFree.class.getConstructors()[0].getParameterTypes();
            if (params.length == 1) {
                if(params[0].equals(int.class)) {
                    System.out.println(C.CORRECT + "yes! - " + full + "/" + full + C.RESET);
                    addPoints(full);
                }
                else {
                    System.out.println(C.PARTCORRECT + "no - incorrect parameter types - " + (half) + "/" + full + C.RESET);
                    addPoints(half);
                }
            }
            else {
                System.out.println(C.INCORRECT + "no - need 1 parameter in constructor - " + (half-1) + "/" + full + C.RESET);
                addPoints(half - 1);
            }
        }
    }

    public static class InstanceVariables extends SingleTest{
        public void exec() {
            int full = 3;
            int half = 2;
            setTotalPoints(full);

            System.out.print(indent() + "int \"n\" instance variable? - ");
            try {
                Field min = BuyNItemsGetOneFree.class.getDeclaredField("n");
                if(min.getType().equals(int.class)) {
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
                    Field[] min = BuyNItemsGetOneFree.class.getDeclaredFields();
                    if(min[0].getType().equals(int.class)) {
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
            setTotalPoints(full * 4);
            BuyNItemsGetOneFree b;
            int n = 7;
            int quantity = 17;
            double itemCost = 11;
            double receivedOutput;
            int[] quantityTests = {6,7,10,14};
            double[] expectedOutputs = {0,11,11,22};
            int i = 0;

            String titleFormat = indent() + "| %-3s | %-8s | %-8s | %-8s | %-8s |%n";
            String dataFormat = indent() + "| %-3d | %-8d | %-8.2f | %-8.2f | %-17s |%n";

            try{
                b = new BuyNItemsGetOneFree(n);
            }
            catch(Throwable t) {
                System.out.println(indent() + C.INCORRECT + "Could not initialize BuyNItemsGetOneFree object" + C.RESET);
                addPoints(getTotalPoints() / 2);
                return;
            }
            
            try{
                receivedOutput = b.computeDiscount(quantityTests[i], itemCost);
            }
            catch(Throwable t) {
                System.out.println(indent() + C.INCORRECT + "Could not run computeDiscount() method" + C.RESET);
                addPoints(getTotalPoints() / 2);
                return;    
            }
            String resultColor = C.CORRECT;
            System.out.format(titleFormat,"n", "quantity", "itemCost", "expected", "returned");
            do {
                receivedOutput = b.computeDiscount(quantityTests[i], itemCost);
                // test 1
                if (receivedOutput == expectedOutputs[i]) {
                    resultColor = C.CORRECT;
                    addPoints(full);
                }
                else {
                    resultColor = C.PARTCORRECT;
                    addPoints(half);
                }
                System.out.format(dataFormat, n, quantityTests[i], itemCost, expectedOutputs[i], resultColor + String.format("%.2f", receivedOutput) + C.RESET);
                i++;
            } while(i < quantityTests.length);
        }
    }

}