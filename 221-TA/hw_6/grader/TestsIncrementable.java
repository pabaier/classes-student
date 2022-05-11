import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import edu.cofc.grader.*;

public class TestsIncrementable {
    public static class Structure extends SingleTest{
        public void exec() {
            int full = 2;
            int half = 1;
            setTotalPoints(full);

            System.out.print(indent() + "Interface? - ");
            if(Incrementable.class.isInterface()){
                System.out.println(C.CORRECT + "yes! - " + full + "/" + full + C.RESET);
                addPoints(full);
            }
            else{
                System.out.println(C.PARTCORRECT + "no - " + half + "/" + full + C.RESET);
                addPoints(half);
            }
        }

    }

    public static class Increment extends SingleTest{
        public void exec() {
            int full = 3;
            int half = 2;
            setTotalPoints(full);

            System.out.print(indent() + "exists and returns void? - ");
            try {
                Method m = Incrementable.class.getDeclaredMethod("increment");
                if(m.getReturnType().equals(Void.TYPE)) {
                    addPoints(full);
                    System.out.println(C.CORRECT + "yes! - " + full + "/" + full + C.RESET);
                }
                else {
                    addPoints(half);
                    System.out.println(C.PARTCORRECT + "exists but does not return void - " + half + "/" + full + C.RESET);
                }
            }
            catch (NoSuchMethodException e) {
                addPoints(half-1);
                System.out.println(C.PARTCORRECT + "no increment method - " + (half - 1) + "/" + full + C.RESET);
            }

        }

    }

    public static class GetValue extends SingleTest{
        public void exec() {
            int full = 3;
            int half = 2;
            setTotalPoints(full);

            System.out.print(indent() + "exists and returns int? - ");
            try {
                Method m = Incrementable.class.getDeclaredMethod("getValue");
                if(m.getReturnType().equals(int.class)) {
                    addPoints(full);
                    System.out.println(C.CORRECT + "yes! - " + full + "/" + full + C.RESET);
                }
                else {
                    addPoints(half);
                    System.out.println(C.PARTCORRECT + "exists but does not return int - " + half + "/" + full + C.RESET);
                }

            }
            catch (NoSuchMethodException e) {
                addPoints(half-1);
                System.out.println(C.PARTCORRECT + "no getValue method - " + (half - 1) + "/" + full + C.RESET);
            }

        }

    }

}