public class Ticket {

    private String nameOfEvent;

    private CalendarDate dateOfEvent;

    public Ticket() {

    }

    public Ticket(String nameOfEvent, CalendarDate dateOfEvent) {
        this.nameOfEvent = nameOfEvent;
        this.dateOfEvent = dateOfEvent;
    }

    public String getNameOfEvent() {
        return nameOfEvent;
    }

    double getPrice(){
        return 0;
    }

    public CalendarDate getDateOfEvent() {
        return dateOfEvent;
    }

    public String toString() {
        return "Ticket:" + " nameOfEvent = " + nameOfEvent + ", dateOfEvent = " + dateOfEvent + ", price = " + 0;
    }

   /* public static void main(String[] args) {
        Ticket Ticket1 = new Ticket("Basketball vs LSU", new CalendarDate());
        System.out.println(Ticket1);
    }*/
}
