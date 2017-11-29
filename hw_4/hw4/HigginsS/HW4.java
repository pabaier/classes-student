
/**
 * Write a description of class HW4 here.
 *
 * Steven Higgins
 * 
 */
import java.util.* ;
import java.io.*;
public class HW4
{
    public static void main(String args[]){
        AppointmentList list = new AppointmentList();
        try{
            System.out.println("Enter a file name. ");
            Scanner scnr = new Scanner(System.in);
            FileInputStream file = new FileInputStream(scnr.nextLine());
            list = importAppointments(file);
        }
        catch (IOException ex) {
            System.out.println("File Name does not exist");
            System.exit(0);
        }
          
        //menu
        
        Scanner input = new Scanner(System.in);
        boolean cont = true;
        while(cont){
            System.out.println("Enter c to cancel an appointment.\nEnter g to get the appointment date for someone.\nEnter q to quit.");
            System.out.println(list);  
            String option = input.nextLine();
            if(option.equals("C") || option.equals("c")){
                System.out.println("Whos appointment are you canceling?");
                list.cancelAppointment(input.nextLine().trim());
            }else if(option.equals("g") || option.equals("g")){
                System.out.println("Enter a Name to find out when their appointment is.");
                System.out.println(list.getAppointment(input.nextLine().trim()));
                
            }
            else if(option.equals("Q") || option.equals("q")){
                System.out.println("Quitting Program...");
                cont = false;
            }
        }
    }   
    
    public static AppointmentList importAppointments(FileInputStream file){
        Scanner scnr = new Scanner(file);
        AppointmentList a = new AppointmentList();
        while(scnr.hasNext()){
            int year = scnr.nextInt();
            int month = scnr.nextInt();
            int day = scnr.nextInt();           
            String name = scnr.nextLine().trim();
            CalendarDate date = new CalendarDate();
            try{
                date = new CalendarDate(year, month, day);
                if(!(date.isAValidDate())){
                    throw new Exception();
                } 
                Employee employee = new Employee(name);
                a.addToList(date, employee);   
            }
            catch(Exception ex){
                System.out.println("Invalid date was in the file it has been ignored.");
                continue;
            }
        }
        System.out.print("\n");
        return a;
        }
    }
