import edu.cofc.grader.*;

public class SingleTests {
    
    public static class IsAValidDate extends SingleTest {
        public void exec() {
        setTotalPoints(5);
        // 0 - month > 12
        // 1 - month < 1
        // 2 - day > 31
        // 3 - february leap year
        // 4 - february not leap year
        String[] tests = {"month > 12",
                            "month < 1",
                            "day > 31",
                            "february leap year",
                            "february not leap year"};
        CalendarDateKey[] key = {new CalendarDateKey(1977, 13, 2),
                                new CalendarDateKey(1977, 0, 2),
                                new CalendarDateKey(1977, 9, 31),
                                new CalendarDateKey(2016, 2, 29),
                                new CalendarDateKey(2015, 2, 29)};
        try {
            CalendarDate[] student = {new CalendarDate(1977, 13, 2),
                                new CalendarDate(1977, 0, 2),
                                new CalendarDate(1977, 9, 31),
                                new CalendarDate(2016, 2, 29),
                                new CalendarDate(2015, 2, 29)};
            for(int i = 0; i < key.length; i++) {
                System.out.print("\t\t" + key[i] + ": " + student[i].isAValidDate());
                if(key[i].isAValidDate() == student[i].isAValidDate()) {
                    System.out.println(getIndent() + " - Correct - " + full + "/" + full);
                    points += full;
                }
                else {
                    System.out.println(getIndent() + " - Incorrect - " + half + "/" + full);
                    points += half;
                }
            }
            System.out.println("\t    " + points + "/" + (full * key.length));
        }
        catch(Exception | NoClassDefFoundError e) {
            System.out.println(INCORRECT + "\t\t" + e);
            System.out.println("\t\tError running test - " + points + "/" + (full * key.length) + RESET);
        }

        // return points;
        }
    }

}