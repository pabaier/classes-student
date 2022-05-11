
/**
 * Takes a date and an employee and turns them into an appointment 
 *
 * @author Lexus Hartung
 * 
 */
import java.util.*;
public class Appointment{
    // instance variables
    private CalendarDate date;
    private Employee worker;
    /**
     * Constructs a new appointment object
     */
    public Appointment(CalendarDate date, Employee worker){
        this.date = date;
        this.worker = worker;
    }

    //Returns the employee  
    public Employee getEmployee(){
        return worker;
    }
    
    //Returns the date
    public CalendarDate getDate(){
        return date;
    }
    
    public String toString() {
        return "" + date + " " + worker.getName() + "";
    }
}
