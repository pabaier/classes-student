//Stephen Pappas
public class StudentAdvanceTicket extends AdvanceTicket {

    public StudentAdvanceTicket(String nameOfEvent, CalendarDate dateOfEvent, CalendarDate ticketDate) {
        super(nameOfEvent, dateOfEvent, ticketDate);

    }

    @Override
    public double getPrice(){
        return super.getPrice()/2;
    }

    @Override
    public String toString() {
        return super.toString() + " (Student ID required)";
    }
}


