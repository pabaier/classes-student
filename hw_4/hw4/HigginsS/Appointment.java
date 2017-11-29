
/**
 * Write a description of class AppointmentList here.
 *
 * Steven Higgins
 * 
 */
import java.util.*;

public class Appointment
{
    //
    private CalendarDate date;
    private Employee person;
    
    public Appointment(CalendarDate date, Employee person) {
        this.date = date;
        this.person = person;
    }
    /*
    public Appointment(){
        this.date = this.date;
        this.person = this.person;
    }
    */
    public Employee getEmployee(){
        return person;
    }
    public CalendarDate getDate(){
        return date;
    }
    public String toString() {
        return date + " " + person ;
    }
}
