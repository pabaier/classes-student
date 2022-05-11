/**
 * Asa Perryman
 */

import java.util.*;
import java.io.*;

public class HW4 {

    public static void main(String[] args){
        CalendarDate calendarDate = new CalendarDate();
        AppointmentList appointmentList = new AppointmentList();
        String eachLine = "";

        try{
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the name of the file ");
            String lineInFile = input.nextLine();
            File firstInput= new File(lineInFile);
            Scanner myFile = new Scanner(firstInput);

            try{    
                while(myFile.hasNextLine()){

                    int year = myFile.nextInt();
                    int month = myFile.nextInt();
                    int day = myFile.nextInt();
                    calendarDate = new CalendarDate(year, month, day);

                    String name = myFile.nextLine();

                    if(calendarDate.isAValidDate()){
                        appointmentList.addToList(calendarDate, new Employee(name.trim()));
                        System.out.println(appointmentList);
                    }

                    else{
                        throw new IllegalArgumentException();
                    }

                    String userChar = "";
                    System.out.println("To cancel an appointment type C. To quit type Q.");
                    userChar = input.next();

                    while(userChar.equals("C") || userChar.equals("c")){
                        System.out.println("To cancel an appointment, enter name: ");
                        String nameFromFile = input.nextLine();

                        for(int i = 0; i < appointmentList.size(); ++i){
                            if(appointmentList.getAppointment().get(i).getEmployee().getName().equals(nameFromFile)){
                                appointmentList.cancelAppointment(name);
                            }
                            System.out.println("Appointment canceled");
                        }
                    }
                }

            }

            catch(IllegalArgumentException invDate){
                System.out.println("Date entered is invalid.");
            }
        }

        catch(FileNotFoundException notFound){
            System.out.println("The file cannot be found.");
        }
    }
}

