
/**
 * Creates a list of all appointments.
 *
 * Claire Gerwatowski
 * 25 October 2017
 */
import java.util.*;
public class AppointmentList
{
    public static List<Appointment> apptList = new ArrayList<Appointment>();
    public AppointmentList() {
        this.apptList = apptList;
        
    }
    
    public String toString() {
        String apptString = "";
        for (int i=0; i<this.apptList.size(); i++) {
            apptString += "Date: ";
            apptString += apptList.get(i);
            apptString += "\n";
        }
        return (apptString);
    }
    
    public void addToList (CalendarDate c, Employee e) {
        apptList.add(new Appointment(c,e));
    }
    
    public CalendarDate getAppointment (String name) {
        CalendarDate getAppt = null;
        for (int i=0; i<apptList.size(); i++) {
            if (apptList.get(i).getEmployee() == name) {
                getAppt = apptList.get(i).getDate();
            }
        }
        return getAppt;
    }
    
    public void cancelAppointment(String name) {
        for (int i=0; i<apptList.size(); i++) {
            if (apptList.get(i).getEmployee().equals(name)) {
                apptList.remove(i);
            }
        }
    }
    
}
