/*
 * Name: Kyle Winstead
 * Date Due: 29 October 2017
 * Assignment: HW4
 */

import java.util.*;
import java.io.*;

public class HW4 {
    public static void main(String[] args) throws Exception {
        int year;
        int month;
        int day;
        String name = null;
        AppointmentList apptlist = new AppointmentList();
        int i=0;
        try {
            Scanner scnr = new Scanner(System.in);
            System.out.println("Enter file name ending in .txt: ");
            String file = scnr.next();
            File infile = new File(file);
            scnr = new Scanner(infile);
            while (scnr.hasNextLine()) {
                CalendarDate date = null;
                String line = scnr.nextLine();
                String part[] = line.split(" ", 4);
                try {
                    year = Integer.parseInt(part[0]);
                    month = Integer.parseInt(part[1]);
                    day = Integer.parseInt(part[2]);
                    name = part[3];
                    date = new CalendarDate(year, month, day);
                    i++;
                } catch (Exception d) {}
                try {
                	 if(date.isAValidDate()) {
     					apptlist.addToList(date, new Employee(name.trim()));
                }} catch (Exception ddate) {
                    System.out.println("3rd try catch");
                    ddate.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Printing list...........");
        System.out.println(apptlist);
        Scanner s = new Scanner(System.in);
        System.out.print("Enter \"Q\" to quit or \"C\" to cancel an appointment: ");
        String input = s.next();
        while(!input.equalsIgnoreCase("Q")) {
            if (input.equalsIgnoreCase("C")) {
                System.out.print("Enter name to cancel: ");
                String can = s.next();
                apptlist.cancelAppointment(can);
                System.out.print(apptlist);
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
System.out.print("Thank you");

        }
}
