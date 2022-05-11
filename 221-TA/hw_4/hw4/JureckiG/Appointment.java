

public class Appointment {
    private Employee person;
    private CalendarDate date;
    //  public Appointment(int year, int month, int day, String name){
    public Appointment(CalendarDate date, Employee person){
        this.date = date;
        this.person = person;
    }

    public Employee getEmployee(){
        return person;
    }

    public CalendarDate getDate(){return date; }



    public String toString() {
        return (""+ person + " " + date);
    }
}

