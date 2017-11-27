import java.io.*;
import java.util.Scanner;


public class HW4 {
    public static void main (String[] args) throws IOException {
        FileInputStream fileByteStream = null; // File input stream
        Scanner reader = new Scanner(System.in); //reads user inputs.
        Scanner S;

        AppointmentList Test_List = new AppointmentList();



        System.out.println("Enter a name of an input file");
        String fileName = reader.nextLine();
        fileByteStream = new FileInputStream(fileName);
        try {
            S = new Scanner(fileByteStream);
            while(S.hasNext()) {
                int year = S.nextInt();
                int month = S.nextInt();
                int day = S.nextInt();

                String name = S.next();

                CalendarDate loopDate = new CalendarDate(year, month, day);
                try {
                    if (loopDate.isAValidDate()) {
                        Employee loopEmployee = new Employee(name);
                        Test_List.addToList(loopDate, loopEmployee);
                    } else
                        throw new Exception("Invalid date");
                } catch (Exception excpt) {
                    System.out.println(excpt.getMessage());
                }
            }
            if (fileByteStream != null) {
                fileByteStream.close();
            }
        }
         catch(IOException excpt) {
             System.out.println("Caught IOException: " + excpt.getMessage());
         }
        System.out.println(Test_List);

        char userChar = ' ';

        while(Character.toLowerCase(userChar) != 'q'){
            System.out.println("Press Q to quit, Press C to Cancel an appointment.");
            userChar = reader.nextLine().charAt(0);
            if(Character.toLowerCase(userChar) == 'c'){
                System.out.println("Please enter the name of the appointment you wish to cancel.");
                String cName = reader.nextLine();
                Test_List.cancelAppointment(cName);
                System.out.println(Test_List);
            }
        }



    }


}
