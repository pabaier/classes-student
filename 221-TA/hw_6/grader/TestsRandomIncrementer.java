import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Field;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

import edu.cofc.grader.*;

public class TestsRandomIncrementer {
    public static class Structure extends SingleTest{
        public void exec() {
            int full = 2;
            int half = 1;
            setTotalPoints(full);

            System.out.print(indent() + "Implements Incrementable? - ");
            if(RandomIncrementer.class.getInterfaces()[0].equals(Incrementable.class)){
                System.out.println(C.CORRECT + "yes! - " + full + "/" + full + C.RESET);
                addPoints(full);
            }
            else{
                System.out.println(C.PARTCORRECT + "no - " + half + "/" + full + C.RESET);
                addPoints(half);
            }
        }

    }

    public static class InstanceVariables extends SingleTest{
        public void exec() {
            int full = 3;
            int half = 2;
            setTotalPoints(full);

            System.out.print(indent() + "int instance variable? - ");
            Field field = getFieldOfType(RandomIncrementer.class, int.class);
            if(field.getType().equals(int.class)) {
                addPoints(full);
                System.out.println(C.CORRECT + "yes! - " + full + "/" + full + C.RESET);
                }
            else {
                addPoints(half);
                System.out.println(C.PARTCORRECT + "no int fields found - " + (half) + "/" + full + C.RESET);
                
            }
        }
    }

    public static class Increment extends SingleTest{
        public void exec() {
            int full = 3;
            int half = 2;
            setTotalPoints(full *2);
            RandomIncrementer inc;

            try {
                inc = new RandomIncrementer();
            }
            catch(Throwable t) {
                System.out.println(indent() + "Could not initialize RandomIncrementer");
                return;
            }
            
            int args;
            Field field;
            try {
                field = getFieldOfType(RandomIncrementer.class, int.class);
                field.setAccessible(true);
                args = field.getInt(inc);
            }
            catch(Throwable t) {
                System.out.println(indent() + "Could not get instance variable");
                return;
            }

            Integer[] results = new Integer[5];
            System.out.println(indent() + "Starts at a random number");
            String titleFormat = indent(2) + "| %-11s | %-11s | %-11s | %-11s | %-11s |%n";
            String dataFormat = indent(2) + "| %-11d | %-11d | %-11d | %-11d | %-11d |%n";
            System.out.format(titleFormat, "Start1", "Start2", "Start3", "Start4", "Start5");
            for(int i = 0; i < results.length; i++) {
                inc = new RandomIncrementer();
                try {
                    results[i] = field.getInt(inc);
                }
                catch(Throwable t) {}
            }
            System.out.format(dataFormat, results[0], results[1], results[2], results[3], results[4]);
            Set<Integer> set = new HashSet<>(Arrays.asList(results));
            if(set.size() > 1) {
                addPoints(full);
                System.out.println(indent() + C.CORRECT + "yes! - " + full + "/" + full + C.RESET);
            }
            else {
                addPoints(half);
                System.out.println(indent() + C.PARTCORRECT + "not random" + args + " - " + half + "/" + full + C.RESET);
            }

            System.out.println();
            results = new Integer[5];
            System.out.println(indent() + "Increments randomly");
            System.out.format(titleFormat, "increment1", "increment2", "increment3", "increment4", "increment5");
            try {
                inc.increment();
            }
            catch (Throwable t) {
                System.out.println(indent(2) + C.PARTCORRECT + "could not run increment()" + C.RESET);
                return;
            }
            for(int i = 0; i < results.length; i++) {
                inc.increment();
                try {
                    results[i] = field.getInt(inc);
                }
                catch(Throwable t) {}
            }
            System.out.format(dataFormat, results[0], results[1], results[2], results[3], results[4]);
            set = new HashSet<>(Arrays.asList(results));
            if(set.size() > 1) {
                addPoints(full);
                System.out.println(indent() + C.CORRECT + "yes! - " + full + "/" + full + C.RESET);
            }
            else {
                addPoints(half);
                System.out.println(indent() + C.PARTCORRECT + "not random" + args + " - " + half + "/" + full + C.RESET);
            }






            //*************************************** */
            //*************************************** */

            // for(int i = 0; i < results.length; i++) {
            //     inc.increment();
            //     try {
            //         results[i] = field.getInt(inc);
            //     }
            //     catch(Throwable t) {}
            // }

            // System.out.println(indent() + "Increments by ones");
            // try {
            //     inc.increment();
            // }
            // catch(Throwable t) {
            //     addPoints(half);
            //     System.out.println(C.PARTCORRECT + "could not run increment() - " + half + "/" + full + C.RESET);
            //     return;
            // }

            // String titleFormat = indent(2) + "| %-9s | %-9s | %-6s |%n";
            // String dataFormat = indent(2) + "| %-9d | %-9d | %-15s |%n";
            // System.out.format(titleFormat,"iteration", "expected", "actual");
            // String resultColor = C.CORRECT;
            // try {
            //     args = field.getInt(inc);
            // }
            // catch(Exception e){}
            // int argsStart = args;
            // for(int i = argsStart; i < argsStart + 4; i++) {
            //     if(args == i) {
            //        addPoints(1);
            //        resultColor = C.CORRECT;
            //     }
            //     else {
            //         resultColor = C.PARTCORRECT;
            //     }
            //     System.out.format(dataFormat, i, i, resultColor + String.format("%d", args) + C.RESET);
            //     inc.increment();
            //     try{
            //         args = field.getInt(inc);                
            //     }
            //     catch(Exception e){}
            // }




        }
    }

    public static class GetValue extends SingleTest{
        public void exec() {
            int full = 3;
            int half = 2;
            setTotalPoints(full);
            
            System.out.print(indent() + "returns the value of the instance variable - ");
            RandomIncrementer inc;
            
            try {
                inc = new RandomIncrementer();
            }
            catch(Throwable t) {
                System.out.println("Could not initialize RandomIncrementer");
                addPoints(half - 1);
                return;
            }
            
            Field field;
            int args;
            try {
                field = getFieldOfType(RandomIncrementer.class, int.class);
                field.setAccessible(true);
                args = field.getInt(inc);
            }
            catch(Throwable t) {
                System.out.println("Could not get instance variable");
                addPoints(half - 1);
                return;
            }
            
            int returnedValue;
            try{
                returnedValue = inc.getValue();
            }
            catch(Throwable t) {
                System.out.println("Could not run getValue()");
                addPoints(half - 1);
                return;    
            }
            
            if(returnedValue == args) {
                addPoints(full);
                System.out.println(C.CORRECT + "yes! - " + full + "/" + full + C.RESET);
            }
            else {
                addPoints(half);
                System.out.println(C.PARTCORRECT + "no - expected: " + args + " - returned: " + returnedValue + " - " + half + "/" + full + C.RESET);
            }
            
        }
        
    }

    /**
     * Finds and returns a field of the desired type in the given class.
     * Returns null if not found
     * @param given the class to search
     * @param desired the target class being searched for
     * @return the field of the desired type
     */
    public static Field getFieldOfType(Class given, Class desired) {
        Field[] allFields = given.getDeclaredFields();
        for(Field f : allFields) {
            if(f.getType().equals(desired))
                return f;
        }
        return null;
    }
    
}