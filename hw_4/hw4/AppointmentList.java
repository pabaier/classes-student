import java.util.ArrayList;

public class AppointmentList{
	public ArrayList<Appointment> appointments;
	private Appointment appointment;
	private CalendarDate c;
	private Employee e;

	public AppointmentList(){
		appointments = new ArrayList(10);
		
	}
	
	public String toString(){
		return "These are your appointments: " + appointments;
	}
	
	public void addToList(CalendarDate c, Employee e){
		appointments.add(new Appointment(c, e));
	}
	
	public CalendarDate getAppointment(String employee){
		if (employee != null){
			return c;
		}
		else{return null;}
	}
	
	public void cancelAppointment(String e){
		int i = 0;
		for(i = 0; i < appointments.size() - 1; i++){
			if(appointments.contains(e)){
				appointments.remove(e);
			}
		}
	}

}
