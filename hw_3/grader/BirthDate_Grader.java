import java.lang.reflect.Method;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Arrays;
import java.util.List;

// needs to test
    // 1. getBirthDate method
            // should take in month, day, year
            // return SampleDate object
    // 2. details(SampleDate) method
            // should print: "You were born on _______ which was a _______"
            // might print: "___(year)___ was a leap year."
    // 3. daysUntilBirthday(SampleDate)
            // should print a happy birthday message
                // or
            // the number of days until the next birthday
    // 4. daysOld(SampleDate)
            // should print: "You are _______ days old."


public class BirthDate_Grader {

        // set input
        public static InputStream originalInput = System.in;
        // FileInputStream in = new FileInputStream(new File("input"));

        // get output
        public static PrintStream originalOutput = System.out;
        public static ByteArrayOutputStream baos = new ByteArrayOutputStream();
        public static PrintStream output = new PrintStream(baos);

    public static void main (String[] args) throws Exception {
        System.setOut(output);

        // test classes
        BirthDateSolution birthDate_Solution = new BirthDateSolution();
        BirthDate studentWork = new BirthDate();
        
        mainTest();


            


    }

    public static int mainTest() throws Exception {
        System.setIn(bais("12 17 1985"));
        
        // main() answer
        BirthDateSolution.main(null);
        System.out.flush();
        System.setOut(originalOutput);
        String answer_main_string = baos.toString();
        System.out.println(answer_main_string);

        // reset input/output
        baos.reset();
        System.setOut(output);
        System.in.reset();
        
        // main() student
        BirthDate.main(null);
        System.out.flush();
        System.setOut(originalOutput);
        String student_main_string = baos.toString();
        System.out.println(student_main_string);

        // get results
        String[] answer_main_results = mainMatcher(answer_main_string);
        String[] student_main_results = mainMatcher(student_main_string);

        List<String> answerList = Arrays.asList(answer_main_results);
        List<String> studentList = Arrays.asList(student_main_results);

        // Date
        if(studentList.contains(answer_main_results[0]))
            System.out.println("+1!");
        // Day

        // Days Until Birthday

        // Days Old 

        return 0;
    }

    public static String[] mainMatcher(String answer) {
        String [] results = new String[4];
        Pattern main_pattern = Pattern.compile("(.*?)" +
                                                    "(\\d{4}/\\d{1,2}/\\d{1,2})" + "(.*?)" +
                                                    "(Monday?|Tuesday?|Wednesday?|Thursday?|Friday?|Saturday?|Sunday?)" + "(.*?)" +
                                                    "(\\d{1,3})" + "(.*?)" +
                                                    "(\\d+)" + "(.*)", 
                                                     Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

        Matcher matcher = main_pattern.matcher(answer);
        matcher.find();
        try{
            results[0] = matcher.group(2);
        }
        catch (Exception e) {
            System.out.println("Couldn't find date in main output - should be in the format YYYY/MM/DD");
        }
        try{
            results[1] = matcher.group(4);
        }
        catch (Exception e) {
            System.out.println("Couldn't find day in main output - looking for Monday, Tuesday,...");
        }
        try{
            results[2] = matcher.group(6);
        }
        catch (Exception e) {
            System.out.println("Couldn't find days until birthday in main output - should be 1 - 3 digit number");
        }
        try{
            results[3] = matcher.group(8);
        }
        catch (Exception e) {
            System.out.println("Couldn't find days old in main output - should be number with more than 3 digits");
        }
        return results;
    }


    public static ByteArrayInputStream bais(String inpt) {
        try {
            return new ByteArrayInputStream(inpt.getBytes("UTF-8"));
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    // public static void stealOutput() {
    //     System.setOut(new PrintStream(new ByteArrayOutputStream()));
    // }

    // public static void returnOutput() {
    //     System.setOut(originalPrintStream);
    // }

    // // accessing private methods!
    // Class[] cArg = new Class[1];
    // cArg[0] = SampleDate.class;

    // Method getBirthdate = BirthDateSolution.class.getDeclaredMethod("getBirthdate");
    // Method details = BirthDateSolution.class.getDeclaredMethod("details", cArg);
    // Method daysUntilBirthday = BirthDateSolution.class.getDeclaredMethod("daysUntilBirthday", cArg);
    // Method daysOld = BirthDateSolution.class.getDeclaredMethod("daysOld", cArg);

    // getBirthdate.setAccessible(true);
    // details.setAccessible(true);
    // daysUntilBirthday.setAccessible(true);
    // daysOld.setAccessible(true);

    // // System.setIn(originalInput);
    // System.setIn(bais("7 12 1988"));
    // SampleDate returned = (SampleDate)getBirthdate.invoke(bds);
    // System.out.println();
    
    // details.invoke(bds, returned);

}