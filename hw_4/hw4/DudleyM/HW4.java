/*
* <Michael Dudley>
* */





import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HW4 {
    public static void main(String[] args) {
        try{
            System.out.println("Enter the file name: ");
            Scanner scan = new Scanner(System.in);
            File file = new File(scan.nextLine());
            Scanner filescanner = new Scanner(file);
            AppointmentList newAppointmentList = new AppointmentList();
            while(filescanner.hasNext()){
                String year = filescanner.next();
                String month = filescanner.next();
                String day = filescanner.next();
                String firstName = filescanner.next();
                String lastName = filescanner.next();
                int yearDate = Integer.parseInt(year);
                int monthDate = Integer.parseInt(month);
                int dayDate = Integer.parseInt(day);
                CalendarDate Date = new CalendarDate(yearDate,monthDate,dayDate);
                Employee person = new Employee(firstName + " " + lastName);
                if(Date.isAValidDate()){
                    newAppointmentList.addToList(Date,person);
                }else{
                    throw new IllegalArgumentException();
                }
            }
            System.out.println(newAppointmentList);

            boolean quit = false;
            while(!quit){
                System.out.println("Press Q if you would like to quit?");
                System.out.println("Press C if you would like to cancel the appointment?");
                String userInput = scan.nextLine();
                if(userInput.equals("c") || userInput.equals("C")){
                    System.out.println("Whose appointment would you like to cancel? ");
                    String userinputName = scan.nextLine();
                    newAppointmentList.cancelAppointment(userinputName);
                }else if(userInput.equals("q") || userInput.equals("Q")){
                    quit = true;
                }else{
                    System.out.println("Needs to be C or Q");
                }
                System.out.println("");
                System.out.println(newAppointmentList);

            }

        }catch (FileNotFoundException e) {
            System.err.println("File Invalid");
        }catch(NumberFormatException e){
            System.err.println("unable to parse Date or Name");
        }catch(IllegalArgumentException e){
            System.err.println("Date or Name not valid");
        }
    }
}