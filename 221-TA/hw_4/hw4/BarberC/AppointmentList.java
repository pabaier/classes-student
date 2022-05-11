import java.util.ArrayList;
public class AppointmentList
{
    private ArrayList appointList;
    public AppointmentList(){
        appointList = new ArrayList<Appointment>();
    }
    public String toString(){
        String s = "";
        for(int i = 0; i<appointList.size(); i++){
            s+= appointList.get(i).toString() + "\n";
        }
        return s;
    }
    public void addToList (CalendarDate c, Employee e){
        appointList.add(new Appointment(c, e));
    }
    public CalendarDate getAppointment(String name){
        for(int i = 0; i<appointList.size();i++){
            Appointment a = (Appointment) appointList.get(i);
            if(a.getEmployee().getName().equals(name))return a.getDate();
            }
        return null;
    }
    public void cancelAppointment(String name){
        for(int i = 0; i<appointList.size(); i++){
            Appointment a = (Appointment) appointList.get(i);
            if(a.getEmployee().getName().equals(name)){
                appointList.remove(i);
                return;
            }
        }
        return;
    }
    
}
