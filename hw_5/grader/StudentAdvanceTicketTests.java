import edu.cofc.grader.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StudentAdvanceTicketTests {

    // global values for reference
    private static String name = "Coco";
    private static CalendarDate date = new CalendarDate(2017, 11, 22);
    private static final String testFilePath = "/mnt/sda5/School/221/hw_5/grader/StudentAdvanceTicket.java";

    public static class Constructor extends SingleTest {
        public void exec() {
            setTotalPoints(6);
            int full = 3;
            int half = 2;
            StudentAdvanceTicket t;
            CalendarDate datePurchased = new CalendarDate(2017, 11, 7);
            
            System.out.print(indent() + "Constructor - ");
            try {
                t = new StudentAdvanceTicket(name, date, datePurchased);
                addPoints(half);
                System.out.println(C.CORRECT + "Correct - " + half + "/" + half + C.RESET);
            }
            catch(Throwable e) {
                try {
                    t = new StudentAdvanceTicket(date, name, datePurchased);
                    addPoints(half - 1);
                    System.out.println(C.PARTCORRECT + "Arguments in Wrong Order - " + (half-1) + "/" + half + C.RESET);
                }
                catch(Throwable f) {
                    try {
                        t = new StudentAdvanceTicket(date, datePurchased, name);
                        addPoints(half - 1);
                        System.out.println(C.PARTCORRECT + "Arguments in Wrong Order - " + (half-1) + "/" + half + C.RESET);
                    }
                    catch(Throwable g) {
                        addPoints(0);
                        System.out.println(C.INCORRECT + "Could Not Construct StudentAdvanceTicket - " + (0) + "/" + half + C.RESET);
                    }
                }
            }
            
            System.out.print(indent() + "Extends AdvanceTicket - ");
            String testFile = getFileText(testFilePath);
            if(isRegexInString("public class StudentAdvanceTicket extends AdvanceTicket", testFile)) {
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
            setTotalPoints(10);
            int full = 2;
            int half = 1;
            
            CalendarDate testDate = new CalendarDate(2017, 10, 22);
            StudentAdvanceTicket thirt = getStudentAdvanceTicket(testDate);
            if (thirt == null) {
                System.out.println(indent() + C.INCORRECT + "Cannot create StudentAdvanceTicket Objects" + C.RESET);
                return;
            }
            
            // clear 15
            System.out.print(indent() + testDate + " " + date + " - $15 - ");
            thirt = getStudentAdvanceTicket(testDate);
            double result = 100;
            try {
                result = thirt.getPrice();
            }
            catch(Throwable e) {
            }
            if(result == 15) {
                addPoints(full);
                System.out.println(C.CORRECT + "Correct - " + full + "/" + full + C.RESET);                
            }
            else {
                addPoints(half);
                System.out.println(C.PARTCORRECT + "" + result + " - incorrect - " + half + "/" + full + C.RESET);
            }
            
            // tight 15
            testDate = new CalendarDate(2017, 11, 12);
            System.out.print(indent() + testDate + " " + date + " - $15 - ");
            thirt = getStudentAdvanceTicket(testDate);
            result = 100;
            try {
                result = thirt.getPrice();
            }
            catch(Throwable e) {
            }
            if(result == 15) {
                addPoints(full);
                System.out.println(C.CORRECT + "Correct - " + full + "/" + full + C.RESET);                
            }
            else {
                addPoints(half);
                System.out.println(C.PARTCORRECT + "" + result + " - incorrect - " + half + "/" + full + C.RESET);
            }
            
            // tight 20
            testDate = new CalendarDate(2017, 11, 13);
            System.out.print(indent() + testDate + " " + date + " - $20 - ");
            thirt = getStudentAdvanceTicket(testDate);
            result = 100;
            try {
                result = thirt.getPrice();
            }
            catch(Throwable e) {
            }
            if(result == 20) {
                addPoints(full);
                System.out.println(C.CORRECT + "Correct - " + full + "/" + full + C.RESET);                
            }
            else {
                addPoints(half);
                System.out.println(C.PARTCORRECT + "" + result + " - incorrect - " + half + "/" + full + C.RESET);
            }

            // clear 20
            testDate = new CalendarDate(2017, 11, 21);
            System.out.print(indent() + testDate + " " + date + " - $20 - ");
            thirt = getStudentAdvanceTicket(testDate);
            result = 100;
            try {
                result = thirt.getPrice();
            }
            catch(Throwable e) {
            }
            if(result == 20) {
                addPoints(full);
                System.out.println(C.CORRECT + "Correct - " + full + "/" + full + C.RESET);                
            }
            else {
                addPoints(half);
                System.out.println(C.PARTCORRECT + "" + result + " - incorrect - " + half + "/" + full + C.RESET);
            }

            // check if it calls super().getPrice()
            System.out.print(indent() + "Calls super().getPrice() - ");
            String testFile = getFileText(testFilePath);
            if(isRegexInString("super().getPrice()", testFile)) {
                addPoints(full);
                System.out.println(C.CORRECT + "Correct - " + full + "/" + full + C.RESET);
            }
            else {
                addPoints(half);
                System.out.println(C.INCORRECT + "No Call to Super Class" + half + "/" + half + C.RESET);
            }
        }
    }

    public static class ToString extends SingleTest {
        public void exec() {
            setTotalPoints(6);
            int full = 2;
            int half = 1;
            
            CalendarDate datePurchased = new CalendarDate(2017, 11, 7);
            System.out.println(indent() + name + " - " + datePurchased + " - " + date + " - " + "$15");
            StudentAdvanceTicket t = getStudentAdvanceTicket(datePurchased);
            if (t == null) {
                System.out.println(indent() + C.INCORRECT + "Cannot create Ticket Objects" + C.RESET);
                return;
            }
            String result = "";
            try {
                result = t.toString();
            }
            catch(Throwable e) {
            }

            // REPLACE THIS***SEARCH THROUGH FILE FOR super().toString()
            // boolean superString = result.contains(getTicket().toString());
            
            String testFile = getFileText(testFilePath);
            boolean superString = isRegexInString("super().toString", testFile);
            boolean price = result.contains("15") || result.contains("20");
            boolean advance = result.toLowerCase().contains("advance");
            // boolean purchased = result.toLowerCase().contains(datePurchased.toString());
            
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
            System.out.print(indent() + "Student Advance Ticket - ");
            if(advance) {
                System.out.println(C.CORRECT + "Correct - " + full + "/" + full + C.RESET);                
                addPoints(full);
            }
            else {
                System.out.println(C.PARTCORRECT + "Missing - " + half + "/" + full + C.RESET);                
                addPoints(half);
            }
            // System.out.print(indent() + "Date Purchased - ");
            // if(purchased) {
            //     System.out.println(C.CORRECT + "Correct - " + full + "/" + full + C.RESET);                
            //     addPoints(full);
            // }
            // else {
            //     System.out.println(C.PARTCORRECT + "Missing - " + half + "/" + full + C.RESET);                
            //     addPoints(half);
            // }
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
    public static StudentAdvanceTicket getStudentAdvanceTicket(CalendarDate purch) {
        try {
            return new StudentAdvanceTicket(name, date, purch);
        }
        catch(Throwable e) {
            try {
                return new StudentAdvanceTicket(date, name, purch); 
            }
            catch(Throwable f) {
                try {
                    return new StudentAdvanceTicket(date, purch, name); 
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