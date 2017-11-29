import edu.cofc.grader.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.apache.commons.io.*;
import java.io.File;
import java.io.Console;
import java.util.Scanner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SingleTests {
    
    // calendar
    public static class IsAValidDate extends SingleTest {
        public void exec() {
            setTotalPoints(10);
            int full = 2;
            int half = 1;
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
                    boolean answer;
                    System.out.print(indent() + key[i] + ": ");
                    try{
                        answer = student[i].isAValidDate();
                    }
                    catch(Throwable e){
                        System.out.println(C.INCORRECT + " - Exception with date - " + 0 + "/" + full + C.RESET);
                        continue;
                    }
                    if(key[i].isAValidDate() == answer) {
                        System.out.println(C.CORRECT + " - Correct - " + full + "/" + full + C.RESET);
                        addPoints(full);
                    }
                    else {
                        System.out.println(C.PARTCORRECT + " - Incorrect - " + half + "/" + full + C.RESET);
                        addPoints(half);
                    }
                }
            }
            catch(Throwable e) {
                System.out.println(getIndent() + C.INCORRECT + "Error running test");
                System.out.println(getIndent() + e + C.RESET);
            }
            finally {
                // fetchKey("CalendarDate");
            }
        }
    }

    // appointment
    public static class AppointmentConstructor extends SingleTest {
        public void exec() {
            setTotalPoints(2);
            int full = 2;
            int half = 1;
            try {
                Appointment a = new Appointment(new CalendarDate(2016, 2, 2), new Employee("John"));
                System.out.println(indent() + C.CORRECT + "Correct - " + full + "/" + full + C.RESET);
                addPoints(full);
            }
            catch(Throwable e) {
                try {
                    Appointment a = new Appointment(new Employee("John"), new CalendarDate(2016, 2, 2));
                    System.out.println(indent() + C.CORRECT + "Correct - " + full + "/" + full + C.RESET);
                    addPoints(full);
                }
                catch(Throwable f) {
                    try {
                        Appointment a = new Appointment(2016, 2, 2, new Employee("John"));
                        System.out.println(indent() + C.PARTCORRECT + "Should take CalendarDate as parameter - " + half + "/" + full + C.RESET);
                        addPoints(half);
                    }
                    catch(Throwable g) {
                        // System.out.println(indent() + C.INCORRECT + e);
                        System.out.println(indent() + "Could not find constructor - " + getPointsEarned() + "/" + full + C.RESET);
                    }
                }
            }
        }
    }

    public static class GetEmployee extends SingleTest {
        public void exec() {
            setTotalPoints(3);
            int full = 3;
            int half = 2;
            AppointmentKey key = new AppointmentKey(new CalendarDate(2016, 2, 2),  new Employee("John"));
            Appointment student;
            System.out.print(indent() + key.getEmployee() + " | ");
            try {
                try {
                    student = new Appointment(key.getDate(), key.getEmployee());
                }
                catch (Throwable e) {
                    try{
                        student = new Appointment(key.getEmployee(), key.getDate());
                    }
                    catch(Throwable f) {
                        try{
                            student = new Appointment(key.getDate().getYear(), key.getDate().getMonth(), key.getDate().getDay(), key.getEmployee());
                        }
                        catch(Throwable g) {
                            addPoints(half - 1);
                            System.out.println("Could not create Appointment - " + getPointsEarned() + "/" + full + C.RESET);
                            return;
                        }
                    }
                }
                try{
                    System.out.print(student.getEmployee() + " ");
                }
                catch(Throwable e) {
                    addPoints(half);
                    System.out.println(C.PARTCORRECT + "- Must return an Employee object -  " + getPointsEarned() + "/" + full + C.RESET);
                    return;
                }
                if(student.getEmployee() == key.getEmployee()) {
                    addPoints(full);
                    System.out.println(C.CORRECT + "- Correct - " + full + "/" + full + C.RESET);
                }
                else {
                    addPoints(half);
                    System.out.println(C.PARTCORRECT + "- Incorrect - " + half + "/" + full + C.RESET);
                }
            }
            catch(Throwable e) {
                System.out.println(indent() + C.INCORRECT + e);
                System.out.println(indent() + "Error running test - " + getPointsEarned() + "/" + full + C.RESET);
            }
        }
    }

    public static class GetDate extends SingleTest {
        public void exec() {
            setTotalPoints(3);
            int full = 3;
            int half = 2;
            AppointmentKey key = new AppointmentKey(new CalendarDate(2016, 2, 2),  new Employee("John"));
            Appointment student;
            System.out.print(indent()  + key.getDate() + " | ");
            try {
                try {
                    student = new Appointment(key.getDate(), key.getEmployee());
                }
                catch (Throwable e) {
                    try{
                        student = new Appointment(key.getEmployee(), key.getDate());
                    }
                    catch(Throwable f) {
                        try {
                            student = new Appointment(key.getDate().getYear(), key.getDate().getMonth(), key.getDate().getDay(), key.getEmployee());
                        }
                        catch(Throwable g) {
                            addPoints(half - 1);
                            System.out.println("Could not create Appointment - " + getPointsEarned() + "/" + full + C.RESET);
                            return;
                        }
                    }
                }
                try {
                    System.out.print(student.getDate() + " ");
                }
                catch(Throwable e) {
                    addPoints(half);
                    System.out.println(C.PARTCORRECT + "- Must return CalendarDate object -  " + getPointsEarned() + "/" + full + C.RESET);
                    return;
                }
                if(student.getDate() == key.getDate()) {
                    System.out.println(C.CORRECT + "- Correct - " + full + "/" + full + C.RESET);
                    addPoints(full);
                }
                else {
                    System.out.println(C.PARTCORRECT + "- Incorrect - " + half + "/" + full + C.RESET);
                    addPoints(half);                
                }
            }
            catch(Throwable e) {
                System.out.println(indent() + C.INCORRECT + e);
                System.out.println(indent() + "Error running test - " + getPointsEarned() + "/" + full + C.RESET);
            }
        }
    }

    public static class AppointmentToString extends SingleTest {
        public void exec() {
            setTotalPoints(3);
            int full = 3;
            int half = 2;
            
            AppointmentKey key = new AppointmentKey(new CalendarDate(1762, 9, 12),  new Employee("Yekaterina Alekseyevna"));
            Appointment student;
            System.out.print(indent() + key + " | ");
            try {
                try {
                    student = new Appointment(key.getDate(), key.getEmployee());
                }
                catch (Throwable e) {
                    try{
                        student = new Appointment(key.getEmployee(), key.getDate());
                    }
                    catch(Throwable f) {
                        try {
                            student = new Appointment(key.getDate().getYear(), key.getDate().getMonth(), key.getDate().getDay(), key.getEmployee());
                        }
                        catch(Throwable g) {
                            addPoints(half - 1);
                            System.out.println("Could not create Appointment - " + getPointsEarned() + "/" + full + C.RESET);
                            return;
                        }                    
                    }
                }
                String studentAnswer;
                try {
                    studentAnswer = student.toString().toUpperCase();
                }
                catch(Throwable e) {
                    addPoints(half);
                    System.out.println(C.PARTCORRECT + "- Must return a String object -  " + getPointsEarned() + "/" + full + C.RESET);
                    return;
                }
                if(studentAnswer.contains(key.getDate().toString().toUpperCase()) &&
                studentAnswer.contains(key.getEmployee().getName().toUpperCase())) {
                    System.out.println(C.CORRECT + "- Correct - " + full + "/" + full + C.RESET);
                    addPoints(full);
                }
                else if(studentAnswer.contains(key.getDate().toString().toUpperCase())) {
                    System.out.println(C.PARTCORRECT + "- Date Correct - " + half + "/" + full + C.RESET);
                    addPoints(half);
                }
                else if(studentAnswer.contains(key.getEmployee().getName().toUpperCase())) {
                    System.out.println(C.PARTCORRECT + "- Name Correct - " + half + "/" + full + C.RESET);
                    addPoints(half);
                }
                else {
                    System.out.println(C.PARTCORRECT + "- Incorrect - " + (half - 1) + "/" + full + C.RESET);
                    addPoints(half - 1);                
                }
            }
            catch(Throwable e) {
                System.out.println(indent() + C.INCORRECT + e);
                System.out.println(indent() + "Error running test - " + getPointsEarned() + "/" + full + C.RESET);
            }
            finally {
                // fetchKey("Appointment");
            }
        }
    }

    // appointmentList
    public static class AppointmentListConstructor extends SingleTest {
        public void exec() {
            setTotalPoints(1);
            int full = 1;
            int half = 0;

            try {
                AppointmentList a = new AppointmentList();
                System.out.println(indent() + C.CORRECT + "Correct - " + full + "/" + full + C.RESET);
                addPoints(full);
            }

            catch(Throwable e) {
                System.out.println(indent() + "Could not find constructor - " + getPointsEarned() + "/" + full + C.RESET);
            }
        }
    }

    public static class AddToList extends SingleTest {
        public void exec() {
            AppointmentList studentAppointmentList = new AppointmentList();
            AppointmentListKey key = new AppointmentListKey();
            ArrayList<Appointment> studentList = getStudentArrayList(studentAppointmentList);

            setTotalPoints(3);
            int full = 3;
            int half = 2;
            ArrayList<Appointment> keyList = key.getList();
            CalendarDate d = new CalendarDate(1960, 7, 11);
            Employee edgar = new Employee("Scout Finch");
            System.out.print(indent() + d + " Scout Finch ");
            try {
                try {
                    studentAppointmentList.addToList(d, edgar);
                }
                catch (Throwable e) {
                    try {
                        studentAppointmentList.addToList(edgar, d);
                        addPoints(-1);
                        System.out.print(C.PARTCORRECT + "-1 should be addToList(Employee, CalendarDate)" + C.RESET);
                    }
                    catch(Throwable t) {
                        addPoints(half - 1);
                        System.out.println(C.INCORRECT + "- Could not add appointment to list - " + getPointsEarned() + "/" + full + C.RESET);
                        return;
                    }
                }
                boolean date = false;
                boolean employee = false;
                try{
                    date = studentList.get(0).getDate() == d;
                }
                catch(Throwable t){}
                try{
                    employee = studentList.get(0).getEmployee() == edgar;
                }
                catch(Throwable t){}
                
                if(date && employee){
                    System.out.println(C.CORRECT + "- Correct - " + full + "/" + full + C.RESET);
                    addPoints(full);
                }
                else if(date) {
                    System.out.println(C.PARTCORRECT + "- Date Correct - " + half + "/" + full + C.RESET);
                    addPoints(half);
                }
                else if(employee) {
                    System.out.println(C.PARTCORRECT + "- Employee Correct - " + half + "/" + full + C.RESET);
                    addPoints(half);
                }
                else {
                    System.out.println(C.PARTCORRECT + "- Incorrect - " + (half - 1) + "/" + full + C.RESET);
                    addPoints(half - 1);
                }
            }
            catch(Throwable e) {
                // System.out.println(indent() + C.INCORRECT + e);
                System.out.println("- Error running test - " + getPointsEarned() + "/" + full + C.RESET);
            }
        }
    }

    public static class GetAppointment extends SingleTest {
        public void exec() {
            AppointmentList studentAppointmentList = new AppointmentList();
            AppointmentListKey key = new AppointmentListKey();
            ArrayList<Appointment> studentList = getStudentArrayList(studentAppointmentList);

            setTotalPoints(6);
            int full = 3;
            int half = 2;
        
            ArrayList<Appointment> keyList = key.getList();
            CalendarDate d1 = new CalendarDate(1925, 7, 13);
            Employee e1 =  new Employee("Lillian Bounds");
            Appointment a1;
            try {
                a1 = new Appointment(d1, e1);
            }
            catch(Throwable t) {
                a1 = new Appointment(e1, d1);
            }
            
            CalendarDate d2 = new CalendarDate(1971, 10, 1);
            Employee e2 = new Employee("Walt Disney");
            Appointment a2;
            try {
                a2 = new Appointment(d2, e2);
            }
            catch(Throwable t) {
                a2 = new Appointment(e2, d2);
            }
            
            studentList.add(a1);
            studentList.add(a2);
            try {
                System.out.print(indent() + e2.getName() + " " + d2);
                if(studentAppointmentList.getAppointment("Walt Disney") == d2) {
                    System.out.println(C.CORRECT + " - Correct - " + full + "/" + full + C.RESET);
                    addPoints(full);
                }
                else {
                    System.out.println(C.PARTCORRECT + " - Incorrect - " + half + "/" + full + C.RESET);
                    addPoints(half);
                }
                System.out.print(indent() + "Null");
                if(studentAppointmentList.getAppointment("Roy Disney") == null) {
                    System.out.println(C.CORRECT + " - Correct - " + full + "/" + full + C.RESET);
                    addPoints(full);
                }
                else {
                    System.out.println(C.PARTCORRECT + " - Incorrect - " + half + "/" + full + C.RESET);
                    addPoints(half);
                }
            }
            catch(Throwable e) {
                System.out.println(indent() + C.INCORRECT + e);
                System.out.println(indent() + "Error running test - " + getPointsEarned() + "/" + full + C.RESET);
            }
        }
    }

    public static class CancelAppointment extends SingleTest {
        public void exec() {
            System.out.print(indent());
            AppointmentList studentAppointmentList = new AppointmentList();
            AppointmentListKey key = new AppointmentListKey();
            ArrayList<Appointment> studentList = getStudentArrayList(studentAppointmentList);

            setTotalPoints(3);
            int full = 3;
            int half = 2;

            ArrayList<Appointment> keyList = key.getList();
            CalendarDate d = new CalendarDate(1906, 12, 9);
            Employee e = new Employee("Grace Hopper");
            Appointment a;
            try {
                a = new Appointment(d, e);
            }
            catch(Throwable t) {
                a = new Appointment(e, d);
            }

            studentList.add(a);
            try {
                System.out.print(e.getName() + " " + d + C.RESET);
                studentAppointmentList.cancelAppointment(e.getName());
                if(studentList.size() == 0) {
                    System.out.println(C.CORRECT + " - Correct - " + full + "/" + full + C.RESET);
                    addPoints(full);
                }
                else {
                    System.out.println(C.PARTCORRECT + " - Incorrect - " + half + "/" + full + C.RESET);
                    addPoints(half);
                }
            }
            catch(Throwable t) {
                addPoints(half - 1);
                System.out.println(C.INCORRECT + " - Could not find method - " + getPointsEarned() + "/" + full + C.RESET);
            }
        }
    }


    // HW4
    public static class HW4Driver extends SingleTest {
        public void exec() {
            String lineUp = "\033[1A";
            setTotalPoints(12);
            Scanner in = new Scanner(System.in);

            // opens file D:\School\221\hw_4\grader\testinput.txt
            // /3
            System.out.print(C.RESET + indent() + "Opens the file - " + C.BLUE);
            int code = in.nextInt();
            addPoints(code);
            System.out.println(lineUp + "\t\t\t" + spaces(3) + "/3" + C.RESET);

            // reads the data
            // /3 (3 correct, 1 incorrect) (-1 for incorrect)
            System.out.print(C.RESET + indent() + "Reads the data - " + C.BLUE);
            code = in.nextInt();
            addPoints(code);
            System.out.println(lineUp + "\t\t\t" + spaces(3) + "/3" + C.RESET);

            // cancel appointments
            // /3
            System.out.print(C.RESET + indent() + "Cancels Appointments - " + C.BLUE);
            code = in.nextInt();
            addPoints(code);
            System.out.println(lineUp + "\t\t\t" + spaces(9) + "/3" + C.RESET);

            // quit
            // /3
            System.out.print(C.RESET + indent() + "Quits with Q - " + C.BLUE);
            code = in.nextInt();
            addPoints(code);
            System.out.println(lineUp + "\t\t\t" + spaces(1) + "/3" + C.RESET);
        }
    }


    //HW4 test cases
    // 1 - get file name from user input (testinput.txt)
    // 2 - access file (will have 3 valid, 1 invalid inputs)
    // 3- store 3 appointments in appointmentlist 
    // 4- output the schedule (should contain magic kingdom, hollywood studios, animal kingdom)
    // 5- point off if it contains epcot
    // 6- get user input 'C'
    // 7- get user input "Magic Kingdom"
    // 8 - output the schedule (should not see Magic Kingdom)
    // 9 - get user input 'Q'
    // 10 - should exit







    // helper methods

    // gets the arraylist from the appoinmentlist
    private static ArrayList<Appointment> getStudentArrayList(AppointmentList studentAppointmentList) {
        Class alClass = studentAppointmentList.getClass();

        Field[] alFields = alClass.getDeclaredFields();
        alFields[0].setAccessible(true);
        try{
            @SuppressWarnings("unchecked")
            ArrayList<Appointment>studentList = (ArrayList<Appointment>)alFields[0].get(studentAppointmentList);
            return studentList;
        }
        catch(Throwable e) {
            System.out.println("Could not grab ArrayList");
        }

        return null;
    }

    // Removes the student's class and replaces it with the key class
    private static void fetchKey(String className) {
        File old = new File("D:\\School\\221\\hw_4\\grader\\classes\\" + className + ".class");
        File newFile = new File("D:\\School\\221\\hw_4\\solution\\" + className + ".class");
        File newDir = new File("D:\\School\\221\\hw_4\\grader\\classes");
        FileUtils.deleteQuietly(old);
        try {
            FileUtils.copyFileToDirectory(newFile, newDir);
        }
        catch(Exception e){System.out.println("DIDNT WORK");}
    }

    private static String spaces(int x) {
        return "\033[" + x + "C";
    }

}
