import java.util.ArrayList;
import java.util.Scanner;

public class AppointmentList{
    private ArrayList <Appointment> appList;
    public AppointmentList(){
        appList = new ArrayList<Appointment>();  
    }
    
   
    public String toString(){
        String appToString = "";
        for (int i = 0; i < appList.size(); ++i){
            appToString += appList.get(i) + "\n";
        }
        return appToString;
    }
    //9.11: ArrayList
    
    public void addToList(CalendarDate c, Employee e){        
        appList.add(new Appointment(c,e));
        return;
    }
    
    public CalendarDate getAppointment(String name){
        CalendarDate appDate = new CalendarDate();
        for (int i = 0; i < appList.size(); ++i){
            if (appList.get(i).getEmployee().getName().equals(name)){
                appDate = appList.get(i).getCalendarDate();
            }
            else{
                appDate = null;
            }
    }
    return appDate;
    }


    public void cancelAppointment(String name){
        //CalendarDate appDate = new CalendarDate();
        for (int i =0; i < appList.size(); ++i){
            if (appList.get(i).getEmployee().getName().equals(name)){
                appList.remove(i);
            //System.out.println("False");
            //System.out.println(name);
            //System.out.println();
            //System.out.println(appList.get(i).getEmployee().getName());
            //System.out.println(appList.size());    
            //System.out.println("True");
                //appList.remove(i);
            }
        }
     //FIX THIS

    }
}