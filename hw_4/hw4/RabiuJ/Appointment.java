
/**
 * Class to manage appointments.
 *
 * Jonathan Rabiu
 * 
 */
import java.util.*;
public class Appointment
{
    // instance variables - replace the example below with your own
    private Employee employee;
    private CalendarDate date;
    
    /**
     * Constructor for objects of class Appointment
     */
    public Appointment(CalendarDate c, Employee empName)
    {
        // initialise instance variables
        employee = empName;
        date = c; 
        
    }
    
    public Employee getEmployee(){
        return employee;
    }
    
    public CalendarDate getDate(){//returns a date
        return date;
    }
    
    public String toString(){
        return date.getYear() + "/" + date.getMonth() + "/" + date.getDay() + " " + employee.getName();
    }
    /* test 
    public static void main (String[] args){
        Appointment test = new Appointment(2017, 5, 12, "Jonathan R");
        System.out.println(test.getEmployee());
        System.out.println(test.getDate());
        System.out.println(test.toString());
    }*/
    
}
