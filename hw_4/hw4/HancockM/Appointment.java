import java.util.ArrayList;
import java.util.Scanner;
/**
 * Write a description of class Appointment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Appointment
{
    private CalendarDate date;
    private Employee emp;
    public Appointment(CalendarDate c, Employee e){
        date = c;
        emp = e;
    }
    public CalendarDate getDate(){
        return this.date; 
    }
    public Employee getEmployee(){
        return this.emp;
    }
    public String toString() {
        return date + " " + emp;
    }
}
