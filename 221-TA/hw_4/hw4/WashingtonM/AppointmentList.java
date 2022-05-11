/*
 * Make an array list of appointments and add to it/ cancel from it
 *
 * Author: Mary Washington
 * Eclipse Oxygen 4.7
 */

import java.util.ArrayList;

public class AppointmentList {

	private ArrayList<Appointment> appointments;
	
	//constructor to initialize variables
	public AppointmentList() {
		appointments = new ArrayList<>();
		
	}
	
	//overrides default toString
	public String toString() {
		String result = "";
		for(int i = 0; i < appointments.size(); i++) {
			result = result + appointments.get(i).toString() + "\n";
		}
		return result;
	}
	
	//adds to appointment list causes exception for invalid date
	public void addToList (CalendarDate c, Employee e) throws Exception {
		
		if(!c.isAValidDate()) {
			throw new Exception("Invalid date exception: " + c.toString());
		}
		else {
			appointments.add(new Appointment(c,e));
		}
		return;
	}
	
	//returns the date of the appointment for a given person
	public CalendarDate getAppointment(String name) {
		
		for(int i = 0; i < appointments.size(); i++) {
		
			if(appointments.get(i).getEmployee().getName().equalsIgnoreCase(name)) {
				return appointments.get(i).getDate();
				
			}
			
		}
		return null;
	}
	
	//cancels an appointment for a given name
	public void cancelAppointment (String name) {
		for(int i = 0; i < appointments.size(); i++) {
			if(appointments.get(i).getEmployee().getName().equalsIgnoreCase(name)) {
				appointments.remove(i);
				return;
			}
		}
		
		return;
	}
}
