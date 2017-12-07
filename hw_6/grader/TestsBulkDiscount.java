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
            try {
                BulkDiscount b = new BulkDiscount(1,2);
                addPoints(full);
                System.out.println(C.CORRECT + "yes! - " + full + "/" + full + C.RESET);
            }
            catch(Throwable t) {
                try {
                    BulkDiscount b = new BulkDiscount();
                    addPoints(half);
                    System.out.println(C.PARTCORRECT + "yes but no parameters - " + half + "/" + full + C.RESET);
                }
                catch(Throwable u) {
                    try {
                        BulkDiscount b = new BulkDiscount(1);
                        addPoints(half);
                        System.out.println(C.PARTCORRECT + "yes but only one parameter - " + half + "/" + full + C.RESET);
                    }
                    catch(Throwable v) {
                        addPoints(half-1);
                        System.out.println(C.INCORRECT + "no - " + (half-1) + "/" + full + C.RESET);
                    }
                }
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