
/**
 * Sets up appointment info
 *
 * @author Ryan Barrett
 * @version 10/25/17
 */
public class Appointment
{
    private CalendarDate date;
    private Employee emp;
    
    public Appointment(CalendarDate d, Employee e)
    {
        date = d;
        emp = e;
    }
    
    public Employee getEmployee()
    {
        return emp;
    }
    
    public CalendarDate getDate()
    {
        return date;
    }
    
    public String toString()
    {
        return date + " " + emp;
    }
}
