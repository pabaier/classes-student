public class StudentAdvanceTicket extends AdvanceTicket{

    public StudentAdvanceTicket(String nameOfEvent, CalendarDate dateOfEvent, CalendarDate datePurchased) {
        super(nameOfEvent, dateOfEvent, datePurchased);
    }

    public StudentAdvanceTicket() {
    }

    public String toString() {
        return "StudentAdvance Ticket: " + getNameOfEvent() + ", Date of Event: " + getDateOfEvent() + ", Price: " + getPrice() + " (ID) Required";
    }

    public double getPrice(){
        double price= super.getPrice()/2;
        return price;
    }
}
