//<Stefan Veloff>
import java.util.*;

//
public class AppointmentList {
	private ArrayList<Appointment> appointments;

// appointment list array:	
public AppointmentList() {
	appointments = new ArrayList<Appointment> ();	
}


public ArrayList<Appointment> getAppointment(){
	return appointments;
}


//to string:
public String toString() {
	return appointments.toString();
}

//adding to list:
public  void addToList(CalendarDate c, Employee e) {
	Appointment appt = new Appointment(c,e);
	appointments.add(appt);	
}

//get length:
public int getLength() {
	return appointments.size();
	
}


// canceling appointments:
public void cancelAppointments(String name) {
	int i = 0;
	for (i = 0; i < appointments.size(); ++i) {
		if (appointments.get(i).getEmployee().getName().equals(name)) {
			appointments.remove(i);		
		}
	}
}

//get appointment: 
public CalendarDate getAppointment(String name) {
	int i = 0;
	for(i = 0; i < appointments.size(); ++i) {
		if (appointments.get(i).getEmployee().getName().equals(name)) {
			return appointments.get(i).getDate();			
		}		
	}
	return null;
}
}
