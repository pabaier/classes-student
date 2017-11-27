
/**
 * An AppointmentList class that keeps track of all 
 * appointments currently scheduled, 
 * stored in an ArrayList of Appointment instances
 *
 * Jonathan Rabiu
 * 
 */
import java.util.*;
public class AppointmentList
{
    ArrayList<Appointment> empList; 
    private String empName;

    /**
     * Constructor for objects of class AppointmentList
     */
    public AppointmentList(){
        empList = new ArrayList<Appointment>();
    }
    
    public String toString(){
       String appts = empList.get(0).toString(); 
        for(int i = 1; i < empList.size(); i++){
            appts = appts + ", " + empList.get(i).toString(); 
       }
       return appts;
    }
    
    public void addToList (CalendarDate c, Employee e){
        empList.add(new Appointment(c.getYear(), c.getMonth(), c.getDay(), e.getName()));    
    }
    
    public CalendarDate getAppointment(String name){
        // if name has a CalendarDate, return date
        // if name doesn't have a CalendarDate, return null
        for(int i = 0; i < empList.size(); i++){
            Appointment currAppt = empList.get(i);
            if((empList.get(i).getEmployee().getName()).equals(name)){
               return currAppt.getDate();
            }   
        }
        return null;
    }
    
    public void cancelAppointment(String name){//removes appt for the employee with name
        for(int i = 0; i < empList.size(); i++){
            Appointment currAppt = empList.get(i);
            if((empList.get(i).getEmployee().getName()).equals(name)){
                empList.remove(currAppt); 
            }
        }
    }
    /*
    public static void main (String[] args){ //testing in main
        AppointmentList test = new AppointmentList();
        CalendarDate appt1 = new CalendarDate(2017, 4, 5);
        CalendarDate appt2 = new CalendarDate(2017, 10, 22);
        Employee name1 = new Employee("Jonathan");
        Employee name2 = new Employee("Anthony");
        test.addToList(appt1,name1);
        test.addToList(appt2,name2);
        //test.cancelAppointment("Anthony");
        System.out.println(test.getAppointment("Jonathan"));
        System.out.println(test.getAppointment("Anthony"));
        System.out.println(test.getAppointment("Ruth"));// not an employee, should return null
        System.out.println(test.toString());
    }*/
    
}
