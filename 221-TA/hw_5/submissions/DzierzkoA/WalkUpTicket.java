import java.text.DecimalFormat;

/*
author: Adam Dzierzko
 */
public class WalkUpTicket extends Ticket {


    public WalkUpTicket(String nameOfEvent, CalendarDate dateOfEvent) {
        super(nameOfEvent, dateOfEvent);
    }

    @Override
    public double getPrice() {
        final float TICKET_PRICE = 50;
        return TICKET_PRICE;
    }

    @Override
    public String toString() {
        return super.toString() + ", Price: $" + getPrice();
    }
}
