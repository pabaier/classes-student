import edu.cofc.grader.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class AdvanceTicketTests {

    // global values for reference
    private static String name = "La Nouba";
    private static CalendarDate date = new CalendarDate(2017, 12, 31);
    private static CalendarDate datePurchased = new CalendarDate(2017, 12, 21);
    private static CalendarDate thirty = new CalendarDate(2017, 12, 21);
    private static CalendarDate forty = new CalendarDate(2017, 12, 20);
    private static final String testFilePath = "/mnt/sda5/School/221/hw_5/grader/AdvanceTicket.java";

    public static class Constructor extends SingleTest {
        public void exec() {
            setTotalPoints(6);
            int full = 3;
            int half = 2;
            AdvanceTicket t;

            System.out.print(indent() + "Constructor - ");
            try {
                t = new AdvanceTicket(name, date, datePurchased);
                addPoints(half);
                System.out.println(C.CORRECT + "Correct - " + half + "/" + half + C.RESET);
            }
            catch(Throwable e) {
                try {
                    t = new AdvanceTicket(date, name, datePurchased);
                    addPoints(half - 1);
                    System.out.println(C.PARTCORRECT + "Arguments in Wrong Order - " + (half-1) + "/" + half + C.RESET);
                }
                catch(Throwable f) {
                    try {
                        t = new AdvanceTicket(date, datePurchased, name);
                        addPoints(half - 1);
                        System.out.println(C.PARTCORRECT + "Arguments in Wrong Order - " + (half-1) + "/" + half + C.RESET);
                    }
                    catch(Throwable g) {
                        addPoints(0);
                        System.out.println(C.INCORRECT + "Could Not Construct AdvanceTicket - " + (0) + "/" + half + C.RESET);
                    }
                }
            }
            
            System.out.print(indent() + "Extends Ticket - ");
            String testFile = getFileText(testFilePath);
            if(isRegexInString("public class AdvanceTicket extends Ticket", testFile)) {
                addPoints(half);
                System.out.println(C.CORRECT + "Correct - " + half + "/" + half + C.RESET);
            }
            else {
                addPoints(half - 1);
                System.out.println(C.INCORRECT + "Does not extend Ticket" + (half - 1) + "/" + half + C.RESET);
            }

            System.out.print(indent() + "Call to super - ");
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
            
            System.out.print(indent() + "30 - ");
            
            AdvanceTicket thirt = getAdvanceTicket(thirty);
            AdvanceTicket fort = getAdvanceTicket(forty);
            if (thirt == null) {
                System.out.println(C.INCORRECT + "Cannot create AdvanceTicket Objects" + C.RESET);
                return;
            }
            
            // 30
            double result = 100;
            try {
                result = thirt.getPrice();
            }
            catch(Throwable e) {
            }
            if(result == 30) {
                addPoints(full);
                System.out.println(C.CORRECT + "Correct - " + full + "/" + full + C.RESET);                
            }
            else {
                addPoints(half);
                System.out.println(C.PARTCORRECT + "" + result + " - incorrect - " + half + "/" + full + C.RESET);
            }
            
            // 40
            System.out.print(indent() + "40 - ");
            result = 100;
            try {
                result = fort.getPrice();
            }
            catch(Throwable e) {
            }
            if(result == 40) {
                addPoints(full);
                System.out.println(C.CORRECT + "Correct - " + full + "/" + full + C.RESET);                
            }
            else {
                addPoints(half);
                System.out.println(C.PARTCORRECT + "" + result + " - incorrect - " + half + "/" + full + C.RESET);
            }
        }
    }
    
    /*
    public static class ToString extends SingleTest {
        public void exec() {
            setTotalPoints(3);
            int full = 3;
            int half = 2;

            System.out.print(indent() + name + " " + date + " " + 50 + " - ");

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

            boolean superString = result.contains(getTicket().toString());
            boolean price = result.contains("50");
            boolean  walkup = result.toLowerCase().contains("walk-up") || 
                            result.toLowerCase().contains("walkup") ||
                            result.toLowerCase().contains("walk up");

            if(superString && price && walkup) {
                addPoints(full);
                System.out.println(C.CORRECT + "Correct - " + full + "/" + full + C.RESET);                
            }
            else if(!superString && !price && !walkup) {
                addPoints(half - 1);
                System.out.println(C.PARTCORRECT + "" + result + " - incorrect - " + (half - 1) + "/" + full + C.RESET);
            }
            else if(!price) {
                addPoints(half);
                System.out.println(C.PARTCORRECT + " - missing the price - " + half + "/" + full + C.RESET);
                System.out.println(indent() + C.PARTCORRECT + result);
            }
            else if(!superString) {
                addPoints(half);
                System.out.println(C.PARTCORRECT + " - does not call super().toString - " + half + "/" + full + C.RESET);
                System.out.println(indent() + C.PARTCORRECT + result);
            }
            else if(!walkup) {
                addPoints(half);
                System.out.println(C.PARTCORRECT + " - could not find 'walk up' - " + half + "/" + full + C.RESET);
                System.out.println(indent() + C.PARTCORRECT + result);
            }
            else {
                addPoints(half - 1);
                System.out.println(C.PARTCORRECT + " - incorrect - " + (half - 1) + "/" + full + C.RESET);
                System.out.println(indent() + C.PARTCORRECT + result);
            }
        }
    }
*/
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
    public static AdvanceTicket getAdvanceTicket(CalendarDate purch) {
        try {
            return new AdvanceTicket(name, date, purch);
        }
        catch(Throwable e) {
            try {
                return new AdvanceTicket(date, name, purch); 
            }
            catch(Throwable f) {
                try {
                    return new AdvanceTicket(date, purch, name); 
                }
                catch(Throwable g){
                    return null;
                }
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