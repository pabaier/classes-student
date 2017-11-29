// Michael Dudley

import java.util.ArrayList;

public class AppointmentList {

    ArrayList<Appointment> appointments;


    public AppointmentList() {
        this.appointments = new ArrayList<>();
    }

    public void addToList (CalendarDate c, Employee e){
        Appointment addAppointment = new Appointment(c.getYear(),c.getMonth(),c.getDay(),e.getName());
        appointments.add(addAppointment);

    }
    public CalendarDate getAppointment(String name){
        for(int i = 0; i < appointments.size(); i++){
            if(name.equals(appointments.get(i).getPerson().getName())){
                return appointments.get(i).getDate();
            }
        }
        return null;
    }
    public void cancelAppointment(String name){
        CalendarDate appointmentDate = getAppointment(name);
        if(appointmentDate != null){
            for(int i = 0; i < appointments.size(); i++){
                if(name.equals(appointments.get(i).getPerson().getName())){
                    appointments.remove(i);
                }
            }
        }
    }

    public String toString() {
        String allAppointments = "";
        for(int i = 0; i < appointments.size(); i++){
            allAppointments += appointments.get(i) + "\n";
        }
        return allAppointments;
    }
/*
    public static void main(String[] args) {
        AppointmentList listofAppointments = new AppointmentList();
        listofAppointments.addToList(new CalendarDate(1994,10,20), new Employee("Michael Dudley"));
        listofAppointments.addToList(new CalendarDate(1995,12,3), new Employee("Katie Dudley"));
        listofAppointments.addToList(new CalendarDate(2017,9,17), new Employee("Kristen Bryant"));
        listofAppointments.addToList(new CalendarDate(2003,1,31), new Employee("Kevin Bryant"));

        System.out.println(listofAppointments);

        */
}
