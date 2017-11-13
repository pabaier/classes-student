
/**
 * Models appointments with employees, recording a date and employee info
 *
 * McCauley
 */
public class AppointmentKey
{
    // instance variables - replace the example below with your own
    private Employee emp;
    private CalendarDateKey date;

    /**
     * Constructor for objects of class Appointment
     */
    public AppointmentKey(CalendarDateKey d, Employee e)
    {
        emp = e;
        date = d;
    }
    
    // getter method to return Employee
    public Employee getEmployee(){
        return emp;
    }
      
    // getter method to return Employee
    public CalendarDateKey getDate(){
        return date;
    }
    
    // String representation of an appointment
    public String toString(){
        return date.toString() + " " + emp.getName(); 
    }
}
