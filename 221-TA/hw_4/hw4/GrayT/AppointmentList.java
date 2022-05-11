/*
 * Contains linked list of apointments
 * allows appointments to be added and removed with a name and for a string representation to be outputed 
 * 
 * Tyler Gray
 */

import java.util.ArrayList;

public class AppointmentList {
	
	private ArrayList<Appointment> appointmentList;
	
	public AppointmentList() {
		appointmentList = new ArrayList<Appointment>();
		
	}
	
	//Returns String of Appointments
	public String toString() {
		String res = "";
		for(Appointment a: appointmentList) {
			res = res + a.toString() + "\n";
		}
		return res;
	}
	
	//Adds appointment to appointmentList
	public void addToList(CalendarDate c, Employee e) throws Exception {
		appointmentList.add(new Appointment(c,e));
	}
	
	//Gets appointment for specific named employee
	public CalendarDate getAppointment(String name) {
		for(Appointment a: appointmentList) {
			if(a.getEmployee().getName() == name) {
				return a.getDate();
			}
		}
		return null;
	}
	
	//removes appointment from list given name
	public void cancelAppointment(String name) {
		for(Appointment a: appointmentList) {
			if(a.getEmployee().getName().equals(name)) {
				appointmentList.remove(a);
				break;
			}
		}
	}
	//Gets list length
	public int getListLength() {
		return appointmentList.size();
	}

}
