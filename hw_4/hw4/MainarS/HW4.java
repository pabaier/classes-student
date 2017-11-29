import java.util.*;
import java.io.*;
import java.lang.*;
/**
 * Write a description of class HW4 here.
 * appt_file.txt
 * @author Shaina Mainar
 * @version (a version number or a date)
 */
public class HW4 {
    public static void main(String[] args) throws Exception {
        int year;
        int month;
        int day;
        String name = null;
        AppointmentList list = new AppointmentList();
        try {
            Scanner scnr = new Scanner(System.in);
            System.out.println("Enter file name (+.txt): ");
            String file = scnr.next();
            File infile = new File(file);
            scnr = new Scanner(infile);
            int lineNum = 1;

            while (scnr.hasNextLine()) {
                CalendarDate date = null;
                Employee e = null;
                String line = scnr.nextLine();
                String part[] = line.split(" ", 4);
                //System.out.println("------------------------------------");
                //System.out.println("PART: " + part[0] + "//" + part[1] + "//" + part[2] + "//" + part[3]);
                try {
                    //ToDo: FIXME!!!
                    year = Integer.parseInt(part[0]);
                    month = Integer.parseInt(part[1]);
                    day = Integer.parseInt(part[2]);
                    name = part[3];
                    date = new CalendarDate(year, month, day);
                    //System.out.println("Date:" + date.toString());
                    //System.out.println("Name:" + name);
                    lineNum++;
                } catch (Exception d) {
                    //d.printStackTrace();
                    System.out.println("Invalid Date. Setting to 9/9/1999");
                    year = 1999;
                    month = 9;
                    day = 9;
                    name = part[3];
                    date = new CalendarDate(year, month, day);

                    //System.out.println("LIST: "+list.toString());
                    //System.out.println("Exception has been thrown: " + e);
                }

                try {
                    //System.out.println("Adding to list");
                    e = new Employee(name);
                    list.addToList(date, e);
                    //System.out.println("LIST: "+list.toString());
                } catch (Exception d) {
                    System.out.println("3st try catch");
                    d.printStackTrace();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            //System.out.println("File not valid **** " + e);
        }
        System.out.println("------------Printing List------------");
        System.out.println(list);
        Scanner s = new Scanner(System.in);
        System.out.print("Enter \"Q\" to quit or \"C\" to cancel an appointment: ");
        String input = s.next();
        while(!input.equalsIgnoreCase("Q")) {
            if (input.equalsIgnoreCase("C")) {
                System.out.print("Enter name to cancel: ");
                String can = s.next();
                list.cancelAppointment(can);
                System.out.print(list);
                System.out.print("Enter \"Q\" to quit or \"C\" to cancel an appointment: ");
                input = s.next();
            } else {
                System.out.println("Not valid");
                System.out.print("Enter \"Q\" to quit or \"C\" to cancel an appointment: ");
                input = s.next();
            }
        }
        
        System.out.println("Exiting...");
        System.exit(0);


    }
}
   

