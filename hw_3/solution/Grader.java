import java.lang.reflect.Method;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.File;
import java.io.FileInputStream;

public class Grader {

    public static void main (String[] args) throws Exception {

        // set input
        InputStream originalInput = System.in;
        // FileInputStream in = new FileInputStream(new File("input"));
        System.setIn(bais("2 2 1985"));

        // get output
        PrintStream originalOutput = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(baos);
        System.setOut(output);

        // test BirthDate class
        BirthDateSolution bds = new BirthDateSolution();
        SampleDate sd = new SampleDate(1985, 2, 2);

        // main();
        BirthDateSolution.main(null);
        System.out.flush();
        System.setOut(originalOutput);
        String outstuff = baos.toString();
        String[] lines = outstuff.split("\\n");
        for(String st : lines)
            System.out.println(st);

        // accessing private methods!
        Class[] cArg = new Class[1];
        cArg[0] = SampleDate.class;

        Method getBirthdate = BirthDateSolution.class.getDeclaredMethod("getBirthdate");
        Method details = BirthDateSolution.class.getDeclaredMethod("details", cArg);
        Method daysUntilBirthday = BirthDateSolution.class.getDeclaredMethod("daysUntilBirthday", cArg);
        Method daysOld = BirthDateSolution.class.getDeclaredMethod("daysOld", cArg);

        getBirthdate.setAccessible(true);
        details.setAccessible(true);
        daysUntilBirthday.setAccessible(true);
        daysOld.setAccessible(true);

        // System.setIn(originalInput);
        System.setIn(bais("7 12 1988"));
        SampleDate returned = (SampleDate)getBirthdate.invoke(bds);
        System.out.println();
        
        details.invoke(bds, returned);

        // test CalendarDate class
        CalendarDateSolution cds = new CalendarDateSolution();
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