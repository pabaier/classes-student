
/**
 * Models appointments with employees, recording a date and employee info
 *
 * McCauley
 */
public class AppointmentKey
{
    // instance variables - replace the example below with your own
    private Employee emp;
    private CalendarDate date;

    /**
     * Constructor for objects of class Appointment
     */
    public AppointmentKey(CalendarDate d, Employee e)
    {
        emp = e;
        date = d;
    }
    
    // getter method to return Employee
    public Employee getEmployee(){
        return emp;
    }
      
    // getter method to return Employee
    public CalendarDate getDate(){
        return date;
    }
    
    // String representation of an appointment
    public String toString(){
        return date.toString() + " " + emp.getName(); 
    }
}
