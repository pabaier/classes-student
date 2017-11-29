
/*
 * CSCI 221, Fall 2017, HW 4
 * 
 * Represents a calendar year/month/day date.
 * Base code provided by instructor. The following updates 
 * 
 *   Completed getDay()
 *   Completed getMonth()
 *   Completed getYear()
 *   Completed getDayOfWeek()
 *   Completed isLeapYear()
 *   Completed nextDay()
 *   Completed toString()
 *   Added isAValidDate()
 * 
 * were added by
 * 
 *  Ashley Woodss
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
        return this.day; 
    }
    
    // Returns this Date's month.
    public int getMonth() {
        return this.month;
    }
    
    // Returns this Date's year.
    public int getYear() {
        return this.year;
    }

    // Returns the day of the week on which this Date occurred,
    // such as "Sunday" or "Wednesday".
    // Hint: 1753/1/1 was a Monday (1)
    public String getDayOfWeek() {
        int startYear = 1753;
        int endYear = this.year;
        int daysSinceBase = 0;
        int dayOfWeek = 0;
        //count days from birth month
        for(int i=1; i<=DAYS_PER_MONTH[1]; i++){
            daysSinceBase += 1;
        }
        //count days from months until end of birthyear
        for (int i=2; i<=12; i++){
            daysSinceBase += DAYS_PER_MONTH[i];
        }
        //count days from years until this year
        for (int i=startYear+1; i<endYear; i++) {
            CalendarDate countingYear = new CalendarDate(i,1,1);
            if (countingYear.isLeapYear()) {
                daysSinceBase += 366;
            }
            else {
                daysSinceBase += 365;
            }
        }
        //count days from months until this month
        for (int i = 1; i<this.month; i++) {
            daysSinceBase += DAYS_PER_MONTH[i];
            if (i==2 && this.isLeapYear()) {
                daysSinceBase += 1;
            }
        }
        //count days from this month up until today
        for (int i=1; i<=this.day; i++) {
            daysSinceBase += 1;
        }
        //Now we calculate the day of the week
        if (daysSinceBase%7 == 0){
            dayOfWeek = 0;
        }
        else if (daysSinceBase%7 == 1) {
            dayOfWeek = 1;
        }
        else if (daysSinceBase%7 == 2) {
            dayOfWeek = 2;
        }
        else if (daysSinceBase%7 == 3) {
            dayOfWeek = 3;
        }
        else if (daysSinceBase%7 == 4) {
            dayOfWeek = 4;
        }
        else if (daysSinceBase%7 == 5) {
            dayOfWeek = 5;
        }
        else if (daysSinceBase%7 == 6) {
            dayOfWeek = 6;
        }
        return DAY_NAMES[dayOfWeek]; // right now, every day is Sunday
    }
    
    // Returns whether this Date occurred during a leap year.
    // Leap years are every fourth year, except those that are
    // divisible by 100 and not by 400.
    public boolean isLeapYear() {
        boolean isLeapYear = false;
        if (this.year%4 == 0) {
            if (this.year%100 == 0) {
                if (this.year % 400 == 0) {
                    isLeapYear = true;
                }
            }
            else {
                isLeapYear = true;
            }
        }
        return isLeapYear; 
    }
    
    // Advances this CalendarDate to the next day.
    // This may cause a wrap-around into the next month or year.
    public void nextDay() {
       if (this.isLeapYear() && this.month == 2 && this.day == 28) {
           this.day +=1;
       }
       else if (day+1<=DAYS_PER_MONTH[month]) {
           this.day +=1;
       }
       else if (month<12) {
           this.day = 1;
           this.month += 1;
       }
       else {
           this.day = 1;
           this.month = 1;
           this.year +=1;
       }
    }
    
    public boolean isAValidDate() {
        boolean isValidDate = true;
        if (this.month>12 || this.month<1) {
            isValidDate = false;
        }
        if ((this.month != 2 && this.day>DAYS_PER_MONTH[this.month]) || this.day <1) {
            isValidDate = false;
        }
        if (this.month == 2) {
            if (this.isLeapYear() && this.day > 29) {
                isValidDate = false;
            }
            else if (this.day > DAYS_PER_MONTH[2]) {
                isValidDate = false;
            }
        }
        return isValidDate;
    }
    
    // Returns a String representation of this CalendarDate, such as "2005/9/22".
    public String toString() {
        String date = this.year + "/" + this.month + "/" +this.day;
        return date;
    }
    
    // Add any helper methods here - they must be declared to be private
}