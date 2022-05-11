/*
author: Adam Dzierzko
 */
public class Ticket {

    private String nameOfEvent;
    CalendarDate dateOfEvent;

    public Ticket(String nameOfEvent, CalendarDate dateOfEvent) {
        this.nameOfEvent = nameOfEvent;
        this.dateOfEvent = dateOfEvent;
    }

    public String getNameOfEvent() {
        return nameOfEvent;
    }

    public CalendarDate getDateOfEvent() {
        return dateOfEvent;
    }

    public double getPrice() {
        return 0;
    }

    public String toString() {
        return "Event: " + getNameOfEvent() + ", Date of Event: " + getDateOfEvent();
    }
}
