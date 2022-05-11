
/**
 * Ariel Robinson
 * 
 * The main method that reads from a file and then gets the employee name and date
 * if appointment is valid then it going to be added to list of appointments
 * then asks user if they want to quit or cancel an appointment 
 * 
 */
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
public class HW4
{
    public static void main(String[] args){ 
        Scanner scnr=new Scanner(System.in);

        String fileName;

        int day;
        int year;
        int month;
        String name;
        AppointmentList appointmentList=new AppointmentList();
        CalendarDate date;
        Employee employee;
        Appointment appointment;

        try{
            System.out.println("Enter file name: ");
            fileName=scnr.next();
            FileReader fileInputStream=new FileReader(fileName);
            Scanner reader=new Scanner(fileInputStream);
            //reads the file of appointments

            while(reader.hasNextLine()){
                year=reader.nextInt();
                month=reader.nextInt();
                day=reader.nextInt();
                name=reader.nextLine();
                employee=new Employee(name.trim());
                date=new CalendarDate(year,month,day);
                try{
                    if(date.isAValidDate()){
                        appointment=new Appointment(date,employee);
                        appointmentList.addToList(date, employee);

                    }
                    else{
                        //throws exception if date is not valid
                        throw new Exception();

                    }

                }

                catch(Exception excpt){
                    System.out.println("Not a valid date: " + date.toString());

                }
            }
            //closes file
            fileInputStream.close();

            System.out.println();
            System.out.println("List of appointments: ");
            System.out.println();

            System.out.println(appointmentList.toString());
            System.out.println("If you want to quit enter Q. To cancel an appointment enter C.");
            String userChoice=scnr.nextLine();
            //loop that ends when the user enters Q if they enter C they can cancel an appt
            while(!userChoice.equals("Q")){
                if(userChoice.equals("C") || userChoice.equals("c")){
                    // asks for user to enter name of employee
                    System.out.println("Please enter the employee's name: " );
                    name=scnr.nextLine();
                    appointmentList.cancelAppointment(name);
                    System.out.println("List of appointments: ");
                    System.out.println(appointmentList.toString());
                    System.out.println();
                    System.out.println("Do you want to quit or cancel an appointment?");

                }
                if(userChoice.equals("Q") || userChoice.equals("q")){
                    break;

                }

                userChoice=scnr.nextLine();

            }
        }
        catch(FileNotFoundException excpt){
            System.out.println("File not found");
        }

        catch(IOException excpt){
            System.out.println("File not able to be read");

        }
    }
}

