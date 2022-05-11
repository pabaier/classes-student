/*
 * Name: Kyle Winstead
 * Date Due: 29 October 2017
 * Assignment: HW4
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
 CalendarDate() {
        this(1970, JANUARY, 1); 
        int daysSinceEpoch = (int) ((System.currentTimeMillis() + 
            TimeZone.getDefault().getRawOffset()) / 1000 / 60 / 60 / 24);
        for (int i = 0; i < daysSinceEpoch; i++) 
            nextDay(); 
    }
    public boolean equals(Object o) {
        if (o instanceof CalendarDate) {
            CalendarDate other = (CalendarDate) o;
            return day == other.day && month == other.month && 
                   year == other.year;
        } else {
            return false;
        }
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
        int res = DAYS_PER_MONTH[this.month];
        if (this.month == 2 && this.isLeapYear()) {
            ++res;
        }
        return res;
    }
    public boolean isAValidDate() {
        
    	if (month < 1 || month > 12)      return false;
        if (day < 1 || day > DAYS_PER_MONTH[month]) return false;
        if (month == 2 && day == 29 && !isLeapYear()) return false;
        if (year < 3000 && year > 1900) return true;
        return false;
    }
}
