
/**
 * Write a description of class AppointmentList here.
 *
 * Steven Higgins
 */
import java.util.*;
public class AppointmentList
{
    // instance variables - replace the example below
    private ArrayList<Appointment> appointments;
    public AppointmentList()
    {
        appointments = new ArrayList<Appointment>();
    }
    public void addToList(CalendarDate c, Employee e){
        Appointment a = new Appointment(c, e);
        appointments.add(a);
    }
    public CalendarDate getAppointment(String name){
        int index = findIndex(name);
        CalendarDate c = new CalendarDate();
        if(index != -1){
            c = appointments.get(index).getDate();
        }
        return c;
    }
    public void cancelAppointment(String name){
        int index = findIndex(name);
        if(index != -1){
            appointments.remove(index);
        }
    }
    public int findIndex(String name) {
        int index = -1;
        for(int i = 0; i <= appointments.size() - 1; i++){
            if(appointments.get(i).getEmployee().getName().equalsIgnoreCase(name)){
                index = i;
                break;
            }
        }
        return index;
    }
    public String toString(){
        String output = "";
        for(int i = 0; i <= appointments.size() - 1; i++){
            output = output + "\n" + appointments.get(i).getDate() + " " + appointments.get(i).getEmployee();
        }
        return output;
    }
}
