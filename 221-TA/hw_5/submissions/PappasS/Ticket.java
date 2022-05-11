//Stephen Pappas
public class Ticket {

    private String nameOfEvent;
    private CalendarDate dateOfEvent;

    public Ticket(String nameOfEvent, CalendarDate dateOfEvent) {
        this.nameOfEvent = nameOfEvent;
        this.dateOfEvent = dateOfEvent;
    }


    public String getNameOfEvent(){
        return this.nameOfEvent;
    }

    public double getPrice(){
        return 0.0;
    }

    public CalendarDate getDateOfEvent() {
        return dateOfEvent;
    }

    public String toString() {
        return "Event: " + getNameOfEvent() + ", Date of Event: " + getDateOfEvent() + ", Price: $" + getPrice();
    }

}
