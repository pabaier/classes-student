import java.lang.reflect.Method;

public class Grader {

    public static void main (String[] args) throws Exception {

        // test BirthDate class
        BirthDateSolution bds = new BirthDateSolution();
        SampleDate sd = new SampleDate(1985, 2, 2);

        // accessing private methods!
        Class[] cArg = new Class[1];
        cArg[0] = SampleDate.class;
        Method details = BirthDateSolution.class.getDeclaredMethod("details", cArg);
        Method daysUntilBirthday = BirthDateSolution.class.getDeclaredMethod("daysUntilBirthday", cArg);
        Method daysOld = BirthDateSolution.class.getDeclaredMethod("daysOld", cArg);
        details.setAccessible(true);
        daysUntilBirthday.setAccessible(true);
        daysOld.setAccessible(true);

        // details()
        details.invoke(bds, sd);
        
        // daysUntilBirthday()
        daysUntilBirthday.invoke(bds, sd);
        
        // daysOld()
        daysOld.invoke(bds, sd);

        // bds.details(sd);

        // test CalendarDate class
        CalendarDateSolution cds = new CalendarDateSolution();
    }
}