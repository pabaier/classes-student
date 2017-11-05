import java.util.TimeZone;

public class SampleDate {
    private static final int JANUARY = 1;
    private static final int FEBRUARY = 2;
    private static final int DECEMBER = 12;
    private static final int DAYS_PER_WEEK = 7;
    private static final String[] DAY_NAMES = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private static final int[] DAYS_PER_MONTH = new int[]{-1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private int year;
    private int month;
    private int day;

    public SampleDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public SampleDate() {
        this(1970, 1, 1);
        int daysSinceEpoch = (int)((System.currentTimeMillis() + (long)TimeZone.getDefault().getRawOffset()) / 1000 / 60 / 60 / 24);
        for (int i = 0; i < daysSinceEpoch; ++i) {
            this.nextDay();
        }
    }

    public boolean equals(Object o) {
        if (o instanceof SampleDate) {
            SampleDate other = (SampleDate)o;
            return this.day == other.day && this.month == other.month && this.year == other.year;
        }
        return false;
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public String getDayOfWeek() {
        int dayIndex = 1;
        SampleDate temp = new SampleDate(1753, 1, 1);
        while (!temp.equals(this)) {
            temp.nextDay();
            dayIndex = (dayIndex + 1) % 7;
        }
        return DAY_NAMES[dayIndex];
    }

    public boolean isLeapYear() {
        return this.year % 400 == 0 || this.year % 4 == 0 && this.year % 100 != 0;
    }

    public void nextDay() {
        ++this.day;
        if (this.day > this.getDaysInMonth()) {
            ++this.month;
            this.day = 1;
            if (this.month > 12) {
                ++this.year;
                this.month = 1;
            }
        }
    }

    public String toString() {
        return "" + this.year + "/" + this.month + "/" + this.day;
    }

    private int getDaysInMonth() {
        int result = DAYS_PER_MONTH[this.month];
        if (this.month == 2 && this.isLeapYear()) {
            ++result;
        }
        return result;
    }
}