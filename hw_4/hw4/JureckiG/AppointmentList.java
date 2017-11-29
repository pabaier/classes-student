import java.util.ArrayList;
import java.util.List;

public class AppointmentList {
    ArrayList<Appointment> appointmentList; //<------------------MAY NEED TO BE "LIST"

    public AppointmentList() {
        appointmentList = new ArrayList<>();
    }

    public void addToList(CalendarDate c, Employee e){
    //    Appointment newAppointment = new Appointment(c.getYear(), c.getMonth(), c.getDay(), e.getName());
        Appointment newAppointment = new Appointment(c, e);
        appointmentList.add(newAppointment);
    }
    public CalendarDate getAppointment(String name){
        //.get gets the item in the ArrayList
        for(int i = 0 ; i < appointmentList.size(); i++){
            if(appointmentList.get(i).getEmployee().getName().equals(name)){
                return appointmentList.get(i).getDate();
            }
        }
        return null;
    }
    public void cancelAppointment(String name){
        //.remove removes item in the ArrayList
        for(int i = 0 ; i < appointmentList.size(); i++){
            if(appointmentList.get(i).getEmployee().getName().equals(name)){
                appointmentList.remove(i);
            }
        }
    }




    public String toString() {
        String results = "";
        for(int i = 0; i < appointmentList.size(); i++){
           results += appointmentList.get(i) + "\n";
        }

        return results;
    }
}
