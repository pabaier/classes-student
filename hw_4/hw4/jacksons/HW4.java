import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
public class HW4{    
    public static void main(String[] args) throws IOException{
        FileInputStream fileStream = null; //file input stream initialized to null (opens file)
        Scanner inMyFile = null; //scanner to scan through file
        Scanner fileInput = new Scanner(System.in); //scanner to receive file name
        
        //prompt user for file name
        System.out.println("Enter a file to be read: ");
        String myFile = fileInput.next(); //gets file name from user input
        AppointmentList listOfApps = new AppointmentList();
        boolean cont = true;
        
        try {
            //System.out.println("Opening file " + myFile + ".");
            //Opening file
            fileStream = new FileInputStream(myFile); //may throw FileNotFoundException
            inMyFile = new Scanner(fileStream);
            
            //If the date is invalid, throw exception and continue reading file
            while (inMyFile.hasNext()){
                int appYear = inMyFile.nextInt();
                int appMonth = inMyFile.nextInt();
                int appDay = inMyFile.nextInt();
                String appName = inMyFile.nextLine();
                Employee appEmploy = new Employee(appName);
                CalendarDate date = new CalendarDate(appYear, appMonth, appDay);

                try {                   
                    if (!(date.isAValidDate())){   
                        throw new Exception("Invalid date."); 
                    }
                    else{
                        listOfApps.addToList(date,appEmploy);
                        
                    }
                }
                
            
                catch (Exception excpt){
                    System.out.println(excpt.getMessage());
                }
            }
        }
        catch (IOException excpt) {
            cont = false;
            System.out.println(excpt.getMessage());
            
        }
        if (cont == true){
        //finally{
            System.out.println(listOfApps);
            Scanner scan = new Scanner(System.in);
            Scanner cancelApp = new Scanner(System.in);
            String appToCancel = "";
            String quitOrCancel = "";
            boolean quit = false;
            //String cancel = "c";
            while (!quit){
                System.out.println("Enter 'c' to cancel an appointment or 'q' to quit.");
                quitOrCancel = scan.nextLine();
                //System.out.println(quitOrCancel);
                if (quitOrCancel.equals("c")){
                    System.out.println("Employee name for appointment cancellation: ");
                    appToCancel = cancelApp.nextLine();
                    listOfApps.cancelAppointment(appToCancel);
                    System.out.println(listOfApps);
                    //System.out.println(appToCancel);
                }
                else if (quitOrCancel.equals("q")){
                    quit = true;
                }
            }
        }
    
    }
}

