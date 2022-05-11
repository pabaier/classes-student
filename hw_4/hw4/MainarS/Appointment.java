
/**
 * Write a description of class Appointment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Appointment
{
    // instance variables - replace the example below with your own
    String name;
    private Employee employee;
    private CalendarDate date;
    
    /**
     * Constructor for objects of class Appointment
     */
    public Appointment(CalendarDate date, Employee employee)
    {
        // initialise instance variables
        
        this.employee = employee;   //new Employee(name);
        this.date = date;           //new CalendarDate();
    }
    public Employee getEmployee(){
        return this.employee;
    }
    public CalendarDate getDate(){
        return this.date;
    }
    public String toString(){
        return date.toString() + " " + employee.toString();
    }
    

   
}
