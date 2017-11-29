import java.util.Scanner;
import java.io.*;
/**
 * Write a description of class HW4 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HW4
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class HW4
     */
    public HW4()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void main(String [] args)
    {
        Scanner user = new Scanner(System.in);
        System.out.print("Please enter the name of employee appointment file: ");
        String filename = user.nextLine();
        CalendarDate c = null;
        String name = "";
        AppointmentList schedule = new AppointmentList();
        
        
        try{
           Scanner fileInput = new Scanner(new File(filename));
           
           while (fileInput.hasNextLine()){
              int year = fileInput.nextInt();
              int month = fileInput.nextInt();
              int day = fileInput.nextInt();
              c = new CalendarDate(year, month, day);
              name = fileInput.nextLine().trim();
              try {
                  if (!c.isAValidDate())
                      throw new Exception("Invalid date");
                  schedule.addToList(c, new Employee(name));   
              }catch (Exception e){
                  System.out.println("Invalid data entered: " + c + " No appointment scheduled.");
              }
              
           } // end while
           char answer = ' ';
           do{
               System.out.println("\nThe appointments scheduled are:");
               System.out.println(schedule);
               System.out.println();
               System.out.println("Type 'Q' to quit, or 'C' to cancel an appointment.");
               answer = user.nextLine().charAt(0);
               if (answer == 'C') {
                   System.out.println("Whose appointment do you wish to cancel?");
                   name = user.nextLine();
                   System.out.println("Canceling for " + name);
                   schedule.cancelAppointment(name);
               }
                   
           }while (answer != 'Q');
           
        } catch (FileNotFoundException e){
            System.out.println("File: " + filename + " not found. Terminating.");
        }
    }
}
