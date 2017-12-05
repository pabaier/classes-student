/*
author: Adam Dzierzko
 */
public class StudentAdvanceTicket extends AdvanceTicket {

    public StudentAdvanceTicket(String nameOfEvent, CalendarDate dateOfEvent, CalendarDate datePurchased) {
        super(nameOfEvent, dateOfEvent, datePurchased);
    }

    @Override
    public double getPrice() {
        return super.getPrice() / 2;
    }

    @Override
    public String toString() {
        return super.toString() + " (ID Required)";
    }
}
