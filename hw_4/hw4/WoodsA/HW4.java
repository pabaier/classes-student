
/**
 * Write a description of class HW4 here.
 *
 * @author Ashley Woods
 */
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
public class HW4
{
    public static void Main() throws FileNotFoundException {
        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String fileName = scnr.next();
        try{
            FileInputStream file = new FileInputStream(fileName);
            Scanner fileScnr = new Scanner(file);
            CalendarDate date = new CalendarDate(fileScnr.nextInt(), fileScnr.nextInt(), fileScnr.nextInt());
            String nextName = fileScnr.nextLine().trim();
            AppointmentList appointmentList = new AppointmentList();
            String userInput;
            while (fileScnr.hasNextLine()) {
                try {
                    if (date.isAValidDate()) {
                        Employee emp = new Employee(nextName);
                        appointmentList.addToList(date,emp);
                    }
                    else {
                        throw new Exception ("Invalid appointment date");
                    }
                }
                catch(Exception b) {
                    System.out.println("Invalid appointment date for " + nextName);
                }
                date = new CalendarDate(fileScnr.nextInt(), fileScnr.nextInt(),fileScnr.nextInt());
                nextName = fileScnr.nextLine().trim();
            }
            try {
                if (date.isAValidDate()) {
                    Employee emp = new Employee(nextName);
                    appointmentList.addToList(date,emp);
                }
                else {
                    throw new Exception ("Invalid appointment date");
                }
            }
            catch(Exception b) {
                System.out.println("Invalid appointment date for " + nextName);
            }
            boolean Continue = true;
            boolean bad = true;
            while (Continue) {
                System.out.println("Name             |Date             ");
                System.out.println("-----------------------------------");
                System.out.println(appointmentList.toString());
                System.out.print("Press Q to quit or C to cancle an appointment: ");
                userInput = scnr.next();
                if (userInput.equalsIgnoreCase("C")) {
                    System.out.print("Enter the name of the person whose appointment you would like to cancle: ");
                    scnr.nextLine();
                    String Name = scnr.nextLine();
                    appointmentList.cancleAppointment(Name);
                }
                else if (userInput.equalsIgnoreCase("Q")) {
                    Continue = false;
                }
                else{
                    bad = true;
                    while (bad) {
                        System.out.print("Enter Q to quit or C to cancle an appointment: ");
                        userInput = scnr.next();
                        if (userInput.equalsIgnoreCase("C") || userInput.equalsIgnoreCase("Q")) {
                            bad = false;
                            if (userInput.equalsIgnoreCase("Q")){
                                Continue = false;
                            }
                            else if(userInput.equalsIgnoreCase("C")) {
                                 System.out.print("Enter the name of the person whose appointment you would like to cancle: ");
                                 scnr.nextLine();
                                 String Name = scnr.nextLine();
                                 appointmentList.cancleAppointment(Name);
                            }
                        }
                    }
                }
            }
            try{
                file.close();
            }
            catch(IOException c){
            }
        } 
        catch(FileNotFoundException e){
            System.out.println("There was a problem with the name of your file. The program has been terminated.");
        
    }
    }
}
