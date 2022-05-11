import edu.cofc.grader.*;

public class TicketTests {

    // global values for reference
    private static String name = "Powerline Concert";
    private static CalendarDate date = new CalendarDate(1995, 4, 7);

    public static class Constructor extends SingleTest {
        public void exec() {
            setTotalPoints(3);
            int full = 3;
            int half = 2;
            Ticket t;
            try {
                t = new Ticket("Powerline Concert", new CalendarDate(1995, 4, 7));
                addPoints(full);
                System.out.println(indent() + C.CORRECT + "Correct - " + full + "/" + full + C.RESET);
            }
            catch(Throwable e) {
                try {
                    t = new Ticket(new CalendarDate(1995, 4, 7), "Powerline Concert");
                    addPoints(half);    
                    System.out.println(indent() + C.PARTCORRECT + "Arguments Reversed - " + half + "/" + full + C.RESET);
                }
                catch(Throwable f) {
                    addPoints(half - 1);
                    System.out.println(indent() + C.INCORRECT + "Could Not Construct Ticket - " + (half - 1) + "/" + full + C.RESET);
                    System.out.println(indent() + C.INCORRECT + "Should be Ticket(String, CalendarDate)" + C.RESET);
                }
            }
        }
    }

    public static class GetName extends SingleTest {
        public void exec() {
            setTotalPoints(3);
            int full = 3;
            int half = 2;

            System.out.print(indent() + name + " - ");

            Ticket t = getTicket();
            if (t == null) {
                System.out.println(C.INCORRECT + "Cannot create Ticket Objects" + C.RESET);
                return;
            }
            String result = null;
            try {
                result = t.getNameOfEvent();
            }
            catch(Throwable e) {
            }
            if(name.equals(result)) {
                addPoints(full);
                System.out.println(C.CORRECT + "Correct - " + full + "/" + full + C.RESET);                
            }
            else {
                addPoints(half);
                System.out.println(C.PARTCORRECT + "" + result + " - incorrect - " + half + "/" + full + C.RESET);
            }
        }
    }

    public static class GetPrice extends SingleTest {
        public void exec() {
            setTotalPoints(3);
            int full = 3;
            int half = 2;

            System.out.print(indent() + "$0 - ");

            Ticket t = getTicket();
            if (t == null) {
                System.out.println(C.INCORRECT + "Cannot create Ticket Objects" + C.RESET);
                return;
            }
            double result = 100;
            try {
                result = t.getPrice();
            }
            catch(Throwable e) {
            }
            if(result == 0) {
                addPoints(full);
                System.out.println(C.CORRECT + "Correct - " + full + "/" + full + C.RESET);                
            }
            else {
                addPoints(half);
                System.out.println(C.PARTCORRECT + "" + result + " - incorrect - " + half + "/" + full + C.RESET);
            }
        }
    }

    public static class GetDate extends SingleTest {
        public void exec() {
            setTotalPoints(3);
            int full = 3;
            int half = 2;

            System.out.print(indent() + date + " - ");

            Ticket t = getTicket();
            if (t == null) {
                System.out.println(C.INCORRECT + "Cannot create Ticket Objects" + C.RESET);
                return;
            }
            CalendarDate result = null;
            try {
                result = t.getDateOfEvent();
            }
            catch(Throwable e) {
            }
            if(date.equals(result)) {
                addPoints(full);
                System.out.println(C.CORRECT + "Correct - " + full + "/" + full + C.RESET);                
            }
            else {
                addPoints(half);
                System.out.println(C.PARTCORRECT + "" + result + " - incorrect - " + half + "/" + full + C.RESET);
            }
        }
    }

    public static class ToString extends SingleTest {
        public void exec() {
            setTotalPoints(3);
            int full = 3;
            int half = 2;

            System.out.print(indent() + name + " " + date + " - ");

            Ticket t = getTicket();
            if (t == null) {
                System.out.println(C.INCORRECT + "Cannot create Ticket Objects" + C.RESET);
                return;
            }
            String result = "";
            try {
                result = t.toString();
            }
            catch(Throwable e) {
            }

            boolean n = result.contains(name);
            boolean d = result.contains(date.toString());

            if(n && d) {
                addPoints(full);
                System.out.println(C.CORRECT + "Correct - " + full + "/" + full + C.RESET);                
            }
            else if(n) {
                addPoints(half);
                System.out.println(C.PARTCORRECT + result + " - only name correct - " + half + "/" + full + C.RESET);
            }
            else if(d) {
                addPoints(half);
                System.out.println(C.PARTCORRECT + result + " - only date correct - " + half + "/" + full + C.RESET);
            }
            else {
                addPoints(half - 1);
                System.out.println(C.PARTCORRECT + "" + result + " - incorrect - " + (half - 1) + "/" + full + C.RESET);
            }
        }
    }

    // returns a new ticket object using different constructor options
    // returns null if constructor does not work
    public static Ticket getTicket() {
        try {
            return new Ticket(name, date);
        }
        catch(Throwable e) {
            try {
                return new Ticket(date, name); 
            }
            catch(Throwable f) {
                return null;
            }
        }

    }
}