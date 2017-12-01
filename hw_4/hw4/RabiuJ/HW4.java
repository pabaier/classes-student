
/**
 * Test driver to test input files containing appointment data
 *
 * Jonathan Rabiu
 * 
 */;
import java.util.Scanner;
import java.io.*;
import java.io.IOException;
import java.io.FileNotFoundException;

public class HW4
{
    public static void main (String[] args) throws IOException {
        try {
            File file = null;
            Scanner read = null;
            int theyear = 0;
            int themonth = 0;
            int theday = 0;
            String thename = "";

            System.out.println("Enter the name of the file to be read");
            Scanner scnr = new Scanner(System.in);
            String filename = scnr.nextLine();
            file = new File(filename);
            read = new Scanner(file);

            //if the filename exists, create appointment instances
            try{
                theyear = read.nextInt();
                themonth = read.nextInt();
                theday = read.nextInt();
                thename = read.nextLine();
                AppointmentList fileappt = new AppointmentList();
                CalendarDate appt = new CalendarDate(theyear, themonth, theday);
                if(theyear < 1000 || !(appt.isAValidDate())){
                    throw new Exception("Invalid date format"); 
                }

                Employee apptname = new Employee(thename);
                fileappt.addToList(appt, apptname);
                System.out.println(fileappt);//print list of appointments
                
                Scanner control = new Scanner(System.in);
                String input = "c";
                while(!input.equals("q")){
                    
                    System.out.println("Press q to quit or press c to cancel an appointment");
                    input = control.nextLine();
                    
                    if(input.equals("c")){
                        System.out.println("Enter the name of the appointment to cancel");
                        input = control.nextLine();
                        fileappt.cancelAppointment(input);
                   }
                }
            }
            catch (Exception excpt){
                System.out.println("Invalid date format");
            }
        }
        catch (FileNotFoundException invalidfile) {
            System.out.println("Invalid file name");
        }

    }
}

