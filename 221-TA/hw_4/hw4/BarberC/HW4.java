import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Carson Barber
 */
public class HW4
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("Please type the name of the file to be read.");
        Scanner scnr = new Scanner(System.in);
        String fileName = scnr.nextLine();
        AppointmentList appList = new AppointmentList();
        try{
            FileInputStream fileStream = new FileInputStream(fileName);
            Scanner fileReader = new Scanner(fileStream);
            while(fileReader.hasNext()){
                CalendarDate date = new CalendarDate(fileReader.nextInt(), fileReader.nextInt(), fileReader.nextInt());
                Employee emp = new Employee(fileReader.next());
                //fileReader.nextLine();////////////////////////////////////////////////
                try{
                if(!date.isAValidDate())throw new Exception(date.toString());
                else appList.addToList(date,emp);
                }
                catch (Exception e){
                    System.out.println("Error:" + e + "is an invalid date");
                }
            }
        }
        catch (IOException e){
            System.out.println("Error: file not found. Aborting...");
            return;
        }
        System.out.println(appList.toString());
        System.out.println("If you wish to quit, press (q). if you with to cancel an appointment, press (c).");
        String s = scnr.nextLine();
        while(!s.equals("q")){//quit program if q is pressed
            if(s.equals("c")){//cancel appointment if c is pressed
                System.out.println("Please type the name of the person whose appointment you would like to cancel.");
                String name = scnr.nextLine();
                appList.cancelAppointment(name);
                System.out.println(appList.toString());
            }
            System.out.println("If you wish to quit, press (q). if you with to cancel an appointment, press (c).");
            s = scnr.nextLine();
        }
        System.out.println("Quitting...");
    }
}