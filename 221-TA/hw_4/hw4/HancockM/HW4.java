import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
/**
 * Write a description of class HW4 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HW4
{
    public static void main(String[] args) throws IOException{
        FileInputStream fileByteStream = null; // File input stream
        Scanner inFS = null; 
        AppointmentList apps = new AppointmentList();
        
        Scanner scnr = new Scanner(System.in);
        Scanner ui = new Scanner(System.in);
        System.out.println("Provide the name of your input file");
        String fileName = scnr.nextLine();
        try{
            fileByteStream = new FileInputStream(fileName);
            inFS = new Scanner(fileByteStream);
            
            while(inFS.hasNext()){
                int year = inFS.nextInt();
                int month = inFS.nextInt();
                int day = inFS.nextInt();
                CalendarDate date = new CalendarDate(year, month, day);
                try{
                    if (date.isAValidDate() == true)
                    throw new Exception("Invalid Date");
                }
                catch(Exception excpt){
                    System.out.println(excpt.getMessage());
                    System.out.println("Cannot complete appointment list");
                }
                Employee emp = new Employee(inFS.nextLine().trim());
                apps.addToList(date,emp);
            }
            fileByteStream.close(); // close() may throw IOException if fails
            System.out.print(apps);
            System.out.println("If you wish to cancel an appointment, enter C, otherwise, enter Q to quit.");
            char userInput = scnr.next().charAt(0);
            while(userInput != 'Q'){
                if(userInput == 'C'){
                
                    System.out.println("Type the name that you wish to cancel:");
                    String can = ui.nextLine().trim();
                    apps.cancelAppointment(can);
                    
                    System.out.print(apps);
                }
                System.out.println("If you wish to cancel an appointment, enter /'C/', otherwise, enter /'Q/' to quit.");
                userInput = scnr.next().charAt(0);
            }
            if(userInput == 'Q'){
                System.out.println("Quitting");
            }
        }
        catch(IOException excpt){
            System.out.println("Caught IOException: " + excpt.getMessage());
        }

        return;
   }
}
