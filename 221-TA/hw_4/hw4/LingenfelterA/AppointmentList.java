/**
 * AppointmentList Class.
 * Tracks all appointments in an arraylist.
 * includes constructor to create arraylist, toString method to return appointments
 * addToList method to add new apointments to arraylist, getAppointment method that returns date for name, 
 * and cancelAppointment to remove appointment for given employee
 * 
 * 
 * @author:  Andrea Lingenfelter
 */

import java.util.*;
public class AppointmentList {

	ArrayList<Appointment> appointments = new ArrayList<String>();
    
	public String toString() {
		for (int i = 0; i < appointments.size(); i++) {
    	    return CalendarDate.toString() + " " Employee.getName();
		}
    }
	
	public void addToList (CalendarDate c, Employee e) {
		//add appointments to list in order received
	}
	
	public CalendarDate getAppointment (String name) {
		//returns date of appt scheduled or null if none
	}
	
	public void cancelAppointment (String name) {
		//removes appointment if one scheduled for employee or does nothing
	}
	
}
