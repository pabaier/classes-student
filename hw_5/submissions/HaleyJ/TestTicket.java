
public class TestTicket
{
    public static void main(String[] args)
    {
        String printStr = "";
        Ticket t1 = new WalkUpTicket("Basketball vs. LSU", new CalendarDate());
        Ticket t2 = new AdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1),new CalendarDate());
        Ticket t3 = new AdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1),
                new CalendarDate(2018, 3, 27));
        Ticket t4 = new StudentAdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1),
                new CalendarDate());
        Ticket t5 = new StudentAdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1),
                new CalendarDate(2018, 3, 27));

        

        System.out.println(t1 + "\n" + t2 + "\n" + t3 + "\n" + t4 + "\n" + t5);
        System.out.println("\n"+ "------------------------------------------"+"\n");
        System.out.println("Walk Up Ticket, getPrice(): $" + t1.getPrice());
        System.out.println("Advance Ticket (10 or more days before), getPrice(): $" + t2.getPrice());
        System.out.println("Advance Ticket (Less than 10 days before), getPrice(): $" + t3.getPrice());
        System.out.println("Student Advance Ticket (10 or more days before), getPrice(): $" + t4.getPrice());
        System.out.println("Student Advance Ticket (Less than 10 days before), getPrice(): $" + t4.getPrice());
        

    }
}

       
