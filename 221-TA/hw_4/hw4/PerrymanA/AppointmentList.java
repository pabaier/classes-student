
/**
 * Asa Perryman
 */
import java.util.*;
public class AppointmentList
{
    private ArrayList<Appointment> appointmentList;

    public AppointmentList(){
        appointmentList = new ArrayList<Appointment> ();

    }
    
     public ArrayList<Appointment> getAppointment(){
        return appointmentList;
    }
    
    public String toString(){
     String stringForm = appointmentList.toString();
     return stringForm;
    }
    
    public void addToList(CalendarDate c, Employee e){
        Appointment newAppt = new Appointment(c,e);
        appointmentList.add(newAppt);
    }
    
    public CalendarDate getAppointment(String name){
        for(int i = 0; i < appointmentList.size(); ++i){
            if(appointmentList.get(i).getEmployee().getName().equals(name)){
                return appointmentList.get(i).getDate();
            }
        }
        return null;
    }
    
    public void cancelAppointment(String name){
        for(int i = 0; i < appointmentList.size(); ++i){
            if(appointmentList.get(i).getEmployee().getName().equals(name)){
                appointmentList.remove(i);
            }
        }
    }
}
   