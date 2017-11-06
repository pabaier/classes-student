
import java.util.*;

public class CalendarDate {
    private static final int JANUARY  =  1;
    private static final int FEBRUARY =  2;
    private static final int MARCH = 3;
    private static final int APRIL = 4;
    private static final int MAY = 5;
    private static final int JUNE = 6;
    private static final int JULY = 7;
    private static final int AUGUST = 8;
    private static final int SEPTEMBER = 9;
    private static final int OCTOBER = 10;
    private static final int NOVEMER = 11;
    private static final int DECEMBER = 12;
    private static final int DAYS_PER_WEEK = 7;

    private static final String[] DAY_NAMES = {
        "Sunday", "Monday", "Tuesday", "Wednesday",
        "Thursday", "Friday", "Saturday"};

    private static final int[] DAYS_PER_MONTH = { -1,
        31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31,
    };

    private int year;
    private int month;
    private int day;

    public CalendarDate(int year, int month, int day) {
       this.year = year;
       this.month = month;
       this.day = day;
    }
    
    public CalendarDate() {
        this(1970, JANUARY, 1);
        int daysSinceEpoch = (int) ((System.currentTimeMillis() + 
            TimeZone.getDefault().getRawOffset()) / 1000 / 60 / 60 / 24);
        for (int i = 0; i < daysSinceEpoch; i++) 
            nextDay(); 
    }

    public boolean equals(Object o) {
        // a well-behaved equals method returns false for null and non-CalendarDates
        if (o instanceof CalendarDate) {
            CalendarDate other = (CalendarDate) o;
            return day == other.day && month == other.month && 
                   year == other.year;
        } else {
            return false;
        }
    }

    public int getDay() {
        // this.day = getDay();
        return day;
    }
    
    public int getMonth() {
        // this.month = getMonth();
        return month; 
    }
    
    public int getYear() {
        // this.year = getYear();
        return year; 
    }

    public String getDayOfWeek() {
        int i = 0;
        Date sample = new Date(1753, JANUARY, 1);
        SampleDate date = new SampleDate(year, month, day);        
        // while ((!sample.equals(date))){
            i = sample.getDay();
            i = (i + 1) % DAYS_PER_WEEK;
            i++;
        // }
        return DAY_NAMES[i]; 
    }
    
    public boolean isLeapYear() {
        return ((year % 400 == 0) || ((year % 4 == 0) && year % 100 != 0));  
    }
    
    public void nextDay() {
       SampleDate date = new SampleDate(year, month, day);
       if (month == FEBRUARY && isLeapYear()) {
           day++;
           if ( day > DAYS_PER_MONTH[month]) {
               month++;
               day = 1;
               if( month > DECEMBER ) {
                   year++;
                   month = JANUARY;
            }
        }
    }
    }
    
    public String toString() {
        return (year + "/" + month + "/" + day); 
    }
    
}