
/**
 * Write a description of class HW4 here.
 *
 * @author Lexus Hartung
 * 
 */
import java.io.*;
import java.util.*;
public class HW4
{
   public static void main (String args[]) {
       System.out.println("Please provide an input file: ");
       Scanner scnrKey = new Scanner(System.in);
       String file = scnrKey.nextLine();
       File input = new File(file + ".txt");
       AppointmentList list = new AppointmentList(); 
       try{
           Scanner scnrfile = new Scanner(input);
           try{
               while (scnrfile.hasNextLine()){
                   int year = scnrfile.nextInt();
                   int month = scnrfile.nextInt();
                   int day = scnrfile.nextInt();
                   String name = scnrfile.nextLine();
                   Employee newWorker = new Employee(name.trim());
                   CalendarDate newDate = new CalendarDate (year,month,day);
                   if (newDate.isAValidDate()){
                       list.addToList(newDate, newWorker);
                   }
                   else{
                       System.out.println(name + " doesn't have a valid date.");
                   }
               }
           }
           catch(Exception Ex){
               System.out.println("File not formatted correctly");
           }
       }
       catch(FileNotFoundException Ex){
           System.out.println("File not found");
       }
       System.out.println(list);
       System.out.println("Press q to quit, Press c to cancle an appointment");
       String cont = scnrKey.next();
       while (!cont.equals("q")){
           if (cont.equals("c")){
               System.out.println("Name of employee for cancellation?");
               Scanner keyboard = new Scanner(System.in);
               String cancelName = keyboard.nextLine();
               System.out.println(cancelName);
               list.cancelAppointment(cancelName);
           }
           System.out.println(list);
           System.out.println("q to quit, c to cancle another appointment");
           cont = scnrKey.next();
       }
   }
}
