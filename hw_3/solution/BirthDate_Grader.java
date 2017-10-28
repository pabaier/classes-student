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
        System.setIn(bais("7 12 1985"));

        // get output
        PrintStream originalOutput = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(baos);
        System.setOut(output);

        // test BirthDate class
        BirthDateSolution bds = new BirthDateSolution();
        SampleDate sd = new SampleDate(1985, 2, 2);

        // need to get the date out
        Pattern pattern_main_correct = Pattern.compile("\\d{4}/\\d{1,2}/\\d{1,2}");
        Pattern pattern_main_partial_a = Pattern.compile("\\d{1,2}/\\d{1,2}/\\d{4}");
        Matcher pattern_answerMatcher = null;

        // main();
        BirthDateSolution.main(null);
        System.out.flush();
        System.setOut(originalOutput);
        String outstuff = baos.toString();
        String[] lines = outstuff.split("\\n");
        for(String st : lines){
            // answerMatcher = answerPattern.matcher(st);
                // if (answerMatcher.find())
                if (Pattern.matches(pattern_main_correct, st))
                    System.out.println("Found! ");// + answerMatcher.group());
            // System.out.println(st);
        }

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

    // public static void stealOutput() {
    //     System.setOut(new PrintStream(new ByteArrayOutputStream()));
    // }

    // public static void returnOutput() {
    //     System.setOut(originalPrintStream);
    // }

    public static ByteArrayInputStream bais(String inpt) {
        try {
            return new ByteArrayInputStream(inpt.getBytes("UTF-8"));
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}