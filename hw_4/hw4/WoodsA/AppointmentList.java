
/**
 * Write a description of class AppointmentList here.
 *
 * @author Ashley Woods
 */
import java.util.ArrayList;
public class AppointmentList
{
    // instance variables - replace the example below with your own
    private ArrayList<Appointment> ListOfAppointments;

    //constructor
    public AppointmentList() {
        // initialise instance variables
        ListOfAppointments = new ArrayList<Appointment>();
    }

    public String toString() {
        for (int i = 0; i<ListOfAppointments.size(); i++) {
            //System.out.println("Name: "  +ListOfAppointments.get(i).getEmployee().getName() + "     Date--" + ListOfAppointments.get(i).getDate());
            System.out.printf("%-20s %-10s" + " %n",ListOfAppointments.get(i).getEmployee().getName(), ListOfAppointments.get(i).getDate());
        }
        return "";
    }
    
    public void addToList(CalendarDate c, Employee e) {
        ListOfAppointments.add(new Appointment(e,c));
    }
    
    public CalendarDate getAppointment(String name) {
        CalendarDate date = null;
        for (int i=0; i<ListOfAppointments.size(); i++) {
            if (ListOfAppointments.get(i).getEmployee().getName().equalsIgnoreCase(name)) {
                date = ListOfAppointments.get(i).getDate();
            }
        }
        return date;
    }
    
    public void cancleAppointment(String name) {
        for (int i=0; i<ListOfAppointments.size(); i++) {
            if (ListOfAppointments.get(i).getEmployee().getName().equalsIgnoreCase(name)) {
                ListOfAppointments.remove(i);
            }
        }
    }
}
