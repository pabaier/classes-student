import edu.cofc.grader.*;
import java.io.File;
import org.apache.commons.io.*;

public class GraderF {
     public static void main(String[] args){

         C.colors(true);

        TestOutline calendarDateTests = new TestOutline(C.UNDERLINE + "CalendarDate" + C.RESET);
        TestOutline appointmentTests = new TestOutline(C.UNDERLINE + "Appointment" + C.RESET);
        TestOutline appointmentListTests = new TestOutline(C.UNDERLINE + "AppointmentList" + C.RESET);
        TestOutline hw4Tests = new TestOutline("HW 4 Tests");

        // calendarDate
        SingleTests.IsAValidDate cdtDate = new SingleTests.IsAValidDate();
        cdtDate.setName("Is A Valid Date");

        calendarDateTests.add(cdtDate);

        calendarDateTests.run();
 
        // appointment
        SingleTests.AppointmentConstructor aptConst = new SingleTests.AppointmentConstructor();
        aptConst.setName("Appointment Constructor");
        
        SingleTests.GetEmployee getEmployee = new SingleTests.GetEmployee();
        getEmployee.setName("getEmployee()");
        
        SingleTests.GetDate getDate = new SingleTests.GetDate();
        getDate.setName("getDate()");

        SingleTests.AppointmentToString aptToString = new SingleTests.AppointmentToString();
        aptToString.setName("toString()");
        
        appointmentTests.add(aptConst);
        appointmentTests.add(getEmployee);
        appointmentTests.add(getDate);
        appointmentTests.add(aptToString);

        appointmentTests.run();

        fetchKey("Appointment");

        // appointment list
        SingleTests.AppointmentListConstructor aptListConst = new SingleTests.AppointmentListConstructor();
        aptListConst.setName("AppointmentList Constructor");

        appointmentListTests.add(aptListConst);

        appointmentListTests.run();

     }

    // Removes the student's class and replaces it with the key class
    private static void fetchKey(String className) {
        File old = new File("D:\\School\\221\\hw_4\\grader\\" + className + ".class");
        File newFile = new File("D:\\School\\221\\hw_4\\HW4\\" + className + ".class");
        File newDir = new File("D:\\School\\221\\hw_4\\grader");
        FileUtils.deleteQuietly(old);
        try {
            FileUtils.copyFileToDirectory(newFile, newDir);
        }
        catch(Exception e){}
    }
}