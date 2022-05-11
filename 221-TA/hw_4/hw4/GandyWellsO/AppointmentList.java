
/**
 * Write a description of class AppointmentList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class AppointmentList
{
    // instance variables - replace the example below with your own
    
    ArrayList<Appointment> appList;
   
    /**
     * Constructor for objects of class AppointmentList
     */
    public AppointmentList()
    {
        // initialise instance variables
      this.appList = new ArrayList<>();
      
      
    }
    public String toString(){
        String allApps = "";
        for(int i = 0; i < appList.size(); i++){
            allApps += appList.get(i) + "\n";
        }
        return allApps;
    }
    public void addToList(CalendarDate c, Employee e){
        Appointment appointment = new Appointment(c, e);
        appList.add(appointment);
        
    }
    public CalendarDate getAppointment(String name){
      
       for(int i = 0; i< appList.size(); i++){
           if(name.equals(appList.get(i).getEmployee().getName())){
               return appList.get(i).getDate();
            }
        }
        
      return null;  
    }
    
    
    public void cancelAppointment(String name){
        CalendarDate appDate = getAppointment(name);
       
            if(appDate != null){
               for (int i = 0; i < appList.size(); i++){
                   if(name.equals(appList.get(i).getEmployee().getName())){
                       appList.remove(i);
                    }
                }
            }
        
    }
 }

   
