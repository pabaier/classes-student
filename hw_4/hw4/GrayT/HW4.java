/*
 * Main running program for HW4
 * Reads in file of appointments and adds to the appointment list
 * Allows user to remove appointments from list
 * 
 * Tyler Gray
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HW4 {

	
	public static void main(String[] args) {
		//Vars
		Scanner sc = new Scanner(System.in);
		Scanner fileSc;
		String fileName;
		File file;
		AppointmentList aList;
		boolean run = true;
		char c = ' ';
		String usrInput;
		aList = new AppointmentList();

		
		//Get file name
		System.out.printf("Please enter the input file name\n");
		//fileName = "data.dat";
		fileName = sc.nextLine();
		//Prevents invalid file
		try {
			file = new File(fileName);
			fileSc = new Scanner(file);
			//Reads one line of data at time and adds to the AppointmentList
			while(fileSc.hasNext()) {
				try {
					aList.addToList(new CalendarDate(fileSc.nextInt(),fileSc.nextInt(),fileSc.nextInt()), new Employee(fileSc.nextLine().trim()));
				}
				catch(Exception e) {
					System.out.printf("Couldnt Create Appointment: Invalid Date \n");
					continue;
				}
				
			}
		
		}
		catch(Exception e){
			System.out.printf("File Not Found");
			return;
		}
		//Main Running Program
		while(run) {
			System.out.printf("Appointment List - %d Appointments\n" , aList.getListLength());
			System.out.printf("*******************\n");
			System.out.printf("%s\n" , aList.toString());
			System.out.printf("C - Cancel Appointment\nQ - Quit Program\n\n");
			c = Character.toLowerCase(sc.nextLine().charAt(0));
			//sc.next();
			switch(c) {
			case 'q':
				System.out.printf("Thanks for using the AppointmentList Tracker. Good-Bye!\n");
				run = false;
				break;
			case 'c':
				//Removes Appointment from list
				System.out.printf("Please enter the name of the person who's appointment you want canceled: \n\n");
				usrInput = sc.nextLine();
				aList.cancelAppointment(usrInput);
				break;
			default:
				System.out.printf("********************************\n");
				System.out.printf("**Please enter a valid command**\n");
				System.out.printf("********************************\n");
				break;
			}
			
			
			
		}
		
		
		

	}
	
	
	

}
