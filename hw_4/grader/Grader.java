import java.io.File;
import org.apache.commons.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;


public class Grader {
    // public static final String RESET = "\u001B[0m";
    // public static final String CORRECT = "\u001B[32m";
    // public static final String PARTCORRECT = "\u001B[34m";
    // public static final String INCORRECT = "\u001B[31m";
    // public static final String TESTHEAD = "\u001B[35m";
    // public static final String TESTEXPECT = "\u001B[36m";

    public static final String RESET = "";
    public static final String CORRECT = "";
    public static final String PARTCORRECT = "";
    public static final String INCORRECT = "";
    public static final String TESTHEAD = "";
    public static final String TESTEXPECT = "";

    public static void main(String[] args){
        int[] totalPoints = new int[4];
        System.out.println(TESTHEAD + "Calendar Date Test:");

        // isAValidDateTest
        totalPoints[0] += isAValidDateTest();
        fetchClassKey("CalendarDate");

        //---------------------------------------------------------

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

        //---------------------------------------------------------

        System.out.println("AppointmentList Test:");
        try {
            // constructor
            totalPoints[2] += apptListConstructorTest();
            if(totalPoints[2] == 0) {
                throw new NoClassDefFoundError();
            }
        
            AppointmentList studentAppointmentList = new AppointmentList();
            AppointmentListKey keyAppointmentList = new AppointmentListKey();

            ArrayList<Appointment> studentList = null;
            try {
                studentList = getStudentArrayList(studentAppointmentList);
            }
            catch(Exception e){}
            if(studentList == null)
                throw new NoClassDefFoundError();
                
            // addToList
            totalPoints[2] += addToListTest(studentList, studentAppointmentList, keyAppointmentList);

            // getAppointment
            totalPoints[2] += getAppointmentTest(studentList, studentAppointmentList, keyAppointmentList);

            // cancelAppointment
            totalPoints[2] += cancelAppointmentTest(studentList, studentAppointmentList, keyAppointmentList);

            // toString
        }
        catch (NoClassDefFoundError e) {
            System.out.println(INCORRECT + "\tCould not instantiate class AppointmentList" + RESET);
        }

        //---------------------------------------------------------

        System.out.println("HW4 Test:");
        try {

        }
        catch (NoClassDefFoundError e) {
            System.out.println(INCORRECT + "\tCould not instantiate class HW4" + RESET);
        }
    }

    // AppointmentList Class Tests

    public static int cancelAppointmentTest(ArrayList<Appointment> studentList, AppointmentList studentAppointmentList, AppointmentListKey key) {
        System.out.println(TESTHEAD + "\tTesting cancelAppointment()" + RESET);
        int points = 0;
        int full = 3;
        int half = 2;

        ArrayList<Appointment> keyList = key.getList();
        studentList.clear();        
        keyList.clear();

        key.addToList(new CalendarDate(1906, 12, 9),  new Employee("Grace Hopper"));
        studentList.add(keyList.get(keyList.size() - 1));
        try {
            System.out.print(TESTEXPECT + "\t\t" + keyList.get(keyList.size() - 1).getEmployee().getName() + " " + keyList.get(keyList.size() - 1).getDate() + RESET);
            studentAppointmentList.cancelAppointment(keyList.get(keyList.size() - 1).getEmployee().getName());
            if(studentList.size() == 0) {
                System.out.println(CORRECT + " - Correct - " + full + "/" + full + RESET);
                points += full;
            }
            else {
                System.out.println(PARTCORRECT + " - Incorrect - " + half + "/" + full + RESET);
                points += half;
            }
        }
        catch(Exception e) {
            System.out.println(INCORRECT + "\t\t" + e);
            System.out.println("\t\tError running test - " + points + "/" + full + RESET);
        }
        return points;
    }


