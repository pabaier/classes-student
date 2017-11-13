import java.io.File;
import org.apache.commons.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class Grader {
    public static void main(String[] args){
        int[] totalPoints = new int[4];
        System.out.println("Calendar Date Test:");
        // isAValidDateTest
        totalPoints[0] += isAValidDateTest();

        fetchClassKey("CalendarDate");

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
            totalPoints[1] += toStringAptTest();
        }
        catch (NoClassDefFoundError e) {
            System.out.println("\tCould not instantiate class Appointment");
        }
        System.out.println("   Total: " + totalPoints[1] + "/" + 10 +"\n");
        fetchClassKey("Appointment");

        System.out.println("AppointmentList Test:");
        try {
            // constructor
            totalPoints[2] += apptListConstructorTest();
            if(totalPoints[2] == 0) {
                throw new NoClassDefFoundError();
            }
            
        try {
            getArrayList();
        }
        catch(Exception e){}
            
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

    // AppointmentList Class Tests

    public static int apptListConstructorTest() {
        System.out.println("\tTesting constructor");
        int points = 0;
        int full = 1;
        int half = 0;
        try {
            AppointmentList a = new AppointmentList();
            System.out.println("\t\tCorrect - " + full + "/" + full);
            points += full;
        }
        catch(Exception e) {
            System.out.println("\t\t" + e);
            System.out.println("\t\tError running test - " + points + "/" + full);
        }
        return points;
    }

    // Appointment Class Tests

    public static int toStringAptTest() {
        System.out.println("\tTesting toString()");
        int points = 0;
        int full = 3;
        int half = 2;
        AppointmentKey key = new AppointmentKey(new CalendarDate(1762, 9, 12),  new Employee("Yekaterina Alekseyevna"));
        try {
            Appointment student = new Appointment(key.getDate(), key.getEmployee());
            String studentAnswer = student.toString().toUpperCase();
            System.out.print("\t\t" + key + " | " + student);
            if(studentAnswer.contains(key.getDate().toString().toUpperCase()) &&
            studentAnswer.contains(key.getEmployee().getName().toUpperCase())) {
                System.out.println(" - Correct - " + full + "/" + full);
                points += full;
            }
            else if(studentAnswer.contains(key.getDate().toString().toUpperCase())) {
                System.out.println(" - Date Correct - " + half + "/" + full);
                points += half;
            }
            else if(studentAnswer.contains(key.getEmployee().getName().toUpperCase())) {
                System.out.println(" - Name Correct - " + half + "/" + full);
                points += half;
            }
            else {
                System.out.println(" - Incorrect - " + (half - 1) + "/" + full);
                points += half - 1;                
            }
        }
        catch(Exception e) {
            System.out.println("\t\t" + e);
            System.out.println("\t\tError running test - " + points + "/" + full);
        }
        return points;
    }

    public static int getDateTest() {
        System.out.println("\tTesting getDate()");
        int points = 0;
        int full = 3;
        int half = 2;
        AppointmentKey key = new AppointmentKey(new CalendarDate(2016, 2, 2),  new Employee("John"));
        try {
            Appointment student = new Appointment(key.getDate(), key.getEmployee());
            System.out.print("\t\t" + key.getDate() + " | " + student.getDate());
            if(student.getDate() == key.getDate()) {
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

    public static int getEmployeeTest() {
        System.out.println("\tTesting getEmployee()");
        int points = 0;
        int full = 3;
        int half = 2;
        AppointmentKey key = new AppointmentKey(new CalendarDate(2016, 2, 2),  new Employee("John"));
        try {
            Appointment student = new Appointment(key.getDate(), key.getEmployee());
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

    // Removes the student's class and replaces it with the key class
    private static void fetchClassKey(String className) {
        File old = new File("D:\\School\\221\\hw_4\\grader\\" + className + ".class");
        File newFile = new File("D:\\School\\221\\hw_4\\HW4\\" + className + ".class");
        File newDir = new File("D:\\School\\221\\hw_4\\grader");
        FileUtils.deleteQuietly(old);
        try {
            FileUtils.copyFileToDirectory(newFile, newDir);
        }
        catch(Exception e){}
    }

    private static void getArrayList() throws Exception{
        AppointmentList studentAppointmentList = new AppointmentList();
        studentAppointmentList.addToList(new CalendarDate(1900,1,1), new Employee("Fred"));
        Class alClass = studentAppointmentList.getClass();

        Field[] alFields = alClass.getDeclaredFields();
        alFields[0].setAccessible(true);
        // alFields[0].set(new ArrayList<Appointment>());
        @SuppressWarnings("unchecked")
        ArrayList<Appointment> studentList = (ArrayList<Appointment>)alFields[0].get(studentAppointmentList);
        studentList.add(new Appointment(new CalendarDate(1900,1,1), new Employee("Wilma")));
        for(Appointment a : studentList)
            System.out.println(a);
        // for(Field f:alFields) {
        //     if(f.getType() == ArrayList.class)
        //         try {
        //             @SuppressWarnings("unchecked")
        //             studentList = f.get(studentAppointmentList);
        //         }
        //         catch(Exception e) {

        //         }
        // }
    }
}