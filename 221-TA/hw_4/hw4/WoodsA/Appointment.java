
/**
 * Write a description of class Appointment here.
 *
 * @author Ashley Woods
 */
public class Appointment
{
    // instance variables - replace the example below with your own
    private CalendarDate date;
    private Employee employee;
    //constructor
    public Appointment(Employee emp, CalendarDate imputDate) {
        date = imputDate;
        employee = emp;
    }

    public Employee getEmployee() {
        return employee;
    }
    
    public CalendarDate getDate(){
        return date;
    }
    
    public String printString() {
        return "" + date + " " + employee;
    }
}
