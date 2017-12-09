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
            if(Incrementable.class.getModifiers() == Modifier.INTERFACE + Modifier.PUBLIC){
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

            System.out.print(indent() + "public and void return? - ");
            try {
                Method m = Incrementable.class.getMethod("increment");
                if(m.getModifiers() == Modifier.PUBLIC) {
                    if(m.getReturnType().equals(Void.TYPE)) {
                        addPoints(full);
                        System.out.println(C.CORRECT + "yes! - " + full + "/" + full + C.RESET);
                    }
                    else {
                        addPoints(half);
                        System.out.println(C.PARTCORRECT + "does not return void - " + half + "/" + full + C.RESET);
                    }
                }
                else {
                    if(m.getReturnType().equals(Void.TYPE)) {
                        addPoints(half);
                        System.out.println(C.PARTCORRECT + "void but not public - " + half + "/" + full + C.RESET);
                    }
                    else {
                        addPoints(half - 1);
                        System.out.println(C.PARTCORRECT + "neither public nor void - " + half + "/" + full + C.RESET);
                    }
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

            System.out.print(indent() + "public and int return? - ");
            try {
                Method m = Incrementable.class.getMethod("increment");
                if(m.getModifiers() == Modifier.PUBLIC) {
                    if(m.getReturnType().equals(int.class)) {
                        addPoints(full);
                        System.out.println(C.CORRECT + "yes! - " + full + "/" + full + C.RESET);
                    }
                    else {
                        addPoints(half);
                        System.out.println(C.PARTCORRECT + "does not return int - " + half + "/" + full + C.RESET);
                    }
                }
                else {
                    if(m.getReturnType().equals(int.class)) {
                        addPoints(half);
                        System.out.println(C.PARTCORRECT + "returns int but not public - " + half + "/" + full + C.RESET);
                    }
                    else {
                        addPoints(half - 1);
                        System.out.println(C.PARTCORRECT + "neither public nor int return - " + half + "/" + full + C.RESET);
                    }
                }
            }
            catch (NoSuchMethodException e) {
                addPoints(half-1);
                System.out.println(C.PARTCORRECT + "no getValue method - " + (half - 1) + "/" + full + C.RESET);
            }

        }

    }

}