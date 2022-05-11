import java.util.*;
import java.io.*;

/**
 * Write a description of class HW4 here.
 *
 * @author (Richard Marshall)
 * @version (a version number or a date)
 */
public class HW4
{
    public static void main() {
        
        boolean contLoop = true;
        Scanner scnr = new Scanner(System.in);
        AppointmentList apps = new AppointmentList();
        
        System.out.println("Please type in the file path to get the list from:");
        
        try {
            FileInputStream file = new FileInputStream(scnr.nextLine());
            
            Scanner fileScnr = new Scanner(file);
            
            while (fileScnr.hasNext()) {
                String line = fileScnr.nextLine();
                String[] column = line.split("\\s+");
                
                int year = Integer.valueOf(column[0]);
                int month = Integer.valueOf(column[1]);
                int day = Integer.valueOf(column[2]);
                CalendarDate appDate = new CalendarDate(year, month, day);
                
                if (!appDate.isValidDate()) {
                    throw new ArithmeticException("Bad date detected. Omitting offending line.");
                }
                
                String empName = column[3];
                Employee employee = new Employee(empName);
                
                apps.addToList(appDate, employee);
            }
            
            file.close();
        }
        catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("Error: File not found. Ending program.");
            return;
        }
        
        
        System.out.println(apps.toString());
        
        while (contLoop) {
            System.out.println("Enter 'C' to cancel an appointment or 'Q' to quit:");
            
            String userChoice = scnr.nextLine();
            
            if (userChoice.equals("C")) {
                System.out.println("Please enter the name of the employee whom you wish to cancel the appointment of:");
                apps.cancelAppointment(scnr.nextLine());
                System.out.println("Appointment canceled.");
                System.out.println(apps.toString());
            }
            
            else if (userChoice.equals("Q")) {
                contLoop = false;
            }
            else {
                System.out.println("Invalid command.");
            }
        }
    }
}
