
/**
 * Test driver.
 *
 * Claire Gerwatowski
 * 25 October 2017
 */
import java.util.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.StringWriter;
import java.io.File;
public class HW4
{
    
    public static void main(String[] args) {
        AppointmentList appointmentList = new AppointmentList();
        Scanner scnrFile = new Scanner(System.in);
        FileReader fileReader = null;
        String fileName = "";   
        int charRead = 0;
        boolean validFile = false;
        
        String year = "";
        String month = "";
        String day = "";
        String name = "";
        String lastname = "";
        boolean inputDone = false;
        String lineString = "";
        
        do{
            System.out.print("Enter valid file name: ");
            fileName = scnrFile.next();
            
            try {
                System.out.println("Opening file " + fileName + ".");
                fileReader = new FileReader(fileName);
                Scanner inSS = new Scanner(new File(fileName));
                while (inSS.hasNextLine()) {
                    lineString = inSS.next();
                    if (lineString.length()>1){
                        year = lineString;
                        year = year.substring(1,year.length()-1);
                        month = inSS.next();
                        month = month.substring(1,month.length()-1);
                        day = inSS.next();
                        day = day.substring(1,day.length()-1);
                        name = inSS.next();
                        name = name.substring(1,name.length()-1);
                        int yearInt = Integer.parseInt(year);
                        int monthInt = Integer.parseInt(month);
                        int dayInt = Integer.parseInt(day);
                        
                        
                        CalendarDate date = new CalendarDate(yearInt,monthInt,dayInt);
                        Employee employee = new Employee(name);
                        try {
                            if (date.isAValidDate()){
                                Appointment appt = new Appointment(date,employee);
                                appointmentList.addToList(date,employee);
                                System.out.println(date+" "+name);
                            }
                            else {
                                throw new Exception("Invalid Date");
                            }
                        } catch (Exception excpt) {
                            System.out.println("Caught Exception: " + excpt.getMessage());
                        }
                    }
                }
                validFile = true;
            } catch (FileNotFoundException excpt) {
                System.out.println("Caught FileNotFoundException: " + excpt.getMessage());
                validFile = false;
            } catch (IOException excpt) {
                System.out.println("Caught IOException: " + excpt.getMessage());
                validFile = false;
            }
            
        } while (!validFile);
        System.out.println("\nAppointments: \n" + appointmentList.toString());
        char input = 'n';
        Scanner scan = new Scanner(System.in);
        
        while (input!='Q') {
            System.out.println("Enter 'Q' to quit or 'C' to cancel an appointment");
            input = scan.next().charAt(0);
            if (input=='C') {
                System.out.print("Enter employee name: ");
                String employeeCanc = scan.next();
                appointmentList.cancelAppointment(employeeCanc);
                System.out.println("\nAppointments: \n" + appointmentList.toString());
            }
            
        }
    }
}
