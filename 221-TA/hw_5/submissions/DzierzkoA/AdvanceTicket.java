/*
author: Adam Dzierzko
 */
public class AdvanceTicket extends Ticket {

    private CalendarDate datePurchased;

    public AdvanceTicket(String nameOfEvent, CalendarDate dateOfEvent, CalendarDate datePurchased) {
        super(nameOfEvent, dateOfEvent);
        this.datePurchased = datePurchased;
    }

    @Override
    public double getPrice() {
        final double TICKET_PRICE = 40;
        final double DISCOUNTED_TICKET_PRICE = 30;
        return datePurchased.daysUntil(dateOfEvent) >= 10 ? DISCOUNTED_TICKET_PRICE : TICKET_PRICE;
    }

    @Override
    public String toString() {
        return super.toString() + ", Purchase Date: " + this.datePurchased + ", Price: $" + getPrice();
    }
}
