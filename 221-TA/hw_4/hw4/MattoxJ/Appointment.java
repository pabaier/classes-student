
/**
 * Creates appointments out of CalendarDate and Employee classes
 *
 * @author Jacob Mattox
 * @version 10/23/2017
 */
public class Appointment{
    //instance variables
    private CalendarDate date;
    private Employee employee;
    //constructor
    public Appointment(CalendarDate c, Employee e){
        date = c;
        employee = e;
    }
    //returns Employee object
    public Employee getEmployee(){
        return employee;
    }
    //returns CalendarDate object
    public CalendarDate getDate(){
        return date;
    }
    //creates a string of date and employee
    public String toString(){
        return date + " " + employee;
    }
    
}
