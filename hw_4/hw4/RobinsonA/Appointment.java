
/**
 * Ariel Robinson
 * 
 * if a date is valid the constructor intitalizes the date and employee
 * returns the appoitnment date and the employee
 * there is a to string method to return a string of the appointment date and the employee's name
 * 
 * 
 */
public class Appointment
{
    // instance variables 

    private CalendarDate date=new CalendarDate();
    private Employee employee;

    /**
     * Constructor for objects of class Appointment
     */
    public Appointment(CalendarDate date, Employee employee)
    {

        if (this.date.isAValidDate() ){
            this.date=date;
            this.employee=employee;

        }
    }

    public Employee getEmployee(){
        return employee;

    }

    public CalendarDate getDate(){
        return date;

    }

    public String toString(){
        return date.getYear()+"/" + date.getMonth() +"/" + date.getDay() + " " + employee.getName();

    }
}