    public static int getAppointmentTest(ArrayList<Appointment> studentList, AppointmentList studentAppointmentList, AppointmentListKey key) {
        System.out.println(TESTHEAD + "\tTesting getAppointment()" + RESET);
        int points = 0;
        int full = 3;
        int half = 2;
        
        ArrayList<Appointment> keyList = key.getList();
        key.addToList(new CalendarDate(1971, 10, 1),  new Employee("Walt Disney"));
        studentList.add(keyList.get(keyList.size() - 1));
        try {
            System.out.print("\t\t" + keyList.get(keyList.size() - 1).getEmployee().getName() + " " + keyList.get(keyList.size() - 1).getDate());
            if(studentAppointmentList.getAppointment("Walt Disney") == keyList.get(keyList.size() - 1).getDate()) {
                System.out.println(CORRECT + " - Correct - " + full + "/" + full + RESET);
                points += full;
            }
            else {
                System.out.println(PARTCORRECT + " - Incorrect - " + half + "/" + full + RESET);
                points += half;
            }
            System.out.print("\t\tNull");
            if(studentAppointmentList.getAppointment("Roy Disney") == null) {
                System.out.println(CORRECT + " - Correct - " + full + "/" + full + RESET);
                points += full;
            }
            else {
                System.out.println(PARTCORRECT + " - Incorrect - " + half + "/" + full + RESET);
                points += half;
            }
        }
        catch(Exception e) {
            System.out.println(INCORRECT + "\t\t" + e);
            System.out.println("\t\tError running test - " + points + "/" + full + RESET);
        }
        return points;
    }

    public static int addToListTest(ArrayList<Appointment> studentList, AppointmentList studentAppointmentList, AppointmentListKey key) {
        System.out.println(TESTHEAD + "\tTesting addToList()" + RESET);
        int points = 0;
        int full = 3;
        int half = 2;
        
        ArrayList<Appointment> keyList = key.getList();
        key.addToList(new CalendarDate(1960, 7, 11),  new Employee("Scout Finch"));
        try {
            studentAppointmentList.addToList(keyList.get(0).getDate(), keyList.get(0).getEmployee());
            System.out.print("\t\t" + keyList.get(0).getDate() + " " + keyList.get(0).getEmployee().getName());
            if(studentList.get(0).getDate() == keyList.get(0).getDate() && 
                studentList.get(0).getEmployee() == keyList.get(0).getEmployee()) {
                System.out.println(CORRECT + " - Correct - " + full + "/" + full + RESET);
                points += full;
            }
            else if(studentList.get(0).getDate() == keyList.get(0).getDate()) {
                System.out.println(PARTCORRECT + " - Date Correct - " + half + "/" + full + RESET);
                points += half;
            }
            else if(studentList.get(0).getEmployee() == keyList.get(0).getEmployee()) {
                System.out.println(PARTCORRECT + " - Employee Correct - " + half + "/" + full + RESET);
                points += half;
            }
            else {
                System.out.println(PARTCORRECT + " - Incorrect - " + (half - 1) + "/" + full + RESET);
                points += half - 1;
            }
        }
        catch(Exception e) {
            System.out.println(INCORRECT + "\t\t" + e);
            System.out.println("\t\tError running test - " + points + "/" + full + RESET);
        }
        return points;
    }

    public static int apptListConstructorTest() {
        System.out.println(TESTHEAD + "\tTesting constructor" + RESET);
        int points = 0;
        int full = 1;
        int half = 0;
        try {
            AppointmentList a = new AppointmentList();
            System.out.println(CORRECT + "\t\tCorrect - " + full + "/" + full + RESET);
            points += full;
        }
        catch(Exception e) {
            System.out.println(INCORRECT + "\t\t" + e);
            System.out.println("\t\tError running test - " + points + "/" + full + RESET);
        }
        return points;
    }

    // Appointment Class Tests

