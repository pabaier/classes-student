import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HW4 {
    public static void main(String args[]) throws FileNotFoundException{

        //File file = new File("namesDates.txt");

        Scanner scnr = new Scanner(System.in);
        System.out.println("enter");
        File inFile =  new File(scnr.next());
        scnr = new Scanner(inFile);
        Scanner docScnr = new Scanner(inFile);

        AppointmentList appointments = new AppointmentList();

        while(docScnr.hasNextLine()){
            String year = docScnr.next();
            String month = docScnr.next();
            String day = docScnr.next();
            String fName = docScnr.next();
            String lName = docScnr.next();

            CalendarDate aptDate = new CalendarDate(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
            Employee aptPerson = new Employee(fName + " "+ lName);

            appointments.addToList(aptDate,aptPerson);

        }
        //not added to appointments yet
        System.out.println(appointments);

        String userChar = "a";
        while(!userChar.equals("q")){
            System.out.println(appointments);
            System.out.println("Would you like to quit (q) or cancel an appointment (c)?");
            Scanner userScnr = new Scanner(System.in);
            userChar = userScnr.nextLine();
            if(userChar.equals("c")){
                String userName = "";
                System.out.println("Please enter the name of appointment you would like to cancel:");
                userName = userScnr.nextLine();
                appointments.cancelAppointment(userName);
            }else if(userChar.equals("q")){
                System.out.println("THE PROGRAM ENDS");
            }
        }




//        System.out.println(appointmentList);
//        [TEST FOR MAIN]
//        Appointment appointmentA = new Appointment(1999, 12, 11, "Phil");
//        System.out.println(appointmentA);
    }

}
