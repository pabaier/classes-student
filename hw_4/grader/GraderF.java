import edu.cofc.grader.*;

public class GraderF {
     public static void main(String[] args){

        TestOutline calendarDateTests = new TestOutline("Calendar Date Tests");
        TestOutline appointmentTests = new TestOutline("Appointment Tests");
        TestOutline appointmentListTests = new TestOutline("AppointmentList Tests");
        TestOutline hw4Tests = new TestOutline("HW 4 Tests");

        SingleTests.IsAValidDate cdtDate = new SingleTests.IsAValidDate();
        cdtDate.setName("Is A Valid Date Test");
        calendarDateTests.addTest(cdtDate);
        calendarDateTests.run();
     }
}