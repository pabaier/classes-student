//Gabe Jurecki
public class StudentAdvanceTicket extends AdvanceTicket {
    public StudentAdvanceTicket(String name,CalendarDate date, CalendarDate datePurchased){
        super(name,date,datePurchased);
        this.datePurchased = datePurchased;
    }
    public double getPrice() {
        return super.getPrice() / 2;
    }
    public String toString() {
        return super.toString() + " Purchase Date: " + datePurchased + " Price: " + getPrice() + " ID Required" ;
    }
}
