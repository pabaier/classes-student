/* <Stefan Veloff>
//October 29, 2017
// this is a program that creates an array of appointments for the user:
*/ 
// I discussed this with CSCI lab Mackenzie, Paul, and Kyle.

import java.util.*;
import java.io.*;

public class HW4 {
	public static void main(String[] args) {
	AppointmentList apptList = new AppointmentList();
	CalendarDate date = new CalendarDate();
	String line;

	//try to find the file that the user has entered:
	try {
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter a file name: ");
		String inFile = in.nextLine();
		File inFile1= new File(inFile);
		
		//System.out.println(inFile1);

		Scanner file = new Scanner(inFile1);
	//try:
	try {
		
		//testing:
		//System.out.println(inFile1);
		
		//while loop:
		while (file.hasNextLine()) {	
			int year = file.nextInt();
			int month = file.nextInt();
			int day = file.nextInt();
			
			String name = file.nextLine();
			date = new CalendarDate(year, month, day);
			
			if (date.isAValidDate()) {
				//System.out.println(date);
				apptList.addToList(date,  new Employee(name.trim()));
				System.out.println(apptList);
	
			}
				else {
					throw new IllegalArgumentException ();
				}
				String cont = "";
				System.out.print(apptList);
				System.out.print("Do you want to cancel an appointment? Type C for yes or Q to quit: ");
				cont = in.next();
				
				
				while (!cont.equals("Q") || !cont.equals("q")) {
					if (cont.equals("c") || cont.equals("C")) {
					
					System.out.print("Enter a name to cancel appointment: ");
					String inName = in.nextLine();
										
					for (int i = 0; i < apptList.getLength(); ++i) {
						if (apptList.getAppointment().get(i).getEmployee().getName().equals(inName)) {
							apptList.cancelAppointments(name);
						}
					System.out.println("Update complete:");
					}
					
					
				}
				}
						
			
			}
	}
	//catch if invalid date:
	catch (IllegalArgumentException z) {
		System.out.println("Invalid date! ");
	}
	}
	//catch if file is not found:
	catch (FileNotFoundException e) {
		//print statement:
		System.out.println("File not found. ");
		
		}


	
}
}