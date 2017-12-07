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

    





    public static Field getFieldNamed(String name, Object type) {
        Class c = type.getClass();
        try {
            Field field = c.getDeclaredField("minimum");
            field.setAccessible(true);
            return field;
        }
        catch(NoSuchFieldException e) {
            return null;
        }
    }

    // Field f = getFieldNamed("minimum", b);
    // try{
    //     System.out.println(f.get(b));
    // }catch(Exception e){}

}