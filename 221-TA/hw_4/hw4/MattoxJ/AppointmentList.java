/**
 * Creates an ArrayList for Appointment class
 *
 * @author Jacob Mattox
 * @version 10/23/2017
 */
import java.util.ArrayList;

public class AppointmentList 
{
    //instance variable
    private ArrayList<Appointment> list;
    //zero parameter constructor
    public AppointmentList(){
        list = new ArrayList<Appointment>();
    }
    //checks date and adds appointment to list if good, throws exception if not
    public void addToList(CalendarDate c, Employee e) throws Exception{
            if (c.isAValidDate()){
                Appointment temp = new Appointment(c, e);
                list.add(temp);
        }
            else{
                throw new Exception(" not a valid date");
            }
    }
    //returns appointment if name is in list, otherwise does nothing
    public CalendarDate getAppointment(String name){
        CalendarDate returnValue = null;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getEmployee().getName().equals(name)){
                returnValue = list.get(i).getDate();
            }
        }
        return returnValue;
    }
    //cancels appointment of first instance of name, else does nothing
    public void cancelAppointment(String name){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getEmployee().getName().equals(name)){
                list.remove(i);
                break;
            }
        }
    }
    //builds a string with each name and date. 
    public String toString(){
        String returnString = "\n----Date-------Name-----\n";
        for(int i = 0; i < list.size(); i++){
            returnString += list.get(i) + "\n";
        }
        return returnString;
        }
}
