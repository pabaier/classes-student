//Stephen Pappas
public class AdvanceTicket extends Ticket {

    private CalendarDate ticketDate;
    private final double cheapPrice = 30;
    private final double soonPrice = 40;

    public AdvanceTicket(String nameOfEvent, CalendarDate dateOfEvent, CalendarDate ticketDate) {
        super(nameOfEvent, dateOfEvent);
        this.ticketDate = ticketDate;
    }

    @Override
    public double getPrice(){
        int daysUntil = ticketDate.daysUntil(super.getDateOfEvent());
        double ticketPrice;
        if(daysUntil >= 10)
            ticketPrice = cheapPrice;
        else
            ticketPrice = soonPrice;
        return ticketPrice;
    }


    @Override
    public String toString() {
        return "Advance Ticket: " + super.toString();
    }
}
