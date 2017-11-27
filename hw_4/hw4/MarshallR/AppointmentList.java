import java.util.*;
/**
 * A class consisting of an array list of appointment objects and methods to
 * cancel or add further appointments.
 *
 * @author (Richard Marshall)
 * 
 */
public class AppointmentList
{
    // instance variables - replace the example below with your own
    private ArrayList<Appointment> appList = new ArrayList<Appointment>();

    /**
     * Constructor for objects of class AppointmentList
     */
    public AppointmentList()
    {
        this.appList = new ArrayList<Appointment>();
    }
    
    public void addToList(CalendarDate c, Employee e) {
        appList.add(new Appointment(e, c));
    }
    
    public CalendarDate getAppointment(String name) {
        CalendarDate date = null;
        
        for (Appointment app : appList) {
            if (name.equals(app.getEmployee().getName())) {
                date = app.getDate();
            }
        }
        
        return date;
    }
    
    public void cancelAppointment(String name) {
        Appointment appToRemove = null;
        
        for (Appointment app : appList) {
            if (app.getEmployee().getName().equals(name)) {
             appToRemove = app;   
            }
        }
        
        appList.remove(appToRemove);
    }
    
    public String toString() {
        String stringToReturn = "";
        
        for (Appointment app : appList) {
            stringToReturn += app.toString() + "\n";
        }
        
        return stringToReturn;
    }

    
}
