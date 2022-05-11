/* Cancel appointments for an employee 
 * 
 * 
 * Author: Mary Washington
 * Eclipse Oxygen 4.7
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class HW4 {

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		String fileName = "";
		AppointmentList appointments = new AppointmentList();
		boolean runProgram = true;
		char userInput = ' ';
		String cancelName = "";
		
		System.out.println("Please enter in your file name.");
		fileName = input.nextLine();
		
		
		try {
			Scanner fileInput = new Scanner(new File (fileName));
			while(fileInput.hasNextLine()) {
				int year = fileInput.nextInt();
				int month = fileInput.nextInt();
				int day = fileInput.nextInt();
				String name = fileInput.nextLine().trim();
				
				try {
				appointments.addToList(new CalendarDate(year, month, day), new Employee(name));
				}
				
				catch (Exception e){
					System.out.println(e.getMessage());
					
				}
			}
			
			fileInput.close();
			
		}
		catch (FileNotFoundException excpt) {
			System.out.println("Sorry, the file was not found.  Please enter in valid file.");
			
		}
		System.out.println("Appointment List: ");
		System.out.println(appointments.toString());
		while(runProgram) {
			
			System.out.println("Please select an option below.");
			System.out.println("C: cancel appointments.");
			System.out.println("Q: quit the program.");
			userInput = input.nextLine().toUpperCase().charAt(0);
			
			if (userInput == 'C') {
				System.out.println("Whose appointment would you like to cancel?");
				cancelName = input.nextLine();
				appointments.cancelAppointment(cancelName);
				System.out.println("New appointment list: ");
				System.out.println(appointments.toString());
			}
			
			else if(userInput == 'Q') {
				runProgram = false;
			}
			else {
				System.out.println("Invalid entry please try again.");
			}
			
		}
		
		input.close();
		
	}

}
