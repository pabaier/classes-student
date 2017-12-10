import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import edu.cofc.grader.*;

public class TestsDiscountPolicy {
    public static class Constructor extends SingleTest{
        public void exec() {
            int full = 2;
            int half = 1;
            setTotalPoints(full);

            System.out.print(indent() + "Abstract? - ");
            if(DiscountPolicy.class.getModifiers() == Modifier.ABSTRACT + Modifier.PUBLIC){
                System.out.println(C.CORRECT + "yes! - " + full + "/" + full + C.RESET);
                addPoints(full);
            }
            else{
                System.out.println(C.PARTCORRECT + "no - " + half + "/" + full + C.RESET);
                addPoints(half);
            }
        }

    }

    public static class ComputeDiscount extends SingleTest{
        public void exec() {
            int full = 3;
            int half = 2;
            setTotalPoints(full);

            System.out.print(indent() + "Abstract ComputeDiscount? - ");
            Class[] params = {int.class, double.class};
            try {
                Method m = DiscountPolicy.class.getDeclaredMethod("computeDiscount", params);
                if(m.getModifiers() == Modifier.ABSTRACT + Modifier.PUBLIC || m.getModifiers() == Modifier.ABSTRACT) {
                    addPoints(full);
                    System.out.println(C.CORRECT + "yes! - " + full + "/" + full + C.RESET);
                }
                else {
                    addPoints(half);
                    System.out.println(C.PARTCORRECT + "no - " + half + "/" + full + C.RESET);
                }
            }
            catch (NoSuchMethodException e) {
                System.out.println(e);
                addPoints(half-1);
                System.out.println(C.PARTCORRECT + "no computeDiscount method - " + (half - 1) + "/" + full + C.RESET);
            }

        }

    }

}