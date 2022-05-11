public class Appointment {

    private CalendarDate cDate;
    private Employee emp;


    public  Appointment(CalendarDate cDate, Employee emp) {

        this.cDate = cDate;
        this.emp = emp;
    }

    public Employee getEmployee() {
        return this.emp;
    }

    public CalendarDate getDate() {
        return this.cDate;
    }


    public String toString() {
        return this.cDate + " " + this.emp.getName();
    }
}
