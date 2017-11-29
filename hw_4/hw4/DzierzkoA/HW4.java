/*
*  Author: Adam Dzierzko
*/


import java.io.File;
import java.util.Scanner;

public class HW4 {

    public static void main(String[] args){
        String filename;
        char userInput = ' ';
        Scanner scanner = new Scanner(System.in);
        AppointmentList appointmentList = new AppointmentList();
        String employeeName;
        Scanner fileReader = null;

        System.out.println("Please enter the name of the file: ");
        filename = scanner.next();
        try {
            fileReader = new Scanner(new File(filename));
        }catch (NullPointerException e){
            System.out.println("Could not find the file. Terminating program...");
        }catch (Exception e){
            System.out.println("Could not load the file. Terminating program...");
        }
        while (fileReader.hasNext()){
            int year = fileReader.nextInt();
            int month = fileReader.nextInt();
            int day = fileReader.nextInt();
            String name = fileReader.next();

            CalendarDate date = new CalendarDate(year, month, day);

            if(date.isAValidDate()){
                Employee employee = new Employee(name);
                appointmentList.AddToList(date, employee);
            }else{
                System.out.println( date + " is not a valid date, this appointment will be skipped");
            }
        }

        System.out.println("Appointment list: \n");
        System.out.println(appointmentList);

        while (userInput != 'Q' && userInput != 'q'){
            System.out.println("What would you like to do next?");
            System.out.println("Enter Q to quit or C to cancel an appointment");
            userInput = scanner.next().charAt(0);

            if(userInput == 'C' || userInput == 'c'){
                System.out.println("Please enter the name of the employee for who you want to cancel the appointment");
                employeeName = scanner.next();
                appointmentList.cancelAppointment(employeeName);

                System.out.println("Appointment list after changes:");
                System.out.print(appointmentList);

            }
        }

    }
}
