//Gabe Jurecki
public class Ticket {

    private String nameOfEvent;
    private CalendarDate dateOfEvent; //Are these private? no because its a superclass?

    public Ticket(){

    }
    public Ticket(String event, CalendarDate date){
        nameOfEvent = event;
        dateOfEvent = new CalendarDate();
    }

    public String getNameOfEvent() {
        return nameOfEvent;
    }

    public CalendarDate getDateOfEvent() {
        return dateOfEvent;
    }

    public double getPrice(){
        return 0;
    }
    @Override
    public String toString() {
        return "Event: " + getNameOfEvent() + " Date: " + getDateOfEvent();
    }


}
