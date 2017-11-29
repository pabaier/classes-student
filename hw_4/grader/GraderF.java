import edu.cofc.grader.*;
import java.io.File;
import org.apache.commons.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class GraderF {
     public static void main(String[] args){

        C.colors(true);
        C.setTitlesArray(new String[]{C.CYAN, C.BLUE, C.MAGENTA});
        C.setResultsArray(new String[]{C.MAGENTA, C.BOLD+C.BACKGROUND_BLACK+C.YELLOW, C.CYAN});

        TestOutline calendarDateTests = new TestOutline(C.UNDERLINE + "CalendarDate" + C.RESET);
        TestOutline appointmentTests = new TestOutline(C.UNDERLINE + "Appointment" + C.RESET);
        TestOutline appointmentListTests = new TestOutline(C.UNDERLINE + "AppointmentList" + C.RESET);
        TestOutline hw4Tests = new TestOutline(C.UNDERLINE + "HW 4" + C.RESET);
        TestOutline homework4 = new TestOutline("Homework 4" + C.RESET);

        homework4.add(calendarDateTests);
        homework4.add(appointmentTests);
        homework4.add(appointmentListTests);
        homework4.add(hw4Tests);

        // calendarDate ********************
        SingleTests.IsAValidDate cdtDate = new SingleTests.IsAValidDate();
        cdtDate.setName("Is A Valid Date");

        calendarDateTests.add(cdtDate);
        // calendarDateTests.run();
 
        // appointment ********************
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
        // appointmentTests.run();

        // fetchKey("Appointment");

        // appointment list ********************
        SingleTests.AppointmentListConstructor aptListConst = new SingleTests.AppointmentListConstructor();
        aptListConst.setName("AppointmentList Constructor");
        SingleTests.AddToList addToList = new SingleTests.AddToList();
        addToList.setName("addToList()");
        SingleTests.GetAppointment getAppointment = new SingleTests.GetAppointment();
        getAppointment.setName("getAppointment()");
        SingleTests.CancelAppointment cancelAppointment = new SingleTests.CancelAppointment();
        cancelAppointment.setName("cancelAppointment()");

        appointmentListTests.add(aptListConst);
        appointmentListTests.add(addToList);
        appointmentListTests.add(getAppointment);
        appointmentListTests.add(cancelAppointment);

        // appointmentListTests.run();

        // hw4 ********************************
        SingleTests.HW4Driver hw4Driver = new SingleTests.HW4Driver();
        hw4Driver.setName("HW4 Tester");

        hw4Tests.add(hw4Driver);

        // hw4Tests.run();

        homework4.run();
     }

    // Removes the student's class and replaces it with the key class
    private static void fetchKey(String className) {
        File old = new File("D:\\School\\221\\hw_4\\grader\\classes" + className + ".class");
        File newFile = new File("D:\\School\\221\\hw_4\\HW4\\" + className + ".class");
        File newDir = new File("D:\\School\\221\\hw_4\\grader\\classes");
        FileUtils.deleteQuietly(old);
        try {
            FileUtils.copyFileToDirectory(newFile, newDir);
        }
        catch(Exception e){}
    }

}
