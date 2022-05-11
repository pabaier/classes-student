import java.util.*;

class TestSingleStudents {
    public static void main(String[] args) {
        AppointmentList l = new AppointmentList();
        Employee edgar = new Employee("Scout Finch");
        CalendarDate d = new CalendarDate(1960, 7, 11);
        l.addToList(d, edgar);
        ArrayList<Appointment> a = l.getList();
        System.out.println(a.get(0).getDate()==d);
        System.out.println(a.get(0).getEmployee()==edgar);


    }
}
