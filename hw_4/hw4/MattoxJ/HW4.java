/**
 * Write a description of class HW4 here.
 *
 * @author Jacob Mattox
 * @version 10/27/2017
 */
//import statements
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.IOException;

public class HW4
{
    public static void main(){
        //initializing variables
        String filename;
        FileInputStream readFile;
        Scanner fileScnr = null;
        Scanner scnr = new Scanner(System.in);
        int year = 0;
        int month = 0;
        int day = 0;
        String name = "";
        CalendarDate date;
        Employee emp = null;
        AppointmentList list = new AppointmentList();
        
        System.out.println("Please enter a valid filename");
        filename = scnr.nextLine();
        //tries filename for valid file printing error if its invalid
        try{
            readFile = new FileInputStream(filename);
            fileScnr = new Scanner(readFile);
        }
        catch(IOException excpt){
            System.out.println("Sorry! Your file doesn't seem to exist. Please restart.");
            return;
        }
        //reads file and tries to create appointment for each skipping bad dates
        while(fileScnr.hasNext()){
            year = fileScnr.nextInt();
            month = fileScnr.nextInt();
            day = fileScnr.nextInt();
            name = fileScnr.nextLine().trim();
            date = new CalendarDate(year, month, day);
            emp = new Employee(name);
            try{
            list.addToList(date, emp);
        }
            catch(Exception excpt){
                System.out.println(date + excpt.getMessage());
            }
        }
        //gets user input for what to do with the list
        System.out.println(list);
        System.out.println("Enter 'C' to cancel appointment or 'Q' to quit");
        String whatToDo = scnr.next();
        scnr.nextLine();
        //keeps asking user what they want to do and handles their input
        while(!(whatToDo.charAt(0) == 'q' || whatToDo.charAt(0) == 'Q' )){
            if(whatToDo.charAt(0) == 'c'|| whatToDo.charAt(0) == 'C'){
                System.out.println("Please enter name of appointment to cancel.");
                name = scnr.nextLine().trim();
                list.cancelAppointment(name);
                System.out.print(list);
                System.out.println("\nEnter 'C' to cancel appointment or 'Q' to quit");
                whatToDo = scnr.next();
                scnr.nextLine();
            }
            else{
                System.out.println("\nEnter 'C' to cancel appointment or 'Q' to quit");
                whatToDo = scnr.next();
                scnr.nextLine();
            }
        }

    }
    
}