
/**
 * Asa Perryman
 */
import java.util.*;
public class Appointment
{
    private CalendarDate date;
    private Employee employee;

    
    public Appointment(CalendarDate date, Employee employee)
    {
        this.employee = employee;
        this.date = date;
    }

    
    public CalendarDate getDate(){
        if(date.isAValidDate() == true){
            return date;
        }
        else{
            return null;
        }
    }
    
    public Employee getEmployee(){
        return employee;
    }
    
    public String toString(){
        String myString = date.getYear() + "/" + date.getMonth() +
                        "/" + date.getDay() + "  "+ employee.getName();
        //System.out.println(myString);
        return myString;
    }
    
}
