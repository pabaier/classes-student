import edu.cofc.grader.*;

public class Grader {
    public static void main(String[] args) {
        C.colors(true);
        TestOutline root = new TestOutline("Homework 5");
        TestOutline ticket = new TestOutline("Ticket");
        TestOutline walkUpTicket = new TestOutline("WalkUpTicket");
        TestOutline advanceTicket = new TestOutline("AdvanceTicket");
        TestOutline studentTicket = new TestOutline("StudentTicket");
        root.add(ticket);
        root.add(walkUpTicket);
        root.add(advanceTicket);
        root.add(studentTicket);

        TicketTests.Constructor ttConst = new TicketTests.Constructor();
        ttConst.setName("Constructor");
        TicketTests.GetName ttgetName = new TicketTests.GetName();
        ttgetName.setName("getName");
        TicketTests.GetPrice ttgetPrice = new TicketTests.GetPrice();
        ttgetPrice.setName("getPrice");
        TicketTests.GetDate ttgetDate = new TicketTests.GetDate();
        ttgetDate.setName("getDate");
        TicketTests.ToString tttoString = new TicketTests.ToString();
        tttoString.setName("toString");
        
        WalkUpTicketTests.Constructor wtConst = new WalkUpTicketTests.Constructor();
        wtConst.setName("Constructor");
        WalkUpTicketTests.GetPrice wtgetPrice = new WalkUpTicketTests.GetPrice();
        wtgetPrice.setName("getPrice");
        WalkUpTicketTests.ToString wttoString = new WalkUpTicketTests.ToString();
        wttoString.setName("toString");
        
        AdvanceTicketTests.Constructor atConst = new AdvanceTicketTests.Constructor();
        atConst.setName("Constructor");
        AdvanceTicketTests.GetPrice atgetPrice = new AdvanceTicketTests.GetPrice();
        atgetPrice.setName("getPrice");
        AdvanceTicketTests.ToString attoString = new AdvanceTicketTests.ToString();
        attoString.setName("toString");

        advanceTicket.add(atConst);
        advanceTicket.add(atgetPrice);
        advanceTicket.add(attoString);

        walkUpTicket.add(wtConst);
        walkUpTicket.add(wtgetPrice);
        walkUpTicket.add(wttoString);
        ticket.add(ttConst);
        ticket.add(ttgetName);
        ticket.add(ttgetPrice);
        ticket.add(ttgetDate);
        ticket.add(tttoString);

        root.run();
        double percent = Math.ceil(((double)root.getPointsEarned())/root.getTotalPoints()) * 100;
        System.out.println(C.BLUE + (int)percent + "%");
    }

}