import java.util.ArrayList;
import java.util.Scanner;
/**
 * Write a description of class AppointmentList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AppointmentList
{
    
    private ArrayList<Appointment> apps = new ArrayList<Appointment>();;
    private Employee emp;
    private CalendarDate date;
    

    /**
     * Constructor for objects of class AppointmentList
     */
    public AppointmentList(){
        ArrayList<Appointment> apps = new ArrayList<Appointment>();
    }
    public void addToList(CalendarDate c, Employee e){
        apps.add(new Appointment(c,e));
    }
    public CalendarDate getAppointment( String name ){
        CalendarDate date2 = new CalendarDate();
        for(int j = 0; j < apps.size(); ++j){
            if(apps.get(j).getEmployee().getName().equals(name)){
                date2 = apps.get(j).getDate();
            }
        }   
        return date2;
    }
    public void cancelAppointment(String name){
        for(int j = 0; j < apps.size(); ++j){
            if(apps.get(j).getEmployee().getName().equals(name)){
                apps.remove(apps.get(j));
            }
        }
    }
    public String toString()
    {
        String ret = "this is the appointment list \n";
        for(int i = 0; i < apps.size(); ++i){
            ret += apps.get(i);
            ret += "\n"; 
        }
        return ret;
    }
}
