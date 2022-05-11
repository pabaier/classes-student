import java.util.ArrayList;
/**
 * Corey Taylor
 * 10/30/2017
 */
public class AppointmentList
{
    public ArrayList<Appointment> list;
    private CalendarDate date;
    private Employee employee;
    private Appointment appointment;
    
    public AppointmentList(){
         list = new ArrayList(10);
    }
    public String toString(){
        for (int i = 0; i<= list.size()-1; i++)
            {
                System.out.println(list.get(i));
            }
        return "";
    }
    public void addToList(){
        list.add(new Appointment(date,employee));
        
    }
    public CalendarDate getAppointment(Employee employee){
        if (employee != null){return date;}
        else{return null;}
    }
    public void cancelAppointment(String name){
        for(int i = 0; i<= list.size() - 1; i++){
            if(list.contains(name)){
                list.remove(i);
            }
            else {
                return;
            }
        }
        return;
    }
}
