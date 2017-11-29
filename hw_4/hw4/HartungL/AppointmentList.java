
/**
 * Takes an appointment and puts into a list of other appointments
 *
 * @author Lexus Hartung
 */
import java.util.*;
public class AppointmentList
{
    // instance variables - replace the example below with your own
    private ArrayList<Appointment> list; 
    
    /**
     * Constructor for objects of class AppointmentList
     */
    public AppointmentList(){
        this.list = new ArrayList<>();
    }
    
    public String toString(){
        int i = 0;
        String words = "";
        String temp = "";
        for (i = 0; i < list.size(); ++i){
            temp = "" + list.get(i) + "";
            words = words.concat(temp) + " ";
        }
        return words;
    }
    
    /**
     * An example of a method - replace this comment with your own
     */
    public void addToList (CalendarDate c, Employee e){
        list.add(new Appointment(c,e));
    }
    
    public CalendarDate getAppointment(String name){
        int i = 0;
        for (i = 0; i < list.size(); ++i){
           Appointment time = list.get(i);
           Employee worker = time.getEmployee();
           if (worker.getName().equals(name)){
               return time.getDate();
           }
        }
        return null;
    }
    
    public void cancelAppointment(String name){
        int i = 0;
        for (i = 0; i < list.size(); ++i){
            Appointment time = list.get(i);
            Employee worker = time.getEmployee();
            if (worker.getName().equals(name)){
                list.remove(i);
            }
        }
    }
}
