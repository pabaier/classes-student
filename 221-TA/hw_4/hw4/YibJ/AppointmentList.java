
/**
 * Write a description of class AppointmentList here.
 *
 * Julie Yib
 * @version (a version number or a date)
 */

import java.util.*;
import java.io.IOException;
import java.io.FileNotFoundException;

public class AppointmentList
{
    private ArrayList<Appointment> list = new ArrayList <> ();
    private String Appointment;

     public void addToList(CalendarDate c, Employee e) throws Exception{
        //testing for a valid date before adding it to the array
         if(!c.isAValidDate()){
            System.out.print("Invalid date exception: " + c.toString());
        }
        else {
            list.add(new Appointment(c,e));
        }
        return;
    }
    
    //returns the calenderdate for each appointment 
    public CalendarDate getAppointment(String name){
        for (int x = 0; x < list.size(); x++){
            if (list.get(x).getEmployee().getName().equals(name))
            {
                return list.get(x).getCalendarDate();
            }
        }
        return null;
    }
    
    public void cancelAppointment(String name){
        //canceling an appointment from the user input of a name 
        for (int x = 0; x < list.size(); x++){
            if ((list.get(x).getEmployee().getName().trim()).equals(name))
            {
                list.remove(x);
            }
        }
    }
    
    //printing everything in an array 
    public String toString(){
        String app = "";
        for (int x = 0; x < list.size(); x++){
            app = app + list.get(x).toString() + "\n";
        }
        return app;
    }
}
