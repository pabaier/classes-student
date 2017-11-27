
/**
 * A class for making an appointment with a date and an employee associated
 *
 * @author (Richard Marshall)
 * 
 */
public class Appointment
{
    // instance variables - replace the example below with your own
    private Employee employee;
    private CalendarDate date;

    /**
     * Constructor for objects of class Appointment
     */
    public Appointment(Employee employee, CalendarDate date) {
        if (date.isValidDate()) {
            this.employee = employee;
            this.date = date;
        }
    }
    
    //getter for date
    public CalendarDate getDate() {
        return date;   
    }
    
    //getter for employee
    public Employee getEmployee() {
        return employee;   
    }
    
    public String toString() {
        return date.toString() + " " + employee.getName();
    }

    
}
