import java.util.*;
/**
 * List of appointments currently scheduled
 *
 * McCauley
 * 
 */
public class AppointmentListKey
{
    // instance variables - replace the example below with your own
    private ArrayList<Appointment> list;

    /**
     * Constructor for objects of class AppointmentList
     */
    public AppointmentListKey()
    {
        list = new ArrayList<>();
    }
    
    public ArrayList<Appointment> getList() {
        return list;
    }

    // Add a new appointment
    public void addToList(CalendarDate d, Employee e){
        
        Appointment a = new Appointment(d, e);    
        list.add(a);
    }
    
    // Return the date of name's appointment, or null
    public CalendarDate getAppointment(String name){
        
        // search list for this person
        boolean found = false;
        int index = 0;
        Appointment a = null;
        CalendarDate returnDate = null;
        while(!found && index < list.size()){
           a = list.get(index);
           if(a.getEmployee().getName().equals(name))
             found = true;
           index++; // moves one ahead
        }
        if (found)
           returnDate = a.getDate();
   
        return returnDate;
    }
    
    // Cancel appointment, if it exists
    public void cancelAppointment(String name){
        
        // find appointment
        // search list for this person
        System.out.println("In cancel appt method.");
        boolean found = false;
        int index = 0;
        int rightIndex = 0;
        CalendarDate returnDate = null;

        while(!found && index < list.size()){

           System.out.println(list.get(index).getEmployee().getName());
           if(list.get(index).getEmployee().getName().equals(name)){  
             found = true;
             System.out.println("Found " + name);
             rightIndex = index;
           }
           index++; // moves one ahead
        } 
        if (found)
          list.remove(rightIndex);
    }
    
    // return a String representation of the appointment list
    public String toString(){
       
       String returnStr = "";
       int index = 0;
       for (index = 0; index < list.size(); index++)
          returnStr += "  " + list.get(index).toString() + "\n";
       
       return returnStr;
    }

}
