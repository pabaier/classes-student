
/**
 * Ariel Robinson
 *
 * creates an array list of appointments
 * can add new appointments if appointment is valid
 * can cancel appointments or get a date of a specific appointment
 */
import java.util.ArrayList;
import java.util.Arrays;

public class AppointmentList
{
    // instance variables 

   
    //initilzing employee and date

    private Employee employee;
    private CalendarDate date;
    //initilizing new array list

    ArrayList<Appointment> appointmentList;
     /**
     * Constructor for objects of class AppointmentList
     * 
     */

    public AppointmentList()
    {
        appointmentList=new ArrayList<Appointment>();

    }

    public void display(){
        int i=0;
        for(i=0;i<appointmentList.size(); i++){
            System.out.println(appointmentList.get(i));

        }

    }
    //returns the list of appointments 
    public String toString(){
        int i=0;
        String builder="";
        for(i=0; i<appointmentList.size();i++){
            builder+= appointmentList.get(i) +"\n";

        }
        return builder;

    }
    //if appointment is valid then it is added to the appt list

    public void addToList(CalendarDate c, Employee e){
        Appointment appointment= new Appointment(c, e);
        appointmentList.add(appointment);
    }
    //returns the appt date of the selected person

    public CalendarDate getAppointment(String name){

        CalendarDate date=null;
        for(int i=0;i<appointmentList.size(); i++){

            if(appointmentList.get(i).getEmployee().getName().equals(name)){
                date=appointmentList.get(i).getDate();
                break;
            }

        }
        return date;

    }
    //cancels the appointment of the selected person if they have an appointment 

    public void cancelAppointment (String name){
        for(int i=0;i<appointmentList.size(); i++){

            if(appointmentList.get(i).getEmployee().getName().equals(name)){
                appointmentList.remove(i);
                break;
            }
        }

    }
}
