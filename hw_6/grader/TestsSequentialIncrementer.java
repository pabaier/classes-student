import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Field;

import edu.cofc.grader.*;

public class TestsSequentialIncrementer {
    public static class Structure extends SingleTest{
        public void exec() {
            int full = 2;
            int half = 1;
            setTotalPoints(full);

            System.out.print(indent() + "Implements Incrementable? - ");
            if(SequentialIncrementer.class.getInterfaces()[0].equals(Incrementable.class)){
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

            System.out.print(indent() + "single int instance variable? - ");
            Field[] fields = SequentialIncrementer.class.getDeclaredFields(); 
            if(fields.length == 0) {
                addPoints(half - 1);
                System.out.println(C.PARTCORRECT + "no fields exist - " + (half - 1) + "/" + full + C.RESET);
            }
            else {
                Field min = fields[0];
                if(min.getType().equals(int.class)) {
                addPoints(full);
                System.out.println(C.CORRECT + "yes! - " + full + "/" + full + C.RESET);
                }
                else {
                    addPoints(half);
                    System.out.println(C.PARTCORRECT + "not an int - " + (half) + "/" + full + C.RESET);
                    
                }
            }
        }
    }

    public static class Increment extends SingleTest{
        public void exec() {
            int full = 3;
            int half = 2;
            setTotalPoints(full + 4);
            SequentialIncrementer inc;

            try {
                inc = new SequentialIncrementer();
            }
            catch(Throwable t) {
                System.out.println(indent() + "Could not initialize SequentialIncrementer");
                return;
            }
            
            int args;
            Field field;
            try {
                field = SequentialIncrementer.class.getDeclaredFields()[0];
                field.setAccessible(true);
                args = field.getInt(inc);
            }
            catch(Throwable t) {
                System.out.println(indent() + "Could not get instance variable");
                return;
            }

            System.out.print(indent() + "Starts at 0 - ");
            if(args == 0) {
                addPoints(full);
                System.out.println(C.CORRECT + "yes! - " + full + "/" + full + C.RESET);
            }
            else {
                addPoints(half);
                System.out.println(C.PARTCORRECT + "no - variable starts at " + args + " - " + half + "/" + full + C.RESET);
            }
            
            System.out.println(indent() + "Increments by ones");
            try {
                inc.increment();
            }
            catch(Throwable t) {
                addPoints(half);
                System.out.println(C.PARTCORRECT + "could not run increment() - " + half + "/" + full + C.RESET);
                return;
            }

            String titleFormat = indent(2) + "| %-9s | %-9s | %-6s |%n";
            String dataFormat = indent(2) + "| %-9d | %-9d | %-15s |%n";
            System.out.format(titleFormat,"iteration", "expected", "actual");
            String resultColor = C.CORRECT;
            try {
                args = field.getInt(inc);
            }
            catch(Exception e){}
            int argsStart = args;
            for(int i = argsStart; i < argsStart + 4; i++) {
                if(args == i) {
                   addPoints(1);
                   resultColor = C.CORRECT;
                }
                else {
                    resultColor = C.PARTCORRECT;
                }
                System.out.format(dataFormat, i, i, resultColor + String.format("%d", args) + C.RESET);
                inc.increment();
                try{
                    args = field.getInt(inc);                
                }
                catch(Exception e){}
            }
        }
    }

    public static class GetValue extends SingleTest{
        public void exec() {
            int full = 3;
            int half = 2;
            setTotalPoints(full);
            
            System.out.print(indent() + "returns the value of the instance variable - ");
            SequentialIncrementer inc;
            
            try {
                inc = new SequentialIncrementer();
            }
            catch(Throwable t) {
                System.out.println("Could not initialize SequentialIncrementer");
                addPoints(half - 1);
                return;
            }
            
            Field field;
            int args;
            try {
                field = SequentialIncrementer.class.getDeclaredFields()[0];
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
    
}