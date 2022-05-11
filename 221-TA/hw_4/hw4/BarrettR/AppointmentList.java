
/**
 * Write a description of class AppointmentList here.
 *
 * @author Ryan Barrett
 * @version 10/26/17
 */
import java.util.*;
public class AppointmentList
{
    ArrayList<Appointment> list;
    
    public AppointmentList(){
        list = new ArrayList<Appointment>();
    }
    
    public void addToList(CalendarDate c, Employee e)
    {
        Appointment a = new Appointment(c, e);
        list.add(a);
    }
    
    public CalendarDate getAppointment(String n){
        CalendarDate date = null;
        for(int i = 0; i < list.size(); i++)
            if(list.get(i).getEmployee().getName().equals(n))
                date = list.get(i).getDate();
        return date;
    }
    
    public void cancelAppointment(String n){
        for(int i = 0; i < list.size(); i++)
            if(list.get(i).getEmployee().getName().equals(n))
                list.remove(i);
    }
    
    public String toString()
    {
        String fullString = "";
        for(int i = 0; i < list.size(); i++)
            fullString = list.get(i) + "\n";
        return fullString;
    }
}
