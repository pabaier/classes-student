import java.util.*;
import java.lang.*;
/**
 * Write a description of class AppointmentList here.
 *
 * @author Shaina Mainar
 * @version (a version number or a date)
 */
public class AppointmentList
{
    // instance variables - replace the example below with your own
    public ArrayList<Appointment> apptList;

    /**
     * Constructor for objects of class AppointmentList
     */
    public AppointmentList()
    {
        // initialise instance variables
        apptList = new ArrayList<Appointment>();

    }
    
    public void addToList(CalendarDate c, Employee e){

        try {
            //System.out.println("Date To Add:"+c);
            //System.out.println("Name To Add:"+e.toString());
            Appointment apt = new Appointment(c, e);
            apptList.add(apt);
        }catch(Exception d){
            d.printStackTrace();
        }

    }
    
    public CalendarDate getAppointment(String name){
        int index = 0;
        CalendarDate x = null;
        for(Appointment a: apptList){
            if(a.getEmployee().getName().equals(name)){
                index = apptList.indexOf(a);
            }
        }
        if(apptList.get(index).getDate() != null){
            x = apptList.get(index).getDate();
        }
        return x;
    }
    
    public void cancelAppointment(String name){
        int index = 0;
        for(Appointment a: apptList){
            if(a.getEmployee().getName().contains(name)){
                index = apptList.indexOf(a);
                break;
            }
        }
        apptList.remove(index);
        
    }
    
    public String toString(){
        //FIXME
        String out = "";
        
        for(Appointment a: apptList){
            out += a.toString() + "\n";
        }
        return out;
    }

}