    public static int toStringAptTest() {
        System.out.println(TESTHEAD + "\tTesting toString()" + RESET);
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
                System.out.println(CORRECT + " - Correct - " + full + "/" + full + RESET);
                points += full;
            }
            else if(studentAnswer.contains(key.getDate().toString().toUpperCase())) {
                System.out.println(PARTCORRECT + " - Date Correct - " + half + "/" + full + RESET);
                points += half;
            }
            else if(studentAnswer.contains(key.getEmployee().getName().toUpperCase())) {
                System.out.println(PARTCORRECT + " - Name Correct - " + half + "/" + full + RESET);
                points += half;
            }
            else {
                System.out.println(PARTCORRECT + " - Incorrect - " + (half - 1) + "/" + full + RESET);
                points += half - 1;                
            }
        }
        catch(Exception e) {
            System.out.println(INCORRECT + "\t\t" + e);
            System.out.println("\t\tError running test - " + points + "/" + full + RESET);
        }
        return points;
    }

    public static int getDateTest() {
        System.out.println(TESTHEAD + "\tTesting getDate()" + RESET);
        int points = 0;
        int full = 3;
        int half = 2;
        AppointmentKey key = new AppointmentKey(new CalendarDate(2016, 2, 2),  new Employee("John"));
        try {
            Appointment student = new Appointment(key.getDate(), key.getEmployee());
            System.out.print("\t\t" + key.getDate() + " | " + student.getDate());
            if(student.getDate() == key.getDate()) {
                System.out.println(CORRECT + " - Correct - " + full + "/" + full + RESET);
                points += full;
            }
            else {
                System.out.println(PARTCORRECT + " - Incorrect - " + half + "/" + full + RESET);
                points += half;                
            }
        }
        catch(Exception e) {
            System.out.println(INCORRECT + "\t\t" + e);
            System.out.println("\t\tError running test - " + points + "/" + full + RESET);
        }
        return points;
    }

    public static int getEmployeeTest() {
        System.out.println(TESTHEAD + "\tTesting getEmployee()"+ RESET);
        int points = 0;
        int full = 3;
        int half = 2;
        AppointmentKey key = new AppointmentKey(new CalendarDate(2016, 2, 2),  new Employee("John"));
        try {
            Appointment student = new Appointment(key.getDate(), key.getEmployee());
            System.out.print("\t\t" + key.getEmployee() + " | " + student.getEmployee());
            if(student.getEmployee() == key.getEmployee()) {
                System.out.println(CORRECT + " - Correct - " + full + "/" + full + RESET);
                points += full;
            }
            else {
                System.out.println(PARTCORRECT + " - Incorrect - " + half + "/" + full + RESET);
                points += half;                
            }
        }
        catch(Exception e) {
            System.out.println(INCORRECT + "\t\t" + e);
            System.out.println("\t\tError running test - " + points + "/" + full + RESET);
        }
        return points;
    }

    public static int apptConstructorTest() {
        System.out.println(TESTHEAD + "\tTesting constructor" + RESET);
        int points = 0;
        int full = 1;
        int half = 0;
        try {
            Appointment a = new Appointment(new CalendarDate(2016, 2, 2), new Employee("John"));
            System.out.println(CORRECT + "\t\tCorrect - " + full + "/" + full + RESET);
            points += full;
        }
        catch(Exception e) {
            System.out.println(INCORRECT + "\t\t" + e);
            System.out.println("\t\tError running test - " + points + "/" + full + RESET);
        }
        return points;
    }

    public static int isAValidDateTest() {
        System.out.println(TESTHEAD + "\tTesting isValidDate()" + RESET);
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
                    System.out.println(CORRECT + " - Correct - " + full + "/" + full + RESET);
                    points += full;
                }
                else {
                    System.out.println(PARTCORRECT + " - Incorrect - " + half + "/" + full + RESET);
                    points += half;
                }
            }
            System.out.println("\t    " + points + "/" + (full * key.length));
        }
        catch(Exception | NoClassDefFoundError e) {
            System.out.println(INCORRECT + "\t\t" + e);
            System.out.println("\t\tError running test - " + points + "/" + (full * key.length) + RESET);
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

    private static ArrayList<Appointment> getStudentArrayList(AppointmentList studentAppointmentList) {
        Class alClass = studentAppointmentList.getClass();

        Field[] alFields = alClass.getDeclaredFields();
        alFields[0].setAccessible(true);
        // alFields[0].set(new ArrayList<Appointment>());
        // ArrayList<Appointment>studentList = new ArrayList<>();
        try{
            @SuppressWarnings("unchecked")
            ArrayList<Appointment>studentList = (ArrayList<Appointment>)alFields[0].get(studentAppointmentList);
            return studentList;
        }
        catch(Exception e) {
            System.out.println("Could not grab ArrayList");
        }
        // studentList.add(new Appointment(new CalendarDate(1900,1,1), new Employee("Wilma")));
        // for(Field f:alFields) {
        //     if(f.getType() == ArrayList.class)
        //         try {
        //             @SuppressWarnings("unchecked")
        //             studentList = f.get(studentAppointmentList);
        //         }
        //         catch(Exception e) {

        //         }
        // }
        return null;
    }
}