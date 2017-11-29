
/**
 * Does stuff for hw4 assignment...
 * I had issues inputting files, but everything else works perfectly
 *
 * @author Ryan Barrett
 * @version 10/28/17
 */
import java.util.*;
import java.io.*;
public class HW4
{
    public static void main(String[]args) throws Exception
    {
        //initializes necessary objects and such and gets a file name from user
        AppointmentList list = new AppointmentList();
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a file name to be read: ");
        String file = scan.nextLine();
        FileInputStream reader = null;
        boolean works = false;

        //tries to access user input file
        try{
            reader = new FileInputStream(file);
            works = true;
        }
        catch(FileNotFoundException e){
            System.out.println("Incorrect file name.");
        }

        //runs only if the input files was accessed
        if(works){
            Scanner fileScanner = new Scanner(reader);  //creates scanner to access the file
            do{
                String text = fileScanner.nextLine();   //gets a line of input from the file
                for(int i = 0; i < text.length(); i++)  //removes the > & <
                    if(text.charAt(i) == '<' || text.charAt(i) == '>')
                    {
                        text = text.substring(0, i) + " " + text.substring(i + 1);
                        i--;
                    }

                //creates a scanner to access the input from file
                Scanner textScanner = new Scanner(text);
                try{

                    //creates a calendardate object with the input from the file
                    int year = textScanner.nextInt();
                    int month = textScanner.nextInt();
                    int day = textScanner.nextInt();
                    CalendarDate date = new CalendarDate(year, month, day);

                    //creates an employee object from the input from the file
                    String firstName = textScanner.next();
                    Employee emp;
                    //used to see if the input file had one or two names for the employee name
                    if(!textScanner.hasNextInt() && textScanner.hasNext())
                    {
                        String lastName = textScanner.next();
                        String name = firstName + " " + lastName;
                        emp = new Employee(name);
                    }
                    else
                        emp = new Employee(firstName);

                    //ensures the date is a valid date
                    if(date.isAValidDate())
                        list.addToList(date, emp);
                    else
                        System.out.println("Incorrect date.");

                }catch(Exception excpt){
                    System.out.println("Incorrect input."); //error message if the input went wrong
                }
                finally{
                    reader.close();     //closes input file
                }
            }while(fileScanner.hasNextLine());  //stops running once there's no more input

            //prints out all appointments and lets user cancel appointments
            boolean quit = false;
            String userInput = "";
            while(!quit){
                System.out.print(list);
                System.out.println("Enter Q if you wish to quit or enter C if you wish to cancel an appointment: ");
                userInput = scan.next();
                if(userInput.equals("C")){
                    scan.nextLine();
                    System.out.println("Enter the name of the employee you wish to cancel an appointment with: ");
                    String name = scan.nextLine();
                    list.cancelAppointment(name);
                }
                else if(userInput.equals("Q"))
                    quit = true;
            }
        }
        return;
    }
}
