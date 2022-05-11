import edu.cofc.grader.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class WalkUpTicketTests {

    // global values for reference
    private static String name = "Hoop-Dee-Doo Musical Revue";
    private static CalendarDate date = new CalendarDate(1971, 11, 19);
    private static final String testFilePath = "/mnt/sda5/School/221/hw_5/grader/WalkUpTicket.java";

    public static class Constructor extends SingleTest {
        public void exec() {
            setTotalPoints(6);
            int full = 3;
            int half = 2;
            WalkUpTicket t;

            System.out.print(indent() + "Constructor - ");
            try {
                t = new WalkUpTicket(name, date);
                addPoints(half);
                System.out.println(C.CORRECT + "Correct - " + half + "/" + half + C.RESET);
            }
            catch(Throwable e) {
                try {
                    t = new WalkUpTicket(date, name);
                    addPoints(half - 1);
                    System.out.println(C.PARTCORRECT + "Arguments Reversed - " + (half-1) + "/" + half + C.RESET);
                }
                catch(Throwable f) {
                    addPoints(0);
                    System.out.println(C.INCORRECT + "Could Not Construct WalkUpTicket - " + (0) + "/" + half + C.RESET);
                }
            }
            
            System.out.print(indent() + "Extends Ticket - ");
            String testFile = getFileText(testFilePath);
            if(isRegexInString("public class WalkUpTicket extends Ticket", testFile)) {
                addPoints(half);
                System.out.println(C.CORRECT + "Correct - " + half + "/" + half + C.RESET);
            }
            else {
                addPoints(half - 1);
                System.out.println(C.INCORRECT + "Does not extend Ticket" + (half - 1) + "/" + half + C.RESET);
            }

            System.out.print(indent() + "Call to super() - ");
            if(isRegexInString("super", testFile)) {
                addPoints(half);
                System.out.println(C.CORRECT + "Correct - " + half + "/" + half + C.RESET);
            }
            else {
                addPoints(half - 1);
                System.out.println(C.INCORRECT + "No Call to super() - " + (half - 1) + "/" + half + C.RESET);
            }
 
        }
    }

    public static class GetPrice extends SingleTest {
        public void exec() {
            setTotalPoints(3);
            int full = 3;
            int half = 2;
            
            System.out.print(indent() + "$50 - ");
            
            WalkUpTicket t = getWalkUpTicket();
            if (t == null) {
                System.out.println(C.INCORRECT + "Cannot create WalkUpTicket Objects" + C.RESET);
                return;
            }
            double result = 100;
            try {
                result = t.getPrice();
            }
            catch(Throwable e) {
            }
            if(result == 50) {
                addPoints(full);
                System.out.println(C.CORRECT + "Correct - " + full + "/" + full + C.RESET);                
            }
            else {
                addPoints(half);
                System.out.println(C.PARTCORRECT + "" + result + " - incorrect - " + half + "/" + full + C.RESET);
            }
        }
    }

    public static class ToString extends SingleTest {
        public void exec() {
            setTotalPoints(6);
            int full = 2;
            int half = 1;

            System.out.println(indent() + name + " - " + date + " - " + "$50");

            WalkUpTicket t = getWalkUpTicket();
            if (t == null) {
                System.out.println(C.INCORRECT + "Cannot create Ticket Objects" + C.RESET);
                return;
            }
            String result = "";
            try {
                result = t.toString();
            }
            catch(Throwable e) {
            }

            // boolean superString = result.contains(getTicket().toString());

            String testFile = getFileText(testFilePath);
            boolean superString = isRegexInString("super().toString", testFile);
            boolean price = result.contains("50");
            boolean walkup = result.toLowerCase().contains("walk-up") || 
                            result.toLowerCase().contains("walkup") ||
                            result.toLowerCase().contains("walk up");

            System.out.print(indent() + "Calls super().toString() - ");
            if(superString) {
                System.out.println(C.CORRECT + "Correct - " + full + "/" + full + C.RESET);                
                addPoints(full);
            }
            else {
                System.out.println(C.PARTCORRECT + "Missing - " + half + "/" + full + C.RESET);                
                addPoints(half);
            }
            System.out.print(indent() + "Price Included - ");
            if(price) {
                System.out.println(C.CORRECT + "Correct - " + full + "/" + full + C.RESET);                
                addPoints(full);
            }
            else {
                System.out.println(C.PARTCORRECT + "Missing - " + half + "/" + full + C.RESET);                
                addPoints(half);
            }
            System.out.print(indent() + "Walk-Up Ticket - ");
            if(walkup) {
                System.out.println(C.CORRECT + "Correct - " + full + "/" + full + C.RESET);                
                addPoints(full);
            }
            else {
                System.out.println(C.PARTCORRECT + "Missing - " + half + "/" + full + C.RESET);                
                addPoints(half);
            }
        }
    }

    // returns a new ticket object using different constructor options
    // returns null if constructor does not work
    public static Ticket getTicket() {
        try {
            return new Ticket(name, date);
        }
        catch(Throwable e) {
            try {
                return new Ticket(date, name); 
            }
            catch(Throwable f) {
                return null;
            }
        }
    }

    // returns a new walk up ticket using different constructor options
    // returns null if constructor does not work
    public static WalkUpTicket getWalkUpTicket() {
        try {
            return new WalkUpTicket(name, date);
        }
        catch(Throwable e) {
            try {
                return new WalkUpTicket(date, name); 
            }
            catch(Throwable f) {
                return null;
            }
        }
    }

    // returns a file as a string
    public static String getFileText(String path) {
        Path file = Paths.get(path);
        StringBuilder totalFile = new StringBuilder();
        Stream<String> lines;
        try {
            lines = Files.lines(file);
        }
        catch (IOException ex) {
            return null;
        }
        lines.forEach(s -> totalFile.append(s));
        return totalFile.toString();
    }

    /*  finds the regex within the doc string and returns that value.
     *   regex should be the regex string wishing to be found in doc
     *   this method wraps the regex in .*?( regex ).*
     *   import java.util.regex.Pattern;
     *   import java.util.regex.Matcher;
     */

    public static String extractRegexFromString(String regex, String doc) {
        if(doc.equals(""))
            return "";
        String r = ".*?(" + regex + ").*"; 
        String found;
        Pattern pattern = Pattern.compile(r, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher matcher = pattern.matcher(doc);
        try{
            matcher.find();
            found = matcher.group(1);
        }
        catch(Exception e){
            found = "";
        }
        return found;
    }

    // same as above but if it contains...
    public static boolean isRegexInString(String regex, String doc) {
        if(doc.equals(""))
            return false;
        String r = ".*?(" + regex + ").*";
        try {
            Pattern pattern = Pattern.compile(r, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
            Matcher matcher = pattern.matcher(doc);
            return matcher.find();
        }
        catch(Exception e) {
            return false;
        }
    }
}