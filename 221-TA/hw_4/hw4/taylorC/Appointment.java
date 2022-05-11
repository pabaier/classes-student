import java.util.Scanner;
/**
 * Corey Taylor
 * 10/30/2017
 */
public class Appointment{
    private CalendarDate date;
    private Employee employee;
    public Employee getEmployee(){
        return this.employee;
    }
    public CalendarDate getDate(){
        return this.date;
    }
    
    public String toString(){
        return this.date + " " + this.employee;
    }
    public Appointment(CalendarDate c, Employee e){
        this.date = c;
        this.employee = e;
    }
}
