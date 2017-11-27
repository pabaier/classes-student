
/**
 * @author Carson Barber
 */
public class Appointment
{
    private Employee emp;
    private CalendarDate date;
    
    public Appointment(CalendarDate date, Employee emp)
    {
        this.emp = emp;
        this.date = date;
    }
    public Employee getEmployee(){
        return emp;
    }
    public CalendarDate getDate(){
        return date;
    }
    public String toString(){
        return date.toString() + "  " + emp.getName();
    }
}
