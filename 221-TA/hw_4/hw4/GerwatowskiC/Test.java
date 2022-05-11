public class Test{
    public static void main(String[] args) {
        Appointment a = new Appointment(new CalendarDate(1977, 2, 3), new Employee("Homer"));
        System.out.println(a.getEmployee());
    }
}
