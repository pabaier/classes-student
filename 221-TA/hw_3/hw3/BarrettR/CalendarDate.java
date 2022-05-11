//package HW3;

/*
 * Represents a calendar year/month/day date.
 * 
 * Ryan Barrett
 */ 

import java.util.*;

public class CalendarDate {
    // constants that may be helpful in avoiding "magic numbers"
    // in your code making it more readable and extendable
    private static final int JANUARY  =  1;
    private static final int FEBRUARY =  2;
    private static final int DECEMBER = 12;
    private static final int DAYS_PER_WEEK = 7;
    
    // these arrays that might simplify your code - remove if
    // you don't use them
    private static final String[] DAY_NAMES = {
        //    0,        1,         2,           3,
        "Sunday", "Monday", "Tuesday", "Wednesday",
        //    4,        5,         6
        "Thursday", "Friday", "Saturday"};

    private static final int[] DAYS_PER_MONTH = { -1,
    //   1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12
        31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31,
    };

    // fields - should not change
    private int year;
    private int month;
    private int day;

    // constructor(s)
    
    /*
     * Constructs a new CalendarDate to represent the specified year/month/day.
     */
    public CalendarDate(int year, int month, int day) {
       this.year = year;
       this.month = month;
       this.day = day;
    }
    
    /*
     * Constructs a new CalendarDate to represent today.
     * Don't tinker with this code - it will work as soon as YOU
     *   correctly complete the nextDay method
     */ 
    public CalendarDate() {
        this(1970, JANUARY, 1); // start date here
        // computes days since Jan 1, 1970
        int daysSinceEpoch = (int) ((System.currentTimeMillis() + 
            TimeZone.getDefault().getRawOffset()) / 1000 / 60 / 60 / 24);
        for (int i = 0; i < daysSinceEpoch; i++) 
            nextDay(); // changes the date stored
    }

    /*
     * Returns whether the given object is a CalendarDate that refers to the 
     * same year/month/day as this CalendarDate.
     */ 
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
    
    // Returns this Date's day.
    public int getDay() {
        return day;
    }
    
    // Returns this Date's month.
    public int getMonth() {
        return month;
    }
    
    // Returns this Date's year.
    public int getYear() {
        return year;
    }

    // Returns the day of the week on which this Date occurred,
    // such as "Sunday" or "Wednesday".
    // Hint: 1753/1/1 was a Monday (1)
    public String getDayOfWeek() {
        CalendarDate base = new CalendarDate(1753, 1, 1);
        int dayCounter = 1;
        while(!this.equals(base))
        {
            base.nextDay();
            dayCounter++;
        }
        return DAY_NAMES[dayCounter % 7];
    }
    
    // Returns whether this Date occurred during a leap year.
    // Leap years are every fourth year, except those that are
    // divisible by 100 and not by 400.
    public boolean isLeapYear() {
        if(year % 100 == 0 && year % 400 != 0)
            return false;
        if(year % 4 == 0)
            return true;
        return false;
    }
    
    // Advances this CalendarDate to the next day.
    // This may cause a wrap-around into the next month or year.
    public void nextDay() {
       int nextDay = day + 1;
       if(this.isLeapYear())
            DAYS_PER_MONTH[2] = 29;
       else
            DAYS_PER_MONTH[2] = 28;
       if(nextDay <= DAYS_PER_MONTH[month]){
            day++;
            return;
        }
       else if(month == 12)
       {
           day = 1;
           month = 1;
           year++;
           return;
       }
       month++;
       day = 1;
       return;
    }
    
    // Returns a String representation of this CalendarDate, such as "2005/9/22".
    public String toString() {
        return year + "/" + month + "/" + day;
    }
}