import java.io.File;
import org.apache.commons.io.*;

public class Grader {
    public static void main(String[] args) {
        int[] totalPoints = new int[4];
        System.out.println("Calendar Date Test:");
        // isAValidDateTest
        totalPoints[0] += isAValidDateTest();

        File source = new File("D:\\School\\221\\hw_4\\grader\\CalendarDate.class");
        // File dest = new File("H:\\work-temp\\file2");
        FileUtils.deleteQuietly(source);
        // try {
        //     FileUtils.copyDirectory(source, dest);
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        System.out.println("Appointment Test:");
        try {

            // constructor
            totalPoints[1] += apptConstructorTest();
            if (totalPoints[1] == 0)
                throw new NoClassDefFoundError();
            
            // getEmployee
            totalPoints[1] += getEmployeeTest();

            // getDate
            totalPoints[1] += getDateTest();

            // toString
        }
        catch (NoClassDefFoundError e) {
            System.out.println("\tCould not instantiate class Appointment");
        }

        System.out.println("AppointmentList Test:");
        try {
            // constructor
            // toString
            // addToList
            // getAppointment
            // cancelAppointment
        }
        catch (NoClassDefFoundError e) {
            System.out.println("\tCould not instantiate class AppointmentList");
        }

        System.out.println("HW4 Test:");
        try {

        }
        catch (NoClassDefFoundError e) {
            System.out.println("\tCould not instantiate class HW4");
        }
    }

    public static int getEmployeeTest() {
        System.out.println("\tTesting getEmployee()");
        int points = 0;
        int full = 3;
        int half = 2;
        AppointmentKey key = new AppointmentKey(new CalendarDateKey(2016, 2, 2),  new Employee("John"));
        try {
            Appointment student = new Appointment(new CalendarDate(2016, 2, 2), key.getEmployee());
            System.out.print("\t\t" + key.getEmployee() + " | " + student.getEmployee());
            if(student.getEmployee() == key.getEmployee()) {
                System.out.println(" - Correct - " + full + "/" + full);
                points += full;
            }
            else {
                System.out.println(" - Incorrect - " + half + "/" + full);
                points += half;                
            }
        }
        catch(Exception e) {
            System.out.println("\t\t" + e);
            System.out.println("\t\tError running test - " + points + "/" + full);
        }
        return points;
    }

    public static int apptConstructorTest() {
        System.out.println("\tTesting constructor");
        int points = 0;
        int full = 1;
        int half = 0;
        try {
            Appointment a = new Appointment(new CalendarDate(2016, 2, 2), new Employee("John"));
            System.out.println("\t\tCorrect - " + full + "/" + full);
            points += full;
        }
        catch(Exception e) {
            System.out.println("\t\t" + e);
            System.out.println("\t\tError running test - " + points + "/" + full);
        }
        return points;
    }

    public static int isAValidDateTest() {
        System.out.println("\tTesting isValidDate()");
        int points = 0;
        int full = 1;
        int half = 0;
        // 0 - month > 12
        // 1 - month < 1
        // 2 - day > 31
        // 3 - february leap year
        // 4 - february not leap year
        String[] tests = {"month > 12",
                            "month < 1",
                            "day > 31",
                            "february leap year",
                            "february not leap year"};
        CalendarDateKey[] key = {new CalendarDateKey(1977, 13, 2),
                                new CalendarDateKey(1977, 0, 2),
                                new CalendarDateKey(1977, 9, 31),
                                new CalendarDateKey(2016, 2, 29),
                                new CalendarDateKey(2015, 2, 29)};
        try {
            CalendarDate[] student = {new CalendarDate(1977, 13, 2),
                                new CalendarDate(1977, 0, 2),
                                new CalendarDate(1977, 9, 31),
                                new CalendarDate(2016, 2, 29),
                                new CalendarDate(2015, 2, 29)};
            for(int i = 0; i < key.length; i++) {
                System.out.print("\t\t" + key[i] + ": " + student[i].isAValidDate());
                if(key[i].isAValidDate() == student[i].isAValidDate()) {
                    System.out.println(" - Correct - " + full + "/" + full);
                    points += full;
                }
                else {
                    System.out.println(" - Incorrect - " + half + "/" + full);
                    points += half;
                }
            }
            System.out.println("\t    " + points + "/" + (full * key.length));
        }
        catch(Exception | NoClassDefFoundError e) {
            System.out.println("\t\t" + e);
            System.out.println("\t\tError running test - " + points + "/" + (full * key.length));
        }

        return points;
    }
}