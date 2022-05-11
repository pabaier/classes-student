/*
*  Author: Adam Dzierzko
*/

public class Appointment {

    private CalendarDate appointmentDate;
    private Employee employee;

    public Appointment(CalendarDate date, Employee employee){
        this.appointmentDate = date;
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public CalendarDate getAppointmentDate() {
        return appointmentDate;
    }


    public String toString() {
        return "" + this.appointmentDate.getYear() + "/" + this.appointmentDate.getMonth() +
                "/" + this.appointmentDate.getDay() + " " + this.employee.getName() + "\n";
    }
}