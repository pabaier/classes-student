/*
 * Represents a calendar year/month/day date.
 * Jacob Mattox
 */ 

import java.util.*;

public class CalendarDate {
    // constants that may be helpful in avoiding "magic numbers"
    // in your code making it more readable and extendable
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
    private static final int NOVEMBER = 11;
    private static final int DECEMBER = 12;
    private static final int DAYS_PER_WEEK = 7;
    
    // these arrays that might simplify your code - remove if
    // you don't use them
    private static final String[] DAY_NAMES = {
        //    0,        1,         2,           3,
        "Sunday", "Monday", "Tuesday", "Wednesday",
        //    4,        5,         6
        "Thursday", "Friday", "Saturday"};

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
        CalendarDate startDate = new CalendarDate(1753, JANUARY, 1);
        int count = 0;
        int returnNum = 0;
        while(!((year == startDate.getYear()) && (month == startDate.getMonth()) && (day == startDate.getDay()))){
            count++;
            startDate.nextDay();
        }
        switch (count % 7){
            case 0:
                returnNum = 1;
                break;
            case 1:
                returnNum = 2;
                break;
            case 2:
                returnNum = 3;
                break;
            case 3:
                returnNum = 4;
                break;
            case 4:
                returnNum = 5;
                break;
            case 5:
                returnNum = 6;
                break;
            default:
                break;
            }
        return DAY_NAMES[returnNum];
    }
    // Returns whether this Date occurred during a leap year.
    // Leap years are every fourth year, except those that are
    // divisible by 100 and not by 400.
    public boolean isLeapYear() {
        Boolean returnVal = true;
        if((year % 400) == 0 || (year % 4 == 0) && !(year % 100 == 0))
            returnVal = true;
        else
            returnVal = false;
        return returnVal;
    }
    // Advances this CalendarDate to the next day.
    // This may cause a wrap-around into the next month or year.
    public void nextDay() {
       day++;
       if(day > 28 && month == FEBRUARY && !(isLeapYear())){
           day = 1;
           month++;
        }
       else if(day > 29 && month == FEBRUARY && isLeapYear()){
           day = 1;
           month++;
        }
       else if(day > 30 && (month == APRIL || month == JUNE || month == SEPTEMBER || month == NOVEMBER)){
           day = 1;
           month++;
        }
       else if(day > 31 && (month == JANUARY || month == MARCH || month == MAY || month == JULY || month == AUGUST
       || month == OCTOBER || month == DECEMBER)){
           day = 1;
           month++;
           if(month > DECEMBER){
               month = JANUARY;
               year++;
            }
        }
    }
    // Returns a String representation of this CalendarDate, such as "2005/9/22".
    public String toString() {
        return year + "/" + month + "/" + day;  // fix to return correctly formatted date
    }
}