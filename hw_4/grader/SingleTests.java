import edu.cofc.grader.*;
import java.lang.reflect.Field;
import java.util.ArrayList;

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
                    System.out.print(indent() + key[i] + ": " + student[i].isAValidDate());
                    if(key[i].isAValidDate() == student[i].isAValidDate()) {
                        System.out.println(C.CORRECT + " - Correct - " + full + "/" + full + C.RESET);
                        addPoints(full);
                    }
                    else {
                        System.out.println(C.PARTCORRECT + " - Incorrect - " + half + "/" + full + C.RESET);
                        addPoints(half);
                    }
                }
            }
            catch(Exception | NoClassDefFoundError e) {
                System.out.println(getIndent() + C.INCORRECT + "Error running test");
                System.out.println(getIndent() + e + C.RESET);
            }
        }
    }

    // appointment
    public static class AppointmentConstructor extends SingleTest {
        public void exec() {
            setTotalPoints(1);
            int full = 1;
            int half = 0;
            try {
                Appointment a = new Appointment(new CalendarDate(2016, 2, 2), new Employee("John"));
                System.out.println(indent() + C.CORRECT + "Correct - " + full + "/" + full + C.RESET);
                addPoints(full);
            }
            catch(Exception e) {
                System.out.println(indent() + C.INCORRECT + e);
                System.out.println(indent() + "Error running test - " + getPointsEarned() + "/" + full + C.RESET);
            }
        }
    }

    public static class GetEmployee extends SingleTest {
        public void exec() {
            setTotalPoints(3);
            int full = 3;
            int half = 2;
            AppointmentKey key = new AppointmentKey(new CalendarDate(2016, 2, 2),  new Employee("John"));
            try {
                Appointment student = new Appointment(key.getDate(), key.getEmployee());
                System.out.print(indent() + key.getEmployee() + " | " + student.getEmployee());
                if(student.getEmployee() == key.getEmployee()) {
                    System.out.println(C.CORRECT + " - Correct - " + full + "/" + full + C.RESET);
                    addPoints(full);
                }
                else {
                    System.out.println(C.PARTCORRECT + " - Incorrect - " + half + "/" + full + C.RESET);
                    addPoints(half);
                }
            }
            catch(Exception e) {
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
            try {
                Appointment student = new Appointment(key.getDate(), key.getEmployee());
                System.out.print(indent()  + key.getDate() + " | " + student.getDate());
                if(student.getDate() == key.getDate()) {
                    System.out.println(C.CORRECT + " - Correct - " + full + "/" + full + C.RESET);
                    addPoints(full);
                }
                else {
                    System.out.println(C.PARTCORRECT + " - Incorrect - " + half + "/" + full + C.RESET);
                    addPoints(half);                
                }
            }
            catch(Exception e) {
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
            try {
                Appointment student = new Appointment(key.getDate(), key.getEmployee());
                String studentAnswer = student.toString().toUpperCase();
                System.out.print(indent() + key + " | " + student);
                if(studentAnswer.contains(key.getDate().toString().toUpperCase()) &&
                studentAnswer.contains(key.getEmployee().getName().toUpperCase())) {
                    System.out.println(C.CORRECT + " - Correct - " + full + "/" + full + C.RESET);
                    addPoints(full);
                }
                else if(studentAnswer.contains(key.getDate().toString().toUpperCase())) {
                    System.out.println(C.PARTCORRECT + " - Date Correct - " + half + "/" + full + C.RESET);
                    addPoints(half);
                }
                else if(studentAnswer.contains(key.getEmployee().getName().toUpperCase())) {
                    System.out.println(C.PARTCORRECT + " - Name Correct - " + half + "/" + full + C.RESET);
                    addPoints(half);
                }
                else {
                    System.out.println(C.PARTCORRECT + " - Incorrect - " + (half - 1) + "/" + full + C.RESET);
                    addPoints(half - 1);                
                }
            }
            catch(Exception e) {
                System.out.println(indent() + C.INCORRECT + e);
                System.out.println(indent() + "Error running test - " + getPointsEarned() + "/" + full + C.RESET);
            }
        }
    }

    //appointmentList
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

            catch(Exception e) {
                System.out.println(indent() + C.INCORRECT + e);
                System.out.println(indent() + "Error running test - " + getPointsEarned() + "/" + full + C.RESET);
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
            key.addToList(new CalendarDate(1960, 7, 11),  new Employee("Scout Finch"));
            try {
                studentAppointmentList.addToList(keyList.get(0).getDate(), keyList.get(0).getEmployee());
                System.out.print(indent() + keyList.get(0).getDate() + " " + keyList.get(0).getEmployee().getName());
                if(studentList.get(0).getDate() == keyList.get(0).getDate() && 
                    studentList.get(0).getEmployee() == keyList.get(0).getEmployee()) {
                    System.out.println(C.CORRECT + " - Correct - " + full + "/" + full + C.RESET);
                    addPoints(full);
                }
                else if(studentList.get(0).getDate() == keyList.get(0).getDate()) {
                    System.out.println(C.PARTCORRECT + " - Date Correct - " + half + "/" + full + C.RESET);
                    addPoints(half);
                }
                else if(studentList.get(0).getEmployee() == keyList.get(0).getEmployee()) {
                    System.out.println(C.PARTCORRECT + " - Employee Correct - " + half + "/" + full + C.RESET);
                    addPoints(half);
                }
                else {
                    System.out.println(C.PARTCORRECT + " - Incorrect - " + (half - 1) + "/" + full + C.RESET);
                    addPoints(half - 1);
                }
            }
            catch(Exception e) {
                System.out.println(indent() + C.INCORRECT + e);
                System.out.println(indent() + "Error running test - " + getPointsEarned() + "/" + full + C.RESET);
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
            key.addToList(new CalendarDate(1925, 7, 13),  new Employee("Lillian Bounds"));
            key.addToList(new CalendarDate(1971, 10, 1),  new Employee("Walt Disney"));
            studentList.add(keyList.get(0));
            studentList.add(keyList.get(1));
            try {
                System.out.print(indent() + keyList.get(1).getEmployee().getName() + " " + keyList.get(1).getDate());
                if(studentAppointmentList.getAppointment("Walt Disney") == keyList.get(1).getDate()) {
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
            catch(Exception e) {
                System.out.println(indent() + C.INCORRECT + e);
                System.out.println(indent() + "Error running test - " + getPointsEarned() + "/" + full + C.RESET);
            }
        }
    }

    public static class CancelAppointment extends SingleTest {
        public void exec() {
            AppointmentList studentAppointmentList = new AppointmentList();
            AppointmentListKey key = new AppointmentListKey();
            ArrayList<Appointment> studentList = getStudentArrayList(studentAppointmentList);

            setTotalPoints(3);
            int full = 3;
            int half = 2;

            ArrayList<Appointment> keyList = key.getList();
            key.addToList(new CalendarDate(1906, 12, 9),  new Employee("Grace Hopper"));
            studentList.add(keyList.get(0));
            try {
                System.out.print(indent() + keyList.get(keyList.size() - 1).getEmployee().getName() + " " + keyList.get(keyList.size() - 1).getDate() + C.RESET);
                studentAppointmentList.cancelAppointment(keyList.get(keyList.size() - 1).getEmployee().getName());
                if(studentList.size() == 0) {
                    System.out.println(C.CORRECT + " - Correct - " + full + "/" + full + C.RESET);
                    addPoints(full);
                }
                else {
                    System.out.println(C.PARTCORRECT + " - Incorrect - " + half + "/" + full + C.RESET);
                    addPoints(half);
                }
            }
            catch(Exception e) {
                System.out.println(indent() + C.INCORRECT + e);
                System.out.println(indent() + "Error running test - " + getPointsEarned() + "/" + full + C.RESET);
            }
        }
    }

    //HW4 test cases






    // helper methods
    private static ArrayList<Appointment> getStudentArrayList(AppointmentList studentAppointmentList) {
        Class alClass = studentAppointmentList.getClass();

        Field[] alFields = alClass.getDeclaredFields();
        alFields[0].setAccessible(true);
        try{
            @SuppressWarnings("unchecked")
            ArrayList<Appointment>studentList = (ArrayList<Appointment>)alFields[0].get(studentAppointmentList);
            return studentList;
        }
        catch(Exception e) {
            System.out.println("Could not grab ArrayList");
        }

        return null;
    }

}