
/**
 * Sets the appointment for the employee
 *
 * Orianna Gandy-Wells
 *
 */
public class Appointment
{
    // instance variables - replace the example below with your own
    private Employee person;
    private CalendarDate day;

    /**
     * Constructor for objects of class Appointment
     */
    public Appointment(CalendarDate day, Employee person)
    {
        // initialise instance variables
        this.person = person;
        this.day = day;
        
    
    }

 
    public CalendarDate getDate()
    {
        return day;
    }
    public Employee getEmployee(){
        return person;
    }
    public String toString(){
        return day + " " + person;
    }
}
