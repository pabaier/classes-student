import java.lang.reflect.Method;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

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

    public static void main (String[] args) throws Exception {

        // set input
        InputStream originalInput = System.in;
        // FileInputStream in = new FileInputStream(new File("input"));
        System.setIn(bais("12 17 1985"));

        // get output
        PrintStream originalOutput = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(baos);
        System.setOut(output);

        // test classes
        BirthDateSolution birthDate_Solution = new BirthDateSolution();
        BirthDate studentWork = new BirthDate();
        // SampleDate sd = new SampleDate(1985, 2, 2);

        // get date out of solution
        Pattern answer_main_combo = Pattern.compile("(.*?)" +
                                                    "(\\d{4}/\\d{1,2}/\\d{1,2})" + "(.*?)" +
                                                    "(Monday?|Tuesday?|Wednesday?|Thursday?|Friday?|Saturday?|Sunday?)" + "(.*?)" +
                                                    "(\\d+)" + "(.*?)" +
                                                    "(\\d+)" + "(.*)", 
                                                     Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

        // main();
        BirthDateSolution.main(null);
        System.out.flush();
        System.setOut(originalOutput);
        String outstuff = baos.toString();

        System.out.println(outstuff);
        
        // Matcher matcher = pattern_main_days_until.matcher(outstuff);
        Matcher matcher = answer_main_combo.matcher(outstuff);
        matcher.matches();
        System.out.println(matcher.group(2));
        System.out.println(matcher.group(4));
        System.out.println(matcher.group(6));
        System.out.println(matcher.group(8));
        
        // System.out.println("Here it is:\n" + answer_date);
        
        
        // String[] lines = outstuff.split("\\n");
        // for(String st : lines){
        //     // answerMatcher = answerPattern.matcher(st);
        //         // if (answerMatcher.find())
        //         if (Pattern.matches(pattern_main_correct, st))
        //             System.out.println("Found! ");// + answerMatcher.group());
        //     // System.out.println(st);
        // }

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