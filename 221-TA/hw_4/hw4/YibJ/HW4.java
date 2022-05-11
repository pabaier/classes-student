
/**
 * main method 
 * 
 * Julie Yib 
 * 
 */
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class HW4
{
    
    public static void main(String [] args) throws Exception 
    {
        Scanner input = new Scanner(System.in);
        String fileName = "";
        
        
        AppointmentList checkLine = new AppointmentList();
        
        boolean continueProgram = true;
        
        System.out.println("Please insert a file name: ");
        fileName = input.nextLine();

        try {
            Scanner fileScan = new Scanner(new File (fileName));
            while (fileScan.hasNextLine()){
                int year = fileScan.nextInt();
                int month = fileScan.nextInt();
                int day = fileScan.nextInt();
                String name = fileScan.nextLine().trim();
               try {
                checkLine.addToList(new CalendarDate(year, month, day), new Employee(name));
               }
               
               catch (Exception e){
                System.out.println(e.getMessage() + " caught exception");
               }
            }
            fileScan.close();
            }
            catch (FileNotFoundException excpt) {
                System.out.println("File is invalid, enter a valid file");
            }
        
        System.out.println("Appointment List: ");
        System.out.println(checkLine.toString());
       
        while(continueProgram) {
            char nextInput= ' ';
            String cancelAppt="";
            System.out.println("Choose 'C': to cancel appointment or 'Q': to quit the program");
            nextInput = input.nextLine().toUpperCase().charAt(0);
            
            if (nextInput == 'C'){
                System.out.println("Enter the appointment's name for cancellation: ");
                cancelAppt = input.nextLine();
                checkLine.cancelAppointment(cancelAppt);
                System.out.println("Updated Appointment List: ");
                System.out.println(checkLine.toString());
            }   
        
            else if (nextInput == 'Q'){
                continueProgram = false;
                System.out.println("Please try again.");
            }
        }
        
     }
}
