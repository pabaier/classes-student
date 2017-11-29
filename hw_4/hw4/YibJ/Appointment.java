
public class Appointment
{
    private CalendarDate date;
    private Employee employee;
    
    public Appointment (CalendarDate date, Employee employee){
        this.date = date;
        this.employee = employee;    
    }
    
    public Employee getEmployee(){
        return this.employee;
    }
   
    public CalendarDate getCalendarDate(){
        return this.date;
    }

    public String toString(){
        date.toString();
        employee.toString();
        return date + " " + employee;   
    }

}
