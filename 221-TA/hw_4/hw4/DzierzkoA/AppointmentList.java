/*
*  Author: Adam Dzierzko
*/

import java.util.ArrayList;

public class AppointmentList {

    private ArrayList<Appointment> appointments;

    public AppointmentList() {
        this.appointments = new ArrayList<>(10);
    }

    public void AddToList(CalendarDate c, Employee e) {
        this.appointments.add(new Appointment(c, e));
    }

    public CalendarDate getAppointment(String name) {
        CalendarDate app = null;
        for (Appointment appointment : appointments) {
            if (appointment.getEmployee().getName().equals(name)) {
                app = appointment.getAppointmentDate();
            }
        }
        return app;
    }


    public void cancelAppointment(String name){
        for (int i = 0; i < appointments.size(); i++){
            if(appointments.get(i).getEmployee().getName().equals(name)){
                appointments.remove(appointments.get(i));
            }
        }
    }

    public String toString() {
        String string = "";
        for (Appointment appointment: appointments) {
            string += appointment;
        }
        return string;
    }
}