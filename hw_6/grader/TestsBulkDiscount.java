import java.lang.reflect.Field;

import edu.cofc.grader.*;

public class TestsBulkDiscount {
    public static class Structure extends SingleTest{
        public void exec() {
            int full = 2;
            int half = 1;
            setTotalPoints(full);
            
            System.out.print(indent() + "Extends DiscountPolicy? - ");
            Class bdSuper = BulkDiscount.class.getSuperclass();
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

            System.out.print(indent() + "Creates BulkDiscount? - ");

            Class[] params = BulkDiscount.class.getConstructors()[0].getParameterTypes();
            if (params.length == 2) {
                if(params[0].equals(int.class) && params[1].equals(int.class)) {
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

            System.out.print(indent() + "int \"minimum\" instance variable? - ");
            try {
                Field min = BulkDiscount.class.getDeclaredField("minimum");
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
                addPoints(half - 1);
                System.out.println(C.PARTCORRECT + "does not exist - " + (half - 1) + "/" + full + C.RESET);
            }

            System.out.print(indent() + "int \"percent\" instance variable? - ");
            try {
                Field percent = BulkDiscount.class.getDeclaredField("percent");
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
                addPoints(half - 1);
                System.out.println(C.PARTCORRECT + "does not exist - " + (half - 1) + "/" + full + C.RESET);
            }
        }
    }

    public static class ComputeDiscount extends SingleTest{
        public void exec() {
            int full = 3;
            int half = 2;
            setTotalPoints(full * 3);
            BulkDiscount b;
            int minimum = 3;
            int percent = 10;
            int quantity = 2;
            double itemCost = 25;
            double receivedOutput;

            String titleFormat = indent() + "| %-7s | %-7s | %-8s | %-8s | %-15s | %-15s |%n";
            String dataFormat = indent() + "| %-7d | %-7d | %-8d | %-8.2f | %-15.2f | %-24s |%n";

            try{
                b = new BulkDiscount(minimum, percent);
            }
            catch(Throwable t) {
                System.out.println(indent() + C.INCORRECT + "Could not initialize BulkDiscount object" + C.RESET);
                addPoints(getTotalPoints() / 2);
                return;
            }
            
            double expectedOutput = 0;
            try{
                receivedOutput = b.computeDiscount(quantity, itemCost);
            }
            catch(Throwable t) {
                System.out.println(indent() + C.INCORRECT + "Could not run computeDiscount() method" + C.RESET);
                addPoints(getTotalPoints() / 2);
                return;    
            }
            String resultColor = C.CORRECT;

            // test 1
            if (receivedOutput == expectedOutput) {
                resultColor = C.CORRECT;
                addPoints(full);
            }
            else {
                resultColor = C.PARTCORRECT;
                addPoints(half);
            }
            System.out.format(titleFormat,"minimum", "percent", "quantity", "itemCost", "expected output", "received output");
            System.out.format(dataFormat, minimum, percent, quantity, itemCost, expectedOutput, resultColor + String.format("%.2f", receivedOutput) + C.RESET);
            
            // test 2
            quantity++;
            expectedOutput = 0;
            receivedOutput = b.computeDiscount(quantity, itemCost);
            if (receivedOutput == expectedOutput) {
                resultColor = C.CORRECT;
                addPoints(full);
            }
            else {
                resultColor = C.PARTCORRECT;
                addPoints(half);
            }
            System.out.format(dataFormat, minimum, percent, quantity, itemCost, expectedOutput, resultColor + String.format("%.2f", receivedOutput) + C.RESET);
            
            // test 3
            quantity++;
            expectedOutput = 2.5;
            receivedOutput = b.computeDiscount(quantity, itemCost);
            if (receivedOutput == expectedOutput) {
                resultColor = C.CORRECT;
                addPoints(full);
            }
            else {
                resultColor = C.PARTCORRECT;
                addPoints(half);
            }
            System.out.format(dataFormat, minimum, percent, quantity, itemCost, expectedOutput, resultColor + String.format("%.2f", receivedOutput) + C.RESET);


            // try
            // if (params.length == 2) {
            //     if(params[0].equals(int.class) && params[1].equals(int.class)) {
            //         System.out.println(C.CORRECT + "yes! - " + full + "/" + full + C.RESET);
            //         addPoints(full);
            //     }
            //     else {
            //         System.out.println(C.PARTCORRECT + "no - incorrect parameter types - " + (half) + "/" + full + C.RESET);
            //         addPoints(half);
            //     }
            // }
            // else {
            //     System.out.println(C.INCORRECT + "no - need 2 parameters in constructor - " + (half-1) + "/" + full + C.RESET);
            //     addPoints(half - 1);
            // }
        }
    }

}