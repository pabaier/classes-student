//Ryan Barrett
//StudentAdvanceTicket class for HW5
public class StudentAdvanceTicket extends AdvanceTicket {

    public StudentAdvanceTicket(String event, CalendarDate dateOfEvent, CalendarDate purchaseDate){
    super(event, dateOfEvent, purchaseDate);
    }
    
    public double getPrice(){
        return super.getPrice() / 2;
    }
    
    public String toString(){
        String string = super.toString();
        string = string.substring(0, string.length() - 4) + this.getPrice();
        return string;
    }
}
