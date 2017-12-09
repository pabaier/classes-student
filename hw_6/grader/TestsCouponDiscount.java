import java.lang.reflect.Field;

import edu.cofc.grader.*;

public class TestsCouponDiscount {
    public static class Structure extends SingleTest{
        public void exec() {
            int full = 2;
            int half = 1;
            setTotalPoints(full);
            
            System.out.print(indent() + "Extends DiscountPolicy? - ");
            Class bdSuper = CouponDiscount.class.getSuperclass();
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

            System.out.print(indent() + "Creates CouponDiscount? - ");

            Class[] params = CouponDiscount.class.getConstructors()[0].getParameterTypes();
            if (params.length == 2) {
                if(params[0].equals(double.class) && params[1].equals(int.class)) {
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

            System.out.print(indent() + "double \"couponValue\" instance variable? - ");
            try {
                Field min = CouponDiscount.class.getDeclaredField("couponValue");
                if(min.getType().equals(double.class)) {
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
                    Field[] allMin = CouponDiscount.class.getDeclaredFields();
                    if(allMin[0].getType().equals(double.class)) {
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

            System.out.print(indent() + "int \"maxUses\" instance variable? - ");
            try {
                Field percent = CouponDiscount.class.getDeclaredField("maxUses");
                if(percent.getType().equals(int.class)) {
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
                    Field[] allPercent = CouponDiscount.class.getDeclaredFields();
                    if(allPercent[1].getType().equals(int.class)) {
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
            CouponDiscount b;
            double[] couponValue = {1.25, 0.25};
            int[] maxUses = {3, 5};
            int[] quantity = {8, 2};
            double itemCost = 13.75;
            double[] expectedOutput = {3.75, 0.5};
            double receivedOutput;
            int i = 0;

            String titleFormat = indent() + "| %-11s | %-7s | %-8s | %-8s | %-8s | %-8s |%n";
            String dataFormat = indent() + "| %-11.2f | %-7d | %-8d | %-8.2f | %-8.2f | %-17s |%n";

            try{
                b = new CouponDiscount(couponValue[0], maxUses[0]);
            }
            catch(Throwable t) {
                System.out.println(indent() + C.INCORRECT + "Could not initialize CouponDiscount object" + C.RESET);
                addPoints(getTotalPoints() / 2);
                return;
            }
            
            try{
                receivedOutput = b.computeDiscount(quantity[0], itemCost);
            }
            catch(Throwable t) {
                System.out.println(indent() + C.INCORRECT + "Could not run computeDiscount() method" + C.RESET);
                addPoints(getTotalPoints() / 2);
                return;    
            }
            String resultColor = C.CORRECT;
            System.out.format(titleFormat,"couponValue", "maxUses", "quantity", "itemCost", "expected", "returned");
            
            do {
                b = new CouponDiscount(couponValue[i], maxUses[i]);
                receivedOutput = b.computeDiscount(quantity[i], itemCost);
                if (receivedOutput == expectedOutput[i]) {
                    resultColor = C.CORRECT;
                    addPoints(full);
                }
                else {
                    resultColor = C.PARTCORRECT;
                    addPoints(half);
                }
                System.out.format(dataFormat, couponValue[i], maxUses[i], quantity[i], itemCost, expectedOutput[i], resultColor + String.format("%.2f", receivedOutput) + C.RESET);
                i++;
            }while(i < couponValue.length);
        }
    }

}