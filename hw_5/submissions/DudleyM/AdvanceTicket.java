public class AdvanceTicket extends Ticket{

    private CalendarDate datePurchased;

    public AdvanceTicket(String nameOfEvent, CalendarDate dateOfEvent, CalendarDate datePurchased) {
        super(nameOfEvent, dateOfEvent);
        this.datePurchased = datePurchased;
    }

    public AdvanceTicket() {

    }

    public String toString() {
        return "AdvanceTicket: " + getNameOfEvent() + ", Date of Event: " + getDateOfEvent() + ", Price: " + getPrice();
    }

    public double getPrice() {
        int price;
        int days = datePurchased.dayUntil(this.getDateOfEvent());
        if(days >= 10){
            price = 30;
        }else{
            price = 40;
        }
        return price;
    }

}
