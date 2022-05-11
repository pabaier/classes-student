
import java.util.Calendar;

/*<Michael Dudley>*/

public class Appointment {

    private CalendarDate Date;
    private Employee person;


    public Appointment(int year, int month, int day, String name) {
        Date = new CalendarDate(year, month, day);
        person = new Employee(name);
    }

    public CalendarDate getDate() {

        return Date;
    }

    public Employee getPerson() {

        return person;
    }

    public String toString() {

        return Date + " " + person.getName();
    }
}
/*

    public static void main(String[] args) {
        Appointment correctformat = new Appointment(2017, 10,27, "Michael Dudley");
        System.out.println(correctformat);
    }
}
*/
